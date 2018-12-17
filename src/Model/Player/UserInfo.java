package Model.Player;

public class UserInfo {
    private String id;
    private String pw;
    private int money;
    private int score;
    private LevelInfo levelInfo;

    public UserInfo() {
        this.money = 0;
    }

    public UserInfo(String id, String pw) {
        this.id = id;
        this.pw = pw;
        levelInfo = new LevelInfo();
    }

    public UserInfo(String id, String pw, int money, int score) {
        this.id = id;
        this.pw = pw;
        this.money = money;
        this.score = score;
        levelInfo = new LevelInfo();
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

    public LevelInfo getLevelInfo() {
        return levelInfo;
    }

    public void setLevelInfo(LevelInfo levelInfo) {
        this.levelInfo = levelInfo;
    }

    public int getUnitLevel(String unitId) {
        int unitLevel = -1;
        switch (unitId) {
            case "UNIT_A":
                unitLevel = levelInfo.getUnitALevel();
                break;
            case "UNIT_B":
                unitLevel = levelInfo.getUnitBLevel();
                break;
            case "UNIT_C":
                unitLevel = levelInfo.getUnitCLevel();
                break;
            case "UNIT_D":
                unitLevel = levelInfo.getUnitDLevel();
                break;
            case "UNIT_E":
                unitLevel = levelInfo.getUnitELevel();
                break;
            case "UNIT_F":
                unitLevel = levelInfo.getUnitFLevel();
                break;
            default:
                break;
        }
        return unitLevel;
    }

    public void setUnitLevel(String unitId) {
        switch (unitId) {
            case "UNIT_A":
                levelInfo.setUnitALevel(levelInfo.getUnitALevel() + 1);
                break;
            case "UNIT_B":
                levelInfo.setUnitBLevel(levelInfo.getUnitBLevel() + 1);
                break;
            case "UNIT_C":
                levelInfo.setUnitCLevel(levelInfo.getUnitCLevel() + 1);
                break;
            case "UNIT_D":
                levelInfo.setUnitDLevel(levelInfo.getUnitDLevel() + 1);
                break;
            case "UNIT_E":
                levelInfo.setUnitELevel(levelInfo.getUnitELevel() + 1);
                break;
            case "UNIT_F":
                levelInfo.setUnitFLevel(levelInfo.getUnitFLevel() + 1);
                break;
            default:
                break;
        }
    }

}
