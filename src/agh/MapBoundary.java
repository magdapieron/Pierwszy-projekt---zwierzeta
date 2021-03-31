package agh;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

	/**
	 * storing information about the area covered by objects on the map
	 */

	private TreeSet<IMapElement> setX;
	private TreeSet<IMapElement> setY;
	private IWorldMap map;
	 
	public MapBoundary(IWorldMap map)
	{
		this.setX = new TreeSet<>(new Xcomparator());
		this.setY = new TreeSet<>(new Ycomparator());
		this.map = map;
	}
		
	@Override
	public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
				
		Animal oldAnimal = new Animal(map, oldPosition);	// works on copies, thing to change 
		IMapElement oldObject = (IMapElement)oldAnimal;
		
		Animal newAnimal = new Animal(map, newPosition);
		IMapElement newObject = (IMapElement)newAnimal;
		
		setX.remove(oldObject);			 				
		setY.remove(oldObject);	
												// removed and added with actual position, so sets are tidy
		setX.add(newObject);
		setY.add(newObject);					
	}
	
	public void add(IMapElement object)
	{
		setX.add(object);
		setY.add(object);
	}
	
	public Vector2d rightCorner()
	{
		Vector2d x = setX.last().getPosition();
		Vector2d y = setY.last().getPosition();
		return x.upperRight(y);
	}
	
	public Vector2d leftCorner()
	{
		Vector2d x = setX.first().getPosition();
		Vector2d y = setY.first().getPosition();
		return x.lowerLeft(y);
	}
}	


/**
 * Comparator returns:
 * -1 if object1 < object 2
 * 1 if object1 > object2
 * 0 if it's the same object 
 */

class Xcomparator implements Comparator<IMapElement>
{	
	@Override
	public int compare(IMapElement x1, IMapElement x2) {
		
		int differenceX = x1.getPosition().x - x2.getPosition().x;
		int differenceY = x1.getPosition().y - x2.getPosition().y;
				
		if(differenceX != 0)
			return differenceX;	
		
		else
		{
			if(differenceY != 0)
				return differenceY;
			
			else
			{
				if(x1 instanceof Animal && x2 instanceof Grass)
					return -1;
				else if(x1 instanceof Grass && x2 instanceof Animal)
					return 1;
				else
					return 0;	
			}
		}
	}
}

class Ycomparator implements Comparator<IMapElement>
{
	@Override
	public int compare(IMapElement y1, IMapElement y2) 
	{		
		int differenceX = y1.getPosition().x - y2.getPosition().x;
		int differenceY = y1.getPosition().y - y2.getPosition().y;
		
		if(differenceY != 0)
			return differenceY;
		
		else
		{
			if(differenceX != 0)
				return differenceX;
			
			else
			{
				if(y1 instanceof Animal && y2 instanceof Grass)
					return -1;
				else if(y1 instanceof Grass && y2 instanceof Animal)
					return 1;
				else
					return 0;
			}
		}
	}
}