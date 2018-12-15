package View;

import Model.Player.PlayerInfo;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends BasePanel {

    private JButton signInButton;
    private JButton signUpButton;
    private JTextField idField;
    private JPasswordField pwField;

    public LoginPanel() {
        super();
    }


    @Override
    protected void initComponents() {
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setLayout(new GridLayout());

        System.out.println("LoginPanel Created");

        this.idField = new JTextField();
        idField.setBounds(800, 800, 600, 60);
        idField.setVisible(true);
        this.add(idField);

        this.pwField = new JPasswordField();
        pwField.setBounds(800, 850, 200, 60);
        pwField.setVisible(true);
        this.add(pwField);

        this.signInButton = new JButton("Sign In");
        signInButton.setBounds(200, 600, 200, 60);
        signInButton.setVisible(true);
        this.add(signInButton);

        this.signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(400, 600, 200, 60);
        signUpButton.setVisible(true);
        this.add(signUpButton);

        this.show();
    }


    @Override
    public void paintComponents( Graphics g ) {
        super.paint(g);
    }

    @Override
    public void update(PlayerInfo playerInfo) {
        System.out.println("Player Info is updated");
    }

}
