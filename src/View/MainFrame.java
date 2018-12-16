package View;

import Controller.MainController;
import Controller.Observer.PlayerObserver;
import Model.Player.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class MainFrame extends JFrame {

    private JPanel cardsPanel;
    private Container container;
    private LoginPanel loginPanel;
    private StagePanel stagePanel;
    private IngamePanel ingamePanel;

    private MainController mainController;
    private PlayerObserver playerObserver;

    public MainFrame(MainController mainController) {
        this.mainController = mainController;
        initComponents();
    }

    private void initComponents() {
        container = getContentPane();
        cardsPanel = new JPanel(new CardLayout(0, 0));

        loginPanel = new LoginPanel(cardsPanel);
        cardsPanel.add(loginPanel, "LoginPanel");
        //loginPanel.addActionListener(loginPanelListener);

        stagePanel = new StagePanel(cardsPanel);
        cardsPanel.add(stagePanel, "StagePanel");

        ingamePanel = new IngamePanel(cardsPanel);
        cardsPanel.add(ingamePanel, "IngamePanel");

        container.add(cardsPanel);
        this.setBounds(30, 30, 1000, 1000);
        this.setResizable(false);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}