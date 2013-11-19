package Board;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

import java.awt.geom.Ellipse2D;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.EventQueue;
import Player.*;

public class MovementController 
{
	int newXCoord;
	int newYCoord; 
	PlayerProfile player;
        private javax.swing.Timer timer;
        private static final int INTERVAL = 500; // 500 ms
	boolean checkBound = true;
    public MovementController()
    {
        
    	//this.player = player;
    	//newXCoord = xcoord;
    	//newYCoord = ycoord;
    }
    
  // This method isn't working at the moment!!!  
  /**  public boolean validateMove() // To be continued
    {
        System.out.println(player.getXCoord());
        if(player.getXCoord() -15 <= 0  || player.getXCoord()+ 15 >= 800)
        {
            checkBound = false;
            System.out.println("Out of bounds move");
        }
        else if(player.getYCoord() -15 <= 0  || player.getYCoord()+ 15 >= 800)
        {
            checkBound = false;
            System.out.println("Out of bounds move");
        }
    	 return checkBound;
    	
    }
    */ 
    
    public void move(PlayerProfile player,Direction d)
    {
        System.out.println(player.getYCoord());
    	switch(d)
    	{
    	    case RIGHT:
                //if(validateMove())
                //{
                   player.setXCoord(player.getXCoord() + 15);
                //}   
                break;
    	    case LEFT:
    	      // if(validateMove())
                //{
                   player.setXCoord(player.getXCoord() - 15);
               // }
                break;
    	       //board.redraw
    	    case UP:
    	    	
                   player.setYCoord(player.getYCoord() - 15);
                              
                break;
    	    	//board.redraw
    	    case DOWN:
                
                   player.setYCoord(player.getYCoord() + 15);
                
                break;
            default:
                break;
    	}
    }
}
