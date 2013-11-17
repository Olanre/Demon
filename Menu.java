/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Board;

/**
 *
 * @author Olanrewaju Okunlola
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.JOptionPane;

import java.io.File;
public class Menu {
    private JMenuBar menuBar;
    /**
     * Create the application.
     */
    public Menu() {
        initialize();
    }

    /**
     * Initialize the contents of the JMenuBar.
     */
    private void initialize() {
    
        menuBar = new JMenuBar();
                
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        
        JMenuItem mntmQuit = new JMenuItem("Quit");
        mntmQuit.setMnemonic(KeyEvent.VK_Q);
        mntmQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Q item");
                System.exit( 0 );
            }
        });

        
        
        JMenuItem mntmSave = new JMenuItem("Save");
        mntmSave.setMnemonic(KeyEvent.VK_S);
        mntmSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("S item");
            }
        });
        mnFile.add(mntmSave);
        mnFile.add(mntmQuit);

        JMenuItem mntmNewGame = new JMenuItem("New Game");
        mntmNewGame.setMnemonic(KeyEvent.VK_S);        
        mnFile.add(mntmNewGame);
        
        JMenu mnOption = new JMenu("Option");
        menuBar.add(mnOption);
        JMenuItem mntmScores = new JMenuItem("Scores");
        mntmScores.setMnemonic(KeyEvent.VK_Q);
        mnOption.add(mntmScores);
                
        
        JMenu mnHelp = new JMenu("Help?");
        menuBar.add(mnHelp);
        JMenuItem mntmInstructions = new JMenuItem("Instructions");
        mntmInstructions.setMnemonic(KeyEvent.VK_Q);
        mnHelp.add(mntmInstructions);
        
    }
    /* to return the JMenuBar from initialize
    */
    public JMenuBar getMenuBar() {
        return menuBar;
    }
}
