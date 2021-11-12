package main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Font;

public class Frame1
{

    private JFrame frame;
    private final Action action = new SwingAction();
    private final Action action_1 = new SwingAction_1();
    private final Action action_2 = new SwingAction_2();
    private final Action action_3 = new SwingAction_3();
    private final Action action_4 = new SwingAction_4();


    /**
     * Launch the application.
     */
    public static void main( String[] args )
    {
        EventQueue.invokeLater( new Runnable()
        {
            public void run()
            {
                try
                {
                    Frame1 window = new Frame1();
                    window.frame.setVisible( true );
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }
            }
        } );
    }


    /**
     * Create the application.
     */
    public Frame1()
    {
        initialize();
    }


    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        mapLoader map = new mapLoader();
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(102, 153, 153));
        frame.setBounds( 100, 100, 400 , 500 );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().setLayout(null);
        
        JRadioButton rdbtnYes = new JRadioButton("Yes");
        rdbtnYes.setAction(action_3);
        rdbtnYes.setBounds(69, 156, 141, 23);
        frame.getContentPane().add(rdbtnYes);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("No");
        rdbtnNewRadioButton.setAction(action_4);
        rdbtnNewRadioButton.setBounds(69, 191, 141, 23);
        frame.getContentPane().add(rdbtnNewRadioButton);
        
        JLabel label = new JLabel(" ");
        try {
            Image img = ImageIO.read(getClass().getResource("/shrek.png"));
            label.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        label.setBounds(48, 37, 98, 70);
        frame.getContentPane().add(label);
        
        JLabel label_1 = new JLabel("");
        label_1.setBounds(83, 23, 64, 64);
        frame.getContentPane().add(label_1);
        
        JButton btnWelcomeToShrekt = new JButton("Welcome to Shrekt");
        btnWelcomeToShrekt.setBackground(new Color(0, 255, 51));
        btnWelcomeToShrekt.setFont(new Font("Geeza Pro", Font.PLAIN, 14));
        btnWelcomeToShrekt.setBounds(118, 43, 180, 60);
        frame.getContentPane().add(btnWelcomeToShrekt);
        
        JButton btnDoYouUnderstand = new JButton("Do you understand the rules of the game?");
        btnDoYouUnderstand.setBounds(69, 115, 289, 29);
        frame.getContentPane().add(btnDoYouUnderstand);
        
        JLabel label_2 = new JLabel("");
        try {
            Image img = ImageIO.read(getClass().getResource("/Shrek-5-icon.png"));
            label_2.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        label_2.setBounds(315, 37, 64, 56);
        frame.getContentPane().add(label_2);
        
        JLabel label_4 = new JLabel("");
        try {
            Image img = ImageIO.read(getClass().getResource("/p.png"));
            label_4.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        label_4.setBounds(118, 195, 30, 23);
        frame.getContentPane().add(label_4);
        
        JLabel label_5 = new JLabel("");
        try {
            Image img = ImageIO.read(getClass().getResource("/po.png"));
            label_5.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        label_5.setBounds(123, 156, 30, 23);
        frame.getContentPane().add(label_5);
        
        JLabel label_6 = new JLabel("");
        try {
            Image img = ImageIO.read(getClass().getResource("/check.png"));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        label_6.setBounds(218, 370, 61, 16);
        frame.getContentPane().add(label_6);
        
        JLabel label_7 = new JLabel("");
        try {
            Image img = ImageIO.read(getClass().getResource("/tunuk.png"));
            label_7.setIcon(new ImageIcon(img));
          } catch (Exception ex) {
            System.out.println(ex);
          }
        label_7.setBounds(143, 226, 158, 141);
        frame.getContentPane().add(label_7);
        
        JLabel lblyesWillProceed = new JLabel("*Yes will proceed to take you to the start of Shreks quest*");
        lblyesWillProceed.setBounds(15, 379, 385, 16);
        frame.getContentPane().add(lblyesWillProceed);
        
        JLabel lblnoWillProceed = new JLabel("*No will proceed to take you to the manual on how to play*");
        lblnoWillProceed.setBounds(15, 416, 385, 16);
        frame.getContentPane().add(lblnoWillProceed);
       
    }

    /**
     * @author adi
     *
     */
    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "No");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
        }
    }
    private class SwingAction_1 extends AbstractAction {
        public SwingAction_1() {
            putValue(NAME, "SwingAction_1");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
            new Main();
        }
    }
    private class SwingAction_2 extends AbstractAction {
        public SwingAction_2() {
            putValue(NAME, "SwingAction_2");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
            new Main();
        }
    }
    private class SwingAction_3 extends AbstractAction {
        public SwingAction_3() {
            putValue(NAME, "Yes");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        public void actionPerformed(ActionEvent e) {
            new Main();
        }
    }
    private class SwingAction_4 extends AbstractAction {
        public SwingAction_4() {
            putValue(NAME, "No");
            putValue(SHORT_DESCRIPTION, "Some short description");
            
        }
        public void actionPerformed(ActionEvent e) 
        {
        	System.out.println("W to move up");
        	System.out.println("S to move down");
        	System.out.println("D to move Right");
        	System.out.println("A to move Left");
        	System.out.println("Avoid the farquaads, because if you get hit 3 times by them then you go back to level 1");
        	System.out.println("If the farquaad that moves diagonally gits you even once you restart from level 1 again");
        	System.out.println("Aim anywhere and left click to shoot and if you shoot enemies they dissapear");
        	System.out.println("The objective is to get to the flag and you will be transported to the next level");




        	



        }
    }
}
