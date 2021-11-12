package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author ashanker
 *
 */
public class mapLoader 
{
	/**
	 * 
	 */
	private BufferedImage image;
	
	/**
	 * @param path
	 * @return
	 */
	public BufferedImage loadImage(String path)
	{
		try 
		{
			image = ImageIO.read(getClass().getResource(path));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return image;
	}
	

}
