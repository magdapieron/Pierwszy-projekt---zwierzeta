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
		
		IMapElement oldObject = (IMapElement)map.objectAt(oldPosition);
		IMapElement newObject = (IMapElement)map.objectAt(newPosition);
		
//		setX.remove(oldObject);		//NullPointerException
//		setY.remove(oldObject);
		
		setX.remove(newObject);	// Override Animals in sets
		setY.remove(newObject);	
		
		setX.add(newObject);
		setY.add(newObject);			// removed and added with actual position, so sets are tidy
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
		System.out.println("prawy: " + x.upperRight(y));
		System.out.println("X" + setX);
		System.out.println("Y" + setY);
		return x.upperRight(y);
	}
	
	public Vector2d leftCorner()
	{
		Vector2d x = setX.first().getPosition();
		Vector2d y = setY.first().getPosition();
		System.out.println("lewy: " + x.lowerLeft(y));
		return x.lowerLeft(y);
	}
}	


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
					return 1;
				else
					return -1;		
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
					return 1;
				else
					return -1;		
			}
		}
	}
}