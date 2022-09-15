package CST8221;

import javax.swing.JOptionPane;

import CST8221.hybrid.Week01.HelloJFX;

public class Week00_Hybrid {

	// Error Message
	String errorMessage = "";

	/**
	 * Week 0 Labs - Hybrid activities
	 * 
	 * @param lab
	 * @param usesJFX
	 * @param args
	 */
	public void invokeHybrid(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		// Week 1 Hybrid examples ................................................
		case 11:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					hybrid11();
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
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

	public void hybrid11() {
		System.out.println("Hello JavaFX...");
		HelloJFX.main(null);
	}

	// NEW WEEKS TO COME ...............................................

}
