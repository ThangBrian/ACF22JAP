package CST8221.hybrid.Week02;

/* CST8221-JAP: HA 02, Example 2
   File name: GlassPaneDemo.java
*/

/*
 * Copyright (c) 1995 - 2008 Sun Microsystems, Inc.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Sun Microsystems nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/* Modified by S.Ranev, D. Cormier */

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

/**
 * An application that requires no other files. It contains three classes:
 * GlassPaneDemo, MyGlassPane and CBListener
 */
public class GlassPaneDemo {
	
	/**
	 * Default constructor
	 */
	public GlassPaneDemo() {
		; // Empty constructor
	}
	
	/* static is used to avoid creating an GlassPaneDemo object in main() */

	/**
	 * Glass pane
	 */
	private static MyGlassPane myGlassPane;

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event-dispatching thread.
	 */
	/* static is used to avoid creating an GlassPaneDemo object in main() */
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("GlassPaneDemo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Start creating and adding components.
		JCheckBox changeButton = new JCheckBox("Glass pane \"visible\"");
		changeButton.setSelected(false);

		// Set up the content pane, where the "main GUI" lives.
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.add(changeButton);
		contentPane.add(new JButton("Button 1"));
		contentPane.add(new JButton("Button 2"));

		// Set up the menu bar, which appears above the content pane.
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menu.add(new JMenuItem("Do nothing"));
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		// Set up the glass pane, which appears over both menu bar
		// and content pane and is an item listener on the change
		// button.
		myGlassPane = new MyGlassPane(changeButton, menuBar, frame.getContentPane());
		changeButton.addItemListener(myGlassPane);
		frame.setGlassPane(myGlassPane);

		// Show the window.
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Execution method
	 */
	public void execute() {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

/**
 * We have to provide our own glass pane so that it can be painted.
 */
class MyGlassPane extends JComponent implements ItemListener {
	/* Swing components are serializable and require serialVersionUID */
	private static final long serialVersionUID = -3362339339954116572L;
	Point point;

	// React to change button clicks.
	@Override
	public void itemStateChanged(ItemEvent e) {
		setVisible(e.getStateChange() == ItemEvent.SELECTED);
	}

	@Override
	// this method is always caled when the GUI has to be repainted.
	protected void paintComponent(Graphics g) {
		if (point != null) {
			g.setColor(Color.red);
			g.fillOval(point.x - 10, point.y - 10, 20, 20);
		}
	}

	public void setPoint(Point p) {
		point = p;
	}

	public MyGlassPane(AbstractButton aButton, JMenuBar menuBar, Container contentPane) {
		CBListener listener = new CBListener(aButton, menuBar, this, contentPane);
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
}

/**
 * Listen for all events that our check box is likely to be interested in.
 * Re-dispatch them to the check box.
 */
class CBListener extends MouseInputAdapter {
	private final Component liveButton;
	private final JMenuBar menuBar;
	private final MyGlassPane glassPane;
	private final Container contentPane;

	public CBListener(Component liveButton, JMenuBar menuBar, MyGlassPane glassPane, Container contentPane) {
		this.liveButton = liveButton;
		this.menuBar = menuBar;
		this.glassPane = glassPane;
		this.contentPane = contentPane;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		redispatchMouseEvent(e, false);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		redispatchMouseEvent(e, true);
	}

	// A basic implementation of redispatching events.
	@SuppressWarnings("deprecation")
	private void redispatchMouseEvent(MouseEvent e, boolean repaint) {
		Point glassPanePoint = e.getPoint();
		Container container = contentPane;
		Point containerPoint = SwingUtilities.convertPoint(glassPane, glassPanePoint, contentPane);
		if (containerPoint.y < 0) { // we're not in the content pane
			if (containerPoint.y + menuBar.getHeight() >= 0) {
				// The mouse event is over the menu bar.
				// Could handle specially.
			} else {
				// The mouse event is over non-system window
				// decorations, such as the ones provided by
				// the Java look and feel.
				// Could handle specially.
			}
		} else {
			// The mouse event is probably over the content pane.
			// Find out exactly which component it's over.
			Component component = SwingUtilities.getDeepestComponentAt(container, containerPoint.x, containerPoint.y);

			if ((component != null) && (component.equals(liveButton))) {
				// Forward events over the check box.
				Point componentPoint = SwingUtilities.convertPoint(glassPane, glassPanePoint, component);
				component.dispatchEvent(new MouseEvent(component, e.getID(), e.getWhen(), e.getModifiers(),
						componentPoint.x, componentPoint.y, e.getClickCount(), e.isPopupTrigger()));
			}
		}

		// Update the glass pane if requested.
		if (repaint) {
			glassPane.setPoint(glassPanePoint);
			glassPane.repaint();
		}
	}
}
