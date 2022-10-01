package CST8221.week01;

/* CST8221-JAP: LAB 01, Example 2
File name: SimpleSwingGUIe2.java
To run this example:
a)In Eclipse, first copy the image files into
the workspace source (src) project folder and the workspace project folder.
b) In NetBeans first copy the image files into
the source (src) folder of the project folder and the project folder as well.
Also, if you want to run the jar file, you must copy the images into
the (dist) folder of the project folder.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Simple Java GUI Example. This example is a modification of Example 1.
 * Anonymous inner class is used to handle the window closing event. An image is
 * used to change the standard application frame icon, and an image is added to
 * the button. Also, it shows how to display the frame in a specific location on
 * the screen.
 * 
 * @author Svillen Ranev, Daniel Cormier
 * @version 1.19.1
 * @since Java 2
 */

public class SimpleSwingGUIe2 extends JFrame implements ActionListener {
	// default serial version ID - Swing components implement the Serializable
	// interface

	/**
	 * Default version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Basic test button
	 */
	private JButton button;

	/**
	 * Basic pane
	 */
	private JPanel pane;

	/**
	 * Basic label
	 */
	private JLabel label;

	/**
	 * Basic image to be included
	 */
	private ImageIcon buttonImage;

	/**
	 * Local variable for counting
	 */
	private int clickCounter;

	/**
	 * String for title
	 */
	private final static String FRAME_TITLE = "Simple Swing GUI - E2";

	/**
	 * String for label
	 */
	private final String LABEL_TEXT = "Number of happy button clicks: ";

	/**
	 * Icon name
	 */
	private final String FRAME_ICON = "duke.gif";

	/**
	 * Default constructor. Sets the frame properties and initializes the GUI.
	 */
	public SimpleSwingGUIe2() {
		// set frame title calling the supper constructor
		super(FRAME_TITLE);
		setFrameProperties();
		setAndLaunch();
	}

	/**
	 * Sets the GUI and makes it visible. This method is called from within the
	 * constructor to initialize the GUI.
	 */

	private void setAndLaunch() {
		// Create and set up containers and components.
		// Create a button with an image and text
		buttonImage = new ImageIcon("happy.gif");
		button = new JButton("A Happy New Semester JButton", buttonImage);

		// Create a keyboard shortcut: Pressing ALT-B will act as a mouse click on the
		// button
		// button.setMnemonic('b');
		button.setMnemonic(KeyEvent.VK_B);

		// Create a Tool Tip. Will show up when the mouse hovers over the button
		button.setToolTipText("Please Click Me");
		// Set the frame to be the event handler for the button click
		button.addActionListener(this);
		label = new JLabel(LABEL_TEXT + "0");
		pane = new JPanel();

		// set a border around the JPanel
		pane.setBorder(BorderFactory.createEmptyBorder(25, 25, 10, 25));

		// change the default Layout Manager
		// use GridLayout with 2 rows and 1 column
		pane.setLayout(new GridLayout(2, 1));

		// Add components to JPanel container.
		pane.add(button);
		pane.add(label);

		// Install JPanel as a content pane
		Container contentPane = getContentPane();
		contentPane.add(pane);

		// Handle the UI events.
		// Create a handler class for the frame closing event
		// Set up the Close button (X) of the frame.
		// Since a Java class can extend one class only, an anonymous inner class
		// which inherits from WindowAdapter and overrides the WindowClosing()
		// method, is used to handle the frame closing event

		WindowListener wl = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// Releases all of the native screen resources used by this frame (Window)
				// Check if all user documents have been saved
				SimpleSwingGUIe2.this.dispose();
				// terminate the application and the Java VM
				/// System.exit(0);
			}
		};
		// add the event handler wl to the frame
		this.addWindowListener(wl);

		// Do not pack() the frame - the frame title will not be displayed completely
		// pack();
		// The frame is ready. Make it visible on the screen.
		setVisible(true);
	}

// Handle the button clicks. 
// Override and Implement the actionPerformed() method of the Action Listener interface
	@Override
	public void actionPerformed(ActionEvent e) {
		// Check which button was clicked and process the event
		Object eventSource = e.getSource();
		if (eventSource == button) {
			clickCounter++;
			label.setText(LABEL_TEXT + clickCounter);
		} else {
			/* check for another component */}
	}

	/**
	 * This method is called from within the constructor to set the frame
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

		// and let platform pick screen location - uncomment to try.
		// setLocationByPlatform(true);

		// Display the frame in the center of the screen
		setLocation(screenWidth / 4, screenHeight / 4);

		// Since Java 1.7 displying the frame in the center of the screen can be
		// achieved with a single call. Try it.
		// setLocationRelativeTo(null);

		// set frame icon
		Image img = tkit.getImage(FRAME_ICON);
		setIconImage(img);
	}

}
