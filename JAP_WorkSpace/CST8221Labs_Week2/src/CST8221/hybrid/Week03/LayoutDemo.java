package CST8221.hybrid.Week03;

/* File name: LayoutDemo.java
To run this example in Eclipse or Netbeans first copy the image files into
the source (src) folder of the project folder.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Java Layout Manager Demo
 * 
 * @author Daniel Cormier
 * @version 1.1
 * @since Java 8
 */
public class LayoutDemo extends JFrame {
	// default serial version ID - Swing components implement the Serializable
	// interface
	private static final long serialVersionUID = 1L;

	// private JButton button;
	
	/**
	 * Application Panels.
	 */
	private JPanel mainGrid, display, pane, demoGrid;
	
	/**
	 * Label application
	 */
	private JLabel label;

	/**
	 * Controller to be used
	 */
	private Controller buttonHandler;

	/**
	 * List of buttons
	 */
	private JButton[] myButtons = new JButton[10];
	
	/**
	 * Frame title.
	 */
	private final static String FRAME_TITLE = "Basic Layout Manager Demo";
	
	/**
	 * Image to be used
	 */
	private final String FRAME_ICON = "black.png";
	
	/**
	 * Labels for buttons
	 */
	private final String[] BUTTON_NAMES = new String[] { "\u03b1", "\u03b2", "\u03b3", "\u03b4", "\u03b5", "\u03b6",
			"\u03b7", "\u03b8", "\u03b9", "\u03ba" };
	
	/**
	 * Action names for commands
	 */
	private final String[] BUTTON_ACTION = new String[] { "alpha", "beta", "gamma", "delta", "epsilon", "zeta", "eta",
			"theta", "iota", "kappa" };

	/**
	 * Default constructor. Sets the frame properties and initializes the GUI.
	 */
	public LayoutDemo() {
		// set frame title calling the super constructor
		super(FRAME_TITLE);
		setFrameProperties();
		setAndLaunch();
	}

	/**
	 * Sets the GUI and makes it visible. This method is called from within the
	 * constructor to initialize the GUI.
	 */
	private void setAndLaunch() {

		// initial setup

		buttonHandler = new Controller();
		label = new JLabel(" ");
		// label.setFont(new Font(Font.SERIF,Font.ITALIC | Font.BOLD,60));
		label.setFont(label.getFont().deriveFont(60f));
		// or you can derive the font

		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(false);
		label.setBackground(Color.GREEN);
		label.setForeground(Color.RED);

		mainGrid = new JPanel();
		display = new JPanel();
		pane = new JPanel();
		demoGrid = new JPanel();

		pane.setBackground(Color.YELLOW);
		pane.setOpaque(true);
		demoGrid.setLayout(new BorderLayout());

		display.setLayout(new BorderLayout());
		pane.setLayout(new BorderLayout());
		display.setBackground(Color.WHITE);

		mainGrid.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		display.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.BLACK));

		// Button creation and loading into an array.
		for (int i = 0; i < BUTTON_NAMES.length; i++) {
			myButtons[i] = createButton(BUTTON_NAMES[i], BUTTON_ACTION[i], buttonHandler);
		}
		// myButtons[3].setPreferredSize(new Dimension(100,50));

		// Load buttons into display.

		for (int i = 0; i < BUTTON_NAMES.length; i++) {
			mainGrid.add(myButtons[i]);
		}

		// JButton button1=createButton("A","letter A",buttonHandler);
		// JButton button2=createButton("B","letter B",buttonHandler);
		// JButton button3=createButton("T", "top button",buttonHandler);
		// JButton button4=createButton("B", "bottom button", buttonHandler);
		// JPanel left = new JPanel();
		// JPanel right = new JPanel();
		// JPanel bottom = new JPanel();

		// left.setLayout(new GridLayout(1,1));
		// right.setLayout(new BorderLayout());
		// left.add(button1);
		// right.add(button2);

		// bottom.add(button3,BorderLayout.NORTH);
		// bottom.add(button4,BorderLayout.SOUTH);
		//
		mainGrid.setBorder(BorderFactory.createMatteBorder(2, 0, 5, 2, Color.BLUE));

		mainGrid.setLayout(new GridLayout(2, 4, 30, 30));
		// mainGrid.setLayout(new GridLayout(2,5,30,30));
		// mainGrid.setLayout(new GridLayout(2,5));
		// JPanel gridAndBottom = new JPanel();
		// gridAndBottom.setLayout(new BorderLayout());
		// gridAndBottom.add(mainGrid,BorderLayout.CENTER);
		// gridAndBottom.add(button3,BorderLayout.NORTH);
		// gridAndBottom.add(button4,BorderLayout.SOUTH);
		// gridAndBottom.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3,
		// Color.BLUE));
		// gridAndBottom.add(bottom,BorderLayout.SOUTH);

		// Adding the remainder of the components.
		display.add(label);

		pane.add(display, BorderLayout.NORTH);
		pane.add(mainGrid, BorderLayout.CENTER);
		// pane.add(left,BorderLayout.WEST);
		// pane.add(right,BorderLayout.EAST);
		// pane.add(gridAndBottom,BorderLayout.CENTER);
		// pane.add(bottom,BorderLayout.SOUTH);

		// Install JPanel as a content pane
		Container contentPane = getContentPane();
		contentPane.add(pane);

		// Handle close button:
		WindowListener wl = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				LayoutDemo.this.dispose();
				/// System.exit(0);
			}
		};
		// add the event handler wl to the frame
		addWindowListener(wl);
		// The frame is ready. Compress unneeded space and make it visible.
		pack();
		setVisible(true);

	}

	// A method to create buttons.
	// Requires display name "dn",
	// Action Command "ac", and
	// action handler
	/**
	 * Method to create buttons.
	 * @param dn String 
	 * @param ac String action
	 * @param hn Action handler
	 * @return Returns button.
	 */
	private JButton createButton(String dn, String ac, Controller hn) {
		JButton newButton;
		newButton = new JButton();
		newButton.setText(dn);
		newButton.setFont(new Font(newButton.getFont().getName(), newButton.getFont().getStyle(), 75));
		newButton.setActionCommand(ac);
		newButton.addActionListener(hn);
		return newButton;
	}

	/**
	 * This method is called from within the constructor to Set the frame
	 * properties.
	 */
	private final void setFrameProperties() {
		// get the current screen size
		Toolkit tkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = tkit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;

		// set frame size - width and height
		setSize(screenWidth / 2, screenHeight / 5);

		// and let platform pick screen location
		// setLocationByPlatform(true);//ByPlatform
		// Display the frame in the center of the screen
		setLocation(screenWidth / 4, screenHeight / 4);

		// Since Java 1.7 displying the frame in the center of the screen can be
		// achieved with a single call. Try it.
		// setLocationRelativeTo(null);

		// set frame icon
		try {
			Image img = tkit.getImage(getClass().getResource(FRAME_ICON));
			setIconImage(img);
		} catch (Exception e) {
			; // No treatment
		}
	}

	/**
	 * The main method.The GUI will have the default Look and Feel - Metal Look and
	 * Feel
	 */
	public static void execute() {
		new LayoutDemo();
	}

	/*
	 * Previously "banana", this private inner class serves as the controller in an
	 * MVC model. Currently only a stub. It sets the top display panel based on the
	 * "action command" value on any triggering button.
	 */

	/**
	 * Inner class. Controller to be used.
	 * @author sousap
	 *
	 */
	private class Controller implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText(e.getActionCommand());
		}
	}
}
