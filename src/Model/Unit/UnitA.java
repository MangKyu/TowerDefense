package Model.Unit;

import javax.swing.*;

public class UnitA extends BaseUnit {
    final static int baseHp = 100;
    final static int basePower = 10;
    final static int baseLevel = 1;
    final static int baseSpeed = 5;
    final static int baseCost = 100;


    public UnitA(int level, boolean teamInfo) {
        super();
        this.unitId = "UNIT_A";
        InitUnit(level, teamInfo);
        System.out.println("A IS CREATED");
    }

    public void InitUnit(int level, boolean teamInfo) {
        int tempHp;
        int tempPower;

        tempHp = baseHp + level * 10;
        tempPower = basePower + level * 5;

        if (teamInfo == false) {
            positionX = 150;
        } else {
            positionX = 800;
        }

        this.power = tempPower;
        this.hp = tempHp;
        this.teamInfo = teamInfo;
        this.cost = baseCost;

    }

}
