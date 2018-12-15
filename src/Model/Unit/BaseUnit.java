package Model.Unit;

public abstract class BaseUnit implements Runnable {
    String unitId;
    int hp;
    int power;
    int level;
    int speed;
    boolean teamInfo;
    int cost;

    public BaseUnit() {
    }

    public void attack() {
    }

    public void move() {
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setTeamInfo(boolean teamInfo) {
        this.teamInfo = teamInfo;
    }

    public boolean getTeamInfo() {
        return this.teamInfo;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    public void InitUnit(int level,boolean teamInfo) {
    }
}
