package View;

import Model.Player.PlayerInfo;

import javax.swing.*;

public class LoginPanel extends BasePanel {


    private JButton signinButton;
    private JButton signupButton;
    private JTextField idField;
    private JTextField pwField;

    public LoginPanel(){
          super();
          this.add(idField);
          this.add(pwField);
          this.add(signinButton);
          this.add(signupButton);
    }


    @Override
    protected void initComponents(){
        System.out.println("LoginPanel Created");
    }

    @Override
    public void update(PlayerInfo playerInfo) {
        System.out.println("Player Info is updated");
    }

}
