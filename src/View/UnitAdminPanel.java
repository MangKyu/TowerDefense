package View;

import Controller.Main;
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
import java.util.ArrayList;

public class UnitAdminPanel extends BasePanel {

    public JButton finishButton;

    public JButton upgradeButton1;
    public JButton upgradeButton2;
    public JButton upgradeButton3;
    public JButton upgradeButton4;
    public JButton upgradeButton5;
    public JButton upgradeButton6;

    public JLabel unitLabel1;
    public JLabel unitLabel2;
    public JLabel unitLabel3;
    public JLabel unitLabel4;
    public JLabel unitLabel5;
    public JLabel unitLabel6;

    public JLabel moneyLabel;
    public JLabel userMoneyLabel;

    public JLabel selectedUnit1;
    public JLabel selectedUnit2;
    public JLabel selectedUnit3;
    public JLabel selectedUnit4;

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
            entryArrow = ImageIO.read(new File("./img/selectPoint.png"));
            g.drawImage(bgImage, 0, 0, 1000, 1000, null);
            g.drawImage(entryArrow, -80, 65, 400, 150, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initComponents() {
        this.setLayout(null);
        this.setSize(1000, 1000);
        BufferedImage btnImage = null;

        try {
            unitImage = ImageIO.read(new File("./img/GiantButton.png"));
            btnImage = ImageIO.read(new File("./img/FinishButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        finishButton = new JButton();
        finishButton.setIcon(new ImageIcon(btnImage));
        finishButton.setBounds(770, 90, 220, 85);
        makeTransparent(finishButton);
        finishButton.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(finishButton);

        try {
            btnImage = ImageIO.read(new File("./img/UpgradeButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        moneyLabel = new JLabel("User Money :");
        moneyLabel.setFont (moneyLabel.getFont().deriveFont (28.0f));
        moneyLabel.setBounds(35, 220, 200, 65);
        moneyLabel.setVisible(true);
        this.add(moneyLabel);

        userMoneyLabel = new JLabel(String.valueOf(MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo().getMoney()));
        userMoneyLabel.setFont (userMoneyLabel.getFont().deriveFont (28.0f));
        userMoneyLabel.setBounds(250, 210, 180, 95);
        userMoneyLabel.setVisible(true);
        this.add(userMoneyLabel);

        // label -> size : 100 100
        try {
            unitImage = ImageIO.read(new File("./img/DogButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        unitLabel1 = new JLabel(new ImageIcon(unitImage));
        unitLabel1.setBounds(0, 350, 150, 150);
        unitLabel1.setVisible(true);
        this.add(unitLabel1);

        upgradeButton1 = new JButton();
        upgradeButton1.setIcon(new ImageIcon(btnImage));
        upgradeButton1.setBounds(115, 380, 200, 87);
        makeTransparent(upgradeButton1);
        upgradeButton1.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton1);

        try {
            unitImage = ImageIO.read(new File("./img/GiantButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel2 = new JLabel(new ImageIcon(unitImage));
        unitLabel2.setBounds(0, 550, 150, 150);
        unitLabel2.setVisible(true);
        this.add(unitLabel2);

        upgradeButton2 = new JButton();
        upgradeButton2.setIcon(new ImageIcon(btnImage));
        upgradeButton2.setBounds(115, 580, 200, 87);
        makeTransparent(upgradeButton2);
        upgradeButton2.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton2);

        try {
            unitImage = ImageIO.read(new File("./img/KnightButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel3 = new JLabel(new ImageIcon(unitImage));
        unitLabel3.setBounds(355, 350, 150, 150);
        unitLabel3.setVisible(true);
        this.add(unitLabel3);

        upgradeButton3 = new JButton();
        upgradeButton3.setIcon(new ImageIcon(btnImage));
        upgradeButton3.setBounds(470, 380, 200, 87);
        makeTransparent(upgradeButton3);
        upgradeButton3.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton3);

        try {
            unitImage = ImageIO.read(new File("./img/PriestButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel4 = new JLabel(new ImageIcon(unitImage));
        unitLabel4.setBounds(355, 550, 150, 150);
        unitLabel4.setVisible(true);
        this.add(unitLabel4);

        upgradeButton4 = new JButton();
        upgradeButton4.setIcon(new ImageIcon(btnImage));
        upgradeButton4.setBounds(470, 580, 200, 87);
        makeTransparent(upgradeButton4);
        upgradeButton4.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton4);

        try {
            unitImage = ImageIO.read(new File("./img/SoldierButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel5 = new JLabel(new ImageIcon(unitImage));
        unitLabel5.setBounds(675, 350, 150, 150);
        unitLabel5.setVisible(true);
        this.add(unitLabel5);

        upgradeButton5 = new JButton();
        upgradeButton5.setIcon(new ImageIcon(btnImage));
        upgradeButton5.setBounds(790, 380, 200, 87);
        makeTransparent(upgradeButton5);
        upgradeButton5.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton5);

        try {
            unitImage = ImageIO.read(new File("./img/WarriorButton.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        unitLabel6 = new JLabel(new ImageIcon(unitImage));
        unitLabel6.setBounds(675, 550, 150, 150);
        unitLabel6.setVisible(true);
        this.add(unitLabel6);

        upgradeButton6 = new JButton();
        upgradeButton6.setIcon(new ImageIcon(btnImage));
        upgradeButton6.setBounds(790, 580, 200, 87);
        makeTransparent(upgradeButton6);
        upgradeButton6.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton6);

        try {
            unitImage = ImageIO.read(new File("./img/EmptyUnit.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        selectedUnit1 = new JLabel(new ImageIcon(unitImage));
        selectedUnit1.setBounds(260, 80, 110, 110);
        selectedUnit1.setVisible(true);
        this.add(selectedUnit1);

        selectedUnit2 = new JLabel(new ImageIcon(unitImage));
        selectedUnit2.setBounds(390, 80, 110, 110);
        selectedUnit2.setVisible(true);
        this.add(selectedUnit2);

        selectedUnit3 = new JLabel(new ImageIcon(unitImage));
        selectedUnit3.setBounds(520, 80, 110, 110);
        selectedUnit3.setVisible(true);
        this.add(selectedUnit3);

        selectedUnit4 = new JLabel(new ImageIcon(unitImage));
        selectedUnit4.setBounds(650, 80, 110, 110);
        selectedUnit4.setVisible(true);
        this.add(selectedUnit4);

        this.setVisible(true);
    }

    @Override
    protected void addActionListener(ActionListener actionListener) {
        finishButton.addActionListener(actionListener);
        upgradeButton1.addActionListener(actionListener);
        upgradeButton2.addActionListener(actionListener);
        upgradeButton3.addActionListener(actionListener);
        upgradeButton4.addActionListener(actionListener);
        upgradeButton5.addActionListener(actionListener);
        upgradeButton6.addActionListener(actionListener);
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
            } else if (source.equals(upgradeButton1)) {
                upgradeUnit("UNIT_A");
            } else if (source.equals(upgradeButton2)) {
                upgradeUnit("UNIT_B");
            } else if (source.equals(upgradeButton3)) {
                upgradeUnit("UNIT_C");
            } else if (source.equals(upgradeButton4)) {
                upgradeUnit("UNIT_D");
            } else if (source.equals(upgradeButton5)) {
                upgradeUnit("UNIT_E");
            } else if (source.equals(upgradeButton6)) {
                upgradeUnit("UNIT_F");
            }
        };

        addActionListener(actionListener);

        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object source = e.getSource();
                if (source.equals(unitLabel1)) {
                    addUnit("UNIT_A");
                } else if (source.equals(unitLabel2)) {
                    addUnit("UNIT_B");
                } else if (source.equals(unitLabel3)) {
                    addUnit("UNIT_C");
                } else if (source.equals(unitLabel4)) {
                    addUnit("UNIT_D");
                } else if (source.equals(unitLabel5)) {
                    addUnit("UNIT_E");
                } else if (source.equals(unitLabel6)) {
                    addUnit("UNIT_F");
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
            JOptionPane.showMessageDialog(null, "Unit is Upgraded");
        } else {
            JOptionPane.showMessageDialog(null, "Not Enough Money");
        }
     }

    private void addMyMouseListener(MouseListener mouseListener) {
        unitLabel1.addMouseListener(mouseListener);
        unitLabel2.addMouseListener(mouseListener);
        unitLabel3.addMouseListener(mouseListener);
        unitLabel4.addMouseListener(mouseListener);
        unitLabel5.addMouseListener(mouseListener);
        unitLabel6.addMouseListener(mouseListener);
    }

    private void addUnit(String unitId) {
        int levelInfo = MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo().getUnitLevel(unitId);
        BaseUnit unit = MainController.getInstance().getUnitController().produceUnit(unitId, levelInfo, false);
        boolean duplicatedFlag = MainController.getInstance().getPlayerController().isDuplicated(unit);
        if (duplicatedFlag) {
            JOptionPane.showMessageDialog(null, "Duplicated Unit is Selected");
        } else {
            JOptionPane.showMessageDialog(null, "Unit is Added");
            ArrayList unitList = MainController.getInstance().getPlayerController().getUnitList();
            int unitListSize = unitList.size();
            if(unitListSize <= 3){
                switch (unitListSize){
                    case 0:
                        selectedUnit1.setIcon(getUnitIcon(unitId));
                        break;
                    case 1:
                        selectedUnit2.setIcon(getUnitIcon(unitId));
                        break;
                    case 2:
                        selectedUnit3.setIcon(getUnitIcon(unitId));
                        break;
                    case 3:
                        selectedUnit4.setIcon(getUnitIcon(unitId));
                        break;
                }
            }else{
                selectedUnit1.setIcon(selectedUnit2.getIcon());
                selectedUnit2.setIcon(selectedUnit3.getIcon());
                selectedUnit3.setIcon(selectedUnit4.getIcon());
                selectedUnit4.setIcon(getUnitIcon(unitId));
                MainController.getInstance().getPlayerController().getUnitList().remove(0);
            }
            MainController.getInstance().getPlayerController().addUnit(unit);
        }
    }

    private ImageIcon getUnitIcon(String unitId){
        BufferedImage unitImage = null;
        String imagePath = null;

        switch (unitId) {
            case "UNIT_A":
                imagePath = "./img/DogButton.png";
                break;
            case "UNIT_B":
                imagePath = "./img/GiantButton.png";
                break;
            case "UNIT_C":
                imagePath = "./img/KnightButton.png";
                break;
            case "UNIT_D":
                imagePath = "./img/PriestButton.png";
                break;
            case "UNIT_E":
                imagePath = "./img/SoldierButton.png";
                break;
            case "UNIT_F":
                imagePath = "./img/WarriorButton.png";
                break;
            default:
                break;
        }

        try {
            unitImage = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ImageIcon(unitImage);
    }

    @Override
    public void update(PlayerInfo playerInfo) {
        userMoneyLabel.setText(String.valueOf(MainController.getInstance().getPlayerController().getPlayerInfo().getUserInfo().getMoney()));
    }

}
