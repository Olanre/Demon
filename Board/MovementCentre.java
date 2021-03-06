/**
 * ENCAPSULATED MOVEMENT CONTROLLER
 * This class handles the movement of the player including
 * 
 */

package Board;

import Player.PlayerProfile;
import java.awt.event.*;
import javax.swing.JComponent;

public class MovementCentre extends JComponent implements KeyListener { 
    /*
     * Configuration constants.
     */ 
    int newXCoord;
    int newYCoord; 
    PlayerProfile player;
    Direction directer;
    Territory terra;
    
    public MovementCentre(PlayerProfile player)
    {
        addKeyListener( this );
        this.player = player;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void keyReleased(KeyEvent ke) {
        //System.out.println( "released: " + ke.getKeyChar() );
    }
    
  // This method can be used to detect player collisons 
    public void validateMove() // To be used at a later date
    {}
    
    
    @Override
    public void keyPressed(KeyEvent ke) {
       // System.out.println( "pressed: " + ke.getKeyChar() );
        terra = player.getTerritory();
        System.out.println(player.getXCoord());
        System.out.println(player.getYCoord());
        System.out.println("The territory width is at: " + terra.getTerritoryWidth());
        System.out.println("The territory height is at: " + terra.getTerritoryHeight());
        switch( ke.getKeyChar() ) {
                case 'w':
                   if(player.getYCoord() -15 < 0)
                   {
                      player.setYCoord(0);
                      System.out.println("Out of bounds move: UP");
                   }
                   else
                   {
                      player.setYCoord(player.getYCoord() - 15);
                   }              
                break;   
                    
                case 'a':
                    if(player.getXCoord() -15 < 0)
                    {
                       player.setXCoord(0);
                       System.out.println("Out of bounds move: LEFT");
                    }
                    else
                   {
                      player.setXCoord(player.getXCoord() - 15);
                   }
                break;
                    
                case 'd':
                   if(player.getXCoord() + 15 > terra.getTerritoryWidth())
                   {
                       player.setXCoord(terra.getTerritoryWidth()-10);
                       System.out.println("Out of bounds move: RIGHT");
                   }
                   else
                   {
                      player.setXCoord(player.getXCoord() + 15);
                   }   
                break;
                    
                case 's':
                   if(player.getYCoord() + 15 > terra.getTerritoryHeight())
                   {
                      player.setYCoord(terra.getTerritoryHeight()-10);
                      System.out.println("Out of bounds move: DOWN");
                   }
                   else
                   {
                      player.setYCoord(player.getYCoord() + 15);
                   }
                break;
                    
                default:
                    break;
             }
    }
}
/*
 *DESIGN DECISION:
 * WE DECIDED TO ENCAPSULATE THE MOVEMENT CONTROLLER CLASS AS WLL AS THE MOVEMENT
 * CLASS BECAUSE IN THIS WAY ALL THYE MOVEMENT IS HANDLED BY A SINGLE MOVEMENTCENTRE 
 * CLASS
 */
    

