package main;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * @author ashanker
 *
 */
public class Battlefield 
{
	public Battlefield(int width, int height, String title, Main main)
	{
		JFrame battle = new JFrame(title);
		battle.setPreferredSize(new Dimension(width,height));
		battle.setMaximumSize(new Dimension(width,height));
		battle.setMinimumSize(new Dimension(width,height));
		
		battle.add(main);
		battle.setResizable(false);
		battle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battle.setLocationRelativeTo(null);
		battle.setVisible(true);
	}

	
}
