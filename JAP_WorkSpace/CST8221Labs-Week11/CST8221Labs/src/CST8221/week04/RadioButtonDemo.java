package CST8221.week04;

//Fig. 26.20: RadioButtonTest.java
//Testing RadioButtonFrame
//Modified by S.Ranev, D. Cormier
//version: 1.20.1
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Dimension;

/**
 * Sample of Radio Button
 * @author sousap
 *
 */
public class RadioButtonDemo {
	
	/**
	 * Default constructor.
	 */
	public RadioButtonDemo() {
		; // No parameter
	}
	
	/**
	 * Execute method
	 */
	public void execute() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
				radioButtonFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				radioButtonFrame.setMinimumSize(new Dimension(320, 110));// set the frame initial and minimum size
				radioButtonFrame.setLocationByPlatform(true);
				radioButtonFrame.setVisible(true); // display frame
			}
		});

	} // end main
} // end class RadioButtonDemo
