package View;

import Controller.EnemyController;
import Controller.MainController;
import Model.Player.PlayerInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class StagePanel extends BasePanel {

    public JButton unitAdminButton;
    public JButton stage1Button;
    public JButton stage2Button;
    public JButton stage3Button;
    public JButton stage4Button;
    public JButton stage5Button;
    private JPanel cardsPanel;
    public static Thread playThread;
    public static Thread enemyThread;
    private EnemyController enemyController;

    public Image bgImage;

    public StagePanel(JPanel cardsPanel) {
        super(MainController.getInstance().getPlayerController());
        MainController.getInstance().getPlayerController().add(this);
        this.cardsPanel = cardsPanel;
        addAction();
    }

    @Override
    public void paintComponent(Graphics g) {
        try{
            bgImage = ImageIO.read(new File("./img/bgImage.png"));
        }catch (Exception e) {}
        g.drawImage(bgImage, 0, 0, 1000, 1000,null);
    }

    @Override
    protected void initComponents() {
        this.setLayout(null);
        this.setSize(1000, 1000);

        unitAdminButton = new JButton("내 유닛 관리");
        unitAdminButton.setBounds(30, 15, 150, 100);
        unitAdminButton.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(unitAdminButton);

        stage1Button = new JButton("stage 1");
        stage1Button.setBounds(30, 425, 150, 100);
        stage1Button.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(stage1Button);

        stage2Button = new JButton("stage 2");
        stage2Button.setBounds(210, 425, 150, 100);
        stage2Button.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(stage2Button);

        stage3Button = new JButton("stage 3");
        stage3Button.setBounds(390, 425, 150, 100);
        stage3Button.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(stage3Button);

        stage4Button = new JButton("stage 4");
        stage4Button.setBounds(570, 425, 150, 100);
        stage4Button.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(stage4Button);

        stage5Button = new JButton("stage 5");
        stage5Button.setBounds(750, 425, 150, 100);
        stage5Button.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(stage5Button);

        this.setVisible(true);
    }

    @Override
    protected void addActionListener(ActionListener actionListener) {
        unitAdminButton.addActionListener(actionListener);
        stage1Button.addActionListener(actionListener);
        stage2Button.addActionListener(actionListener);
        stage3Button.addActionListener(actionListener);
        stage4Button.addActionListener(actionListener);
        stage5Button.addActionListener(actionListener);
    }

    @Override
    protected void addAction() {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            if (source.equals(unitAdminButton)) {
                ((CardLayout) cardsPanel.getLayout()).show(cardsPanel, "UnitAdminPanel");
            } else {

                if (source.equals(stage1Button)) {
                    enemyController = new EnemyController(1);
                } else if (source.equals(stage2Button)) {
                    enemyController = new EnemyController(2);
                } else if (source.equals(stage3Button)) {
                    enemyController = new EnemyController(3);
                } else if (source.equals(stage4Button)) {
                    enemyController = new EnemyController(4);
                } else if (source.equals(stage5Button)) {
                    enemyController = new EnemyController(5);
                }

                System.out.println("----------- G A M E     S T A R T ! -----------");
                ((CardLayout) cardsPanel.getLayout()).show(cardsPanel, "IngamePanel");
                playThread = new Thread(MainController.getInstance().getAttackController());
                enemyThread = new Thread(enemyController);
                MainController.getInstance().getAttackController().setIsPlaying(true);
                enemyController.setIsPlaying(true);
                playThread.start();
                enemyThread.start();

            }
        };

        addActionListener(actionListener);
    }

    @Override
    public void update(PlayerInfo playerInfo) {

    }
}
