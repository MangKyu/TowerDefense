package Controller;

import Controller.Database.DatabaseController;
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

    public PlayerController(){
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
        for(Observer o: observers){
            o.update(playerInfo);
        }
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        notifyObservers();
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public UserInfo signIn(UserInfo userInfo){
        UserDAO userDAO = DatabaseController.getInstance().acquireUserDAO();
        userInfo = userDAO.signInUser(userInfo);
        DatabaseController.getInstance().releaseDatabase(userDAO);
        return userInfo;
    }

    public boolean signUp(PlayerInfo playerInfo){
        UserDAO userDAO = DatabaseController.getInstance().acquireUserDAO();
        int result = userDAO.insertUserInfo(playerInfo.getUserInfo());
        DatabaseController.getInstance().releaseDatabase(userDAO);
        return result > 0;
    }

    public LevelInfo retrieveLevelInfo(UserInfo userInfo){
        UserDAO userDAO = DatabaseController.getInstance().acquireUserDAO();
        LevelInfo levelInfo = userDAO.retrieveLevelInfo(userInfo);
        DatabaseController.getInstance().releaseDatabase(userDAO);
        return levelInfo;
    }

    public void skill(SkillStrategy skillStrategy){
        skillStrategy.skill();
    }

    public BaseUnit getUnitByIndex(int index){
        return unitList.get(index);
    }

    public ArrayList getUnitList(){
        return unitList;
    }

    public void addUnit(BaseUnit unit){
        unitList.add(unit);
    }

    public void deleteUnit(BaseUnit unit){
        unitList.remove(unit);
    }

}
