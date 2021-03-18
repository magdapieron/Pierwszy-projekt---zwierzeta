package agh;

public class OptionParser {
	
	public MoveDirection[] parse(String[] args)
	{
		
		int ctr = 0;
		
		for(String arg : args)
		{
			if( "f".equals(arg) || "forward".equals(arg) || "b".equals(arg) || "backward".equals(arg)
					|| "r".equals(arg) || "right".equals(arg) || "l".equals(arg) || "left".equals(arg))
			{
				ctr++;
			}
		}
		
		MoveDirection[] movements = new MoveDirection[ctr];
		
		int i=0;
		
		for(String arg : args)
		{
			switch(arg)
			{
			case "f": 
				movements[i] = MoveDirection.FORWARD;
				i++;
				break;
			case "forward": 
				movements[i] = MoveDirection.FORWARD;
				i++;
				break;
			case "b": 
				movements[i] = MoveDirection.BACKWARD;
				i++;
				break;
			case "backward":
				movements[i] = MoveDirection.BACKWARD;
				i++;
				break;
			case "r": 
				movements[i] = MoveDirection.RIGHT;
				i++;
				break;
			case "right":
				movements[i] = MoveDirection.RIGHT;
				i++;
				break;
			case "l": 
				movements[i] = MoveDirection.LEFT;
				i++;
				break;
			case "left":
				movements[i] = MoveDirection.LEFT;
				i++;
				break;
			default: 
				throw new IllegalArgumentException(arg + " is not legal move specification");
			}		
		}
			return movements;	
	}
	

}
