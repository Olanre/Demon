package Board;
import Game.*;
import javax.swing.JFrame;
/**
 * This is our Main class for running the game
 * @author nathan
 */
public class Main extends JFrame
{
    
    public Main()
    {
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
        
    public static void main(String[] args) 
    {
        Main main = new Main();
        
    }
	
}