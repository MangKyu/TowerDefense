package Controller;

import Controller.Database.DatabaseController;
import Controller.Unit.UnitController;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainController {
    private Date date;
    private DatabaseController databaseController;
    private UnitController unitController;
    private PlayerController playerController;

    public MainController(){
        this.date = new Date();
        this.databaseController= new DatabaseController();
        this.unitController = new UnitController();
        this.playerController = new PlayerController();
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
}
