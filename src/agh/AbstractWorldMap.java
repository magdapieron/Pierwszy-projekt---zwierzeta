package agh;

import java.util.LinkedHashMap;
import java.util.Map;


public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {

	protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
	protected MapVisualizer visulation = new MapVisualizer(this);
//	protected MapBoundary mapBoundary = new MapBoundary(this);
	
	public abstract boolean canMoveTo(Vector2d position);
	
	public boolean placeAnimal(Animal animal) {
		if(isOccupied(animal.getPosition()))
			throw new IllegalArgumentException(animal.getPosition() + "is occupied");
		animals.put(animal.getPosition(), animal);
		animal.addObserver(this);
		return true;
	}

	public boolean isOccupied(Vector2d position) {
		if(animals.containsKey(position))
			return true;
		return false;
	}
	
	abstract Vector2d getRightCorner();
	abstract Vector2d getLeftCorner();
	
	public String toString()		
	{
		return visulation.draw(getLeftCorner(), getRightCorner());	
	}
	
	public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
	{
		Animal animal = animals.get(oldPosition);
		animals.remove(oldPosition, animal);
		animals.put(newPosition, animal);
	}
}
