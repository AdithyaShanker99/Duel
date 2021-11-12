package main;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 * @author ashanker
 *
 */
public class objh 
{
	/**
	 * 
	 */
	LinkedList<gobj> object = new LinkedList<gobj>();
	
	private boolean up=false,down =false,left=false,right=false;
	/**
	 * 
	 */
	private sprites ss;
	


	/**
	 * @return
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * @param up
	 */
	public void setUp(boolean up) {
		this.up = up;
	}

	/**
	 * @return
	 */
	public boolean isDown() {
		return down;
	}

	/**
	 * @param down
	 */
	public void setDown(boolean down) {
		this.down = down;
	}

	/**
	 * @return
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * @param left
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}

	/**
	 * @return
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * @param right
	 */
	public void setRight(boolean right) {
		this.right = right;
	}

	/**
	 * 
	 */
	public void tick()
	{
		for (int i =0; i< object.size(); i++)
		{
			gobj tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	/**
	 * @param grap
	 */
	public void render(Graphics grap)
	{
		for (int i =0; i< object.size(); i++)
		{
			gobj tempObject = object.get(i);
			tempObject.render(grap);
		}
	}
	
	/**
	 * 
	 */
	private void clearLevel() {
		
		object.clear();
	}
	
	/**
	 * Loading new level after clearing existing level
	 */
	public void newLevel() {
		clearLevel();
		int Level = main.Main.levels;
		switch(Level) {
		
			
		case 1 :{
			
			mapLoader map=new mapLoader(); 
			 view view = new view(0,0);
			  BufferedImage sprite = map.loadImage("/leveltwo.png"); 
			  
			  BufferedImage spriteSheet = map.loadImage("/sprites2.png"); 
			  ss=new sprites(spriteSheet);
		    BufferedImage ground = ss.loadSprite(1, 1, 32, 32);
		    //this.addMouseListener(new aimFire(obj,view,ss));
		   
			loadLevel(sprite,ss);
		}
		
		case 2 :{
			
			mapLoader map=new mapLoader(); 
			
			  BufferedImage sprite = map.loadImage("/levelthree.png"); 
			  
			  BufferedImage spriteSheet = map.loadImage("/sprites2.png"); 
			  ss=new sprites(spriteSheet);
		    BufferedImage ground = ss.loadSprite(1, 1, 32, 32);
		    //this.addMouseListener(new aimFire(obj,view,ss));
		    view view = new view(0,0);
			loadLevel(sprite,ss);
		}
		
		}
	}
	
	/**
	 * @param tempObject
	 */
	public void addObject(gobj tempObject)
	{
		object.add(tempObject);
	}
	/**
	 * @param tempObject
	 */
	public void removeObject(gobj tempObject)
	{
		object.remove(tempObject);
	}
	
	/**
	 * @param image
	 * @param ss2
	 */
	public  void loadLevel(BufferedImage image, sprites ss2)
	{
		mapLoader map=new mapLoader();
			    
		int count=0;
		int w= image.getWidth();
		int h= image.getHeight();
		for (int xx=0;xx<w;xx++)
		{
			for(int yy=0;yy<h;yy++)
			{
				int pixel = image.getRGB(xx, yy);
				int red= (pixel >> 16)  & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red==255)
				{
					addObject(new wall(xx*32,yy*32,type.Wall,ss2));
				}
				if(blue==255 && green == 0 && (red == 0 || red == 0) )
				{
					addObject(new brawler(xx*32,yy*32,type.Player,this,ss2));
				}
				if(green==255 && blue==0 && red ==0 )
				{
					addObject(new fighter(xx*32,yy*32,type.Fighter,this,ss2));
					count++;
					
				}
				if(green == 255 && blue == 255 && red == 0)
				{
					addObject(new flag(xx*32,yy*32,type.Flag,this,ss2));
					
				}
				
				if(green == 255 && blue == 0 && red == 255)
				{
					addObject(new boss(xx*32,yy*32,type.Boss,this,ss2));
					
					
				}
				
			}
		}
	}
	
	
	

}
