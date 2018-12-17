package View;

import Controller.MainController;
import Controller.Strategy.SkillStrategyA;
import Controller.Strategy.SkillStrategyB;
import Model.Player.PlayerInfo;
import Model.Unit.BaseUnit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;


public class IngamePanel extends BasePanel {

    public JButton pauseButton;
    public JButton skillButton;
    public JButton summon1Button;
    public JButton summon2Button;
    public JButton summon3Button;
    public JButton summon4Button;
    private JPanel cardsPanel;
    private Thread playThread;
    private String switchSkill = "스킬A";

    public IngamePanel(JPanel cardsPanel) {
        super(MainController.getInstance().getPlayerController());
        MainController.getInstance().getPlayerController().add(this);
        this.cardsPanel = cardsPanel;
        /*
        playThread = new Thread(MainController.getInstance().getPlayController());
        MainController.getInstance().getPlayController().setIsPlaying(true);
        playThread.start();
        */
        addAction();
    }

    @Override
    public void paintComponent(Graphics g) {
        Image bgImage = null;

        try {
            bgImage = ImageIO.read(new File("./img/bgImage.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(bgImage, 0, 0, 1000, 1000, null);

        g.setColor(Color.RED);
        g.fillRect(700, 850, 250, 25);
        g.setColor(Color.BLUE);
        g.fillRect(700, 900, 250, 25);
        g.setColor(Color.BLACK);
        g.drawRect(700, 850, 250, 25);
        g.drawRect(700, 900, 250, 25);
    }

    @Override
    protected void initComponents() {

        this.setLayout(null);
        this.setSize(1000, 1000);

        this.pauseButton = new JButton("일시정지");
        pauseButton.setBounds(750, 50, 200, 50);
        pauseButton.setVisible(true);
        this.add(pauseButton);

        this.skillButton = new JButton("스킬");
        skillButton.setBounds(50, 800, 100, 100);
        skillButton.setVisible(true);
        this.add(skillButton);

        this.summon1Button = new JButton("유닛1");
        summon1Button.setBounds(300, 850, 75, 75);
        summon1Button.setVisible(true);
        this.add(summon1Button);

        this.summon2Button = new JButton("유닛2");
        summon2Button.setBounds(400, 850, 75, 75);
        summon2Button.setVisible(true);
        this.add(summon2Button);

        this.summon3Button = new JButton("유닛3");
        summon3Button.setBounds(500, 850, 75, 75);
        summon3Button.setVisible(true);
        this.add(summon3Button);

        this.summon4Button = new JButton("유닛4");
        summon4Button.setBounds(600, 850, 75, 75);
        summon4Button.setVisible(true);
        this.add(summon4Button);

        this.setVisible(true);
    }

    @Override
    public void update(PlayerInfo playerInfo) {
        System.out.println("Player Info is updated");
    }

    @Override
    public void addActionListener(ActionListener actionListener) {
        pauseButton.addActionListener(actionListener);
        skillButton.addActionListener(actionListener);
        summon1Button.addActionListener(actionListener);
        summon2Button.addActionListener(actionListener);
        summon3Button.addActionListener(actionListener);
        summon4Button.addActionListener(actionListener);
    }

    @Override
    protected void addAction() {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            PlayerInfo playerInfo = MainController.getInstance().getPlayerController().getPlayerInfo();
            if (source.equals(skillButton)) {
                boolean skillFlag = playerInfo.getSkillFlag();
                if (skillFlag) {
                    MainController.getInstance().getPlayerController().skill(new SkillStrategyA());
                } else {
                    MainController.getInstance().getPlayerController().skill(new SkillStrategyB());
                }
                playerInfo.setSkillFlag(!skillFlag);

            } else if (source.equals(summon1Button)) {
                addUnit(0);

            } else if (source.equals(summon2Button)) {
                addUnit(1);

            } else if (source.equals(summon3Button)) {
                addUnit(2);

            } else if (source.equals(summon4Button)) {
                addUnit(3);
            }

        };

        addActionListener(actionListener);

    }

    private void addUnit(int index) {
        BaseUnit unit = MainController.getInstance().getPlayerController().getUnitByIndex(index);
        if (unit != null) {
            int unitLevel = MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo().getUnitLevel(unit.getUnitId());
            BaseUnit newUnit = MainController.getInstance().getUnitController().produceUnit(unit.getUnitId(), unitLevel, false);
            //MainController.getInstance().getPlayController().addUnit(newUnit);
        }
    }
}