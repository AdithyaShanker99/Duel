package main;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author ashanker
 *
 */
public abstract class gobj
{
	/**
	 * 
	 */
	/**
	 * 
	 */
	protected int x,y;
	/**
	 * 
	 */
	/**
	 * 
	 */
	protected float spedx =0, spedy =0;
	/**
	 * 
	 */
	protected type type;
	/**
	 * 
	 */
	protected sprites ss;
	
	/**
	 * @param x
	 * @param y
	 * @param type
	 * @param ss
	 */
	public gobj(int x, int y, type type, sprites ss)
	{
		this.x=x;
		this.y=y;
		this.type = type;
		this.ss=ss;
	}
	
	/**
	 * @return
	 */
	public type getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(type type) {
		this.type = type;
	}

	/**
	 * 
	 */
	public abstract void tick();
	/**
	 * @param grap
	 */
	public abstract void render(Graphics grap) ;
	/**
	 * @return
	 */
	public abstract Rectangle getBounds();
	

	/**
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return
	 */
	public float getSpedx() {
		return spedx;
	}

	/**
	 * @param spedx
	 */
	public void setSpedx(float spedx) {
		this.spedx = spedx;
	}

	/**
	 * @return
	 */
	public float getSpedy() {
		return spedy;
	}

	/**
	 * @param spedy
	 */
	public void setSpedy(float spedy) {
		this.spedy = spedy;
	}
	
}
