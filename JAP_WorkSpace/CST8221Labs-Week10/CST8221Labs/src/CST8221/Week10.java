package CST8221;

import javax.swing.JOptionPane;

import CST8221.week10.ListNIFs;
import CST8221.week10.ListNets;
import CST8221.week10.ParseURL;
import CST8221.week10.URLReader;

/**
 * Week 10 class
 * @author sousap
 *
 */
public class Week10 {

	/**
	 * Default constructor
	 */
	public Week10() {
		; // Empty definitions
	}
	
	/**
	 * Error message string.
	 */
	String errorMessage = "";

	/**
	 * Week 10 Labs - Networking 1
	 * 
	 * @param lab Lab number.
	 * @param usesJFX Uses JavaFX
	 * @param args pARAMETERS.
	 */
	public void invokeWeek10(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w101(); // Parse URL
			break;
		case 2:
			example_w102(); // URL Reader
			break;
		case 3:
			example_w103(); // Network interfaces
			break;
		case 4:
			example_w104(); // Network lists
			break;
		default: // invalid lab
			errorMessage = "No valid Lab 10";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}


	// WEEK 10 ..........................................

	/**
	 * Method for week 10 - example 1 - URL Components
	 */
	public void example_w101() {
		ParseURL netSample = new ParseURL();
		try {
			netSample.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method for week 10 - example 2 - Reading URL
	 */
	public void example_w102() {
		URLReader netSample = new URLReader();
		try {
			netSample.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method for week 10 - example 3 - Network interfaces
	 */
	public void example_w103() {
		ListNIFs netSample = new ListNIFs();
		try {
			netSample.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method for week 10 - example 4 - Net list
	 */
	public void example_w104() {
		ListNets netSample = new ListNets();
		try {
			netSample.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
