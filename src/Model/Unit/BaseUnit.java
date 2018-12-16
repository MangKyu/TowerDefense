package Model.Unit;

import Controller.PlayerController;
import Controller.Unit.AttackController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public abstract class BaseUnit implements Runnable {
    private final Lock lock = new ReentrantLock(true);
    //UNIT A B C D E F HAS DIFFERENT UNITID
    String unitId;
    //VARIABLE FOR ID INITIALIZE. NEED TO BE LOCKED BEFORE INITIALIZE
    static int commonId = 0;
    //Every UNIT HAS SPECIFIC ID THOUGH SOME UNITS HAVE COMMON UNITID
    int id;
    int hp;
    int power;
    int level;
    int speed;
    boolean teamInfo;
    boolean isAlive = true;
    boolean isAttack = false;
    int cost;
    int positionX;
    int positionY = 500;
    public final static int attackRange = 15;
    Thread th;


    public BaseUnit(int positionX) {
        this.positionX = positionX;
        lock.lock();
        try {
            id = commonId;
            commonId++;
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public int getId() {
        return this.id;
    }

    public void attack() {
        AttackController.InflictDamage(this.id, this.power);
    }

    public void move() {
        if (teamInfo == false) {
            this.positionX += this.speed;
        } else {
            this.positionX -= this.speed;
        }
    }

    public void setIsAttack(boolean isAttack) {
        this.isAttack = isAttack;
    }

    public boolean getIsAttack() {
        return this.isAttack;
    }

    public void setX(int x) {
        this.positionX = x;
    }

    public int getX() {
        return this.positionX;
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

    public void InitUnit(int level, boolean teamInfo) {
    }

    public boolean AliveDetection() {
        if (this.hp <= 0) {
            this.isAlive = false;
        }
        return isAlive;
    }

    public void run() {
        while (AliveDetection()) {
            if (isAttack) {
                attack();
            } else {
                move();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }
}
