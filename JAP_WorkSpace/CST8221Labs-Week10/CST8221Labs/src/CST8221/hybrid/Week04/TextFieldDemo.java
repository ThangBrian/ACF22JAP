package CST8221.hybrid.Week04;

//Fig. 26.10: TextFieldDemo.java 
//Modified by S. Ranev, D. Cormier
//version: 1.20.1
import javax.swing.JFrame;

import java.awt.*;

/**
 * TextField Sample
 * @author sousap
 *
 */
public class TextFieldDemo {
	
	/**
	 * Default constructor.
	 */
	public TextFieldDemo() {
		; // No commands
	}
	
	/**
	 * Execute method.
	 */
	public void execute() {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				// create the application frame
				JFrame frame = new JFrame("Swing Text Fields Demo");
				TextFieldPanel textFieldPanel = new TextFieldPanel();
				Container contentPane = frame.getContentPane();
				contentPane.add(textFieldPanel, BorderLayout.CENTER);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setMinimumSize(new Dimension(400, 130));// set frame mimimum size
				// frame.setResizable(false);
				frame.setLocationByPlatform(true);
				frame.setVisible(true); // display frame
			}
		});
	} // end main
} // end class TextFieldDemo
