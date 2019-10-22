/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.Action;

/**
 *
 * @author karlw
 */
public class NavigationListener implements Action {
private ArrayList<PropertyChangeListener> listeners = new ArrayList();


    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for (PropertyChangeListener listen : this.listeners){
          return;
       }
    }

    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEnabled(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean accept(Object sender) {
        return Action.super.accept(sender); //To change body of generated methods, choose Tools | Templates.
    }
    
}
