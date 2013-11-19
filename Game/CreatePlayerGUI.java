/**
 * This class is used to allow players
 * to create new accounts for the game.
 */
package Game;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class CreatePlayerGUI extends javax.swing.JFrame {

    /* Creates new form CreatePlayerGUI */
    public CreatePlayerGUI() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FirstName = new javax.swing.JLabel();
        LastName = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        ConfirmPassword = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        FirstNameField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        UsernameField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JPasswordField();
        ConfirmPasswordField = new javax.swing.JPasswordField();
        Start = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Project Demon");
        setName("Create Player"); // NOI18N

        FirstName.setText("First Name :");

        LastName.setText("Last Name :");

        Username.setText("Username :");

        Password.setText("Password :");

        ConfirmPassword.setText("Confirm Password :");

        Title.setText("Create Player");

        Start.setText("Create");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(63, 63, 63)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(Start)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Cancel))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, ConfirmPassword)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, Password)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, Username)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, LastName)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, FirstName))
                        .add(84, 84, 84)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(UsernameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(PasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(ConfirmPasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(LastNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(FirstNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(Title)
                .add(178, 178, 178))
        );

        layout.linkSize(new java.awt.Component[] {ConfirmPassword, FirstName, LastName, Password, Username}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[] {ConfirmPasswordField, FirstNameField, LastNameField, PasswordField, UsernameField}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.linkSize(new java.awt.Component[] {Cancel, Start}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(Title, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 29, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(UsernameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(layout.createSequentialGroup()
                                        .add(FirstName)
                                        .add(26, 26, 26)
                                        .add(LastName))
                                    .add(layout.createSequentialGroup()
                                        .add(FirstNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(LastNameField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .add(18, 18, 18)
                                .add(Username)))
                        .add(18, 18, 18)
                        .add(Password))
                    .add(PasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(ConfirmPassword)
                    .add(ConfirmPasswordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(Cancel)
                    .add(Start))
                .add(29, 29, 29))
        );

        layout.linkSize(new java.awt.Component[] {ConfirmPassword, FirstName, LastName, Password, Username}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* Cancels the class */
    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        this.dispose();        
    }//GEN-LAST:event_CancelActionPerformed

    /* Get values from the text fields */
    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
               
        String passText,confirmPass,fName,lName,uName,pInfo;
        passText = new String(PasswordField.getPassword());
        confirmPass = new String(ConfirmPasswordField.getPassword());
        fName = FirstNameField.getText();
        lName = LastNameField.getText();
        uName = UsernameField.getText();
        pInfo = uName + "," + passText + "," + fName + "," + lName;
        
        // have a check class 
        if(!(passText.equals(confirmPass) && confirmPass.length() != 0))
        {
            JOptionPane.showMessageDialog(this, "Passwords don't match", "Error", 0);                
        }
        else if(fName.length() == 0 || lName.length() == 0 || uName.length() == 0)
        {
            JOptionPane.showMessageDialog(this, "Error - All critera not met", "Error", 0);
        }
        else if( fName.contains(" ") || lName.contains(" ") || uName.contains(" "))
        {
            JOptionPane.showMessageDialog(this, "Error - Can't have spaces in names", "Error", 0);
        }
        else
        {
            BufferedWriter writer;
            try
            {
                writer = new BufferedWriter( new FileWriter("players.txt",true));
                writer.write(pInfo);
                writer.append("\n");
                writer.close();
                this.dispose();
            } 
            catch(IOException ioE)
            {
                JOptionPane.showMessageDialog(this, "Can't Write File", "Error", 0);
            }            
        }
    }//GEN-LAST:event_StartActionPerformed

    /* Main method of the create player class */
    public static void main(String args[]) {
        
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(CreatePlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(CreatePlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(CreatePlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(CreatePlayerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatePlayerGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JLabel ConfirmPassword;
    private javax.swing.JPasswordField ConfirmPasswordField;
    private javax.swing.JLabel FirstName;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JLabel LastName;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton Start;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Username;
    private javax.swing.JTextField UsernameField;
    // End of variables declaration//GEN-END:variables
}
