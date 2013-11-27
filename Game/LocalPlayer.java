/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Player.*;
/**
 *
 * @author cs
 */
public class LocalPlayer {
    public static PlayerProfile current_Player;
    
    public static void setLocalPlayer(PlayerProfile login_Player){
        current_Player = login_Player;        
    }
    public static PlayerProfile getLocalPlayer(){
        return current_Player;
    }
}
