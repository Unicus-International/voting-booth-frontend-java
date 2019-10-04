import View.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;

public class VotingMachine {


    public void main(String[] args) {
        JPanel cards; //a panel that uses CardLayout
        String BUTTONPANEL = "Card with JButtons";
        String TEXTPANEL = "Card with JTextField";

        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener((ItemListener) this);
        comboBoxPane.add(cb);

        //Create the "cards".
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));

        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);



        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
