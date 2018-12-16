package View;

import Model.Player.PlayerInfo;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class UnitAdminPanel extends BasePanel {

    public JButton finishButton;

    public JButton upgradeButton_1;
    public JButton upgradeButton_2;
    public JButton upgradeButton_3;
    public JButton upgradeButton_4;
    public JButton upgradeButton_5;
    public JButton upgradeButton_6;
    public JButton upgradeButton_7;
    public JButton upgradeButton_8;
    public JButton upgradeButton_9;

    public JLabel unitLabel_1;
    public JLabel unitLabel_2;
    public JLabel unitLabel_3;
    public JLabel unitLabel_4;
    public JLabel unitLabel_5;
    public JLabel unitLabel_6;
    public JLabel unitLabel_7;
    public JLabel unitLabel_8;
    public JLabel unitLabel_9;

    private JLabel pointSelectedUnit;

    public Image entryArrow;
    private JPanel cardsPanel;

    public UnitAdminPanel(){
        super();
    }

    public UnitAdminPanel(JPanel cardsPanel){
        super();
        this.cardsPanel = cardsPanel;
        addAction();
    }

    @Override
    protected void initComponents(){
        this.setLayout(null);
        this.setSize(1000, 1000);

        finishButton =new JButton("완료");
        finishButton.setBounds(800,15,150,100);
        finishButton.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(finishButton);
        /*
        pointSelectedUnit = new JLabel(new ImageIcon(BasePanel.class.getResource("./image/selectPoint.png")));
        pointSelectedUnit.setBounds(30, 15, 400, 150);
        this.add(pointSelectedUnit);
        */
        // label -> size : 100 100
        upgradeButton_1 =new JButton("업그레이드\n  500G");
        upgradeButton_1.setBounds(150,250,150,100);
        upgradeButton_1.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_1);

        upgradeButton_2 =new JButton("업그레이드\n  500G");
        upgradeButton_2.setBounds(150,400,150,100);
        upgradeButton_2.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_2);

        upgradeButton_3 =new JButton("업그레이드\n  500G");
        upgradeButton_3.setBounds(150,550,150,100);
        upgradeButton_3.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_3);

        upgradeButton_4 =new JButton("업그레이드\n  500G");
        upgradeButton_4.setBounds(470,250,150,100);
        upgradeButton_4.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_4);

        upgradeButton_5 =new JButton("업그레이드\n  500G");
        upgradeButton_5.setBounds(470,400,150,100);
        upgradeButton_5.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_5);

        upgradeButton_6 =new JButton("업그레이드\n  500G");
        upgradeButton_6.setBounds(470,550,150,100);
        upgradeButton_6.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_6);

        upgradeButton_7 =new JButton("업그레이드\n  500G");
        upgradeButton_7.setBounds(790,250,150,100);
        upgradeButton_7.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_7);

        upgradeButton_8 =new JButton("업그레이드\n  500G");
        upgradeButton_8.setBounds(790,400,150,100);
        upgradeButton_8.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_8);

        upgradeButton_9 =new JButton("업그레이드\n  500G");
        upgradeButton_9.setBounds(790,550,150,100);
        upgradeButton_9.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_9);

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
        upgradeButton_7.addActionListener(actionListener);
        upgradeButton_8.addActionListener(actionListener);
        upgradeButton_9.addActionListener(actionListener);
    }

    @Override
    protected void addAction() {

        ActionListener actionListener = e -> {
            Object source = e.getSource();
            if (source.equals(finishButton)) {
                ((CardLayout) cardsPanel.getLayout()).show(cardsPanel, "StagePanel");
            } else{

            }
        };

        addActionListener(actionListener);
    }

    @Override
    public void update(PlayerInfo playerInfo) {
        System.out.println("Player Info is updated");
    }
}
