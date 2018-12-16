package View;

import Controller.MainController;
import Model.Player.PlayerInfo;
import Model.Player.UserInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;


public class IngamePanel extends BasePanel {

    public JButton Pause;
    public JButton SkillButton;
    public JButton Summon1;
    public JButton Summon2;
    public JButton Summon3;
    public JButton Summon4;
    public Image bgImage;
    private JPanel cardsPanel;

    public IngamePanel() {
        super();
    }

    public IngamePanel(JPanel cardsPanel) {
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
        System.out.println("LoginPanel Created");

        this.Pause = new JButton("일시정지");
        Pause.setBounds(750,50,200,50);
        Pause.setVisible(true);
        this.add(Pause);
        System.out.println("Pause");

        this.SkillButton = new JButton("스킬");
        SkillButton.setBounds(50,800,100, 100);
        SkillButton.setVisible(true);
        this.add(SkillButton);
        System.out.println("Skill");

        this.Summon1 = new JButton("유닛1");
        Summon1.setBounds(300,850,75,75);
        Summon1.setVisible(true);
        this.add(Summon1);
        System.out.println("Summon1");

        this.Summon2 = new JButton("유닛2");
        Summon2.setBounds(400,850,75,75);
        Summon2.setVisible(true);
        this.add(Summon2);

        this.Summon3 = new JButton("유닛3");
        Summon3.setBounds(500,850,75,75);
        Summon3.setVisible(true);
        this.add(Summon3);

        this.Summon4 = new JButton("유닛4");
        Summon4.setBounds(600,850,75,75);
        Summon4.setVisible(true);
        this.add(Summon4);

        this.setVisible(true);
    }

    @Override
    public void update(PlayerInfo playerInfo) {
        System.out.println("Player Info is updated");
    }

    @Override
    public void addActionListener(ActionListener actionListener) {
        Pause.addActionListener(actionListener);
        SkillButton.addActionListener(actionListener);
        Summon1.addActionListener(actionListener);
        Summon2.addActionListener(actionListener);
        Summon3.addActionListener(actionListener);
        Summon4.addActionListener(actionListener);
    }

    @Override
    protected void addAction() {
        ActionListener actionListener = e -> {
            Object source = e.getSource();
            if (source.equals(SkillButton)) {

            }

        };

        addActionListener(actionListener);

    }
}