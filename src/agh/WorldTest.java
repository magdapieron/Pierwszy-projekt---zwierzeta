package agh;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class WorldTest extends OptionParser{

	RectangularMap map = new RectangularMap(4,5);
	Animal animal = new Animal(map);
	String[] movements = new String[] {"f", "r", "right", "b", "s", "k"};
	MoveDirection[] correctMovements = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.BACKWARD};
	
	@Test
	void shouldGetGoodLocation() 
	{
		animal.move(MoveDirection.RIGHT);
		assertEquals(MapDirection.EAST, animal.getOrientation());
	}

	@Test
	void shouldGetGoodPosition()
	{
		animal.move(MoveDirection.FORWARD);
		assertEquals(new Vector2d(2,3), animal.getPosition());
	}
	
	@Test
	void isOnTheMap()
	{
		for(int i=0; i<6; i++)
		{
			animal.move(MoveDirection.FORWARD);
		}
		assertEquals(new Vector2d(2,4), animal.getPosition());
		
		for(int i=0; i<6; i++) 
		{
			animal.move(MoveDirection.BACKWARD);
		}
		assertEquals(new Vector2d(2,0), animal.getPosition());
	}
	
	@Test
	void areCorrectlyInterpreted()
	{
		assertTrue(Arrays.deepEquals(parse(movements),correctMovements ));
	}
	
	
	String[] args = new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
	MoveDirection[] directions = new OptionParser().parse(args);
	IWorldMap map1 = new RectangularMap(10, 5);
	Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
	IEngine enegine = new SimulationEngine(directions, map1, positions);
			
	@Test
	void testAnimalsOrientations()
	{
		
	}
}
