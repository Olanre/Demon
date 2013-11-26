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
    Map map_terra; 
    public Territory territory;
    private JButton save;
    Tile[] tilepad;
    JFrame frame = new JFrame();
    JPanel p = new JPanel();
    private javax.swing.Timer timer;

    /** Board will not be used to draw the territory
     * 
     * @param territory the territory we are displaying at this moment
     */
    public Board(){
        
        this.frame = frame;
        //frame.add(map);
        frame.setSize(  250,  200 ); 
        frame.setJMenuBar(new Menu().getMenuBar());
        frame.setTitle( "main game board" );
        frame.setDefaultCloseOperation( frame.DO_NOTHING_ON_CLOSE );
        frame.setVisible( true );
             
    }
    public Board(Territory territory){
           
             System.out.println("Territory was: " + territory.getName());
             territory.repaint();
             save = new JButton("Click to save and exit");
             save.addActionListener(this);
            p.setLayout( new BoxLayout(p, BoxLayout.PAGE_AXIS));
           // p.setLayout(new GridBagLayout());
             //GridBagConstraints c = new GridBagConstraints();
             
            // c.fill = GridBagConstraints.VERTICAL;
             p.add(save);
             Map map =  new Map();
             // c.fill = GridBagConstraints.VERTICAL;
             p.add(map);
  
             frame = new JFrame();
             this.frame = frame;
             frame.add(territory); 
             frame.add( p, BorderLayout.EAST);
             //frame.add(map);
             frame.setSize( territory.getTerritoryWidth() + 250, territory.getTerritoryHeight() + 200 ); 
             frame.setJMenuBar(new Menu().getMenuBar());
             frame.setTitle( territory.getName() );
             frame.setDefaultCloseOperation( frame.DO_NOTHING_ON_CLOSE );
             frame.setVisible( true );
             
             add(LocalPlayer.current_Player.icon);
             territory.addPlayer(LocalPlayer.current_Player);
             LocalPlayer.current_Player.icon.repaint();
              MovementCentre move = new MovementCentre(LocalPlayer.current_Player);
              move.setFocusable(true);
              frame.add(move);
              territory.repaint();
}
   
    /**@Override
    public void paintComponent( Graphics g ) {       
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        for( int i = 0 ; i < tilepad.length; i++ ) {
                tilepad[i].draw(g2d); 
        }        
    }
    * */
    public int[] getBoundary(){
        int[] arr = {width, height}; 
        return arr; 
    }
    
    public void placeTerritory( Territory terra){
        this.territory = terra;
        p.removeAll();
        p.revalidate();
        System.out.println("Territory was: " + territory.getName());
        territory.repaint();
        save = new JButton("Click to save and exit");
        save.addActionListener(this);
        p.setLayout( new BoxLayout(p, BoxLayout.PAGE_AXIS));
           
        p.add(save);
        Map map =  new Map();
       // c.fill = GridBagConstraints.VERTICAL;
        p.add(map);
        p.revalidate();  
        frame.setSize( territory.getTerritoryWidth() + 250, territory.getTerritoryHeight() + 200 ); 
        frame.setTitle( territory.getName() );
        frame.add( p, BorderLayout.EAST);
        territory.repaint();  
        frame.setVisible( true );
        territory.repaint();
        
        
    }
    
     @Override
    public void paintComponent( Graphics g ) {    
       territory.repaint();
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Closing the frame yo");
        this.frame.dispose();

    }
}
