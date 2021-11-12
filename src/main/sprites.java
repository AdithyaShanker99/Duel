package main;

import java.awt.image.BufferedImage;

/**
 * @author ashanker
 *
 */
public class sprites 
{
	/**
	 * 
	 */
	private BufferedImage img;
	/**
	 * @param img
	 */
	public sprites(BufferedImage img)
	{
		this.img=img;
	}
	/**
	 * @param col
	 * @param row
	 * @param width
	 * @param height
	 * @return
	 */
	public BufferedImage loadSprite(int col, int row, int width, int height)
	{
		return img.getSubimage(col*32-32, row*32-32, width, height);
	}

}
