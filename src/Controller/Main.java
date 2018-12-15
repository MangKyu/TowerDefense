package Controller;

import View.LoginPanel;
import View.MainFrame;

public class Main {

    public static void main(String args[]){
        /*
        UserDatabase db = new UserDatabase();
        UserDAO userDAO = new UserDAO();
        List<UserInfo> userInfoList = userDAO.selectAllUser();
        System.out.println(userDAO.selectAllUser().toString());

        MainController mainController = new MainController();
        LoginPanel a =new LoginPanel(mainController.getPlayerController());
        mainController.getPlayerController().setPlayerInfo(new PlayerInfo());

        MainController mainController = new MainController();
        BaseUnit b = mainController.getUnitController().produceUnit("UNIT_D");
        b.attack();
        */


        MainController mainController = new MainController();
        MainFrame mainFrame = new MainFrame(mainController);
    }

}
