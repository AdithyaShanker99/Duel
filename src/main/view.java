package main;

/**
 * @author ashanker
 *
 */
public class view 
{
	/**
	 * 
	 */
	/**
	 * 
	 */
	private float x,y;
	/**
	 * @param x
	 * @param y
	 */
	public view(float x, float y)
	{
		this.x=x;
		this.y=y;
	}
	
	
	/**
	 * @param obj
	 */
	public void tick(gobj obj)
	{
		x+= ((obj.getX()-x)-1000/2)*0.05f;
		y+= ((obj.getY()-y)-563/2)*0.05f;
		if (x<=0)
		{
			x=0;
		}
		if (x>=1047)
		{
			x=1047;
		}
		if(y<=0)
		{
			y=0;
		}
		if(y>=1507)
		{
			y=1507;
		}

	}


	/**
	 * @return
	 */
	public float getX() {
		return x;
	}


	/**
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}


	/**
	 * @return
	 */
	public float getY() {
		return y;
	}


	/**
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}
	

}
