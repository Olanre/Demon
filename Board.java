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
import pkg3716proj.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Font;
import java.awt.Dimension;

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

public class Board extends JPanel implements
   ActionListener{
    private JButton[] phonepad;
    private JButton call, endcall, zero; 
    private JTextArea display;
    private String digits = "";

   
    /** Constructor to build PhoneKeyPad object which
     *allows the user to create the panel, buttons and textfield
     */
    public Board(){
        setLayout( new BorderLayout() );
        JPanel p = new JPanel( new GridLayout(8, 8) );
        phonepad = new JButton[ 200 ];
        for( int i = 0 ; i < phonepad.length; i++ ) {
           //String k = String.valueOf(i); 
           //p.add( new JLabel(k));
           phonepad[i] = new JButton( String.valueOf( i + 1 ));
           phonepad[i].addActionListener( this );
           p.add( phonepad[i] );
        }
        
       // call = new JButton("T");
        //call.addActionListener( this );
        //p.add(call);
        //zero = new JButton("0");
       // zero.addActionListener( this); 
       // p.add(zero);
       // endcall = new JButton("E");
       // endcall.addActionListener( this );
        //p.add(endcall);
        
        display = new JTextArea();
        add( display, BorderLayout.NORTH );
        add( p, BorderLayout.CENTER );

   }
   /** Action preformed method to dictate what to happen
    *when an action is performed
    *@param e which is the ActionEvent
    */
   public void actionPerformed( ActionEvent e)  {
        Object o = e.getSource();
        JButton b = (JButton)o;
        String item = b.getText();

        if( item.equals("T")){
            display.setText( "calling" );
            digits = "";
        }
        else if(item.equals("E")){
            display.setText("end call");
            digits = "";
        }
        else {
            digits += item;
            display.setText( digits );
        }
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
