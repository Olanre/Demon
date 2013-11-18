/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 *
 * @author ooo524
 */

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.EventQueue;

import Player.*;

public class Movepad extends JPanel
    implements  KeyListener 
{
    /*
     * Configuration constants.
     */
    private static final int INTERVAL = 500; // 500 ms
     private javax.swing.Timer timer;
     private final PlayerProfile player; 
     private MovementController Mover; 
     Direction directer; 
     
     public Movepad( PlayerProfile player){
        
          addKeyListener( this );
          this.player = player;
         
     }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println( "pressed: " + ke.getKeyChar() );
             switch( ke.getKeyChar() ) {
                case 'w':
                   Mover.move( player, Direction.UP);
                    break;
                case 'a':
                    Mover.move( player, Direction.LEFT);
                    break;
                case 'd':
                    Mover.move( player, Direction.RIGHT);
                    break;
                case 's':
                    Mover.move( player, Direction.DOWN);
                    break; 
                case ';':

             }
             repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        System.out.println( "released: " + ke.getKeyChar() );
    }
    
}
