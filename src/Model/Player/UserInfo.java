package Model.Player;

import java.util.Map;

public class UserInfo {
    private String id;
    private String pw;
    private int money;
    private int score;
    private Map levelInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Map getLeveInfo(){
        return this.levelInfo;
    }

    public void setLevelInfo(Map levelInfo){
        this.levelInfo = levelInfo;
    }
}
