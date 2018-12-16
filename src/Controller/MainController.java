package Controller;

import Controller.Database.DatabaseController;
import Controller.Unit.AttackController;
import Controller.Unit.UnitController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainController {
    private Date date;
    private static MainController instance;
    private DatabaseController databaseController;
    private UnitController unitController;
    private PlayerController playerController;
    private AttackController attackController;

    public MainController(){
        instance = this;
        this.date = new Date();
        this.attackController = new AttackController();
        this.databaseController= new DatabaseController();
        this.playerController = new PlayerController();
        this.unitController = new UnitController();
    }

    public String getCurrentDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd a hh:mm:ss ");
        return dateFormat.format(date);
    }

    public Date getDate() {
        return date;
    }

    public DatabaseController getDatabaseController() {
        return databaseController;
    }

    public UnitController getUnitController() {
        return unitController;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public AttackController getAttackController(){
        return this.attackController;
    }

    public static MainController getInstance(){
        if(instance == null){
            instance = new MainController();
        }
        return instance;
    }

}
