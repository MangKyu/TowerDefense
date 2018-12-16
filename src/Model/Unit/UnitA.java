package Model.Unit;

public class UnitA extends BaseUnit {
    final static int baseHp = 100;
    final static int basePower = 10;
    final static int baseLevel = 1;
    final static int baseSpeed = 5;
    final static int baseCost = 100;


    public UnitA(int level,boolean teamInfo,int positionX) {
        super(positionX);
        this.unitId = "UNIT_A";
        InitUnit(level, teamInfo);
        th = new Thread(this);
        th.start();
    }

    public void InitUnit(int level, boolean teamInfo) {
        int tempHp;
        int tempPower;

        tempHp = baseHp + level * 10;
        tempPower = basePower + level * 5;

        this.power = tempPower;
        this.hp = tempHp;
        this.teamInfo = teamInfo;
        this.cost = baseCost;

    }

}
