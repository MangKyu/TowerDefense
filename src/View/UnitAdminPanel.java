package View;

import Model.Player.PlayerInfo;

import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
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

    private JLabel pointSelectedUnit = new JLabel(new ImageIcon(BasePanel.class.getResource("./image/selectPoint.png")));

    public UnitAdminPanel(){
        super();
    }

    @Override
    protected void initComponents(){
        this.setLayout(null);
        this.setSize(1000, 1000);

        finishButton =new JButton("완료");
        finishButton.setBounds(800,15,150,100);
        finishButton.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(finishButton);

        pointSelectedUnit.setBounds(30, 15, 400, 150);
        this.add(pointSelectedUnit);

        upgradeButton_1 =new JButton("업그레이드\n  500G");
        upgradeButton_1.setBounds(30,250,150,100);
        upgradeButton_1.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_1);

        upgradeButton_2 =new JButton("업그레이드\n  500G");
        upgradeButton_2.setBounds(150,250,150,100);
        upgradeButton_2.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_2);

        upgradeButton_3 =new JButton("업그레이드\n  500G");
        upgradeButton_3.setBounds(280,250,150,100);
        upgradeButton_3.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_3);

        this.setVisible(true);
    }

    @Override
    protected void addActionListener(ActionListener actionListener) {
        finishButton.addActionListener(actionListener);
        upgradeButton_1.addActionListener(actionListener);
        upgradeButton_2.addActionListener(actionListener);
        upgradeButton_3.addActionListener(actionListener);

    }

    @Override
    public void update(PlayerInfo playerInfo) {

    }
}
