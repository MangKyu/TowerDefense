package Controller.Unit;

import Model.Unit.BaseUnit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayController implements Runnable {

    public static ArrayList<BaseUnit> unitList;
    private boolean isPlaying = true;

    public void run() {
        while (isPlaying) {
            BaseUnit b1;
            BaseUnit b2;
            Iterator<BaseUnit> unit = unitList.iterator();

            for (int i = 0; i < unitList.size(); i++) {
                b1 = unitList.get(i);
                for (int j = i + 1; j < unitList.size(); j++) {
                    b2 = unitList.get(j);
                    int enemyNum = 0;
                    if ((b1.getTeamInfo() != b2.getTeamInfo()) &&
                            !b1.getIsAttack() && !b2.getIsAttack() &&
                            (Math.abs(b1.getX() - b2.getX()) <= BaseUnit.attackRange)) {
                        enemyNum += 1;
                    }
                    if (enemyNum > 0) {
                        b1.setIsAttack(true);
                    } else {
                        b1.setIsAttack(false);
                    }
                }
            }

            while (unit.hasNext()) {
                for (int i = 0; i < unitList.size(); i++)
                    if (!unitList.get(i).AliveDetection()) {
                        unitList.remove(i);
                    }
            }
        }
    }

    public static void InflictDamage(int id, int power) {
        BaseUnit attacker = null;
        BaseUnit opponent = null;
        for (int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i).getId() == id) {
                attacker = unitList.get(i);
            }
        }

        for (int i = 0; i < unitList.size(); i++) {
            opponent = unitList.get(i);
            if (id != opponent.getId() &&
                    attacker.getTeamInfo() != opponent.getTeamInfo() &&
                    (Math.abs(attacker.getX() - opponent.getX()) <= BaseUnit.attackRange)) {
                opponent.setHp(opponent.getHp() - power);
            }
        }
    }
}
