												package CST8221;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import CST8221.hybrid.Week01.HelloJFX;
import CST8221.hybrid.Week02.GlassPaneDemo;
import CST8221.hybrid.Week02.JavaFXAppLifeCycle;
import CST8221.hybrid.Week02.MultipleStages;
import CST8221.hybrid.Week02.OpacityDemo;
import CST8221.hybrid.Week03.BasePane;
import CST8221.hybrid.Week03.LayoutDemo;
import CST8221.hybrid.Week04.LayeredPaneDemo;
import CST8221.hybrid.Week04.TextAreaDemo;
import CST8221.hybrid.Week04.TextAreaDemoFX;
import CST8221.hybrid.Week04.TextFieldDemo;
import CST8221.hybrid.Week04.TextFieldDemoFX;
import CST8221.hybrid.Week05.CustomDialogFX;
import CST8221.hybrid.Week05.DialogExample;
import CST8221.hybrid.Week05.ListFrame;
import CST8221.hybrid.Week05.PaintPanel;
import CST8221.hybrid.Week05.StandardDialogDemo;
import CST8221.hybrid.Week05.StandardDialogFX;
import CST8221.hybrid.Week06.OnLineShop;
import CST8221.hybrid.Week09.Calculator2MVC;
import CST8221.hybrid.Week09.SwingThreadTest;

