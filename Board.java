/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3716proj.Demon;

/**
 *
 * @author ooo524
 */
/** Creates a phonekeypad which allows the user
 *to input some numbers or letter which will be displayed on 
 * a display area
 *@author Olanrewaju Okunlola
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Board extends JPanel  implements ActionListener{
    private static final int INTERVAL = 250;
    private JTextArea display;
    private String digits = "";
    private int height = 740;
    private int width = 700;
    private int framex = 0;
    private int framey = 0;
    Tile[] tilepad;
    private javax.swing.Timer timer;

   
    /** Constructor to build PhoneKeyPad object which
     *allows the user to create the panel, buttons and textfield
     */
    public Board(){
        setLayout( new BorderLayout() );
        //JPanel p = new JPanel( new GridLayout(8, 8) );
       // p.setPreferredSize(new Dimension(height, width));
       // phonepad = new JButton[ 200 ];
         int h = 40;
        int w = 40;
        height = 750;
        width = 700;
        tilepad = new Tile[200];
        
           for( int i = 0 ; i < tilepad.length; i++ ) {
           //String k = String.valueOf(i); 
           //p.add( new JLabel(k));
           tilepad[i] = new Tile( framex, framey, w, h);
            System.out.println("The x coord is: " + framex + "\nThe y coord is: " + framey);
           if(framex+w >= width){
               framey = framey + h+1;   
               framex = 0;
           }else{
               
               framex = framex + w+1;                
           }
           
           
          
            
            
         }
         // framex = framex + width;
       
        
        timer = new javax.swing.Timer(INTERVAL, this);
        timer.start(); 
         repaint();
        
        display = new JTextArea();
        //add( display, BorderLayout.NORTH );
        //add( p, BorderLayout.CENTER );

   }
   
    @Override
    protected void paintComponent( Graphics g ) {
       
        super.paintComponent( g );
        Graphics2D g2d = (Graphics2D)g;
        for( int i = 0 ; i < tilepad.length; i++ ) {
                tilepad[i].draw(g2d); 
        }
    }
    
    /** Action preformed method to dictate what to happen
    *when an action is performed
    *@param e which is the ActionEvent
    */
    @Override
     public void actionPerformed( ActionEvent evt ) {        
        /*
         * code to handle animation.
         */
         repaint();
     }
    
    
   /** Main method which creates instance of class object
    *models the frame and displays it
    *@param args which is an array of strings
    */    
    public static void main( String[] args ) { 
       /* create frame */
       JFrame frame = new JFrame();
       
       Board keypad = new Board();
       frame.setSize( new Dimension( 800, 800) );
        
       frame.setTitle( keypad.getClass().getName() );
       frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       frame.add( keypad );
       frame.setVisible( true );
    } 



}
