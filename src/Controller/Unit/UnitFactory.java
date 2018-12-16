package Controller.Unit;

import Model.Player.UserInfo;
import Model.Unit.*;

public class UnitFactory {
    //private static UnitFactory instance;

    public UnitFactory() {
    }

    public BaseUnit produceUnit(String unitId,int level,boolean teamInfo,int positionX) {
        BaseUnit baseUnit;

        switch (unitId) {
            case "UNIT_A":
                baseUnit = new UnitA(level,teamInfo,positionX);
                break;
            case "UNIT_B":
                baseUnit = new UnitB(level,teamInfo,positionX);
                break;
            case "UNIT_C":
                baseUnit = new UnitC(level,teamInfo,positionX);
                break;
            case "UNIT_D":
                baseUnit = new UnitD(level,teamInfo,positionX);
                break;
            case "UNIT_E":
                baseUnit = new UnitE(level,teamInfo,positionX);
                break;
            case "UNIT_F":
                baseUnit = new UnitF(level,teamInfo,positionX);
                break;
            default:
                baseUnit = null;
                break;
        }
        return baseUnit;
    }
}
