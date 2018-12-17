package Controller;

import Controller.Unit.UnitFactory;
import Model.Unit.BaseUnit;

import java.util.Random;

public class EnemyController implements Runnable {

    private int mp = 1500;
    private Random random;
    public static boolean isPlaying;
    private UnitFactory unitFactory;
    private int stageNum;

    public EnemyController(int stageNum) {
        this.stageNum = stageNum;
        this.mp += stageNum * 100;
        this.isPlaying = false;
        isPlaying = false;
        random = new Random();
        unitFactory = new UnitFactory();
    }

    public void setIsPlaying(boolean playing) {
        this.isPlaying = playing;
    }


    public void run() {
        while (isPlaying && mp >= 100) {
            int num = random.nextInt(6);
            BaseUnit base = null;
            switch (num) {
                case 0:
                    base = unitFactory.produceUnit("UNIT_A", stageNum, true);
                    break;
                case 1:
                    base = unitFactory.produceUnit("UNIT_B", stageNum, true);
                    break;
                case 2:
                    base = unitFactory.produceUnit("UNIT_C", stageNum, true);
                    break;
                case 3:
                    base = unitFactory.produceUnit("UNIT_D", stageNum, true);
                    break;
                case 4:
                    base =unitFactory.produceUnit("UNIT_E", stageNum, true);
                    break;
                case 5:
                    base = unitFactory.produceUnit("UNIT_F", stageNum, true);
                    break;
            }
            MainController.getInstance().getAttackController().addUnit(base);

            this.mp -= 100;
            try {
                Thread.sleep(new Random().nextInt(2000) + 2000);
            } catch (InterruptedException e) {
            }
        }
    }


}
