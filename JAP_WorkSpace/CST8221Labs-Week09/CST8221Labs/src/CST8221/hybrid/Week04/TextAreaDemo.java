package CST8221.hybrid.Week04;

//Fig. 26.48: TextAreaDemo.java
//Copying selected text from one text area to another. 
//Modified by S.Ranev, D. Cormier
//version: 1.20.1
import java.awt.EventQueue;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Text area demo.
 * @author sousap
 *
 */
public class TextAreaDemo {
	
	/**
	 * Default constructor.
	 */
	public TextAreaDemo() {
		; // No parameter
	}
	
	/**
	 * Execute method.
	 */
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TextAreaFrame textAreaFrame = new TextAreaFrame();
				textAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				textAreaFrame.setMinimumSize(new Dimension(425, 200)); // set frame minimum size
				textAreaFrame.setLocationByPlatform(true);
				textAreaFrame.setVisible(true); // display frame
			}
		});
	} // end main
} // end class TextAreaDemo
