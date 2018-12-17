package Controller.Database;

import java.util.ArrayList;

public class DatabaseController {
    private static DatabaseController instance;
    //private ArrayList<UserDatabase> databaseList;
    private ArrayList<UserDAO> userDAOList;
    private ArrayList<LevelDAO> levelDAOList;
    private final int poolSize = 5;
    private int userDAOcount;
    private int levelDAOCount;

    public DatabaseController(){
        userDAOList = new ArrayList<>();
        for(int i = 0 ; i < poolSize; i++){
            userDAOList.add(new UserDAO());
        }

        levelDAOList = new ArrayList<>();
        for(int i = 0 ; i < poolSize; i++){
            levelDAOList.add(new LevelDAO());
        }

        levelDAOCount = poolSize;
        userDAOcount = poolSize;
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
            userDAO = userDAOList.remove(userDAOcount-1);
            userDAOcount--;
        }
        return userDAO;
    }

    public void releaseUserDAO(UserDAO userDAO){
        if(userDAOcount < poolSize){
            userDAOList.add(userDAO);
            userDAOcount++;
        }
    }

    public LevelDAO acquireLevelDAO(){
        LevelDAO levelDAO = null;
        if(levelDAOList.size() > 0){
            levelDAO = levelDAOList.remove(levelDAOCount-1);
            levelDAOCount--;
        }
        return levelDAO;
    }

    public void releaseLevelDAO(LevelDAO levelDAO){
        if(levelDAOCount < poolSize){
            levelDAOList.add(levelDAO);
            levelDAOCount++;
        }
    }

}
