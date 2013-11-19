/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;
import Game.*;
import Player.*;
/**
 *
 * @author ooo524
 */
import java.awt.*;
import javax.swing.JMenuBar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame{
    
    public Main(){
        add(new Board());
        setJMenuBar(new Menu().getMenuBar());
        setSize( 870, 700 ); 
        setTitle( "Demon" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible( true );
        Movepad move = new Movepad(LocalPlayer.current_Player);
        move.setFocusable(true);

        add(move);
    }
        
    public static void main(String[] args) {
        Main main = new Main();
        
    }
	
}