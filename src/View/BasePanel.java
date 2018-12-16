package View;

import Controller.Observer.Observer;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class BasePanel extends JPanel implements Observer {
    public BasePanel() {
        initComponents();
    }

    protected abstract void initComponents();

    protected abstract void addActionListener(ActionListener actionListener);

    protected abstract void addAction();

}
