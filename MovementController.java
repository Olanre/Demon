//package pkg3716proj.Demon;
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
//import pkg3716proj.Demon.PlayerProfile;

public class MovementController 
{
	int newXCoord;
	int newYCoord; 
	PlayerProfile player;
    private javax.swing.Timer timer;
    private static final int INTERVAL = 500; // 500 ms
	
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
    		   break;
    	    case LEFT:
    	       player.setXCoord(player.getXCoord() - 5);
    	       //board.redraw
    	       break;
    	    case UP:
    	    	player.setYCoord(player.getYCoord() + 5);
    	    	//board.redraw
    	    	break;
    	    case DOWN:	
    	    	player.setYCoord(player.getYCoord() - 5);
    	    	//board.redraw
    	    	break;
    	    default:
    	    	System.out.println("Default");
    	}
    }
}
