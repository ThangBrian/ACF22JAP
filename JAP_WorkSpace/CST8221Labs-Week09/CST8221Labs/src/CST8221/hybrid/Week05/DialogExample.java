package CST8221.hybrid.Week05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Dialog example.
 * @author sousap
 *
 */
public class DialogExample {
	
	/**
	 * Dialog.
	 */
	private static JDialog d;

	/**
	 * Default constructor
	 */
	DialogExample() {
		JFrame f = new JFrame();
		d = new JDialog(f, "Dialog Example", true);
		d.setLayout(new FlowLayout());
		JButton b = new JButton("OK");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogExample.d.setVisible(false);
			}
		});
		d.add(new JLabel("Click button to continue."));
		d.add(b);
		d.setSize(300, 300);
		d.setVisible(true);
	}

	/**
	 * Execute method
	 */
	public static void execute() {
		new DialogExample();
	}
}