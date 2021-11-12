package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author ashanker
 *
 */
public class bullet extends gobj
{
	/**
	 * 
	 */
	private objh obj;
	

	

	/**
	 * @param x
	 * @param y
	 * @param type
	 * @param obj
	 * @param dx
	 * @param dy
	 * @param ss
	 */
	public bullet(int x, int y, type type, objh obj, int dx, int dy, sprites ss) 
	{
		super(x, y, type, ss);
		this.obj=obj;	
		this.ss=ss;
		spedx=(dx-x)/10;
		spedy=(dy-y)/10;

	}

	/**
	 *
	 */
	@Override
	public void tick() 
	{
		x+=spedx;
		y+=spedy;
		
		for(int i=0; i<obj.object.size(); i++)
		{
			gobj tempobject= obj.object.get(i);
			if(tempobject.getType() == type.Wall)
			{
				if(getBounds().intersects( tempobject.getBounds()))
				{
					obj.removeObject(this);
				}
			}
			
			if(tempobject.getType() == type.Fighter)
			{
				if(getBounds().intersects( tempobject.getBounds()))
				{
					obj.removeObject(tempobject);
					
					
				}
			}
		}
	}

	/**
	 *
	 */
	@Override
	public void render(Graphics grap) 
	{
		grap.setColor(Color.green);
		grap.fillOval(x,y,8,8);
		
	}

	/**
	 *
	 */
	@Override
	public Rectangle getBounds() 
	{
		return new Rectangle(x,y,8,8);
	}
	

}
