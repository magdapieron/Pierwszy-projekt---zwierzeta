package agh;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SimulationEngine implements IEngine {

	private MoveDirection[] directions;
	private IWorldMap map;
	protected Map<Vector2d, Animal> animals; 

	public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions) {
		super();
		this.animals = new LinkedHashMap<>();
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
				animals.put(pos, animal);
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
				List<Vector2d> list = new ArrayList<>(animals.keySet());
				
				Vector2d index = list.get(i % list.size());
				
				Animal actualAnimal = (Animal)(map.objectAt(index));
				System.out.println(actualAnimal);
				System.out.println(actualAnimal.getPosition());
				
				actualAnimal.move(directions[i]); 
			}
		}
		System.out.println(map);
	}
}
