/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3716proj.Demon;

/**
 *
 * @author ooo524
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
public class Tile  implements Drawable {
    private RoundRectangle2D rect1;
    private Color colourIndex = Color.GRAY;
    int x, y, w, h;
   
    
    public Tile( int x, int y, int w, int h ) {
         this.w = w;
         this.x = x;
         this.y = y;
         this.h = h;
         
    }
    
    public Tile( int w, int h ) {
         this.w = w;
         this.h = h;
         
    }
    /**
     * nextColor - return the next colour in the array.
     *
     * @return the next colour
     */
    private void setColor(Color new_color) {
        this.colourIndex = new_color;
    }

    /**
     * draw - draws the sprite
     *
     * @param g2d the drawing object
     */
    
    @Override
    public void draw(Graphics2D g2d) {
       g2d.setColor( colourIndex );
        // move to the location of the sprite
        g2d.translate( x, y );  
        g2d.drawRect(x, y, w, h );   
        // reset the translate
        g2d.translate( -x, -y );
    }

    /**
     * changeConfiguration requests that drawing configuration of
     * the sprite should change.
     */
    void changeConfiguration() {
        // skip a colour
       // nextColor();
    }


}
