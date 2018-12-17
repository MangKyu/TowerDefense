package View;

import Controller.Observer.Observer;
import Controller.Observer.PlayerObserver;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class BasePanel extends JPanel implements Observer {
    PlayerObserver playerObserver;

    public BasePanel(PlayerObserver playerObserver) {
        this.playerObserver = playerObserver;
        initComponents();

    }

    protected abstract void initComponents();

    protected abstract void addActionListener(ActionListener actionListener);

    protected abstract void addAction();

}
