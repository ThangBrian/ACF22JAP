package CST8221.week04;

//Fig. 26.18: CheckBoxTest.java
//Testing CheckBoxFrame.
//Modified by S. Ranev, D. Cormier
//version: 1.20.1
import javax.swing.JFrame;
import java.awt.EventQueue;

/**
 * Class for Checkbox demo
 * @author sousap
 *
 */
public class CheckBoxDemo {
	
	/**
	 * Default constructor
	 */
	public CheckBoxDemo() {
		; // Empty declaration
	}
	
	/**
	 * Execute method
	 */
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CheckBoxFrame checkBoxFrame = new CheckBoxFrame();
				checkBoxFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				checkBoxFrame.setSize(400, 100); // set frame size
				checkBoxFrame.setLocationByPlatform(true);
				checkBoxFrame.setVisible(true); // display frame
			}
		});

	} // end main
} // end class CheckBoxDemo
