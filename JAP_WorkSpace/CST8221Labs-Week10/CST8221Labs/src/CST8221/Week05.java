package CST8221;

import javax.swing.JOptionPane;

import CST8221.week05.ContextFXMenuDemo;
import CST8221.week05.JFXMenuDemo;
import CST8221.week05.MenuDemoFX;
import CST8221.week05.MenuTest;
import CST8221.week05.SwingMenuDemo;

/**
 * Week 05 Class.
 * @author sousap
 *
 */
public class Week05 {

	/**
	 * Error messages.
	 */
	String errorMessage = "";

	/**
	 * Default constructor.
	 */
	public Week05() {
		; // No commands
	}
	
	/**
	 * Week 05 Labs - Events examples
	 * 
	 * @param lab Lab week
	 * @param usesJFX Flag for using Java FX
	 * @param args Command line.
	 */
	public void invokeWeek05(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w51(); // Menu
			break;
		case 2:
			example_w52(); // Menu
			break;
		case 3:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					example_w53(args); // JavaFX Radio Button events
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
					example_w54(args); // JavaFX Radio Button events
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 5:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					example_w55(args); // JavaFX Radio Button events
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
			errorMessage = "No valid Lab 5";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}

	// WEEK 05 ..........................................

	/**
	 * Method for week 5 - example 1 - Menus
	 */
	public void example_w51() {
		SwingMenuDemo menuDemo = new SwingMenuDemo();
		menuDemo.execute();
	}

	/**
	 * Method for week 5 - example 2 - Menu Frame
	 */
	public void example_w52() {
		MenuTest.execute();
	}

	/**
	 * Method for week 5 - example 3 - Menu JavaFX
	 * @param args Arguments.
	 */
	public void example_w53(String[] args) {
		MenuDemoFX.execute(args);
	}

	/**
	 * Method for week 5 - example 4 - 2nd JavaFX Example
	 * @param args Arguments
	 */
	public void example_w54(String[] args) {
		JFXMenuDemo.execute(args);
	}

	/**
	 * Method for week 5 - example 4 - 2nd JavaFX Example
	 * @param args Arguments
	 */
	public void example_w55(String[] args) {
		ContextFXMenuDemo.execute(args);
	}
	
}
