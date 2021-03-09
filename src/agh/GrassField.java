package agh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

	
	private List<Animal> animals;
	private int numberOfGrassField;
	private int max;
	private List<Grass> grassFields;
	private Vector2d grassPosition;
	private List<Vector2d> corner = new ArrayList<>();

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
	
	@Override
	public boolean canMoveTo(Vector2d position) {	
		if( !isOccupied(position) )
			return true;
		return false;
	}

	public boolean placeGrass(Grass grass) {
		if(isOccupied(grass.getPosition()))
			return false;
		grassFields.add(grass);
		return true;
	}
	
	@Override
	public boolean isOccupied(Vector2d position) {
		
		if(super.isOccupied(position))
			return true;

		for(Grass g : grassFields)
		{
			if(g.getPosition().equals(position))
				return true;
		}
		return false;
	}
	

	public Object objectAt(Vector2d position) {
		
		Object object = super.objectAt(position);
		
		if(object != null)
			return object;

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
	
	private void corners()		
	{
		Vector2d left = null, right = null;
	
		for(int i=0; i<animals.size(); i++)
		System.out.println(animals.get(i).getPosition());
		
		System.out.println(animals);
		
		if(animals != null && animals.size() != 0)
		{
			left = animals.get(0).getPosition();
			right = animals.get(0).getPosition();
	
			for(Animal a : animals)
			{
				left = a.getPosition().lowerLeft(left);
				right = a.getPosition().upperRight(right);
			}

		}
		if(grassFields != null && grassFields.size() != 0)
		{
			left = grassFields.get(0).getPosition();
			right = grassFields.get(0).getPosition();

			for(Grass g : grassFields)
			{
				left = g.getPosition().lowerLeft(left);
				right = g.getPosition().upperRight(right);
			}

		}			
		corner.add(0, left);
		corner.add(1, right);
	}
	
	public String toString()
	{	
		System.out.println("test");
		corners();
		MapVisualizer visulation = new MapVisualizer(this);
		return visulation.draw(corner.get(0), corner.get(1));	
	}
	
}
