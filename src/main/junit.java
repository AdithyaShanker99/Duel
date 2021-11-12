package main;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import main.flag;
import main.sprites;

/**
 * @author ashanker
 *
 */
public class junit {

	/**
	 * 
	 */
	private mapLoader map = new mapLoader();

	/**
	 * 
	 */
	private BufferedImage spriteSheet = map.loadImage("/sprites2.png");
	/**
	 * 
	 */
	private sprites ss = new sprites(spriteSheet);

	/**
	 * 
	 */
	private objh objectHandler = new objh();

	/**
	 * 
	 */
	@Before
	public void setUp() {

	}

	/**
	 * 
	 */
	@Test
	public void AddObject() {

		objectHandler.addObject(new fighter(32, 32, type.Fighter, objectHandler, ss));
		objectHandler.addObject(new brawler(32, 32, type.Player, objectHandler, ss));
		assertEquals(objectHandler.object.get(0).getType().toString(), type.Fighter.toString());
		assertEquals(objectHandler.object.get(1).getType().toString(), type.Player.toString());

		objectHandler.object.clear();
		System.out.println(objectHandler.object.isEmpty());
		assertEquals(objectHandler.object.isEmpty(), true);

	}

	/**
	 * 
	 */
	@Test
	public void RemoveObject()

	{

		objectHandler.addObject(new fighter(32, 32, type.Fighter, objectHandler, ss));

		objectHandler.removeObject((objectHandler.object.get(0)));

		assertEquals(objectHandler.object.isEmpty(), true);

	}

	/**
	 * 
	 */
	@Test
	public void ClearObject()

	{

		objectHandler.addObject(new fighter(32, 32, type.Fighter, objectHandler, ss));
		objectHandler.addObject(new brawler(32, 32, type.Player, objectHandler, ss));

		objectHandler.object.clear();
		assertEquals(objectHandler.object.isEmpty(), true);

	}

	/**
	 * 
	 */
	@Test
	public void TestNewLevel()

	{

		objectHandler.addObject(new fighter(32, 32, type.Fighter, objectHandler, ss));
		objectHandler.addObject(new brawler(32, 32, type.Player, objectHandler, ss));
		objectHandler.newLevel();
		assertEquals(objectHandler.object.isEmpty(), true);

	}
	
	

	/**
	 * 
	 */
	@Test
	public void TestLoadSprite()

	{

		BufferedImage ground = ss.loadSprite(1, 1, 32, 32);
		assertEquals(ground.getWidth(), 32);
		assertEquals(ground.getHeight(), 32);

	}

	/**
	 * 
	 */
	@Test
	public void TestLoadLevel()

	{
		BufferedImage sprite = map.loadImage("/levelthree.png");
		objectHandler.loadLevel(sprite, ss);
		assertEquals(objectHandler.object.getFirst().type, type.Wall);
		// assertEquals(ground.getHeight(), 32);

	}
	
	/**
	 * 
	 */
	@Test
	public void TestView()

	{
		BufferedImage sprite = map.loadImage("/levelthree.png");
		objectHandler.loadLevel(sprite, ss);
		assertEquals(objectHandler.object.getFirst().type, type.Wall);
		// assertEquals(ground.getHeight(), 32);
	    view view = new view(0,0);
	    assertEquals(view.getX(), 0);

	}
	
	/**
	 * 
	 */
	@Test
	public void TestFighter()

	{

		objectHandler.addObject(new fighter(32, 32, type.Fighter, objectHandler, ss));
		assertEquals(objectHandler.object.get(0).getType().toString(), type.Fighter.toString());
		objectHandler.object.clear();

	}
	
	/**
	 * 
	 */
	@Test
	public void TestPlayer()

	{

		objectHandler.addObject(new brawler(32, 32, type.Player, objectHandler, ss));
		assertEquals(objectHandler.object.get(0).getType().toString(), type.Player.toString());
		objectHandler.object.clear();

	}
	
	/**
	 * 
	 */
	@Test
	public void TestFlag()

	{

		objectHandler.addObject(new flag(32, 32, type.Flag, objectHandler, ss));
		assertEquals(objectHandler.object.get(0).getType().toString(), type.Flag.toString());
		objectHandler.object.clear();

	}
	
	/**
	 * 
	 */
	@Test
	public void TestWall()

	{

		objectHandler.addObject(new wall(32, 32, type.Wall, ss));
		assertEquals(objectHandler.object.get(0).getType().toString(), type.Wall.toString());
		objectHandler.object.clear();

	}
	
	

}
