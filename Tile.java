package Board;

/**
 * Tile class is modular component of the 
 * main game board
 */

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Tile  implements Drawable{
    private Color colourIndex = Color.BLUE;
    int x, y, w, h;
    
    public Tile( int x, int y, int w, int h ){
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
    private void setColor(Color new_color){
        this.colourIndex = new_color;
    }

    /**
     * draw - draws the sprite
     *
     * @param g2d the drawing object
     */
    
    @Override
    public void draw(Graphics2D g2d){
       g2d.setColor( colourIndex );
       g2d.drawRect(x, y, w, h );   
    }

    /**
     * changeConfiguration requests that drawing configuration of
     * the sprite should change.
     */
    void changeConfiguration(){
        // skip a colour
       // nextColor();
    }
}
