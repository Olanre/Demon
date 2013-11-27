/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Board;

import java.awt.Color;
import java.awt.event.ActionListener;
import Player.PlayerSprite;
import Game.LocalPlayer;
import Game.StartMenuGUI;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import Player.*;
import java.util.ArrayList;

/**
 *
 * @author cs
 */
public class Territory extends JPanel implements ActionListener{
    
    String name;
    TerritoryType type;
    Color the_color;
    int ID;
    int[] borders;
    //for the territory
    int height;
    int width;
    //dimension for the specific tiles
    int h = 40;
    int w = 40;
    //number of tiles that can fit on a row
    int x_tileno;
    //number tiles that can fit in a column
    int y_tileno;
    Tile[][] tilepad; 
    private int framex = 0;
    private int framey = 0;
     private static final int INTERVAL = 250;
     TerritoryMovement actual_switch = new TerritoryMovement();
     
     ArrayList<PlayerProfile> on_this = new ArrayList<PlayerProfile>(); 
      private javax.swing.Timer timer;
              private static JFrame main_Frame = new JFrame();
              private JButton switch_terri;
       
     
    /** Constructor to create the territory with a given parameters
     * 
     * @param name is the territory name
     * @param type is the type of government of the territory or whether is a free area
     * @param color is the color the tiles in this territory are colored with
     * @param border is the territory names which border this territory
     * @param height is the height of the territory to be displayed
     * @param width is the width of the territory to be displayed
     */
    public Territory(String name, int ID, TerritoryType type, Color color, int[] border,int width ,int height){
         
          setLayout( new BorderLayout());
          
        this.width = width;
        this.height = height;
        this.name = name;
        this.type = type;
        this.the_color = color;
        this.borders = border; 
        this.ID = ID;
        
        //display button on the Territory panel to switch territories
        // p = new JPanel( );
        //switch_terri = new JButton("Click to switch to bordering territory");
        //switch_terri.addActionListener( actual_switch);
        //p.add(switch_terri);
        //add( p, BorderLayout.EAST);
        timer = new javax.swing.Timer(INTERVAL, (ActionListener) this);
        x_tileno = width/w;
        y_tileno = height/h;
        tilepad = new Tile[x_tileno][y_tileno]; 
         repaint();
        //System.out.println("The maximum rows is" + x_tileno + "The maximum column is" + y_tileno );
        timer.start();
        
        //add to board
         //add(LocalPlayer.current_Player.icon);
         //addPlayer(LocalPlayer.current_Player);
          //LocalPlayer.current_Player.icon.repaint();
                   // MovementCentre move = new MovementCentre(LocalPlayer.current_Player);
                   //move.setFocusable(true);
                   // add(move);
       
    }
    /** Paint method takes in parameter
     * 
     * @param g which is a graphics object, it is converted to a 2D graphics object for painting
     */
    @Override
    public void paintComponent( Graphics g ) {    
        framex = 0;
        framey = 0;
        
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        //draw the tiles pad which is now a 2D array
        for( int j = 0 ; j < y_tileno-1; j++ ) {
            for(int i = 0; i< x_tileno-1; i++){
                //System.out.println(i + " " + j);
                tilepad[i][j] = new Tile( framex, framey, w, h);
                tilepad[i][j].setColor(the_color);
                //tilepad[i][j].draw(g2d);
                
                Rectangle rect = new Rectangle(framex, framey, w, h);
                g2d.setColor(the_color);
                g2d.fill(rect);
                // System.out.println("Now painting");
                
                //incrmeent x position by width of the tile drawn
                framex = framex + w+1;
            }
            for(int i = 0; i < on_this.size(); i++){
                    MovementCentre move = new MovementCentre(on_this.get(i));
                    move.setFocusable(true);
                    add(move); 
                    add(on_this.get(i).icon);
                    on_this.get(i).icon.repaint();
                  
                    
             }
            //increment height position by one
            framey = framey + h+1;
            framex = 0;
        }     
       
    }
    //add a player to this board. 
   public void addPlayer(PlayerProfile player){
       on_this.add(player);
       for(int i = 0; i < on_this.size(); i++){
                    System.out.println(on_this.get(i).getUserName());
                    
        }
       
   }
    //add a player to this board. 
   public void removePlayer(PlayerProfile player){
       on_this.remove(player);
       
   }
   //method the show the map 
   public void ShowMap(){
       Map map =  new Map();
       
   }
   
   /**all the getter methods are here
     * */ 
   
   //return the list on players currently on this board.
   public ArrayList<PlayerProfile> getPlayers(){
       return on_this;
       
   }
   //get Boundary of this territory, the width and height
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
          
         return width;
         
     }
     
     public int getTerritoryHeight(){
        
         return height; 
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
    public void actionPerformed( ActionEvent evt ) {
     
    }    
    
    class Show implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
             
                
                //this.dispose();
            }
         }
    
   /** public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         *
        
        //</editor-fold>
        //territory 4
         int[] arr = {2,5};
        Territory Nomad = new Territory("Roaming Region", 1, TerritoryType.Nomad, Color.MAGENTA, arr ,600, 800);
            JPanel p = new JPanel(new BorderLayout());
            p.add(Nomad); 
            main_Frame.add(p); 
            main_Frame.setSize( 870, 700 ); 
           main_Frame.setTitle( "Demon" );
          main_Frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        main_Frame.setVisible( true );
        //MovementCentre move = new MovementCentre(LocalPlayer.current_Player);
       // move.setFocusable(true);
        
        /* Create and display the form */ 
 
}
