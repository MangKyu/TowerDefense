package View;

import Controller.Observer.PlayerObserver;
import Model.Player.PlayerInfo;

public class LoginFrame extends BaseFrame{
    public LoginFrame(PlayerObserver playerObserver) {
        super(playerObserver);
        playerObserver.add(this);
    }

    @Override
    public void update(PlayerInfo playerInfo) {
        System.out.println("Player Info is updated");
    }
}
