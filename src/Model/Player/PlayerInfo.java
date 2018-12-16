package Model.Player;

import Controller.Strategy.SkillStrategy;
import Model.Unit.BaseUnit;

import java.util.Queue;

public class PlayerInfo {
    private int hp;
    private int mp;
    private Queue<BaseUnit> unitQueue;
    private UserInfo userInfo;
    private SkillStrategy skillStrategy;
    private boolean skillFlag;

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

    public Queue<BaseUnit> getUnitQueue() {
        return unitQueue;
    }

    public void setUnitQueue(Queue<BaseUnit> unitQueue) {
        this.unitQueue = unitQueue;
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

    public void addUnit(BaseUnit unit){
        unitQueue.offer(unit);
    }

    public void deleteUnit(BaseUnit unit){
        unitQueue.remove(unit);
    }

}
