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
    
    public static void setLocalPlayer(String userName,String pass, String fName, String lName){
        current_Player = new PlayerProfile(userName, pass, fName, lName);
    }
}
