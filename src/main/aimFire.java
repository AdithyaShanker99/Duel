package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author ashanker
 *
 */
public class aimFire extends MouseAdapter 
{
	/**
	 * 
	 */
	private objh obj;
	/**
	 * 
	 */
	private view view;
	/**
	 * 
	 */
	private sprites ss;
	/**
	 * @param obj
	 * @param view
	 * @param ss
	 */
	public aimFire(objh obj, view view,sprites ss)
	{
		this.obj=obj;
		this.view=view;
		this.ss=ss;
	}
	/**
	 *
	 */
	public void mousePressed(MouseEvent e)
	{
		int dx = (int)(e.getX()+view.getX());
		int dy = (int)(e.getY()+view.getY());
		
		for(int i=0; i<obj.object.size();i++)
		{
			gobj tempobject = obj.object.get(i);
			if(tempobject.getType() == type.Player)
			{
				obj.addObject(new bullet (tempobject.getX()+16,tempobject.getY()+24,type.Bullet, obj,dx,dy,ss));
			}
		}

	}

}
