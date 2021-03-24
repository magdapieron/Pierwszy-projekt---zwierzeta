package agh;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap {

	/**
	 * map with Grass and Animals
	 */
	
	private int numberOfGrassField;
	private Map<Vector2d, Grass> grassFields;
	
	GrassField(int numberOfGrassField)
	{
		this.numberOfGrassField = numberOfGrassField;
		this.grassFields = new LinkedHashMap<>();
		addGrass();		
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
	
	public void addGrass()
	{
		for(int i=0; i<numberOfGrassField; i++)
		{		
			Vector2d position = randomizePosition();
			while(isOccupied(position))
			{
				position = randomizePosition();
			}
			Grass grass =  new Grass(position);
			grassFields.put(position, grass);
			super.mapBoundary.add(grass);
		}
	}
	
	@Override
	public boolean canMoveTo(Vector2d position) {
		return (!isOccupied(position) || objectAt(position) instanceof Grass);
	}
	
	@Override
	public boolean isOccupied(Vector2d position) {
		
		if(super.isOccupied(position))
			return true;

		return (grassFields.containsKey(position));
			

	}
	
	@Override
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
	
	@Override
	public Vector2d getRightCorner()
	{	
		return mapBoundary.rightCorner();
	}
	
	@Override
	public Vector2d getLeftCorner()
	{		
		return mapBoundary.leftCorner();
	}	
}
