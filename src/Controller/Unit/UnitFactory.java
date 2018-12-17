package Controller.Unit;

import Model.Unit.*;

public class UnitFactory {
    //private static UnitFactory instance;

    public UnitFactory() {
    }

    public BaseUnit produceUnit(String unitId) {
        BaseUnit baseUnit = null;

        switch (unitId) {
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
                break;
        }
        return baseUnit;
    }

    public BaseUnit produceUnit(String unitId,int level,boolean teamInfo) {
        BaseUnit baseUnit = null;

        switch (unitId) {
            case "UNIT_A":
                baseUnit = new UnitA(level,teamInfo);
                break;
            case "UNIT_B":
                baseUnit = new UnitB(level,teamInfo);
                break;
            case "UNIT_C":
                baseUnit = new UnitC(level,teamInfo);
                break;
            case "UNIT_D":
                baseUnit = new UnitD(level,teamInfo);
                break;
            case "UNIT_E":
                baseUnit = new UnitE(level,teamInfo);
                break;
            case "UNIT_F":
                baseUnit = new UnitF(level,teamInfo);
                break;
            default:
                break;
        }
        return baseUnit;
    }
}
