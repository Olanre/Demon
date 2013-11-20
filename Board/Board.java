package Board;

/**
 * Board Class is used to generate game board at the start of the game
 * and hold tiles
 */

import Game.LocalPlayer;
import Player.PlayerSprite;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener{
    private static final int INTERVAL = 250;
    private int height = 800;
    private int width = 800;
    private int framex = 0;
    private int framey = 0;
    Tile[] tilepad;
    private javax.swing.Timer timer;

    //Constructor generates the game board
    public Board(){
        setLayout( new BorderLayout());
        int h = 40;
        int w = 40;
        height = 800;
        width = 800;
        tilepad = new Tile[300];
        
        for( int i = 0 ; i < tilepad.length; i++ ) {
           tilepad[i] = new Tile( framex, framey, w, h);
           if(framex+w >= width){
               framey = framey + h+1;   
               framex = 0;
           }
           else{               
               framex = framex + w+1;                
           } 
         }
           
        timer = new javax.swing.Timer(INTERVAL, this);
        timer.start();
        add(LocalPlayer.current_Player.icon);
   }
   
    @Override
    public void paintComponent( Graphics g ) {       
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        for( int i = 0 ; i < tilepad.length; i++ ) {
                tilepad[i].draw(g2d); 
        }        
    }
    public int[] getBoundary(){
        int[] arr = {width, height}; 
        return arr; 
    }
    
    @Override
    public void actionPerformed( ActionEvent evt ) {/**Code to handle animation*/}    
}
