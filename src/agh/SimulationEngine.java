package agh;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

	private MoveDirection[] directions;
	private Vector2d[] positions;
	private IWorldMap map;
	private List<Animal> animals = new ArrayList<>();

	public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
		super();
		this.directions = directions;
		this.positions = positions;
		this.map = map;
		
		for(Vector2d pos : positions)
		{
			Animal animal = new Animal(map, pos);
			if(map.place(animal))
			{
				animals.add(animal);
			}
		}
	}

	@Override
	public void run() {
//		System.out.println(map);
		for(int i=0; i<directions.length; i++)
		{
			Animal actualAnimal = (Animal)(map.objectAt(animals.get(i % animals.size()).getPosition()));
			actualAnimal.move(directions[i]);
		}
//		System.out.println(map);
	}

}
