package Controller;

import java.util.ArrayList;

public class DatabaseController {
    private static DatabaseController instance;
    private ArrayList<UserDatabase> databaseList;
    private final int poolSize = 5;
    private int count;

    public DatabaseController(){
        databaseList = new ArrayList<>();
        count = 0;
        for(int i = 0 ; i < poolSize; i++){
            databaseList.add(new UserDatabase());
        }
        count = poolSize;
    }

    public static DatabaseController getInstance(){
        if(instance == null){
            instance = new DatabaseController();
        }
        return instance;
    }

    public UserDatabase acquireDatabase(){
        UserDatabase database = null;
        if(databaseList.size() > 0){
            database = databaseList.remove(count-1);
            count--;
        }
        return database;
    }

    public void releaseDatabase(UserDatabase database){
        if(count < poolSize){
            databaseList.add(database);
            count++;
        }
    }

}
