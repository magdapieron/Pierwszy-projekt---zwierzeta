package agh;

public class Animal{

	private MapDirection orientation;
	private Vector2d position;
	private IWorldMap map;
	
	public Animal()
	{
		this.orientation = MapDirection.NORTH;
		this.position = new Vector2d(2,2);
	}
	
	public Animal(IWorldMap map) 
	{
		this();
		this.map = map; 
	}
	
	public Animal(IWorldMap map, Vector2d initialPosition) {
		this(map);
		this.position = initialPosition;
	}
	
	public MapDirection getOrientation() {
		return orientation;
	}

	public Vector2d getPosition() {
		return position;
	}

	@Override
	public String toString() {	
		return orientation.toString();
	}
	
	 void move(MoveDirection direction)
	{	
		 Vector2d position1 = null;

			switch(direction)
			{
			case RIGHT: orientation = orientation.next();
			break;
			
			case LEFT: orientation = orientation.previous();
			break;
			
			case FORWARD: position1 = position.add(orientation.toUnitVector());
						if(map.canMoveTo(position1)) 
							position = position1;
								
			break;
			
			case BACKWARD: position1 = position.add(orientation.toUnitVector().opposite());
						if(map.canMoveTo(position1))
							position = position1;
			break;
			
			default:
			break;
			}
	}	
}
