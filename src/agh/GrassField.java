package agh;

import java.util.Iterator;
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
//			super.mapBoundary.addObject(grass);
		}
	}
	
	@Override
	public boolean canMoveTo(Vector2d position) {
		if(!isOccupied(position))
			return true;
		return false;
	}
	
	@Override
	public boolean isOccupied(Vector2d position) {
		
		if(super.isOccupied(position))
			return true;

		if(grassFields.containsKey(position))
			return true;

		return false;
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
		Iterator<Vector2d> keyA = animals.keySet().iterator();
		Iterator<Vector2d> keyG = grassFields.keySet().iterator();
		
		Vector2d upperRight = keyA.next();	
				
		while (keyA.hasNext())
		{
			upperRight = upperRight.upperRight(keyA.next());
		}
		while (keyG.hasNext())
		{
			upperRight = upperRight.upperRight(keyG.next());
		}
		return upperRight;
	}
	
	@Override
	public Vector2d getLeftCorner()
	{		
		Iterator<Vector2d> keyA = animals.keySet().iterator();
		Iterator<Vector2d> keyG = grassFields.keySet().iterator();
		
		Vector2d lowerLeft =  keyA.next();
		
		while (keyA.hasNext())
		{
			lowerLeft = lowerLeft.lowerLeft(keyA.next());
		}
		while (keyG.hasNext())
		{
			lowerLeft = lowerLeft.lowerLeft(keyG.next());
		}
		return lowerLeft;
	}	
}
