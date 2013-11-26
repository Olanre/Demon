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
import Game.LocalPlayer;
import javax.swing.JFrame;
import Player.PlayerSprite;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main extends JFrame{
    
    public Main(){
        Map map = new Map();
        
            int[] arr5 = {3, 4, 7};
        Territory Jungle = new Territory("Jungle", 5, TerritoryType.Nomad , Color.ORANGE, arr5 ,500, 600);
        JPanel p = new JPanel(new BorderLayout());
            p.add(map); 
        add(new Map());
        setJMenuBar(new Menu().getMenuBar());
        setSize( 300, 300 ); 
        setTitle( "Demon" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable(false);
        setVisible( true );
        add(LocalPlayer.current_Player.icon);
             Jungle.addPlayer(LocalPlayer.current_Player);
             LocalPlayer.current_Player.icon.repaint();
              MovementCentre move = new MovementCentre(LocalPlayer.current_Player);
      
        move.setFocusable(true);

        add(move);
    }
        
    public static void main(String[] args) {
        Main main = new Main();
        
    }
	
}