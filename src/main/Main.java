package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


/**
 * @author ashanker
 *
 */
public class Main extends Canvas implements Runnable
{
	
	
	/**
	 *  playing is if the game is running
	 */
	/**
	 * 
	 */
	private static boolean playing = false;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Thread thread;
	/**
	 * 
	 */
	private objh obj;
	/**
	 * 
	 */
	private BufferedImage sprite =null;
	/**
	 * 
	 */
	private BufferedImage ground = null;
	/**
	 * 
	 */
	private BufferedImage spriteSheet =null;
	/**
	 * 
	 */
	private sprites ss;
	/**
	 * 
	 */
	private view view;
	/**
	 * 
	 */
	public static int fighterCount;
	/**
	 * 
	 */
	public static int levels;

	

	/**
	 * 
	 */
	public Main() 
	{
		/**
		 * dimensions title and the main class
		 */
		new Battlefield(1000, 563, "duel", this);
		play();
		obj = new objh();
		view = new view(0,0);
		this.addKeyListener(new input(obj));
		mapLoader map=new mapLoader(); 
		
		  sprite = map.loadImage("/levelone.png"); 
		  spriteSheet =map.loadImage("/sprites2.png"); 
		  ss=new sprites(spriteSheet);
		 
	    ground=ss.loadSprite(1, 10, 32, 32);
	    this.addMouseListener(new aimFire(obj,view,ss));
		obj.loadLevel(sprite,ss);
		levels=0;
		  
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		
		new Main();
			
		}
		
		
	

	/**
	 *
	 */
	@Override
	/**
	 * this is the run method which is in charge of the fps and refresh rates for the game
	 */
			
	public void run() 
	{
		this.requestFocus();
		long LastTime = System.nanoTime();
		/**
		 * fps
		 */
		double ticks = 60.0;
		double n = 1000000000/ticks;
		double delta =0;
		long time = System.currentTimeMillis();
		int frames =0;
		
		while (playing)
		{
			long now = System.nanoTime();
			delta+= (now-LastTime)/n;
			LastTime=now;
			while(delta>= 1)
			{
				tick();
				delta--;
			}
		
    		
			render();
		frames++;
		
		if(System.currentTimeMillis() - time >1000)
		{
			time+=1000;
			frames=0;
		}
		
		
				} 
			
			
		
		
		
	
		end();
	}
	/**
	 * 
	 */
	public void tick()
	{
		for(int i=0;i<obj.object.size();i++)
		{
			if(obj.object.get(i).getType() == type.Player)
			{
				view.tick(obj.object.get(i));
			}
			
				
			
			 
			 
		}
		obj.tick();
	}
	
	/**
	 * 
	 */
	public void render()
	{
		/**
		 * when buffer strat created it is null, check if null and if so set to 3
		 */
		BufferStrategy b  = this.getBufferStrategy();
		if (b==null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics grap = b.getDrawGraphics();
		Graphics2D downLook =(Graphics2D)grap;
		/*8
		 * draws the graphics
		 */
		
		downLook.translate(-view.getX(), -view.getY());
		for(int xx=0;xx<30*72;xx+=32)
		{
			for(int yy=0; yy<30*72; yy+=32)
			{
				grap.drawImage(ground,xx,yy,null);
			}
		}
		obj.render(grap);
		downLook.translate(view.getX(), view.getY());

		grap.dispose();
		b.show();
	}
	
	/**
	 * @param image
	 */
	private void loadLevel(BufferedImage image)
	{
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
					obj.addObject(new wall(xx*32,yy*32,type.Wall,ss));
				}
				if(blue==255)
				{
					obj.addObject(new brawler(xx*32,yy*32,type.Player,obj,ss));
				}
				if(green==255)
				{
					obj.addObject(new fighter(xx*32,yy*32,type.Fighter,obj,ss));
					count++;
					
				}
				
			}
		}
	}
	/**
	 * 
	 */
	public void play()
	{
		playing=true;
		thread = new Thread(this); 
		/**
		 * this refers to the run method for this class
		 */
		thread.start();
		
	}
	/**
	 * 
	 */
	public void end()
	{
		if(levels==1) {
		playing=false;
		thread.interrupt();
		

		/*
		 * try { thread.join(); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); };
		 * //System.out.println("thread");
		 */		
		}
			
	}
	
	

}
