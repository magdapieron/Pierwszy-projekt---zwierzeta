package agh;

import java.util.LinkedList;
import java.util.List;

public class Animal implements IMapElement{

	private MapDirection orientation;
	private Vector2d position;
	private IWorldMap map;
	private List<IPositionChangeObserver> observers = new LinkedList<>();
	
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

	@Override
	public Vector2d getPosition() {
		return position;
	}

	@Override
	public String toString() {	
		return orientation.toString();
	}
	
	public void move(MoveDirection direction)
	{	
		 Vector2d nextPosition = null;

			switch(direction)
			{
			case RIGHT: orientation = orientation.next();
			break;
			
			case LEFT: orientation = orientation.previous();
			break;
			
			case FORWARD: nextPosition = position.add(orientation.toUnitVector());
							tryMove(nextPosition);
								
			break;
			
			case BACKWARD: nextPosition = position.add(orientation.toUnitVector().opposite());
							tryMove(nextPosition);
			break;
			
			default:
			break;
			}
	}	
	
	private void tryMove(Vector2d nextPosition)
	{
		if(map.canMoveTo(nextPosition))
		{
			positionChanged(position, nextPosition);
			this.position = nextPosition;
		}
	}
	 
	public void addObserver(IPositionChangeObserver observer)
	 {
		 observers.add(observer);
	 }
	 
	public void removeObserver(IPositionChangeObserver observer)
	 {
		 observers.remove(observer);
	 }
	 
	public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
	 {
		 for(IPositionChangeObserver obs : observers)
		 {
			 obs.positionChanged(oldPosition, newPosition);
		 }
	 }
}
