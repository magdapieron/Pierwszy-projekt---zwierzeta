package agh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField implements IWorldMap {

	private List<Animal> animals;
	private int numberOfGrassField;
	private int max;
	private List<Grass> grassFields;
	private Vector2d grassPosition;


	GrassField(int numberOfGrassField)
	{
		this.numberOfGrassField = numberOfGrassField;
		this.grassFields = new ArrayList<>();
		this.animals = new ArrayList<>();
		
		placeGrass();
			
	}
	
	public Vector2d randomizePosition()
	{
		int x,y;
		int max = (int)(Math.sqrt(numberOfGrassField*10));
		Random r = new Random();				
		x = r.nextInt(max+1);	
		y = r.nextInt(max+1);
		return new Vector2d(x,y);
	}
	
	public void placeGrass()
	{
		for(int i=0; i<numberOfGrassField; i++)
		{		
			Vector2d position = randomizePosition();
			while(isOccupied(position))				// animal is ok, grass is not  
			{
				position = randomizePosition();
			}
			grassFields.add(new Grass(position));
		}
	}
	
	public boolean canMoveTo(Vector2d position) {	
		if( !isOccupied(position) )
			return true;
		return false;
	}

	@Override
	public boolean placeAnimal(Animal animal) {
		if(isOccupied(animal.getPosition()))
			return false;
		animals.add(animal);
		return true;
	}

	@Override
	public boolean placeGrass(Grass grass) {
		if(isOccupied(grass.getPosition()))
			return false;
		grassFields.add(grass);
		return true;
	}
	
	public boolean isOccupied(Vector2d position) {
		for(Animal a : animals)
		{
			if(a.getPosition().equals(position))
				return true;
		}

		for(Grass g : grassFields)
		{
			if(g.getPosition().equals(position))
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
		for(Grass g : grassFields)
		{
			if(g.getPosition().equals(position))
			{
				Object obj = g;
				return g;
			}
		}
		return null;
	}
	
	public String toString()
	{	
		MapVisualizer visulation = new MapVisualizer(this);
		return visulation.draw(new Vector2d(-2,-2), new Vector2d(10,10));	
	}
	
}
