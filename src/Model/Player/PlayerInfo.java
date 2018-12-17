package Model.Player;

import Controller.Strategy.SkillStrategy;

public class PlayerInfo {
    private int hp;
    private int mp;
    private UserInfo userInfo;
    private SkillStrategy skillStrategy;
    private boolean skillFlag;

    public PlayerInfo() {
        this.hp = 1000;
        this.mp = 1000;
        this.userInfo = new UserInfo();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public SkillStrategy getSkillStrategy() {
        return skillStrategy;
    }

    public void setSkillStrategy(SkillStrategy skillStrategy) {
        this.skillStrategy = skillStrategy;
    }

    public boolean getSkillFlag() {
        return skillFlag;
    }

    public void setSkillFlag(boolean skillFlag) {
        this.skillFlag = skillFlag;
    }

}
