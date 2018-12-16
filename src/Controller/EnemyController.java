package Controller;

import Controller.Unit.UnitFactory;

import java.util.Random;

public class EnemyController implements Runnable {

    private int mp = 1500;
    private Random random;
    private boolean isPlaying;
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
            switch (num) {
                case 0:
                    unitFactory.produceUnit("UNIT_A", stageNum, true);
                    break;
                case 1:
                    unitFactory.produceUnit("UNIT_B", stageNum, true);
                    break;
                case 2:
                    unitFactory.produceUnit("UNIT_C", stageNum, true);
                    break;
                case 3:
                    unitFactory.produceUnit("UNIT_D", stageNum, true);
                    break;
                case 4:
                    unitFactory.produceUnit("UNIT_E", stageNum, true);
                    break;
                case 5:
                    unitFactory.produceUnit("UNIT_F", stageNum, true);
                    break;
            }

            this.mp -= 100;
            try {
                Thread.sleep(new Random().nextInt(2000) + 2000);
            } catch (InterruptedException e) {
            }
        }
    }


}
