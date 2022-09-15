package CST8221;

import javax.swing.JOptionPane;

import CST8221.hybrid.Week01.HelloJFX;
import CST8221.hybrid.Week02.GlassPaneDemo;
import CST8221.hybrid.Week02.JavaFXAppLifeCycle;
import CST8221.hybrid.Week02.MultipleStages;
import CST8221.hybrid.Week02.OpacityDemo;

/**
 * Default Week 0 (Hybrid activities)
 * @author sousap
 *
 */
public class Week00_Hybrid {

	/**
	 * Error Message
	 */
	String errorMessage = "";

	/**
	 * Default constructor
	 */
	public Week00_Hybrid() {
		; // Default constructor
	}
	
	
	/**
	 * Week 0 Labs - Hybrid activities
	 * 
	 * @param lab Current lab
	 * @param usesJFX Boolean use of JavaFX
	 * @param args Command line parameters
	 */
	public void invokeHybrid(int lab, boolean usesJFX, String[] args) {
		switch (lab) {

		// Week 1 Hybrid examples ................................................
		case 11:
			if (usesJFX)
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					hybrid11();
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
			
		// Week 2 Hybrid examples ................................................
		case 21:
			hybrid21();
			break;
		case 22:
			hybrid22();
			break;
		case 23:
			if (usesJFX)
				hybrid23(args);
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 24:
			if (usesJFX)
				hybrid24(args);
			else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
			
		// Default ................................................
		default: // invalid lab
			errorMessage = "No valid Hybrid";
			JOptionPane.showMessageDialog(null, errorMessage);
		}

	}

	// HYBRID (WEEK 1) ..................................................

	/**
	 * Hybrid 11 - Basic JavaFX Hello
	 */
	public void hybrid11() {
		System.out.println("Hello JavaFX...");
		HelloJFX.main(null);
	}
	
	// HYBRID (WEEK 2) ..................................................
	
	/**
	 * Hybrid 1 - Week 2 - Code 1 - GlassPaneDemo
	 */
	public void hybrid21() {
		System.out.println("Hybrid Week 2 / Ex 1: GlassPane...");
		GlassPaneDemo Hybrid21 = new GlassPaneDemo();
		Hybrid21.execute();
	}

	/**
	 * Hybrid 1 - Week 2 - Code 2 - OpacityDemo
	 */
	public void hybrid22() {
		System.out.println("Hybrid Week 2 / Ex 2: Opacity...");
		OpacityDemo Hybrid22 = new OpacityDemo();
		Hybrid22.execute();
	}

	/**
	 * Hybrid 1 - Week 2 - Code 3 - JavaFXAppLifeCycle
	 * @param args Function parameters
	 */
	public void hybrid23(String[] args) {
		System.out.println("Hybrid Week 2 / Ex 3: JavaFX Basics...");
		JavaFXAppLifeCycle.execute(args);
	}

	/**
	 * Hybrid 1 - Week 2 - Code 4 - MultipleStages
	 * @param args Function parameters
	 */
	public void hybrid24(String[] args) {
		System.out.println("Hybrid Week 2 / Ex 4: Multistages...");
		MultipleStages.execute(args);
	}

	// NEW WEEKS TO COME ...............................................

}
