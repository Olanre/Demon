/**
 * This class is meant to keep track of all players that
 * are currently logged into the game. 
 */

package Game;

import java.util.ArrayList;
import Player.*;

public class ActivePlayers
{
    public ArrayList<PlayerProfile> PlayersList = new ArrayList<PlayerProfile>();

    public void addPlayer(PlayerProfile player)
    {
        PlayersList.add(player);
    }
    
    /**
     * Method is used to avoid player collision
     * !!!MAY NOT BE NEEDED!!
     */
    public boolean validateLocation(int x, int y)
    {
        boolean check = true;//space is available
        for(PlayerProfile e : PlayersList)//check list if coordinates are already taken
        {
            if(e.getXCoord() == x && e.getYCoord() == y) 
            {
                check = false;//space is not available
            } 
        }
        return check;        
    }
}


