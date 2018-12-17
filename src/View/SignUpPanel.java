package View;

import Controller.MainController;
import Model.Player.LevelInfo;
import Model.Player.PlayerInfo;
import Model.Player.UserInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SignUpPanel extends BasePanel{
    public JButton cancelButton;
    public JButton signUpButton;
    public JTextField idField;
    public JPasswordField pwField;
    public JLabel idLabel;
    public JLabel pwLabel;
    private JPanel cardsPanel;

    public SignUpPanel() {
        super(MainController.getInstance().getPlayerController());
        MainController.getInstance().getPlayerController().add(this);
    }

    public SignUpPanel(JPanel cardsPanel) {
        super(MainController.getInstance().getPlayerController());
        MainController.getInstance().getPlayerController().add(this);
        this.cardsPanel = cardsPanel;
        addAction();
    }


    @Override
    protected void initComponents() {
        this.setLayout(null);
        this.setSize(1000, 1000);

        this.idLabel = new JLabel("I D  입 력");
        idLabel.setBounds(300, 300, 200, 60);
        idLabel.setVisible(true);
        this.add(idLabel);

        this.pwLabel = new JLabel("P W  입 력");
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

        this.cancelButton = new JButton("cancel");
        cancelButton.setBounds(200, 600, 200, 60);
        cancelButton.setVisible(true);
        this.add(cancelButton);

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
    protected void addActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
        signUpButton.addActionListener(actionListener);
    }

    @Override
    protected void addAction() {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            if (source.equals(signUpButton)) {
                String id = idField.getText();
                String pw = String.valueOf(pwField.getPassword());
                UserInfo userInfo = new UserInfo(id, pw);

                boolean signUpFlag = requestSignUp(userInfo);

                if (signUpFlag) {
                    ((CardLayout) cardsPanel.getLayout()).show(cardsPanel, "LoginPanel");
                } else {
                    JOptionPane.showMessageDialog(null, "existing ID");
                }
            } else if(source.equals(cancelButton)) {
                ((CardLayout) cardsPanel.getLayout()).show(cardsPanel, "LoginPanel");
            }
        };

        addActionListener(actionListener);

    }

    private boolean requestSignUp(UserInfo userInfo) {
        boolean signUpFlag = MainController.getInstance().getPlayerController().signUp(userInfo);
        return signUpFlag;
    }
}
