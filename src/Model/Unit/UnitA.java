package Model.Unit;

public class UnitA extends BaseUnit {
    final static int baseHp = 100;
    final static int basePower = 10;
    final static int baseLevel = 1;
    final static int baseSpeed = 5;



    public UnitA(){
        super();
        this.unitId = "A";
        initUnit(hp, power, level, speed, true);
    }
    @Override
    public void attack() {
        //super.attack();
        System.out.println("UnitA Attack");
    }

    public void run(){
    }


}
