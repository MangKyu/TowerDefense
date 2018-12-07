package Controller;

import Controller.Database.UserDAO;
import Controller.Database.UserDatabase;
import Model.Player.PlayerInfo;
import Model.Player.UserInfo;
import View.LoginFrame;

import java.util.List;

public class Main {

    public static void main(String args[]){
        /*
        UserDatabase db = new UserDatabase();
        UserDAO userDAO = new UserDAO();
        List<UserInfo> userInfoList = userDAO.selectAllUser();
        System.out.println(userDAO.selectAllUser().toString());
        */
        MainController mainController = new MainController();
        LoginFrame a =new LoginFrame(mainController.getPlayerController());
        mainController.getPlayerController().setPlayerInfo(new PlayerInfo());
    }
}
