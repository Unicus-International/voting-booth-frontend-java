
import Controllers.AuthenticationController;
import frontend.Views.*;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author karlw
 */
public class VotingBooth extends javax.swing.JFrame {

    public static CardLayout card;
    public static Container c;

    AuthenticationController authController;
    Container contentpane;
    
    public VotingBooth() throws HeadlessException {
        
        
        initComponents();

    }

    public static void main(String[] args) {
        VotingBooth vb = new VotingBooth();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(votingmachine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {

            

            vb.setVisible(true);

            vb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        });

    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // setTitle("c");
        // setName("c"); // NOI18N
        
        contentpane = getContentPane();
        contentpane.setLayout(new java.awt.CardLayout());


        authController = new AuthenticationController(contentpane);
 


        pack();

    }// </editor-fold>       s

    private void hello() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
