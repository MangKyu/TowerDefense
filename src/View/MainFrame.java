package View;

import Controller.MainController;
import Controller.Observer.PlayerObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainFrame extends JFrame {

    private CardLayout cards;
    private MainController mainController;
    private PlayerObserver playerObserver;

    public MainFrame(MainController mainController) {
        this.mainController = mainController;
        initComponents();

        //playerObserver = 로그인 이후 받아온 데이터
        //this.addKeyListener(new MyKeyListener());
    }

    private void initComponents(){
        LoginPanel loginPanel = new LoginPanel();
        this.add(loginPanel);






        this.setVisible(true);
        this.setResizable(false);
    }

    /*
    public void destroy(){
        int result=JOptionPane.showConfirmDialog(this, "醫낅즺�븯�떆寃좎뒿�땲源�?","醫낅즺",JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result==JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }

    class MyKeyListener implements KeyListener {

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {


                case KeyEvent.VK_ENTER:

                    break;
            }

        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyTyped(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }
    }
    */
}