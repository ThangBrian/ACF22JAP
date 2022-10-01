package CST8221;

import javax.swing.JOptionPane;

import CST8221.week03.BorderLayoutDemo;
import CST8221.week03.BoxLayoutDemo;
import CST8221.week03.CardLayoutDemo;
import CST8221.week03.FlowLayoutDemo;
import CST8221.week03.GridBagLayoutDemo;
import CST8221.week03.GridLayoutDemo;
import CST8221.week03.GroupLayoutDemo;
import CST8221.week03.SpringLayoutDemo;

/**
 * Class for Week 3 - Layouts
 * @author sousap
 *
 */
public class Week03 {

	/**
	 * Default constructor.
	 */
	public Week03() {
		; // Empty definitions
	}
	// Error message
	String errorMessage = "";

	/**
	 * Week 03 Labs - Basic about Layouts
	 * 
	 * @param lab Lab executed in this week.
	 * @param usesJFX Flag to define JavaFX
	 * @param args Parameters for execution.
	 */
	public void invokeWeek03(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w31(); // BorderLayout
			break;
		case 2:
			example_w32(); // BoxLayout
			break;
		case 3:
			example_w33(); // CardLayout
			break;
		case 4:
			example_w34(); // FlowLayout
			break;
		case 5:
			example_w35(); // GridLayout
			break;
		case 6:
			example_w36(); // GridBagLayout
			break;
		case 7:
			example_w37(); // GroupLayout
			break;
		case 8:
			example_w38(); // SpringLayout
			break;
		default: // invalid lab
			errorMessage = "No valid Lab 3";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}


	// WEEK 03 ...........................................................

	/**
	 * Method for week 3 - example 1 - BorderLayout
	 */
	public void example_w31() {
		BorderLayoutDemo layout;
		try {
			layout = new BorderLayoutDemo();
			layout.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method for week 3 - example 2 - BoxLayout
	 */
	public void example_w32() {
		BoxLayoutDemo layout = new BoxLayoutDemo();
		layout.execute();
	}

	/**
	 * Method for week 3 - example 3 - CardLayout
	 */
	public void example_w33() {
		CardLayoutDemo layout = new CardLayoutDemo();
		layout.execute();
	}

	/**
	 * Method for week 3 - example 4 - FlowLayout
	 */
	public void example_w34() {
		FlowLayoutDemo layout = new FlowLayoutDemo("FlowLayoutDemo");
		layout.execute();
	}

	/**
	 * Method for week 3 - example 5 - GridLayout
	 */
	public void example_w35() {
		GridLayoutDemo layout = new GridLayoutDemo("GridLayoutDemo");
		layout.execute();
	}

	/**
	 * Method for week 3 - example 6 - GridBagLayout
	 */
	public void example_w36() {
		GridBagLayoutDemo layout = new GridBagLayoutDemo();
		layout.execute();
	}

	/**
	 * Method for week 3 - example 7 - GroupLayout
	 */
	public void example_w37() {
		GroupLayoutDemo layout = new GroupLayoutDemo();
		layout.execute();
	}

	/**
	 * Method for week 3 - example 8 - SpringLayout
	 */
	public void example_w38() {
		SpringLayoutDemo layout = new SpringLayoutDemo();
		layout.execute();
	}

}
