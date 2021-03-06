package agh;

public class RectangularMap extends AbstractWorldMap {
	
	private Vector2d uppRight;
	private Vector2d lowLeft;
	
	public RectangularMap(int width, int height) {
		this.uppRight = new Vector2d(width-1, height-1);
		this.lowLeft = new Vector2d(0,0);
	}
		
	public boolean canMoveTo(Vector2d position) {
		if(getLeftCorner().precedes(position) && getRightCorner().follows(position) && !isOccupied(position))
			return true;
		return false;
	}
	
	public Object objectAt(Vector2d position) {
		if(isOccupied(position))
		{
			if(animals.get(position) != null)
			{
				Object obj = animals.get(position);
				return obj;
			}
		}
		return null;
	}

	@Override
	public Vector2d getRightCorner() {
		return uppRight;
	}

	@Override
	public Vector2d getLeftCorner() {
		return lowLeft;
	}
	
}
