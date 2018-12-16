package Model.Unit;

import Controller.PlayerController;
import Controller.Unit.PlayController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public abstract class BaseUnit implements Runnable {
    private final Lock lock = new ReentrantLock(true);
    String unitId;
    static int commonId = 0;
    //Every Unit has specific Id for distinction
    int id;
    int hp;
    int power;
    int level;
    int speed;
    boolean teamInfo;
    boolean isAlive = true;
    boolean isAttack = false;
    int cost;
    int positionX = 150;
    int positionY = 500;
    public final static int attackRange = 15;


    public BaseUnit() {
        lock.lock();
        try {
            id = commonId;
            commonId++;
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public int getId(){
        return this.id;
    }
    public void attack() {
        PlayController.InflictDamage(this.id, this.power);
    }

    public void move() {
        this.positionX += this.speed;
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
}
