/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3716proj.Demon;

/**
 *
 * @author ooo524
 */
import Board.Animate;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class PlayerSprite implements Animate {
    private Ellipse2D ring1;
    private Ellipse2D ring2;
    private Ellipse2D ring3;
    private Ellipse2D ring4;
    private double x;
    private double y;
    private Color[] rectColours = {Color.BLUE, Color.RED, Color.YELLOW};
    private int colourIndex = 0;

    /**
     * SquaresSprite - build the sprite
     *
     * @param w the width of the sprite
     * @param h the width of the sprite
     */
     public PlayerSprite(  ) {
        
    }
    
    public PlayerSprite( double x, double y, int w, int h ) {
         
         this.x = x;
         this.y = y; 
         ring1 = new Ellipse2D.Double( x, y, w, h);
         ring2 = new Ellipse2D.Double( x+5, y+5, w-10, h-10);
         ring3 = new Ellipse2D.Double( x+10, y+10, w-15, h-15);
         ring4 = new Ellipse2D.Double( x+15, y+15, w-20, h-20);
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
    void draw(Graphics2D g2d){
        
        // move to the location of the sprite
        
       g2d.setColor(nextColor() );
        g2d.fill( ring1 );
        g2d.setColor(nextColor() );
       g2d.draw( ring2 );
       g2d.setColor(nextColor() );
        g2d.fill( ring3 );
        g2d.setColor(nextColor() );
        g2d.draw( ring4 );
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
    @Override
     public void move( double x, double y){
        this.x = x;
        this.y = y; 
        changeConfiguration();
    }
}

