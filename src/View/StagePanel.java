package View;

import Controller.MainController;
import Model.Player.PlayerInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class StagePanel extends BasePanel {

    public JButton unitAdminButton;
    public JButton stage1Button;
    public JButton stage2Button;
    public JButton stage3Button;
    public JButton stage4Button;
    public JButton stage5Button;
    private JPanel cardsPanel;

    public StagePanel(JPanel cardsPanel) {
        super(MainController.getInstance().getPlayerController());
        MainController.getInstance().getPlayerController().add(this);
        this.cardsPanel = cardsPanel;
        addAction();
    }

    @Override
    public void paintComponent(Graphics g) {
        Image bgImage = null;
        try{
            bgImage = ImageIO.read(new File("./img/StageBackground.png"));
        }catch (Exception e) {
            e.printStackTrace();
        }
        g.drawImage(bgImage, 0, 0, 1000, 1000,null);
    }

    @Override
    protected void initComponents() {
        this.setLayout(null);
        this.setSize(1000, 1000);
        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(new File("./img/UnitAdminButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        unitAdminButton = new JButton();
        unitAdminButton.setBounds(30, 50, 361, 113);
        unitAdminButton.setIcon(new ImageIcon(bufferedImage));
        makeTransparent(unitAdminButton);
        this.add(unitAdminButton);

        try {
            bufferedImage = ImageIO.read(new File("./img/Stage1.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage1Button = new JButton();
        stage1Button.setBounds(20, 525, 188, 188);
        stage1Button.setIcon(new ImageIcon(bufferedImage));
        makeTransparent(stage1Button);
        stage1Button.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(stage1Button);

        try {
            bufferedImage = ImageIO.read(new File("./img/Stage2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage2Button = new JButton();
        stage2Button.setBounds(210, 525, 188, 188);
        stage2Button.setIcon(new ImageIcon(bufferedImage));
        makeTransparent(stage2Button);
        stage2Button.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(stage2Button);

        try {
            bufferedImage = ImageIO.read(new File("./img/Stage3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage3Button = new JButton();
        stage3Button.setBounds(400, 525, 188, 188);
        stage3Button.setIcon(new ImageIcon(bufferedImage));
        makeTransparent(stage3Button);
        stage3Button.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(stage3Button);

        try {
            bufferedImage = ImageIO.read(new File("./img/Stage4.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage4Button = new JButton();
        stage4Button.setBounds(590, 525, 188, 188);
        stage4Button.setIcon(new ImageIcon(bufferedImage));
        makeTransparent(stage4Button);
        stage4Button.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(stage4Button);

        try {
            bufferedImage = ImageIO.read(new File("./img/Stage5.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage5Button = new JButton("stage 5");
        stage5Button.setBounds(780, 525, 188, 188);
        stage5Button.setIcon(new ImageIcon(bufferedImage));
        makeTransparent(stage5Button);
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
                int stageNum = 0;
                if (source.equals(stage1Button)) {
                    stageNum = 1;
                } else if (source.equals(stage2Button)) {
                    stageNum = 2;
                } else if (source.equals(stage3Button)) {
                    stageNum = 3;
                } else if (source.equals(stage4Button)) {
                    stageNum = 4;
                } else if (source.equals(stage5Button)) {
                    stageNum = 5;
                }

                ((CardLayout) cardsPanel.getLayout()).show(cardsPanel, "IngamePanel");
                ((IngamePanel)cardsPanel.getComponent(3)).startGame(stageNum);

            }
        };

        addActionListener(actionListener);
    }

    @Override
    public void update(PlayerInfo playerInfo) {

    }
}
