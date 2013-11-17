
public class Test {
	public static void main(String[] args){
		
		PlayerProfile play = new PlayerProfile("Mark","H","TheBestGuy","tester");
		PlayerPositions pos = new PlayerPositions();
		MovementController move = new MovementController();
		
		play.setXCoord(6);
		play.setYCoord(4);
		pos.addPLayerLoc(play);
		System.out.println(play.getCoords()[0]);
		move.move(play, Direction.RIGHT);
		System.out.println(play.getCoords()[0]);
		System.out.println(play.getCoords()[1]);
		
		
		
		if(pos.validateLocation(2,4))
		{
			System.out.println("Valid");
		}
		else if(!pos.validateLocation(3,4))
		{
			System.out.println("Invalid");
		}		
	}	
}
