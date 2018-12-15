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

    private MainController mainController;

    private PlayerObserver playerObserver;

    public MainFrame(MainController mainController) {
        this.mainController = mainController;
        initComponents();
    }

    private void initComponents() {
        container = getContentPane();
        cardsPanel = new JPanel(new CardLayout(0, 0));

        LoginPanel loginPanel = new LoginPanel();
        cardsPanel.add(loginPanel, "LoginPanel");

        ActionListener actionListener = e -> {
            Object source = e.getSource();
            if (source.equals(loginPanel.signInButton)) {
                String id = loginPanel.idField.getText();
                String pw = String.valueOf(loginPanel.pwField.getPassword());
                UserInfo userInfo = new UserInfo(id, pw);

                userInfo = loginPanel.requestSignIn(userInfo);

                if (userInfo == null) {
                    ((CardLayout) cardsPanel.getLayout()).show(cardsPanel, "다른 패널 이름");
                } else {
                }
            } else if (source.equals(loginPanel.signUpButton)) {
            }
        };

        loginPanel.addActionListener(actionListener);


        container.add(cardsPanel);
        this.setBounds(30, 30, 1000, 1000);
        this.setResizable(false);
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}