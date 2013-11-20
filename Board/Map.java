package Board;

/** Map class holds the general layout for our territories */
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map extends JPanel implements ActionListener{
    private static final int INTERVAL = 250;
    private int height = 800;
    private int width = 800;
    private int framex = 0;
    private int framey = 0;
    Territory[] map_terra;
    private javax.swing.Timer timer;
    int[] arr;
	
	//Constructor generates the game map which in tern defines territories
    public Map(){
        setLayout( new BorderLayout());
        int h = 40;
        int w = 40;
        height = 400;
        width = 400;
       
        generate_map();
        
           
        timer = new javax.swing.Timer(INTERVAL, this);
        timer.start();
        
   }
   
    
    /** Method to generate all the territories,
     * new expansion packs can be added here
     */
    @SuppressWarnings("empty-statement")
    public void generate_map(){
        //territory 1
         int[] arr1 = {2, 4, 5};
        Territory Nomad = new Territory("Roaming Region", 1, TerritoryType.Nomad, Color.lightGray, arr ,750, 600);
        
         //territory 2
         int[] arr2 = {1, 3, 4};
        Territory Circle = new Territory("1st Circle", 2, TerritoryType.Democracy, Color.BLUE, arr2 ,400, 400);
        
         //territory 3
         int[] arr3 = {2, 4, 6};
        Territory Realm = new Territory("2nd Realm", 3, TerritoryType.Dictatorship, Color.RED, arr2 ,500, 700);
        
         //territory 4
         int[] arr4 = {2, 3, 5,1, 6};
        Territory Coast = new Territory("3rd Coast", 4, TerritoryType.Democracy, Color.GREEN, arr2 ,250, 700);
        
         //territory 5
        int[] arr5 = {1, 4, 7};
        Territory Pillar = new Territory("4th Pillar", 5,TerritoryType.Democracy, Color.DARK_GRAY, arr2 ,300, 200);
        
        //territory 6
        int[] arr6 = {3, 4, 7};
        Territory Jungle = new Territory("5th Jungle", 6, TerritoryType.Nomad , Color.ORANGE, arr2 ,550, 300);
        
        //territory 7
        int[] arr7 = {4, 5, 6};
        Territory Mordor = new Territory("6th Mordor", 7, TerritoryType.Dictatorship, Color.GRAY, arr2 ,300, 800);
        
        
    }
    
    @Override
    public void actionPerformed( ActionEvent evt ) {/**Code to handle animation*/}    
}