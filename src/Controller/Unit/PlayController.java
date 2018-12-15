package Controller.Unit;

import Model.Unit.BaseUnit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayController implements Runnable {

    public ArrayList<BaseUnit> unitList;
    private boolean isPlaying = true;

    public void run() {
        ;
        while (isPlaying) {
            BaseUnit b1;
            BaseUnit b2;
            Iterator<BaseUnit> unit = unitList.iterator();

            for (int i = 0; i < unitList.size(); i++) {
                for (int j = i + 1; j < unitList.size(); j++) {
                    b1 = unitList.get(i);
                    b2 = unitList.get(j);
                    if ((b1.getTeamInfo() != b2.getTeamInfo()) &&
                            !b1.getIsAttack() && !b2.getIsAttack() &&
                            (Math.abs(b1.getX() - b2.getX()) <= BaseUnit.attackRange)) {
                        b1.setIsAttack(true);
                        b2.setIsAttack(true);
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
}
}
