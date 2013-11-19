/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

/**
 *
 * @author ooo524
 */
import Board.Animate;
import Board.Animate;
import Board.Animate;
import Board.Board;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class PlayerSprite extends JComponent implements Animate {
    private Ellipse2D ring1;
    private Ellipse2D ring2;
    private Ellipse2D ring3;
    private Ellipse2D ring4;
    private double x;
    private double y;
    private int w,h;
    private Color[] rectColours = {Color.BLUE, Color.CYAN, Color.WHITE};
    private int colourIndex = 0;

    /**
     * SquaresSprite - build the sprite
     *
     * @param w the width of the sprite
     * @param h the width of the sprite
     */
    
    public PlayerSprite( double x, double y, int w, int h ) {
         this.w =w;
         this.h = h;
         this.x = x;
         this.y = y; 
         ring1 = new Ellipse2D.Double( x, y, w, h);
         ring2 = new Ellipse2D.Double( x+5, y+5, w-10, h-10);

         repaint();
    }

    /**
     * nextColor - return the next colour in the array.
     *
     * @return the next colour
     */
    private Color nextColor() {
        colourIndex++;
        if ( colourIndex >= rectColours.length ) {
            colourIndex = 0;
        }
        return rectColours[ colourIndex ];
    }

    /**
     * draw - draws the sprite
     *
     * @param g2d the drawing object
     */
    @Override
    public void paintComponent( Graphics g ) {
        System.out.println("I have made the sprite");
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        // move to the location of the sprite
        ring1 = new Ellipse2D.Double( x, y, w, h);
        ring2 = new Ellipse2D.Double( x+5, y+5, w-10, h-10);
       g2d.setColor(nextColor() );
        g2d.fill( ring1 );
        g2d.setColor(nextColor() );
       g2d.fill( ring2 );
       
        // reset the translate
       // g2d.translate( -tx, -ty );
    }

    /**
     * changeConfiguration requests that drawing configuration of
     * the sprite should change.
     */
    @Override
    public void changeConfiguration() {
        // skip a colour
        nextColor();
    }
   
     public void move( double x, double y){
        this.x = x;
        this.y = y; 
        changeConfiguration();
        repaint();
        
        
    }
}

