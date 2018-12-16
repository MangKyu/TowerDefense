package Model.Unit;

public class UnitB extends BaseUnit {
    final static int baseHp = 100;
    final static int basePower = 10;
    final static int baseLevel = 1;
    final static int baseSpeed = 5;
    final static int baseCost = 100;

    public UnitB(int level,boolean teamInfo) {
        super();
        this.unitId = "UNIT_B";
        InitUnit(level, teamInfo);
    }

    @Override
    public void attack() {
        //super.attack();
        System.out.println("UnitA Attack");
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
