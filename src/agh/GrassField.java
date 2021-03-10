package agh;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

	private int numberOfGrassField;
	private Map<Vector2d, Grass> grassFields;
	
	GrassField(int numberOfGrassField)
	{
		this.numberOfGrassField = numberOfGrassField;
		this.grassFields = new LinkedHashMap<>();
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
			grassFields.put(position, new Grass(position));
		}
	}
	
	public boolean placeGrass(Grass grass) {
		if(isOccupied(grass.getPosition()))
			return false;
		grassFields.put(grass.getPosition(), grass);
		return true;
	}
	
	@Override
	public boolean isOccupied(Vector2d position) {
		
		if(super.isOccupied(position))
			return true;

		if(grassFields.containsKey(position))
			return true;

		return false;
	}
	

	public Object objectAt(Vector2d position) {
		
		if(isOccupied(position))  
		{
				if(grassFields.get(position) != null)
				{
					Object obj = grassFields.get(position);
					return obj;
				}
				
				if(animals.get(position) != null)
				{
					Object obj = animals.get(position);
					return obj;
				}
		}	
		
		return null;
	}
	
	public Vector2d getRightCorner()
	{
		Vector2d right = null;

		System.out.println(right);
		for(Vector2d keyA : animals.keySet())
		{			
			for(Vector2d keyG : grassFields.keySet())
			{
				right = keyA.upperRight(keyG);
			}
		}		
		return right;
	}
	
	public Vector2d getLeftCorner()
	{
		Vector2d left = null;

		for(Vector2d keyA : animals.keySet())
		{
			for(Vector2d keyG : grassFields.keySet())
			{
				left = keyA.upperRight(keyG);
			}
		}		
		return left;
	}
	
//	public void corners()		
//	{
//		Vector2d left = null, right = null;
//		
//		if(animals != null && animals.size() != 0)
//		{
//			left = animals.g
//			right = animals.get(0).getPosition();
//	
//			for(Animal a : animals)
//			{
//				left = a.getPosition().lowerLeft(left);
//				right = a.getPosition().upperRight(right);
//			}
//		}
//		if(grassFields != null && grassFields.size() != 0)
//		{
//			for(Grass g : grassFields)
//			{
//				left = g.getPosition().lowerLeft(left);
//				right = g.getPosition().upperRight(right);
//			}
//
//		}			
//		corner.add(0, left);
//		corner.add(1, right);
//	}
	
}
