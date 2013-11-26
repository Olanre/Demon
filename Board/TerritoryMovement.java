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
    Territory terra; 
    Map map_terra; 
    public final Board board = new Board() ;
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
                          //remove the player from the old territory's list of references
                          old.removePlayer(the_player);
                          //add the player reference to the list of players in the new territory
                         territory.addPlayer(null);
                         updateBoard(territory);
                      //Frame[] frames = JFrame.getFrames();
                      //for(int i = 0; i < frames.length; i ++){
                          //frames[i].dispose();
                          //frames[i].removeAll();
                         // frames[i].validate();
                     // }
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
