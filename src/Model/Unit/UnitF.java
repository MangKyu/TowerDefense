package Model.Unit;

public class UnitF extends BaseUnit {

    final static int baseHp = 100;
    final static int basePower = 10;
    final static int baseLevel = 1;
    final static int baseSpeed = 5;
    final static int baseCost = 100;

    public UnitF(int level, boolean teamInfo) {
        super();
        this.unitId = "UNIT_F";
        InitUnit(level, teamInfo);
        if (teamInfo) {
            System.out.println("Enemy F IS CREATED");
        } else {
            System.out.println("F IS CREATED");
        }
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
