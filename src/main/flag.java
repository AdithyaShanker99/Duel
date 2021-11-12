package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author ashanker
 *
 */
public class flag extends gobj {
	/**
	 * 
	 */
	objh obj;
	/**
	 * 
	 */
	private BufferedImage farq;

	/**
	 * @param x
	 * @param y
	 * @param type
	 * @param obj
	 * @param ss
	 */
	public flag(int x, int y, type type, objh obj,sprites ss) {
		super(x, y, type, ss);	
		this.ss=ss;
		this.obj = obj;
		farq = ss.loadSprite(7, 20, 50, 100);
//		farq = ss.loadSprite(7, 18, 50, 70);




	}

	
	/**
	 *
	 */
	@Override
	public void render(Graphics grap) 
	{
		grap.drawImage(farq,x,y,null);

	}

	/**
	 *
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}


	/**
	 *
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	

}
