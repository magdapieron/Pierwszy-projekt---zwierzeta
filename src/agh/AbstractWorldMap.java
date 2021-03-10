package agh;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public abstract class AbstractWorldMap implements IWorldMap {

	protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
	protected MapVisualizer visulation = new MapVisualizer(this);
	protected List<Vector2d> corner = new ArrayList<>();
	
	public boolean canMoveTo(Vector2d position) {
		if(getLeftCorner().precedes(position) && getRightCorner().follows(position) && !isOccupied(position) )
			return true;
		return false;
	}
	
	public boolean placeAnimal(Animal animal) {
		if(isOccupied(animal.getPosition()))
			return false;
		animals.put(animal.getPosition(), animal);
		return true;
	}

	public boolean isOccupied(Vector2d position) {
		if(animals.containsKey(position))
			return true;
		return false;
	}
	
//	public abstract void corners();
	public abstract Vector2d getRightCorner();
	public abstract Vector2d getLeftCorner();
	
	public String toString()		
	{
		return visulation.draw(getLeftCorner(), getRightCorner());	
	}
}