/**
 * Class for all hybrid tests
 * 
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
		; // No statement
	}

	/**
	 * Week 0 Labs - Hybrid activities
	 * 
	 * @param lab     Current lab
	 * @param usesJFX Boolean use of JavaFX
	 * @param args    Command line parameters
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
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					hybrid23(args);
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 24:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					hybrid24(args);
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;

		// Week 3 Hybrid examples ................................................
		case 31:
			hybrid31(); // Layout Test (Prof. Daniel)
			break;
		case 32:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					hybrid32(args); // Base Pane Test (Prof. Daniel)
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;

		// Week 4 Hybrid examples ................................................
		case 41:
			hybrid41(); // TextField
			break;
		case 42:
			hybrid42(); // TextArea
			break;
		case 43:
			hybrid43(); // Layers
			break;
		case 44:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					hybrid44(args); // TextField JavaFX
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 45:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					hybrid45(args); // TextArea JavaFX
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;

		// Week 5 Hybrid examples ................................................
		case 51:
			hybrid51(); // Dialog demo
			break;
		case 52:
			hybrid52(); // Dialog
			break;
		case 53:
			hybrid53(); // Book: Panel color
			break;
		case 54:
			hybrid54(); // Book: Paint
			break;
		case 55:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					hybrid55(args); // TextField
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;
		case 56:
			if (usesJFX) {
				if (!Main.JFXLaunched) {
					Main.JFXLaunched = true;
					hybrid56(args); // TextField
				} else {
					errorMessage = "You can execute JavaFX only once!";
					JOptionPane.showMessageDialog(null, errorMessage);
				}
			} else {
				errorMessage = "Unable to run JavaFX...";
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			break;

		// Week 6 Hybrid examples ................................................
		case 61:
			hybrid61(); // Dialog demo
			break;

		// Week 9 Hybrid examples ................................................
		case 91:
			hybrid91(); // Swing Threads 1
			break;
		case 92:
			hybrid92(); // Swing Threads 2
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
	 * 
	 * @param args Function parameters
	 */
	public void hybrid23(String[] args) {
		System.out.println("Hybrid Week 2 / Ex 3: JavaFX Basics...");
		JavaFXAppLifeCycle.execute(args);
	}

	/**
	 * Hybrid 1 - Week 2 - Code 4 - MultipleStages
	 * 
	 * @param args Function parameters
	 */
	public void hybrid24(String[] args) {
		System.out.println("Hybrid Week 2 / Ex 4: Multistages...");
		MultipleStages.execute(args);
	}

	// HYBRID (WEEK 3) ..................................................

	/**
	 * Method for week 3 - Hybrid for Layouts - Prof. Daniel
	 */
	public void hybrid31() {
		System.out.println("Hybrid Week 3 / Ex 1: Layout demo...");
		LayoutDemo.execute();
	}

	/**
	 * Method for week 3 - Base Pane (for test) - Prof. Daniel
	 * 
	 * @param args Parameters for JavaFX
	 */
	public void hybrid32(String[] args) {
		System.out.println("Hybrid Week 3 / Ex 2: Basic about Panes...");
		BasePane pane = new BasePane();
		pane.execute(args);
	}

	// HYBRID (WEEK 4) ..................................................

	/**
	 * Method for week 4 - Hybrid 1: TextField - Prof. Daniel
	 */
	public void hybrid41() {
		System.out.println("Hybrid Week 4 / Ex 1: Textfield demo...");
		TextFieldDemo text = new TextFieldDemo();
		text.execute();
	}

	/**
	 * Method for week 4 - Hybrid 2: TextArea - Prof. Daniel
	 */
	public void hybrid42() {
		System.out.println("Hybrid Week 4 / Ex 2: Textarea demo...");
		TextAreaDemo text = new TextAreaDemo();
		text.execute();
	}

	/**
	 * Method for week 4 - Hybrid 3: Layers (Oracle)
	 */
	public void hybrid43() {
		System.out.println("Hybrid Week 4 / Ex 3: Layers...");
		LayeredPaneDemo layers = new LayeredPaneDemo();
		layers.execute();
	}
	

	/**
	 * Method for week 4 - Hybrid 4: TextField - Prof. Daniel
	 * @param args Arguments
	 */
	public void hybrid44(String[] args) {
		System.out.println("Hybrid Week 4 / Ex 4: JavaFX TextFieldDemo...");
		TextFieldDemoFX text = new TextFieldDemoFX();
		text.execute(args);
	}

	/**
	 * Method for week 4 - Hybrid 5: TextArea - Prof. Daniel
	 * @param args Arguments
	 */
	public void hybrid45(String[] args) {
		System.out.println("Hybrid Week 4 / Ex 5: JavaFX TextAreaDemo...");
		TextAreaDemoFX text = new TextAreaDemoFX();
		text.execute(args);
	}
	

	// HYBRID (WEEK 5) ..................................................

	/**
	 * Method for week 5 - Hybrid 1: Dialogs 1
	 */
	public void hybrid51() {
		System.out.println("Hybrid Week 5 / Ex 1: Dialogs...");
		StandardDialogDemo dialogDemo = new StandardDialogDemo();
		dialogDemo.execute();
	}

	/**
	 * Method for week 5 - Hybrid 2: Dialogs no modal
	 */
	public void hybrid52() {
		System.out.println("Hybrid Week 5 / Ex 4: More Dialogs...");
		DialogExample.execute();
	}

	/**
	 * Method for week 5 - Hybrid 3: Color panel
	 */
	public void hybrid53() {
		System.out.println("Hybrid Week 5 / Ex 5: Frames Properties...");
		ListFrame listFrame = new ListFrame(); // create ListFrame
		listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listFrame.setSize(350, 150);
		listFrame.setVisible(true);
	}

	/**
	 * Method for week 5 - Hybrid 4: Paint
	 */
	public void hybrid54() {
		System.out.println("Hybrid Week 5 / Ex 1: Paint...");
		// create JFrame
		JFrame application = new JFrame("A simple paint program");
		PaintPanel paintPanel = new PaintPanel();
		application.add(paintPanel, BorderLayout.CENTER);
		// create a label and place it in SOUTH of BorderLayout
		application.add(new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(400, 200);
		application.setVisible(true);
	}

	/**
	 * Method for week 5 - Hybrid 5: Dialogs FX
	 * @param args Arguments (not used)
	 */
	public void hybrid55(String[] args) {
		System.out.println("Hybrid Week 5 / Ex 2: JavaFX Dialogs...");
		StandardDialogFX.execute(args);
	}

	/**
	 * Method for week 5 - Hybrid 6: Dialogs FX
	 * @param args Arguments (not used)
	 */
	public void hybrid56(String[] args) {
		System.out.println("Hybrid Week 5 / Ex 3: JavaFX Custom Dialogs...");
		CustomDialogFX.execute(args);
	}

	// HYBRID (WEEK 6) ..................................................

	/**
	 * Method for week 6 - Hybrid 1: On line shopping
	 */
	public void hybrid61() {
		System.out.println("Hybrid Week 6 / Ex 1: Facade...");
		OnLineShop facade = new OnLineShop();
		facade.simulation();
	}

	// HYBRID (WEEK 9) ..................................................

	/**
	 * Method for week 9 - example 1 - Swing Thread
	 */
	public void hybrid91() {
		System.out.println("Hybrid Week 9 / Ex 1: Swing Thread...");
		SwingThreadTest test = new SwingThreadTest();
		test.execute();
	}

	/**
	 * Method for week 9 - example 2 - Calculator2 MVC
	 */
	public void hybrid92() {
		System.out.println("Hybrid Week 9 / Ex 2: MVC Calculator...");
		System.out.println("Another MVC Calculator");
		Calculator2MVC mvcExample = new Calculator2MVC();
		mvcExample.execute();
	}

	// NEW WEEKS TO COME ...............................................

}
