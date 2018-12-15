package View;

import Controller.Observer.Observer;

import javax.swing.*;

public abstract class BasePanel extends JPanel implements Observer {
    public BasePanel(){
        initComponents();
    }

    protected abstract void initComponents();
}
