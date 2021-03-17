package agh;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {

	private MoveDirection[] directions;
	private IWorldMap map;
	private List<Animal> animals; 

	public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
		super();
		this.animals = new ArrayList<>();
		this.directions = directions;
		this.map = map;
		putAnimalsOnMap(positions);
	}
	
	private void putAnimalsOnMap(Vector2d[] positions)
	{
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
			int i = 0;
			for(MoveDirection direction : directions)
			{
				if(i == animals.size())
					i = 0;
				Animal actualAnimal = animals.get(i);
				actualAnimal.move(direction);
				i++;
			}
			
		}
		System.out.println(map);
	}
}
