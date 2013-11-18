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
	
    public MovementController()
    {
        
    	//this.player = player;
    	//newXCoord = xcoord;
    	//newYCoord = ycoord;
    }
    
    
    public void validateMove()
    {
    	//TODO
    	//check board to see if move is valid
    	//POSSIBLITY: wrap the board(i.e from max size back to 0 and vice versa)
    	//Possible: Maybe let this class accept some parameters to 
    	
    }
    
    public void move(PlayerProfile player,Direction d)
    {
    	switch(d)
    	{
    	    case RIGHT:
    		   player.setXCoord(player.getXCoord() + 5);
    	    case LEFT:
    	       player.setXCoord(player.getXCoord() - 5);
    	       //board.redraw
    	    case UP:
    	    	player.setYCoord(player.getYCoord() + 5);
    	    	//board.redraw
    	    case DOWN:	
    	    	player.setYCoord(player.getYCoord() - 5);
    	    	//board.redraw
    	}
    }
}
