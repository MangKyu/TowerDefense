package Controller;

import View.LoginPanel;
import View.MainFrame;

public class Main {

    public static void main(String args[]){


        MainController mainController = new MainController();
        MainFrame mainFrame = new MainFrame(mainController);
    }

}
