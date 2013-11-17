/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3716proj.Demon;

/**
 *
 * @author ooo524
 */
import pkg3716proj.*;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

       public static void runApplication( JPanel app, JMenuBar app2 ) {
       /* create frame */
       JFrame frame = new JFrame();
       
       frame.setLayout(new FlowLayout()); 
       frame.setSize( 870, 700 ); 
       frame.setTitle( app.getClass().getName() );
       frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       frame.setJMenuBar(app2);
       frame.add( app ); 
       frame.setVisible( true ); 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Board board = new Board();
        Menu menu = new Menu(); 
 
        runApplication( board, menu.getMenuBar() ); 
    }
}
