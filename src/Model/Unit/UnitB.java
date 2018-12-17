package Model.Unit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class UnitB extends BaseUnit {
    final int baseHp = 100;
    final int basePower = 10;
    final int baseLevel = 1;
    final int baseSpeed = 5;
    final int baseCost = 100;

    public UnitB() {
        super("UNIT_B");
    }

    public UnitB(int level, boolean teamInfo) {
        super("UNIT_B");
        initUnit(level, teamInfo);
        System.out.println("B IS CREATED");
    }

    @Override
    public void initUnit(int level, boolean teamInfo) {
        int tempHp;
        int tempPower;

        tempHp = baseHp + level * 10;
        tempPower = basePower + level * 5;
        if (teamInfo == false) {
            positionX = 150;
        } else {
            positionX = 800;
        }
        this.power = tempPower;
        this.hp = tempHp;
        this.teamInfo = teamInfo;
        this.cost = baseCost;

        BufferedImage unitImage = null;
        try {
            unitImage = ImageIO.read(new File("./img/Unit_Giant.JPG"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setIcon(new ImageIcon(unitImage));
        this.setBounds(positionX, 350, 94, 95);
        this.setVisible(true);

    }
}
