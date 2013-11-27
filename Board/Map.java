package Board;

/** Map class holds the general layout for our territories */
import Game.StartMenuGUI;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map extends JComponent implements ActionListener{
    private static final int INTERVAL = 250;
    private int height = 800;
    private int width = 800;
    private int framex = 0;
    private int framey = 0;
    Territory[] map_terra = new Territory[6];
    private javax.swing.Timer timer;
    int[] arr;
    int terra_width;
    int terra_height;
    int[] terra_x = new int[6];
    int[] terra_y = new int[6]; 
    Rectangle[] rects = new Rectangle[6];
    JPanel panel = new javax.swing.JPanel();
     JLabel map_label = new javax.swing.JLabel();
    public final TerritoryMovement switching = new TerritoryMovement(this); 
	
	//Constructor generates the game map which in tern defines territories
    public Map(){
        setLayout( new BorderLayout());
        map_label.setText("This is your map, \n click a point to move there");
        int h = 40;
        int w = 40;
        height = 400;
        width = 400;
        add(map_label, BorderLayout.NORTH);
           //panel.setLayout(null);
       // timer = new javax.swing.Timer(INTERVAL, this);
        //timer.start();
        generate_map();
        repaint();
        this.addMouseListener(switching);
   }
   
    private Territory[] getTerritories(){
        
        return map_terra; 
    }
    
    private void getKeyBounds(){
        int max = 0;
        for(int i = 0; i< terra_x.length; i++){
          // if(map_terra[i].getWidth() > )
        }
        
    }
    /** Method to generate all the territories,
     * new expansion packs can be added here
     */
    @SuppressWarnings("empty-statement")
    public final void generate_map(){
        
        //initialize our various territories
        //territory 1
         int[] arr1 = {2,5};
        Territory Nomad = new Territory("Roaming Region", 1, TerritoryType.Nomad, Color.MAGENTA, arr1 ,600, 800);
        
         //territory 2
         int[] arr2 = {1,4};
        Territory Circle = new Territory(" Circle", 2, TerritoryType.Democracy, Color.BLUE, arr2 ,600, 400);
        
         //territory 3
         int[] arr3 = { 4};
        Territory Realm = new Territory(" Realm", 3, TerritoryType.Dictatorship, Color.RED, arr3 ,500, 400);
        
         //territory 4
         int[] arr4 = {2, 3, 5};
        Territory Coast = new Territory("Coast", 4, TerritoryType.Democracy, Color.GREEN, arr4 ,800, 400);
        
        //territory 5
        int[] arr5 = { 4, 6};
        Territory Jungle = new Territory("Jungle", 5, TerritoryType.Nomad , Color.ORANGE, arr5 ,500, 600);
        
        //territory 6
        int[] arr6 = {5};
        Territory Mordor = new Territory("Mordor", 6, TerritoryType.Dictatorship, Color.PINK, arr6 ,700, 500);
        //create the territories in the instance array
         map_terra[0] =  Nomad;
         
         map_terra[1] = Circle;
         
         map_terra[2] = Realm;
        
         map_terra[3] = Coast;
       
         map_terra[4] = Jungle;
         
         map_terra[5] = Mordor; 
        
         
        //now assign the x draw coordinate start point for the territories to be drawn on the map
        terra_x[0] = 20;
        terra_x[1] =  80;
        terra_x[2] = 150;
        terra_x[3] = 120;
        terra_x[4] = 80;
        terra_x[5] = 130;
         //now assign the y draw coordinates start point for the territories to be drawn on the map
        terra_y[0] = 20;
        terra_y[1] = 20;
        terra_y[2] = 20;
        terra_y[3] = 60;
        terra_y[4] = 100;
        terra_y[5] = 110;
        
        //not draw the actual territory. 
         repaint();     
        
    }
    
     @Override
    public void paintComponent( Graphics g ) {    
        
        
        //assign color random value
        Color color = Color.BLACK;
      
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        g2d.fillRect(20,20, 180, 140); 
        //draw the territories on a small map representing their actual location to each other
        for( int i = 0 ; i < map_terra.length; i++ ) {
         JPanel p = new JPanel(new BorderLayout());
            terra_width = map_terra[i].getTerritoryWidth()/10;
            terra_height = map_terra[i].getTerritoryHeight()/10;
            Color color2;
            color2 = map_terra[i].getColor();
            rects[i] = new Rectangle (terra_x[i], terra_y[i], terra_width , terra_height);
            g2d.setColor(color2);
            g2d.fill(rects[i]);
            //g2d.fillRect(terra_x[i], terra_y[i], terra_width , terra_height);  
            //map_terra[i].repaint();  
                
        }      
        
    }
     
   public boolean insideTerritory(int x, int y) {
       boolean val = true;
       int i = 0;
        while(i < rects.length){
                         if(rects[i].contains(x,y) ){
                            val =  true;
                            
                            break;
                          }else{
                            val= false;
                         }
                         i = i + 1;
        }
        return val;
        
    }
    @Override
    public void actionPerformed( ActionEvent evt ) {/**Code to handle animation*/}    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartMenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
           Map map = new Map();
        /* Create and display the form */
          
    }

    Territory getTerritory(int x, int y) {
        int i = 0;
        Territory val = null;
         while(i < rects.length){
                         if(rects[i].contains(x,y) ){
                            val =  map_terra[i];
                            System.out.println("Territory was: " + map_terra[i].getName());
                            break;
                          }else{
                            val= null;
                         }
                         i = i + 1;
        }
        
         return val;
    }
}