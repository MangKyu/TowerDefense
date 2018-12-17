package View;

import Controller.EnemyController;
import Controller.MainController;
import Controller.Strategy.SkillStrategyA;
import Controller.Strategy.SkillStrategyB;
import Model.Player.PlayerInfo;
import Model.Unit.BaseUnit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IngamePanel extends BasePanel implements ActionListener{

    public JButton cancelButton;
    public JButton pauseButton;
    public JButton skillButton;
    public JButton summon1Button;
    public JButton summon2Button;
    public JButton summon3Button;
    public JButton summon4Button;
    private JPanel cardsPanel;
    private Timer timer;
    private Thread playThread;
    private Thread enemyThread;
    private EnemyController enemyController;

    public IngamePanel(JPanel cardsPanel) {
        super(MainController.getInstance().getPlayerController());
        MainController.getInstance().getPlayerController().add(this);
        this.cardsPanel = cardsPanel;
        this.timer = new Timer(1000, this);
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

        int hp = MainController.getInstance().getPlayerController().getPlayerInfo().getHp();
        int mp = MainController.getInstance().getPlayerController().getPlayerInfo().getMp();
        g.setColor(Color.RED);
        g.fillRect(700, 850, hp*250/1000, 25);

        g.setColor(Color.BLUE);
        g.fillRect(700, 900, mp*250/1500, 25);

        g.drawRect(700, 850, 250, 25);
        g.setColor(Color.WHITE);
        g.drawRect(700, 900, 250, 25);
    }

    @Override
    protected void initComponents() {

        this.setLayout(null);
        this.setSize(1000, 1000);

        this.cancelButton = new JButton("돌아가기");
        cancelButton.setBounds(520, 50, 200, 50);
        cancelButton.setVisible(true);
        this.add(cancelButton);

        this.pauseButton = new JButton("일시정지");
        pauseButton.setBounds(750, 50, 200, 50);
        pauseButton.setVisible(true);
        this.add(pauseButton);

        this.skillButton = new JButton();
        BufferedImage btnImage = null;
        try {
            btnImage = ImageIO.read(new File("./img/SkillA.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        skillButton.setIcon(new ImageIcon(btnImage));
        skillButton.setBounds(50, 800, 180, 180);
        skillButton.setVisible(true);
        skillButton.setOpaque(false);
        skillButton.setContentAreaFilled(false);
        skillButton.setBorderPainted(false);
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
    public void addActionListener(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
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
                BufferedImage btnImage = null;
                boolean skillFlag = playerInfo.getSkillFlag();
                if (skillFlag) {
                    MainController.getInstance().getPlayerController().skill(new SkillStrategyA());
                    try {
                        btnImage = ImageIO.read(new File("./img/SkillA.png"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                } else {
                    MainController.getInstance().getPlayerController().skill(new SkillStrategyB());
                    try {
                        btnImage = ImageIO.read(new File("./img/SkillB.png"));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                skillButton.setIcon(new ImageIcon(btnImage));
                playerInfo.setSkillFlag(!skillFlag);

            } else if (source.equals(cancelButton)) {
                MainController.getInstance().getAttackController().setIsPlaying(false);
                EnemyController.isPlaying = false;
                stopTimer();
                ((CardLayout) cardsPanel.getLayout()).show(cardsPanel, "StagePanel");

            } else {
                int index;
                if (source.equals(summon1Button)) {
                      index = 0;
                } else if (source.equals(summon2Button)) {
                    index = 1;
                } else if (source.equals(summon3Button)) {
                    index = 2;
                } else if (source.equals(summon4Button)) {
                    index = 3;
                }else{
                    index = 0;
                }
                addUnit(index);
            }
        };

        addActionListener(actionListener);

    }

    private void addUnit(int index) {
        BaseUnit unit = MainController.getInstance().getPlayerController().getUnitByIndex(index);
        int mp = MainController.getInstance().getPlayerController().getPlayerInfo().getMp() - unit.getCost();
        if (unit != null) {
            if(mp >= 0){
                int unitLevel = MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo().getUnitLevel(unit.getUnitId());
                BaseUnit newUnit = MainController.getInstance().getUnitController().produceUnit(unit.getUnitId(), unitLevel, false);
                MainController.getInstance().getAttackController().addUnit(newUnit);
                this.add(newUnit);
                MainController.getInstance().getPlayerController().getPlayerInfo().setMp(mp);
                MainController.getInstance().getPlayerController().updatePlayerInfo();

                Thread t = new Thread(newUnit);
                t.start();
            }else {
                JOptionPane.showMessageDialog(null, "Player's MP is not enough");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Unit doesn't Exist");

        }
    }

    protected void startGame(int stageNum){
        MainController.getInstance().getPlayerController().getPlayerInfo().setHp(1000);
        MainController.getInstance().getPlayerController().getPlayerInfo().setMp(1500);
        enemyController = new EnemyController(this, stageNum);

        playThread = new Thread(MainController.getInstance().getAttackController());
        enemyThread = new Thread(enemyController);
        MainController.getInstance().getAttackController().setIsPlaying(true);
        enemyController.setIsPlaying(true);
        enemyThread = new Thread(enemyController);
        playThread.start();
        enemyThread.start();
        timer.start();
    }

    private void stopTimer(){
        timer.stop();
    }

    @Override
    public void update(PlayerInfo playerInfo) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timer){
            repaint();
        }
    }
}