package agh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class Vector2dTest {


	Vector2d vec = new Vector2d(1,2);

	
	@Test
	void testEquals() 
	{
		assertTrue(vec.equals(new Vector2d(1,2)));
		assertFalse(vec.equals(new Vector2d(-1,-2)));
	}
		
	@Test
	void testToString()
	{
		assertEquals("Vector2d (1,2)", vec.toString());
	}
	
	@Test
	void testPrecedes()
	{
		assertTrue(vec.precedes(new Vector2d(3,4)));
		assertFalse(vec.precedes(new Vector2d(0,0)));
	}
	
	@Test
	void testFollows()
	{
		assertTrue(vec.follows(new Vector2d(0,0)));
		assertFalse(vec.follows(new Vector2d(3,4)));
	}
	
	@Test
	void testUpperRight()
	{
		assertEquals(new Vector2d(1,3), vec.upperRight(new Vector2d(0,3)));
	}
	
	@Test
	void testUpperLeft()
	{
		assertEquals(new Vector2d(1,-3), vec.lowerLeft(new Vector2d(2,-3)));
	}
	
	@Test
	void testAdd()
	{
		assertEquals(new Vector2d(2,4), vec.add(new Vector2d(1,2)));
	}
	
	@Test
	void testSubtract()
	{
		assertEquals(new Vector2d(0,0), vec.subtract(new Vector2d(1,2)));
	}
	
	@Test
	void testOpposite()
	{
		assertEquals(new Vector2d(-1,-2), vec.opposite());
	}
}
