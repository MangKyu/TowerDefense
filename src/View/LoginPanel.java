package View;

import Controller.MainController;
import Model.Player.PlayerInfo;
import Model.Player.UserInfo;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginPanel extends BasePanel {

    public JButton signInButton;
    public JButton signUpButton;
    public JTextField idField;
    public JPasswordField pwField;
    public JLabel idLabel;
    public JLabel pwLabel;

    public LoginPanel() {
        super();
    }


    @Override
    protected void initComponents() {
        this.setLayout(null);
        this.setSize(1000, 1000);

        this.idLabel = new JLabel("I D");
        idLabel.setBounds(300, 300, 200, 60);
        idLabel.setVisible(true);
        this.add(idLabel);

        this.pwLabel = new JLabel("P W");
        pwLabel.setBounds(300, 400, 200, 60);
        pwLabel.setVisible(true);
        this.add(pwLabel);

        this.idField = new JTextField();
        idField.setBounds(650, 300, 200, 60);
        idField.setVisible(true);
        this.add(idField);

        this.pwField = new JPasswordField();
        pwField.setBounds(650, 400, 200, 60);
        pwField.setVisible(true);
        this.add(pwField);

        this.signInButton = new JButton("Sign In");
        signInButton.setBounds(200, 600, 200, 60);
        signInButton.setVisible(true);
        this.add(signInButton);

        this.signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(600, 600, 200, 60);
        signUpButton.setVisible(true);
        this.add(signUpButton);

        this.setVisible(true);
    }

    @Override
    public void update(PlayerInfo playerInfo) {
        System.out.println("Player Info is updated");
    }

    @Override
    public void addActionListener(ActionListener actionListener) {
        signInButton.addActionListener(actionListener);
        signUpButton.addActionListener(actionListener);
    }

    public UserInfo requestSignIn(UserInfo userInfo) {
        userInfo = MainController.getInstance().getPlayerController().signIn(userInfo);
        return userInfo;
    }


}
