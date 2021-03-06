package agh;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

	protected List<Animal> animals = new ArrayList<>();
	protected List<Grass> grassFields = new ArrayList<>();
	protected Vector2d uppRight;
	protected Vector2d lowLeft;
	
	public boolean canMoveTo(Vector2d position) {
		if(lowLeft.precedes(position) && uppRight.follows(position) && !isOccupied(position) )
			return true;
		return false;
	}

	public boolean isOccupied(Vector2d position) {
		for(Animal a : animals)
		{
			if(a.getPosition().equals(position))
				return true;
		}
		return false;
	}

	
	public Object objectAt(Vector2d position) {
		if(isOccupied(position))
			for(Animal a : animals)
			{
				if(a.getPosition().equals(position))
				{
					Object obj = a;
					return a;
				}
			}
		return null;
	}
}
