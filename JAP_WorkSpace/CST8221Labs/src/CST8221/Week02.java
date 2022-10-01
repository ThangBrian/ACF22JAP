package CST8221;

import javax.swing.JOptionPane;

import CST8221.week02.BordersDemoFX;
import CST8221.week02.JFXDemoW2;
import CST8221.week02.SwingDemoW2;
import CST8221.week02.SwingBordersDemo;

/**
 * Class for Week 02 Examples
 * @author sousap
 *
 */
public class Week02 {

	/**
	 * Default constructor
	 */
	public Week02() {
		; // Empty declarations
	}
	
	// Error message
	String errorMessage = "";

	/**
	 * Week 02 Labs - Basic about Borders
	 * 
	 * @param lab Lab to be tested
	 * @param usesJFX Boolean identification for using JavaFX
	 * @param args Parameters for execution (ignored)
	 */
	public void invokeWeek02(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w21();
			break;
		case 2:
			example_w22();
			break;
		case 3:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					example_w23(args);
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 4:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					example_w24(args);
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		default: // invalid lab
			errorMessage = "No valid Lab " + lab + " for week 2";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}

	// WEEK 02 ...........................................................

	/**
	 * Method for week 2 - example 1 - Border
	 */
	public void example_w21() {
		SwingBordersDemo ExampleW21 = new SwingBordersDemo();
		ExampleW21.execute();
	}

	/**
	 * Method for week 2 - example 2 - Hello Swing
	 */
	public void example_w22() {
		SwingDemoW2 d1 = new SwingDemoW2();
		d1.demo();
	}
	
	/**
	 * Method for week 2 - example 3 - Borders JFX
	 * @param args Command line parameters
	 */
	public void example_w23(String[] args) {
		BordersDemoFX.execute(args);
	}

	/**
	 * Method for week 2 - example 4 - Hello JFX
	 * @param args Command line parameters
	 */
	public void example_w24(String[] args) {
		JFXDemoW2 d2 = new JFXDemoW2();
		d2.execute(args);
	}

}
