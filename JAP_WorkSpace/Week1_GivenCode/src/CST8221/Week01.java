package CST8221;

import javax.swing.JOptionPane;

import CST8221.week01.FXMLCSSButton;
import CST8221.week01.SimpleJavaFXGUIe4;
import CST8221.week01.SimpleSwingGUIe1;
import CST8221.week01.SimpleSwingGUIe2;
import CST8221.week01.SimpleSwingGUIe2R;
import CST8221.week01.SimpleSwingGUIe3;
import CST8221.week01.SimpleSwingGUIe3L;
import CST8221.week01.SwingJavaFX;

public class Week01 {

	// Error message
	String errorMessage = "";

	/**
	 * Week 1 Labs - Basic about Swing and JavaFX
	 * 
	 * @param lab
	 * @param usesJFX
	 * @param args
	 */
	public void invokeWeek01(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w11();
			break;
		case 2:
			example_w12();
			break;
		case 3:
			example_w13();
			break;
		case 4:
			example_w14();
			break;
		case 5:
			example_w15();
			break;
		case 6:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					example_w16(args);
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			}
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		/*
		 * case 7: if (usesJFX) example_w17(args); // ERR else { errorMessage =
		 * "Unable to run JavaFX..."; JOptionPane.showMessageDialog(null, errorMessage);
		 * } break; case 8: if (usesJFX) example_w18(args); // ERR else { errorMessage =
		 * "Unable to run JavaFX..."; JOptionPane.showMessageDialog(null, errorMessage);
		 * } break;
		 */
		default: // invalid lab
			errorMessage = "No valid Lab 1";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}

	// WEEK 01 ...........................................................

	/**
	 * Method for example1 from week 1
	 */
	public void example_w11() {
		new SimpleSwingGUIe1();
	}

	/**
	 * Method for example2 from week 1
	 */
	public void example_w12() {
		new SimpleSwingGUIe2();
	}

	/**
	 * Method for example2r from week 1
	 */
	public void example_w13() {
		new SimpleSwingGUIe2R();
	}

	/**
	 * Method for example3 from week 1
	 */
	public void example_w14() {
		SimpleSwingGUIe3 ExampleW13 = new SimpleSwingGUIe3();
		ExampleW13.execute();
	}

	/**
	 * Method for example3l from week 1
	 */
	public void example_w15() {
		SimpleSwingGUIe3L ExampleW13l = new SimpleSwingGUIe3L();
		ExampleW13l.execute();
	}

	/**
	 * Method for example4 from week 1
	 */
	public void example_w16(String[] args) {
		SimpleJavaFXGUIe4 ExampleW14 = new SimpleJavaFXGUIe4();
		ExampleW14.execute(args);
	}

	/**
	 * Method for SwingJavaFX from week 1 (ERR)
	 */
	public void example_w17(String[] args) {
		SwingJavaFX ExampleW1SFX = new SwingJavaFX();
		ExampleW1SFX.execute(args);
	}

	/**
	 * Method for SwingJavaFX from week 1
	 */
	public void example_w18(String[] args) {
		FXMLCSSButton ExampleW1CSSButton = new FXMLCSSButton();
		ExampleW1CSSButton.execute(args);
	}

}
