package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author ashanker
 *
 */
public class input extends KeyAdapter
{
	/**
	 * 
	 */
	objh obj;
	/**
	 * @param obj
	 */
	public input(objh obj)
	{
		this.obj=obj;
	}
	/**
	 *
	 */
	public void keyPressed(KeyEvent e)
	{
		int k=e.getKeyCode();
		for(int i=0; i<obj.object.size();i++)
		{
			gobj tempobject = obj.object.get(i);
			if (tempobject.getType()==type.Player)
			{
				if(k == KeyEvent.VK_W)
				{
					obj.setUp(true);
				}
				if(k == KeyEvent.VK_S)
				{
					obj.setDown(true);
				}
				if(k == KeyEvent.VK_D)
				{
					obj.setRight(true);
				}
				if(k == KeyEvent.VK_A)
				{
					obj.setLeft(true);
				}
			}

			
		}
	}
	/**
	 *
	 */
	public void keyReleased(KeyEvent e)
	{
		int k=e.getKeyCode();
		for(int i=0; i<obj.object.size();i++)
		{
			gobj tempobject = obj.object.get(i);
			if (tempobject.getType()==type.Player)
			{
				if(k == KeyEvent.VK_W)
				{
					obj.setUp(false);
				}
				if(k == KeyEvent.VK_S)
				{
					obj.setDown(false);
				}
				if(k == KeyEvent.VK_D)
				{
					obj.setRight(false);
				}
				if(k == KeyEvent.VK_A)
				{
					obj.setLeft(false);
				}
			}

			
		}
	}

}
