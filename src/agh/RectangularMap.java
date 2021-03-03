package agh;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
	
	private List<Animal> animals;
	private int width;
	private int height;
	private Vector2d uppRight;
	private Vector2d lowLeft; 

	
	public RectangularMap(int width, int height) {
		this.width = width;
		this.height = height;
		this.uppRight = new Vector2d(width-1, height-1);
		this.lowLeft = new Vector2d(0,0);
		this.animals = new ArrayList<>();
	}
	
		@Override
	public boolean canMoveTo(Vector2d position) {
		if(lowLeft.precedes(position) && uppRight.follows(position) && !isOccupied(position) )
			return true;
		return false;
	}
		
	
	@Override
	public boolean place(Animal animal) {
		if(isOccupied(animal.getPosition()))
			return false;
		animals.add(animal);
		return true;
	}

	@Override
	public boolean isOccupied(Vector2d position) {
		for(Animal a : animals)
		{
			if(a.getPosition().equals(position))
				return true;
		}
		return false;
	}

	@Override
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
	
	public String toString()
	{
		MapVisualizer visulation = new MapVisualizer(this);
		return visulation.draw(this.lowLeft, this.uppRight);	
	}
	
}
