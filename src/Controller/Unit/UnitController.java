package Controller.Unit;

import Model.Player.PlayerInfo;
import Model.Player.UserInfo;
import Model.Unit.BaseUnit;

import java.util.Map;

public class UnitController {
    private UnitFactory unitFactory;

    public UnitController() {
        this.unitFactory = new UnitFactory();
    }

    public BaseUnit produceUnit(String unitId, int level) {

        return unitFactory.produceUnit(unitId, level);
    }

}
