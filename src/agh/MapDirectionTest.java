package agh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapDirectionTest {

	
	@Test 
	public void testNext()
	{
		assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
		assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
		assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
		assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
	}

	@Test
	public void testPrevious()
	{
		assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
		assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
		assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
		assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
	}
}
