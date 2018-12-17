package View;

import Controller.MainController;
import Model.Player.PlayerInfo;
import Model.Player.UserInfo;
import Model.Unit.BaseUnit;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class UnitAdminPanel extends BasePanel {

    public JButton finishButton;

    public JButton upgradeButton_1;
    public JButton upgradeButton_2;
    public JButton upgradeButton_3;
    public JButton upgradeButton_4;
    public JButton upgradeButton_5;
    public JButton upgradeButton_6;

    public JLabel unitLabel_1;
    public JLabel unitLabel_2;
    public JLabel unitLabel_3;
    public JLabel unitLabel_4;
    public JLabel unitLabel_5;
    public JLabel unitLabel_6;

    public JLabel moneyLabel;
    public JLabel userMoneyLabel;

    public JLabel pointSelectedUnit_1;
    public JLabel pointSelectedUnit_2;
    public JLabel pointSelectedUnit_3;
    public JLabel pointSelectedUnit_4;

    private BufferedImage unitImage;
    public Image entryArrow;
    public Image bgImage;
    private JPanel cardsPanel;

    public UnitAdminPanel(JPanel cardsPanel) {
        super(MainController.getInstance().getPlayerController());
        MainController.getInstance().getPlayerController().add(this);
        this.cardsPanel = cardsPanel;
        addAction();
    }

    @Override
    public void paintComponent(Graphics g) {
        try {
            bgImage = ImageIO.read(new File("./img/bgImage.png"));
        } catch (Exception e) {
        }
        g.drawImage(bgImage, 0, 0, 1000, 1000, null);
        try {
            entryArrow = ImageIO.read(new File("./img/selectPoint.png"));
        } catch (Exception e) {
        }
        g.drawImage(entryArrow, 15, 65, 400, 150, null);

    }

    @Override
    protected void initComponents() {
        this.setLayout(null);
        this.setSize(1000, 1000);

        finishButton = new JButton("완료");
        finishButton.setBounds(800, 65, 150, 100);
        finishButton.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(finishButton);

        // label -> size : 100 100
        try {
            unitImage = ImageIO.read(new File("./img/Unit_Dog.JPG"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        moneyLabel = new JLabel("User Money :   ");
        moneyLabel.setBounds(35, 200, 94, 65);
        moneyLabel.setVisible(true);
        this.add(moneyLabel);

        userMoneyLabel = new JLabel(String.valueOf(MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo().getMoney()));
        userMoneyLabel.setBounds(100, 200, 94, 95);
        userMoneyLabel.setVisible(true);
        this.add(userMoneyLabel);

        unitLabel_1 = new JLabel(new ImageIcon(unitImage));
        unitLabel_1.setBounds(35, 350, 94, 95);
        unitLabel_1.setVisible(true);
        this.add(unitLabel_1);

        upgradeButton_1 = new JButton("업그레이드  500G");
        upgradeButton_1.setBounds(150, 350, 150, 100);
        upgradeButton_1.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_1);

        try {
            unitImage = ImageIO.read(new File("./img/Unit_Giant.JPG"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel_2 = new JLabel(new ImageIcon(unitImage));
        unitLabel_2.setBounds(35, 500, 94, 95);
        unitLabel_2.setVisible(true);
        this.add(unitLabel_2);

        upgradeButton_2 = new JButton("업그레이드  500G");
        upgradeButton_2.setBounds(150, 500, 150, 100);
        upgradeButton_2.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_2);

        try {
            unitImage = ImageIO.read(new File("./img/Unit_Knight.JPG"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel_3 = new JLabel(new ImageIcon(unitImage));
        unitLabel_3.setBounds(355, 350, 94, 95);
        unitLabel_3.setVisible(true);
        this.add(unitLabel_3);

        upgradeButton_3 = new JButton("업그레이드  500G");
        upgradeButton_3.setBounds(470, 350, 150, 100);
        upgradeButton_3.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_3);

        try {
            unitImage = ImageIO.read(new File("./img/Unit_Priest.JPG"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel_4 = new JLabel(new ImageIcon(unitImage));
        unitLabel_4.setBounds(355, 500, 94, 95);
        unitLabel_4.setVisible(true);
        this.add(unitLabel_4);

        upgradeButton_4 = new JButton("업그레이드  500G");
        upgradeButton_4.setBounds(470, 500, 150, 100);
        upgradeButton_4.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_4);

        try {
            unitImage = ImageIO.read(new File("./img/Unit_Soldier.JPG"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel_5 = new JLabel(new ImageIcon(unitImage));
        unitLabel_5.setBounds(675, 350, 94, 95);
        unitLabel_5.setVisible(true);
        this.add(unitLabel_5);

        upgradeButton_5 = new JButton("업그레이드  500G");
        upgradeButton_5.setBounds(790, 350, 150, 100);
        upgradeButton_5.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_5);

        try {
            unitImage = ImageIO.read(new File("./img/Unit_Warrior.JPG"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel_6 = new JLabel(new ImageIcon(unitImage));
        unitLabel_6.setBounds(675, 500, 94, 95);
        unitLabel_6.setVisible(true);
        this.add(unitLabel_6);

        upgradeButton_6 = new JButton("업그레이드  500G");
        upgradeButton_6.setBounds(790, 500, 150, 100);
        upgradeButton_6.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_6);

        this.setVisible(true);
    }

    @Override
    protected void addActionListener(ActionListener actionListener) {
        finishButton.addActionListener(actionListener);
        upgradeButton_1.addActionListener(actionListener);
        upgradeButton_2.addActionListener(actionListener);
        upgradeButton_3.addActionListener(actionListener);
        upgradeButton_4.addActionListener(actionListener);
        upgradeButton_5.addActionListener(actionListener);
        upgradeButton_6.addActionListener(actionListener);
    }

    @Override
    protected void addAction() {

        ActionListener actionListener = e -> {
            Object source = e.getSource();
            if (source.equals(finishButton)) {
                if (MainController.getInstance().getPlayerController().getUnitList().size() <= 0) {
                    JOptionPane.showMessageDialog(null, "Unit is not Selected");
                } else {
                    ((CardLayout) cardsPanel.getLayout()).show(cardsPanel, "StagePanel");
                }
            } else if (source.equals(upgradeButton_1)) {
                upgradeUnit("UNIT_A");
            } else if (source.equals(upgradeButton_2)) {
                upgradeUnit("UNIT_B");
            } else if (source.equals(upgradeButton_3)) {
                upgradeUnit("UNIT_C");
            } else if (source.equals(upgradeButton_4)) {
                upgradeUnit("UNIT_D");
            } else if (source.equals(upgradeButton_5)) {
                upgradeUnit("UNIT_E");
            } else if (source.equals(upgradeButton_6)) {
                upgradeUnit("UNIT_F");
            }
        };

        addActionListener(actionListener);

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object source = e.getSource();
                if (source.equals(unitLabel_1)) {
                    addUnit("UNIT_A", true);
                } else if (source.equals(unitLabel_2)) {
                    addUnit("UNIT_B", true);
                } else if (source.equals(unitLabel_3)) {
                    addUnit("UNIT_C", true);
                } else if (source.equals(unitLabel_4)) {
                    addUnit("UNIT_D", true);
                } else if (source.equals(unitLabel_5)) {
                    addUnit("UNIT_E", true);
                } else if (source.equals(unitLabel_6)) {
                    addUnit("UNIT_F", true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        addMyMouseListener(mouseListener);
    }

    private void upgradeUnit(String unitId) {
        UserInfo userInfo = MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo();
        if (userInfo.getMoney() - 500 >= 0) {
            userInfo.setUnitLevel(unitId);
            userInfo.setMoney(userInfo.getMoney() - 500);
            MainController.getInstance().getPlayerController().updateLevelInfo(MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo().getLevelInfo());
            MainController.getInstance().getPlayerController().updatePlayerInfo(userInfo);
        }else{
            JOptionPane.showMessageDialog(null, "Not Enough Money");
        }
     }

    private void addMyMouseListener(MouseListener mouseListener) {
        unitLabel_1.addMouseListener(mouseListener);
        unitLabel_2.addMouseListener(mouseListener);
        unitLabel_3.addMouseListener(mouseListener);
        unitLabel_4.addMouseListener(mouseListener);
        unitLabel_5.addMouseListener(mouseListener);
        unitLabel_6.addMouseListener(mouseListener);
    }

    private void addUnit(String unitId, boolean teamFlag) {
        int levelInfo = MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo().getUnitLevel(unitId);
        BaseUnit unit = MainController.getInstance().getUnitController().produceUnit(unitId, levelInfo, true);
        boolean duplicatedFlag = MainController.getInstance().getPlayerController().addUnit(unit);
        if (duplicatedFlag) {
            JOptionPane.showMessageDialog(null, "Duplicated Unit is Selected");
        } else {
            JOptionPane.showMessageDialog(null, "Unit is Added");
        }
    }

    @Override
    public void update(PlayerInfo playerInfo) {
        userMoneyLabel.setText(String.valueOf(MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo().getMoney()));
    }

}
