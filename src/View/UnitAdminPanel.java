package View;

import Model.Player.PlayerInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionListener;
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

    public JLabel pointSelectedUnit_1;
    public JLabel pointSelectedUnit_2;
    public JLabel pointSelectedUnit_3;
    public JLabel pointSelectedUnit_4;

    public Image entryArrow;
    public Image bgImage;
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
    public void paintComponent(Graphics g) {
        try{
            bgImage = ImageIO.read(new File("./img/bgImage.png"));
        }catch (Exception e) {}
        g.drawImage(bgImage, 0, 0, 1000, 1000,null);
        try{
            entryArrow = ImageIO.read(new File("./img/selectPoint.png"));
        }catch (Exception e) {}
        g.drawImage(entryArrow, 15, 65, 400, 150,null);

    }
    @Override
    protected void initComponents(){
        this.setLayout(null);
        this.setSize(1000, 1000);

        finishButton =new JButton("완료");
        finishButton.setBounds(800,65,150,100);
        finishButton.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(finishButton);
        /*
        pointSelectedUnit = new JLabel(new ImageIcon(BasePanel.class.getResource("./image/selectPoint.png")));
        pointSelectedUnit.setBounds(30, 15, 400, 150);
        this.add(pointSelectedUnit);
        */
        // label -> size : 100 100

        upgradeButton_1 =new JButton("업그레이드  500G");
        upgradeButton_1.setBounds(150,350,150,100);
        upgradeButton_1.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_1);

        upgradeButton_2 =new JButton("업그레이드  500G");
        upgradeButton_2.setBounds(150,500,150,100);
        upgradeButton_2.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_2);

        upgradeButton_3 =new JButton("업그레이드  500G");
        upgradeButton_3.setBounds(470,350,150,100);
        upgradeButton_3.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_3);

        upgradeButton_4 =new JButton("업그레이드  500G");
        upgradeButton_4.setBounds(470,500,150,100);
        upgradeButton_4.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_4);

        upgradeButton_5 =new JButton("업그레이드  500G");
        upgradeButton_5.setBounds(790,350,150,100);
        upgradeButton_5.setBorder(new SoftBevelBorder((SoftBevelBorder.RAISED)));
        this.add(upgradeButton_5);

        upgradeButton_6 =new JButton("업그레이드  500G");
        upgradeButton_6.setBounds(790,500,150,100);
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
