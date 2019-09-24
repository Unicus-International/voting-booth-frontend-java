package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class BallotView implements Viewable {

	@Override
	public void refreshView() {

		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Voting booth");
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.setSize(300, 200);
		frame.setResizable(false);
		// frame.pack();
		frame.setVisible(true);
		
 
	}



}
