package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author ashanker
 *
 */
public class boss extends gobj {
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
	public boss(int x, int y, type type, objh obj,sprites ss) {
		super(x, y, type, ss);	
		this.ss=ss;
		this.obj = obj;
		farq = ss.loadSprite(7, 18, 50, 70);
		
		spedx = 10;
		//this.obj.addObject(new bullet (16,24,type.Bullet, obj,0,0,ss));


	}

	/**
	 *
	 */
	@Override
	public void tick() {
		
		/*
		 * x += spedx; Random rand = new Random();
		 * 
		 * int rand_int1 = rand.nextInt(20); int rand_int2 = rand.nextInt(500);
		 * obj.addObject(new bullet (x+rand_int1,y+rand_int2,type.Bullet, obj,rand_int1
		 * ,rand_int2,ss)); //obj.addObject(new bullet (x+16,y+24,type.Bullet,
		 * obj,rand_int1 ,rand_int2,ss)); //
		 */		collision();

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
