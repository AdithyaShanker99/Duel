package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author ashanker
 *
 */
public class fighter extends gobj {
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
	public fighter(int x, int y, type type, objh obj,sprites ss) {
		super(x, y, type, ss);	
		this.ss=ss;
		this.obj = obj;
		farq = ss.loadSprite(7, 18, 50, 70);

		spedx = 10;


	}

	/**
	 *
	 */
	@Override
	public void tick() {

		x += spedx;


		collision();

		}
	



	/**
	 * @return
	 */
	private boolean collision() {
		for (int i = 0; i < obj.object.size(); i++) {
			gobj tempObject = obj.object.get(i);

			if (tempObject.getType() == type.Wall) {
				if (getBounds().intersects(tempObject.getBounds())) {
					
					if(spedx==10) {
					spedx = -10;
					
					return true;
					}
					else {
						spedx=10;
						return true;
					}
						
					}
					
				}
			


			}
		return true;

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
	

}
