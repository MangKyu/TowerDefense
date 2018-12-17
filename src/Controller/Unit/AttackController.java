package Controller.Unit;

import Model.Unit.BaseUnit;

import java.util.ArrayList;

public class AttackController implements Runnable {

    public static ArrayList<BaseUnit> unitList;
    private boolean isPlaying = false;

    public AttackController(){

    }

    public void addUnit(BaseUnit unit){
        unitList.add(unit);
        System.out.println("Unit Added");
    }

    public void setIsPlaying(boolean playing){
        this.isPlaying = playing;
    }
    public void run() {
        while (isPlaying) {
            unitList = new ArrayList<BaseUnit>();
            BaseUnit b1;
            BaseUnit b2;
            if (unitList.size() != 0) {
                for (int i = 0; i < unitList.size(); i++) {
                    b1 = unitList.get(i);
                    int enemyNum = 0;
                    for (int j = i + 1; j < unitList.size(); j++) {
                        b2 = unitList.get(j);
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
