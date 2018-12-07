package View;

import Controller.Observer.Observer;
import Controller.Observer.PlayerObserver;

import javax.swing.*;

public abstract class BaseFrame extends JFrame implements Observer {
    private PlayerObserver playerObserver;
    public BaseFrame(PlayerObserver playerObserver){
        this.playerObserver = playerObserver;
    }
}
