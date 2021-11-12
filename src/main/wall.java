package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author ashanker
 *
 */
public class wall extends gobj
{
	/**
	 * 
	 */
	private BufferedImage wall;

	/**
	 * @param x
	 * @param y
	 * @param type
	 * @param ss
	 */
	public wall(int x, int y, type type,sprites ss) 
	{
		
		super(x, y, type, ss);
		this.ss=ss;
		wall = ss.loadSprite(1, 20, 32, 32);
	}

	/**
	 *
	 */
	@Override
	public void tick() 
	{
		
	}

	/**
	 *
	 */
	@Override
	public void render(Graphics grap) 
	{
		grap.drawImage(wall,x,y,null);
	}

	/**
	 *
	 */
	@Override
	public Rectangle getBounds() 
	{
		return new Rectangle(x,y,32,32);
	}
	

}
