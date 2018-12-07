package Controller;

import Controller.Database.UserDAO;
import Controller.Database.UserDatabase;

public class Main {

    public static void main(String args[]){
        UserDatabase db = new UserDatabase();
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.selectAllUser().toString());
    }


}
