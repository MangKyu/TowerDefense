package View;

import Controller.MainController;
import Controller.Observer.PlayerObserver;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private CardLayout cards;
    private MainController mainController;
    private PlayerObserver playerObserver;

    public MainFrame(MainController mainController) {
        this.mainController = mainController;
        this.setSize(1000, 1000);
        initComponents();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(new GridLayout());
        validate();

        LoginPanel loginPanel = new LoginPanel();
        this.add(loginPanel);
    }


}