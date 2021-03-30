package agh;

import java.util.LinkedHashMap;
import java.util.Map;


public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {

	protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
	protected MapVisualizer visulation = new MapVisualizer(this);
	protected MapBoundary mapBoundary = new MapBoundary(this);
	
	public abstract boolean canMoveTo(Vector2d position);
	
	public boolean placeAnimal(Animal animal) {
		if(isOccupied(animal.getPosition()))
			throw new IllegalArgumentException(animal.getPosition() + "is occupied");
		animals.put(animal.getPosition(), animal);
		animal.addObserver(this);						// register the map as an observer
		animal.addObserver(mapBoundary);				// register the mapBoundary as an observer
		mapBoundary.add(animal);
					
		return true;
	}

	public boolean isOccupied(Vector2d position) {	
		return animals.containsKey(position);
	}
	
	abstract Vector2d getRightCorner();		
	abstract Vector2d getLeftCorner();
	
	public String toString()		
	{
		return visulation.draw(getLeftCorner(), getRightCorner());	
	}
	
	public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
	{
		System.out.println("stara i nowa: " + oldPosition + " " + newPosition);
		Animal animal = animals.get(oldPosition);
		System.out.println(animal.getPosition());
		animals.remove(oldPosition, animal);
		animals.put(newPosition, animal);
	}
	
}
