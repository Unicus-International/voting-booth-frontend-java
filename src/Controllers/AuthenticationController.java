/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Network.Connection;
import Model.AuthenticationModel;
import frontend.Views.LoginView;
import frontend.Views.RegisterView;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author karlw
 */
public class AuthenticationController extends Connection  implements ActionListener{
    ArrayList<INavigateListener> listener;
    Container contentPane;
    LoginView login;
    RegisterView register;

    public AuthenticationController() {
        
    }

    public AuthenticationController(Container contentpane) {
        this.listener = new ArrayList<INavigateListener>();
        this.contentPane = contentpane;
        init();

    }
    
    public void addListener(INavigateListener listener){
        this.listener.add(listener);
    }
    

    public boolean jButton2ActionPerformed(ActionEvent evt, AuthenticationModel authenticationModel) {
        try {
            return login(authenticationModel.email, authenticationModel.password);
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(INavigateListener listen: this.listener){
           listen.call();
       }
    }
    
    private void init(){
        login = new LoginView();
        register = new RegisterView();
        
        contentPane.add(login);
        contentPane.add(register);
    }

}
