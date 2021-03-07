package agh;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
	
	private List<Animal> animals;
	private int width;
	private int height;
	private Vector2d uppRight;
	private Vector2d lowLeft; 

	
	public RectangularMap(int width, int height) {
		this.width = width;
		this.height = height;
		this.uppRight = new Vector2d(width-1, height-1);
		this.lowLeft = new Vector2d(0,0);
		this.animals = new ArrayList<>();
	}
	
	public String toString()
	{
		MapVisualizer visulation = new MapVisualizer(this);
		return visulation.draw(this.lowLeft, this.uppRight);	
	}
	
}
