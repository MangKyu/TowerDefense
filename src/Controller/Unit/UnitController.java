package Controller.Unit;

import Model.Unit.BaseUnit;

public class UnitController {
    private UnitFactory unitFactory;

    public UnitController() {
        this.unitFactory = new UnitFactory();
    }

    public BaseUnit produceUnit(String unitId, int level, boolean teamInfo,int positionX) {
        return unitFactory.produceUnit(unitId, level, teamInfo, positionX);
    }

}
