package agh;

public class Grass implements IMapElement{

	private Vector2d position;
	
	Grass(Vector2d position)
	{
		this.position = position;
	}

	@Override
	public String toString() {
		return "*";
	}

	@Override
	public Vector2d getPosition() {
		return position;
	}

}
