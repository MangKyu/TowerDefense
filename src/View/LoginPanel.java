package View;

import Model.Player.PlayerInfo;

public class LoginPanel extends BasePanel {

    public LoginPanel(){
        super();
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
