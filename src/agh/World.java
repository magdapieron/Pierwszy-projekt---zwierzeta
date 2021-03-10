package agh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;

public class World extends OptionParser {

	public static void main(String[] args)
	{	
		// f b r l f f r r f f f f f f f f
				
		new OptionParser();
		MoveDirection[] directions = OptionParser.parse(args);
		IWorldMap map = new RectangularMap(10, 5);
		Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
		IEngine enegine = new SimulationEngine(directions, map, positions);
		
		enegine.run();
		
//		
//		MoveDirection[] directions = new OptionParser().parse(args);
//		IWorldMap map = new GrassField(10);
//		Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//		IEngine enegine = new SimulationEngine(directions, map, positions);
//		
//		enegine.run();

		
	} 
	
}
