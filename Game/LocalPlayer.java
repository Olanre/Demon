package Game;
import Player.*;
/**
 * This class holds the current player of 
 * unique game instance
 * @author cs
 */
public class LocalPlayer 
{
    public static PlayerProfile current_Player;
    /**
     * This method initializes the current player
     * @param login_Player 
     */
    public static void setLocalPlayer(PlayerProfile login_Player)
    {
        current_Player = login_Player;        
    }
}
