/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Board;

import java.awt.Color;
import java.awt.event.ActionListener;
import Game.LocalPlayer;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Player.PlayerSprite;

/**
 *
 * @author cs
 */
class Territory extends JPanel implements ActionListener{
    
    String name;
    TerritoryType type;
    Color the_color;
    int ID;
    int[] borders;
    int height;
    int width;
    Tile[][] tilepad; 
    private int framex = 0;
    private int framey = 0;
     private static final int INTERVAL = 250;
      private javax.swing.Timer timer;
      int h = 40;
      int w = 40;
    /** Constructor to create the territory with a given parameters
     * 
     * @param name is the territory name
     * @param type is the type of government of the territory or whether is a free area
     * @param color is the color the tiles in this territory are colored with
     * @param border is the territory names which border this territory
     * @param height is the height of the territory to be displayed
     * @param width is the width of the territory to be displayed
     */
    public Territory(String name, int ID, TerritoryType type, Color color, int[] border,int height,int width){
        this.framex = width;
        this.framey = height;
        this.name = name;
        this.type = type;
        this.the_color = color;
        this.borders = border; 
        this.ID = ID;
        tilepad = new Tile[width][height];    
        timer = new javax.swing.Timer(INTERVAL, (ActionListener) this);
        
        timer.start();
    }
    /** Paint method takes in parameter
     * 
     * @param g which is a graphics object, it is converted to a 2D graphics object for painting
     */
    @Override
    public void paintComponent( Graphics g ) {       
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        //draw the tiles pad which is now a 2D array
        for( int i = 0 ; i < height; i++ ) {
            for(int j = 0; j< width; j++){
                tilepad[i][j] = new Tile( framex, framey, w, h);
                tilepad[i][j].setColor(the_color);
                tilepad[i][j].draw(g2d); 
                //incrmeent x position by width of the tile drawn
                framex = framex + w+1;
            }
            //increment height position by one
            framey = framey + h+1;
        }        
    }
    /**all the getter methods are here
     * */ 
   
    public int[] getBoundary(){
        int[] arr = {width, height}; 
        return arr; 
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    public  TerritoryType getType(){
        return type;
    }
    public Color getColor(){
        return the_color;
    }
     public int[] getBorders(){
           return borders; 
     }
     public int getID(){
           return this.ID; 
     }
     public int getTerritoryWidth(){
         return framex;
     }
     
     public int getTerritoryHeight(){
         return framey; 
     }
     
     //setter methods
     /** Method to set the color for the territory
      * @param nextColor which is the new color to be represented in
      */
     public void setColor(Color nextColor){
        this.the_color = nextColor;
        repaint();
    }
     
     /** Method to set the type of territory this is
      * @param new_type which is the new governing type of could be free roaming 
      */
     public void setType( TerritoryType new_type){
         this.type = new_type;
     }
     /**Method to set the name of the territory 
      * @param new_name which is the new name of the territory
      */
     public void setTheName(String new_name){
         this.name = new_name;
     }
    @Override
    public void actionPerformed( ActionEvent evt ) {/**Code to handle animation*/}    
}
