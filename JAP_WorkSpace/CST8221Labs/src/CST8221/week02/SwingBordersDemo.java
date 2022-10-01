package CST8221.week02;

/* CST8221-JAP: LAB 02, Borders
   File name: SwingBordersDemo.java
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.*;

/**
 * Demonstrates how to create simple boarders using the BorderFactory class.
 * Also, demonstrates how to use a class from the javax.swing.border package.
 * JLabel is used for the demonstration, Note that a border can be painted
 * around every JComponent object
 * 
 * @version 1.19.1
 * @author Svillen Ranev, Daniel Cormier
 * @since Java 2
 */
public class SwingBordersDemo extends JFrame {
	/* Swing components are serializable and require serialVersionUID */
	private static final long serialVersionUID = -6784904236778611860L;

	/**
	 * Default constructor. Sets the GUI.
	 */
	public SwingBordersDemo() {
		super("Swing Borders Demo");
		createGUI();
	}

	/** Builds the GUI */
	private void createGUI() {
		Border empty, thickEmptyBoarder;
		Border line, thickLine;
		Border raisedbevel, loweredbevel;
		Border raisedEtched, loweredEtched;
		Border defaultTitle, modifiedTitle;
		Border compoundBorder1, compoundBorder2;
		// create different borders
		empty = BorderFactory.createEmptyBorder();
		thickEmptyBoarder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		line = BorderFactory.createLineBorder(Color.red); // create Rounded Line Border

		// Create a Rounded Line border.
		// The BorderFactory does not provide an appropriate method.
		// In this case, the LineBorder class must be used directly.
		thickLine = new LineBorder(Color.red, 3, true);

		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		loweredEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		defaultTitle = BorderFactory.createTitledBorder("Title");
		modifiedTitle = BorderFactory.createTitledBorder(line, "Title", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		compoundBorder1 = BorderFactory.createCompoundBorder(raisedbevel, line);
		compoundBorder2 = BorderFactory.createCompoundBorder(defaultTitle, line);

		// create array of borders
		Border[] borders = { empty, thickEmptyBoarder, line, thickLine, raisedbevel, loweredbevel, raisedEtched,
				loweredEtched, defaultTitle, modifiedTitle, compoundBorder1, compoundBorder2 };
		// create array of label text using an anonimous array
		String[] labelText;
		labelText = new String[] { "empty border", "thick empty border", "line border", "thick rounded line border",
				"raised bevel border", "lowered bevel border", "raised etched border", "lowered etched border",
				"default titled border", "modified titled border", "compound border(raised bevel and line)",
				"compound border (title and line)" };
		// create array of labels
		JLabel[] labels = new JLabel[borders.length];
		for (int i = 0; i < borders.length; ++i) {
			labels[i] = createLabel(borders[i], labelText[i]);
		}
		// create pane to hold borders
		JPanel simpleBordersPane = new JPanel(new GridLayout(6, 2, 10, 10));
		simpleBordersPane.setBorder(thickEmptyBoarder);
		simpleBordersPane.setBackground(Color.WHITE);
		// add labels to pane
		for (int i = 0; i < borders.length; ++i) {
			simpleBordersPane.add(labels[i]);
		}
		// add pane to frame
		getContentPane().add(simpleBordersPane, BorderLayout.CENTER);

	}

	/**
	 * Creates a JLabel with specific border and description
	 * 
	 * @param border      the label border
	 * @param description the label text
	 * @return a label with border and text
	 */

	private JLabel createLabel(Border border, String text) {
		JLabel label = new JLabel(text, JLabel.CENTER);
		label.setBorder(border);
		return label;
	}

	/**
	 * Execute method. The GUI will start with the default Look and Feel - Metal
	 * Runs the application GUI as a thread in the event queue.
	 */
	public void execute() {
		/*
		 * Make all components be configured by the event dispatch thread. This is the
		 * thread that passes user provoked events such as mouse clicks to the GUI
		 * components which have registered listeners for the events. The following code
		 * fragment forces the statements in the run() method to be executed in the
		 * event dispatch thread. The SwingUtilities.invokeLater() actually calls
		 * EventQueue.invokeLater() method.
		 */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SwingBordersDemo frame = new SwingBordersDemo();
				// set up the Close button (X) of the frame
				// no need to use explicitly a WindowListener. The line below will generate one
				// for you.
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.pack();
				frame.setLocationByPlatform(true);
				// make the GUI visible
				frame.setVisible(true);
			}
		});
	}
}
