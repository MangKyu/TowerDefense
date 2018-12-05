package Controller;

import java.util.Date;

public class MainController {
    private Date date;
    private DatabaseController dc;
    private UnitController uc;
    private PlayerController pc;

    public MainController(){
        this.date = new Date();
        this.dc = new DatabaseController();
        this.uc = new UnitController();
        this.pc = new PlayerController();

    }


}
