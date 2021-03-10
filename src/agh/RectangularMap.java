package agh;


public class RectangularMap extends AbstractWorldMap{
	
	private Vector2d uppRight;
	private Vector2d lowLeft;

	
	public RectangularMap(int width, int height) {
		this.uppRight = new Vector2d(width-1, height-1);
		this.lowLeft = new Vector2d(0,0);
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
	
	
//	public void corners()	
//	{
//		corner.add(0, this.lowLeft);
//		corner.add(1, this.uppRight);
//	}
	
}
