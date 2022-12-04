package CST8221;

import javax.swing.JOptionPane;

import CST8221.week06.MVCCalculator;

/**
 * Week 05 Class.
 * @author sousap
 *
 */
public class Week06 {

	/**
	 * Error messages.
	 */
	String errorMessage = "";

	/**
	 * Default constructor.
	 */
	public Week06() {
		; // No commands
	}
	
	/**
	 * Week 06 Labs - Events examples
	 * 
	 * @param lab Lab week
	 * @param usesJFX Flag for using Java FX
	 * @param args Command line.
	 */
	public void invokeWeek06(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w61(); // MVC
			break;
		default: // invalid lab
			errorMessage = "No valid Lab 6";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}

	// WEEK 06 ..........................................

	/**
	 * Method for week 6 - example 1 - MVC
	 */
	public void example_w61() {
		MVCCalculator.main(null);
	}

}
