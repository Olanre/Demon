/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 *
 * @author ooo524
 */
import Game.LocalPlayer;
import Player.PlayerProfile;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

 
public class TerritoryMovement extends JComponent implements MouseListener, ActionListener {
    Map map_terra; 
    public Board board;
    private Territory territory;
    JFrame frame = new JFrame();
    private JButton switch_terri;
    public TerritoryMovement(Map terra) 
    {
         this.map_terra = terra;
        
       
    }
    public TerritoryMovement(){
        
    }
     @Override
          public void mouseClicked(MouseEvent mouseEvent){
                  System.out.println("Mouse clicked on: " + mouseEvent.getX() + " " + mouseEvent.getY() );
                 
                  if(  map_terra.insideTerritory(mouseEvent.getX(), mouseEvent.getY())){
                        removeAll();//or remove(JComponent)
                        
                        territory = map_terra.getTerritory(mouseEvent.getX(), mouseEvent.getY());
                        //get the current player's profile
                        PlayerProfile the_player; 
                        the_player = LocalPlayer.getLocalPlayer();
                        //get the territory the current player is set it
                        Territory old = the_player.getTerritory();
                        
                        //if the player had not yet moved to a territory don't try to print the old one
                        if(old != null){
                            //don't allow movement within the same territory
                            if(territory.getName().equals(old.getName())){
                                System.out.println("You cannot move within the same territory like this");
                                return;
                            }
                          //remove the player from the old territory's list of references
                           old.removePlayer(the_player);
                           System.out.println("The player " + the_player.getUserName() + " has been moved from " + old.getName() + " to " + territory.getName());
                        }else{
                            //add the player reference to the list of players in the new territory
                            System.out.println("The player " + the_player.getUserName()  + " to " + territory.getName());
                        }
                       territory.addPlayer(the_player);
                       the_player.setTerritory(territory);
                      Frame[] frames = JFrame.getFrames();
                      for(int i = 0; i < frames.length; i ++){
                          frames[i].dispose();
                          frames[i].removeAll();
                         frames[i].validate();
                     }
                       board = new Board() ;
                       //place the player on a random set of coordinates
                       Random yrandom = new Random();
                       //new y coordinate
                       int new_y;
                       new_y = yrandom.nextInt(territory.getTerritoryHeight());
                       the_player.setYCoord(new_y);
                       //new x coordinate
                       int new_x;
                        Random xrandom = new Random();
                       new_x = xrandom.nextInt(territory.getTerritoryWidth());
                       the_player.setXCoord(new_x);
                      updateBoard(territory);
                       //Board.placeTerritory( territory); 
                        
                     //add(LocalPlayer.current_Player.icon);
                     //LocalPlayer.current_Player.icon.repaint();
                    //MovementCentre move = new MovementCentre(LocalPlayer.current_Player);
                   // move.setFocusable(true);
                   // add(move);
                     
                  }
     }
              

    @Override
    public void mousePressed(MouseEvent me) {
         this.frame.dispose();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       
    }

    @Override
    public void mouseExited(MouseEvent me) {
       
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Closing the frame yo");
        this.frame.dispose();

    }
    
    public void updateBoard(Territory terra){
        board.placeTerritory( territory); 
    }
              
        
}
