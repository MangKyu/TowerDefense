package Controller;

import Controller.Database.DatabaseController;
import Controller.Database.UserDAO;
import Controller.Observer.Observer;
import Controller.Observer.PlayerObserver;
import Model.Player.PlayerInfo;
import Model.Player.UserInfo;

import java.util.ArrayList;

public class PlayerController implements PlayerObserver {
    private PlayerInfo playerInfo;
    private ArrayList<Observer> observers;

    public PlayerController(){
        observers = new ArrayList<>();
        playerInfo = new PlayerInfo();
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

    public void signIn(PlayerInfo playerInfo){
        UserDAO userDAO = DatabaseController.getInstance().acquireUserDAO();
        UserInfo userInfo = userDAO.selectUserById(playerInfo.getUserInfo());
        playerInfo.setUserInfo(userInfo);
        DatabaseController.getInstance().releaseDatabase(userDAO);
    }

    public boolean signUp(PlayerInfo playerInfo){
        UserDAO userDAO = DatabaseController.getInstance().acquireUserDAO();
        int result = userDAO.insertUserInfo(playerInfo.getUserInfo());
        DatabaseController.getInstance().releaseDatabase(userDAO);
        return result > 0;
    }

}
