package Controller;

import Controller.Database.DatabaseController;
import Controller.Database.LevelDAO;
import Controller.Database.UserDAO;
import Controller.Observer.Observer;
import Controller.Observer.PlayerObserver;
import Controller.Strategy.SkillStrategy;
import Model.Player.LevelInfo;
import Model.Player.PlayerInfo;
import Model.Player.UserInfo;
import Model.Unit.BaseUnit;

import java.util.ArrayList;

public class PlayerController implements PlayerObserver {
    private PlayerInfo playerInfo;
    private ArrayList<Observer> observers;
    private ArrayList<BaseUnit> unitList;

    public PlayerController() {
        observers = new ArrayList<>();
        playerInfo = new PlayerInfo();
        unitList = new ArrayList<>(4);
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void delete(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(playerInfo);
        }
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public void updatePlayerInfo() {
        notifyObservers();
    }

    public void updatePlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        notifyObservers();
    }

    public void updatePlayerInfo(UserInfo userInfo) {
        playerInfo.setUserInfo(userInfo);
        notifyObservers();
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public UserInfo signIn(UserInfo userInfo) {
        UserDAO userDAO = DatabaseController.getInstance().acquireUserDAO();
        userInfo = userDAO.signInUser(userInfo);
        DatabaseController.getInstance().releaseUserDAO(userDAO);
        return userInfo;
    }

    public boolean signUp(UserInfo userInfo) {
        UserDAO userDAO = DatabaseController.getInstance().acquireUserDAO();
        int result = userDAO.insertUserInfo(userInfo);
        DatabaseController.getInstance().releaseUserDAO(userDAO);
        return result > 0;
    }

    public boolean updateLevelInfo(LevelInfo levelInfo) {
        LevelDAO levelDAO = DatabaseController.getInstance().acquireLevelDAO();
        boolean isSuccess = levelDAO.updateLevelInfo(levelInfo);
        DatabaseController.getInstance().releaseLevelDAO(levelDAO);
        if (isSuccess) {
            UserDAO userDAO = DatabaseController.getInstance().acquireUserDAO();
            int result = userDAO.updateUserInfo(playerInfo.getUserInfo());
            DatabaseController.getInstance().releaseUserDAO(userDAO);
        }
        return isSuccess;
    }

    public LevelInfo retrieveLevelInfo(UserInfo userInfo) {
        LevelDAO levelDAO = DatabaseController.getInstance().acquireLevelDAO();
        LevelInfo levelInfo = levelDAO.retrieveLevelInfo(userInfo);
        DatabaseController.getInstance().releaseLevelDAO(levelDAO);
        return levelInfo;
    }

    public void skill(SkillStrategy skillStrategy) {
        skillStrategy.skill();
    }

    public BaseUnit getUnitByIndex(int index) {
        BaseUnit unit = null;
        try {
            unit = unitList.get(index);
        } catch (IndexOutOfBoundsException e) {

        }
        return unit;
    }

    public ArrayList getUnitList() {
        return unitList;
    }

    public boolean isDuplicated(BaseUnit newUnit) {
        boolean duplicatedFlag = false;
        for (BaseUnit unit : unitList) {
            if (unit.getUnitId().equals(newUnit.getUnitId())) {
                duplicatedFlag = true;
                break;
            }
        }
        if (!duplicatedFlag) {
            System.out.println(newUnit.getUnitId());
        }
        return duplicatedFlag;
    }

    public void deleteUnit(BaseUnit unit) {
        unitList.remove(unit);
    }

    public void addUnit(BaseUnit unit) {
        unitList.add(unit);
    }
}
