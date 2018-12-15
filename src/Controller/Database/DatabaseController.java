package Controller.Database;

import java.util.ArrayList;

public class DatabaseController {
    private static DatabaseController instance;
    //private ArrayList<UserDatabase> databaseList;
    private ArrayList<UserDAO> userDAOList;
    private final int poolSize = 5;
    private int count;

    public DatabaseController(){
        //databaseList = new ArrayList<>();
        /*
        for(int i = 0 ; i < poolSize; i++){
            databaseList.add(new UserDatabase());
        }
        */
        count = 0;
        userDAOList = new ArrayList<>();
        for(int i = 0 ; i < poolSize; i++){
            userDAOList.add(new UserDAO());
        }
        count = poolSize;
    }

    public static DatabaseController getInstance(){
        if(instance == null){
            instance = new DatabaseController();
        }
        return instance;
    }

    public UserDAO acquireUserDAO(){
        UserDAO userDAO = null;
        if(userDAOList.size() > 0){
            userDAO = userDAOList.remove(count-1);
            count--;
        }
        return userDAO;
    }


    public void releaseDatabase(UserDAO userDAO){
        if(count < poolSize){
            userDAOList.add(userDAO);
            count++;
        }
    }
}
