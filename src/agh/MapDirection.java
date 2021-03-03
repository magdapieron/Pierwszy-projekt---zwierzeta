package agh;

public enum MapDirection {

	NORTH, 
	EAST, 
	SOUTH, 
	WEST; 
	
	public String toString()
	{
		switch(this)
		{
			case NORTH: return "N";
			case SOUTH: return "S";
			case WEST: return "W";
			case EAST: return "E";
			default: return "No such direction";
		}			
	}
	
	public MapDirection next()
	{
		switch(this)
		{
			case NORTH: return EAST;
			case SOUTH: return WEST;
			case WEST: return NORTH;
			case EAST: return SOUTH;
			default: return null;
		}
	}
	
	public MapDirection previous()
	{
		int index = this.ordinal();
		return MapDirection.values()[(index+3) % 4];
	}
	
	public Vector2d toUnitVector()
	{
		switch(this)
		{
			case NORTH: return new Vector2d(0,1);
			case SOUTH: return new Vector2d(0,-1);
			case WEST: return new Vector2d(-1,0);
			case EAST: return new Vector2d(1,0);
			default: return null;
		}		
	}
}
