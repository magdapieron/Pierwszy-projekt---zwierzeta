package agh;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

	private MoveDirection[] directions;
	private Vector2d[] positions;
	private IWorldMap map;
	private List<Animal> animals;


	public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
		super();
		this.animals = new ArrayList<>();
		this.directions = directions;
		this.positions = positions;
		this.map = map;
		
		for(Vector2d pos : positions)
		{
			Animal animal = new Animal(map, pos);
			if(map.placeAnimal(animal))
			{
				animals.add(animal);
			}
		}

	}

	@Override
	public void run() {
		System.out.println(map);
		if( animals.size() != 0)
		{
			for(int i=0; i<directions.length; i++)
			{	
				Animal actualAnimal = (Animal)(map.objectAt(animals.get(i % animals.size()).getPosition()));
				actualAnimal.move(directions[i]);
			}
			System.out.println(map);
		}


	}

}
