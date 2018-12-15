package Controller.Unit;

import Model.Player.UserInfo;
import Model.Unit.*;

public class UnitFactory {
    //private static UnitFactory instance;

    public UnitFactory() {
    }

    public BaseUnit produceUnit(String unitId,int level) {
        BaseUnit baseUnit;

        switch (unitId) {
            case "UNIT_A":
                baseUnit = new UnitA(level);
                break;
            case "UNIT_B":
                baseUnit = new UnitB(level);
                break;
            case "UNIT_C":
                baseUnit = new UnitC(level);
                break;
            case "UNIT_D":
                baseUnit = new UnitD(level);
                break;
            case "UNIT_E":
                baseUnit = new UnitE(level);
                break;
            case "UNIT_F":
                baseUnit = new UnitF(level);
                break;
            default:
                baseUnit = null;
                break;
        }
        return baseUnit;
    }
}
