package Model.Player;

import java.util.Map;

public class UserInfo {
    private String id;
    private String pw;
    private int money;
    private int score;

    public UserInfo(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public UserInfo(String id, String pw, int money, int score) {
        this.id = id;
        this.pw = pw;
        this.money = money;
        this.score = score;
    }
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

}
