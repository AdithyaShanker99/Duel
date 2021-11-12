package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author ashanker
 *
 */
public class brawler extends gobj
{
    /**
     * 
     */
    /**
     * 
     */
    objh obj;
    /**
     * 
     */
    /**
     * 
     */
    int lifeCount = 0;
    /**
     * 
     */
    /**
     * 
     */
    private BufferedImage troll;
    //private view vw;

	/**
	 * @param x
	 * @param y
	 * @param type
	 * @param obj
	 * @param ss
	 */
	
	public brawler(int x, int y, type type,objh obj, sprites ss) {
		super(x, y, type, ss);
		this.obj=obj;
		troll = ss.loadSprite(7, 15, 50, 85);
	}

	/**
	 *
	 */
	/**
	 *
	 */
	@Override
	public void tick() 
	{
		x+=spedx;
		y+=spedy;
		collision();
		if (obj.isUp())
		{
			spedy=-10;
		}
		else if (!obj.isDown())
		{
			spedy=0;
		}
		if (obj.isDown())
		{
			spedy=10;
		}
		else if (!obj.isUp())
		{
			spedy=0;
		}
		if (obj.isRight())
		{
			spedx=10;
		}
		else if (!obj.isLeft())
		{
			spedx=0;
		}
		if (obj.isLeft())
		{
			spedx=-10;
		}
		else if (!obj.isRight())
		{
			spedx=0;
		}
	}
	/**
	 * 
	 */
	/**
	 * 
	 */
	private void collision()
	{
		for(int i=0;i<obj.object.size();i++)
		{
			gobj tempObject = obj.object.get(i);
			if(tempObject.getType() == type.Wall )
			{
				if(getBounds().intersects(tempObject.getBounds()))
				{
					x+= spedx*-1;
					y+= spedy*-1;

				}
				
			}
			if(tempObject.getType() == type.Fighter )
			{
				if(getBounds().intersects(tempObject.getBounds()))
					
				{
					lifeCount++;
					if (lifeCount == 10) {
						System.out.println("Game Over");
						//main.Main.levels=3;
						//new main.Main();
					}

				}
				
			}
			
			if(tempObject.getType() == type.Flag )
			{
				if(getBounds().intersects(tempObject.getBounds()))
					
				{
					if (main.Main.levels == 2 ) {
						System.out.println("Congrulatgion you have completed the game" );
					}
					else {
					main.Main.levels=main.Main.levels+1;
					this.obj.newLevel();
					}
				}
				
			}
		}
	
	}
	/**
	 *
	 */
	/**
	 *
	 */
	@Override
	public void render(Graphics grap) {
		grap.drawImage(troll,x,y,null);

	}

	/**
	 *
	 */
	/**
	 *
	 */
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}
	
}
