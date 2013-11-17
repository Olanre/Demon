import java.util.ArrayList;
import java.util.ArrayList;


public class ActivePlayers
{
		public ArrayList<PlayerProfile> PlayersList = new ArrayList<PlayerProfile>();
		
		public void addPLayerLoc(PlayerProfile player)
		{
			PlayersList.add(player);
		}
		
		public boolean validateLocation(int x, int y)
		{
			boolean check = true;                 //space is available
			for(PlayerProfile e : PlayersList)             //check list if coordinates are already taken
			{
				if(e.getXCoord() == x && e.getYCoord() == y) 
				{
					check = false;                //space is not available
				} 
			}
			return check;        
		}
}


