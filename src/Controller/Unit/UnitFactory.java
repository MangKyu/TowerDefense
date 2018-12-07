package Controller.Unit;

import Model.Unit.*;

public class UnitFactory {
    //private static UnitFactory instance;

    public UnitFactory(){

    }

    /*
    private static UnitFactory getInstance(){
        if(instance == null){
            instance = new UnitFactory();
        }
        return instance;
    }
    */

    public BaseUnit produceUnit(String unitId) {
        BaseUnit baseUnit;
        switch (unitId){
            case "UNIT_A":
                baseUnit = new UnitA();
                break;
            case "UNIT_B":
                baseUnit = new UnitB();
                break;
            case "UNIT_C":
                baseUnit = new UnitC();
                break;
            case "UNIT_D":
                baseUnit = new UnitD();
                break;
            case "UNIT_E":
                baseUnit = new UnitE();
                break;
            case "UNIT_F":
                baseUnit = new UnitF();
                break;
            default:
                baseUnit = null;
                break;
        }
        return baseUnit;
    }
}
