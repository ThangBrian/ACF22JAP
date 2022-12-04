package CST8221;

import javax.swing.JOptionPane;

import CST8221.week04.Beeper;
import CST8221.week04.ButtonDemo;
import CST8221.week04.ButtonFXDemo;
import CST8221.week04.CheckBoxDemo;
import CST8221.week04.CheckBoxDemoFX;
import CST8221.week04.RadioButtonDemo;
import CST8221.week04.RadioButtonDemoFX;
import CST8221.week04.SplashScreenDemo;
import CST8221.week04.SplashScreenDemoFX;

/**
 * Week 04 class.
 * @author sousap
 *
 */
public class Week04 {

	// Error message
	String errorMessage = "";

	/**
	 * Default constructor.
	 */
	public Week04() {
		; // No commands
	}
	
	/**
	 * Week 04 Labs - Events examples
	 * 
	 * @param lab Lab identification
	 * @param usesJFX Indicates if use JavaFX
	 * @param args Parameters
	 */
	public void invokeWeek04(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w41(); // Beeper
			break;
		case 2:
			example_w42(); // Swing splash
			break;
		case 3:
			example_w43(); // Swing Checkbox events
			break;
		case 4:
			example_w44(); // Swing Radiobutton events
			break;
		case 5:
			example_w45(args); // Swing splash
			break;
		case 6:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					example_w46(args); // JavaFX splash
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 7:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					example_w47(args); // JavaFX Checkbox events
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 8:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					example_w48(args); // JavaFX Radio Button events
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 9:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					example_w49(args); // JavaFX splash
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
			errorMessage = "No valid Lab from Week 4";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}

	// WEEK 04 ..........................................

	/**
	 * Method for week 4 - example 1 - Beeper
	 */
	public void example_w41() {
		Beeper beeper = new Beeper();
		beeper.execute();
	}

	/**
	 * Method for week 4 - example 2 - Button Events
	 */
	public void example_w42() {
		ButtonDemo.execute();
	}

	/**
	 * Method for week 4 - example 3 - Swing CheckBox Events
	 */
	public void example_w43() {
		CheckBoxDemo eventDemo = new CheckBoxDemo();
		eventDemo.execute();
	}

	/**
	 * Method for week 4 - example 4 - RadioButton Events
	 */
	public void example_w44() {
		RadioButtonDemo eventDemo = new RadioButtonDemo();
		eventDemo.execute();
	}


	/**
	 * Method for week 4 - example 5 - Swing Splash
	 * @param args Parameters.
	 */
	public void example_w45(String[] args) {
		SplashScreenDemo.execute(args);
	}


	/**
	 * Method for week 4 - example 6 - Splash FX
	 * @param args Parameters
	 */
	public void example_w46(String[] args) {
		ButtonFXDemo eventDemo = new ButtonFXDemo();
		eventDemo.execute(args);
	}


	/**
	 * Method for week 4 - example 7 - JavaFX CheckBox Events
	 * @param args Parameters
	 */
	public void example_w47(String[] args) {
		CheckBoxDemoFX eventDemo = new CheckBoxDemoFX();
		eventDemo.execute(args);
	}


	/**
	 * Method for week 4 - example 8 - RadioButton Events
	 * @param args Parameters
	 */
	public void example_w48(String[] args) {
		RadioButtonDemoFX eventDemo = new RadioButtonDemoFX();
		eventDemo.execute(args);
	}


	/**
	 * Method for week 4 - example 9 - Splash FX
	 * @param args Parameters
	 */
	public void example_w49(String[] args) {
		SplashScreenDemoFX.execute(args);
	}

}
