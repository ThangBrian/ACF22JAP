package CST8221.hybrid.Week09;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * This program demonstrates that a thread that runs in parallel with the event
 * dispatch thread can cause errors in Swing components.
 * 
 * @version 1.19.2
 * @author Cay Horstmann, modified by S. Ranev
 */
public class SwingThreadTest {

	/**
	 * Default constructor.
	 */
	public SwingThreadTest() {
		; // No commands
	}
	
	/**
	 * Execute method.
	 */
	public void execute() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SwingThreadFrame frame = new SwingThreadFrame();
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setMinimumSize(new Dimension(300, 250));
				frame.setLocationByPlatform(true);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * This frame has two buttons to fill a combo box from a separate thread. The
 * "Good" button uses the event queue, the "Bad" button modifies the combo box
 * directly.
 */
class SwingThreadFrame extends JFrame {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -6592537458591587426L;

	/**
	 * Constructor
	 */
	public SwingThreadFrame() {
		setTitle("SwingThreadTest");

		final JComboBox<Integer> combo = new JComboBox<Integer>();
		combo.insertItemAt(Integer.MAX_VALUE, 0);
		combo.setPrototypeDisplayValue(combo.getItemAt(0));
		combo.setSelectedIndex(0);

		JPanel panel = new JPanel();

		JButton goodButton = new JButton("Good");
		goodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Thread(new GoodWorkerRunnable(combo)).start();
			}
		});
		panel.add(goodButton);
		JButton badButton = new JButton("Bad");
		badButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new Thread(new BadWorkerRunnable(combo)).start();
			}
		});
		panel.add(badButton);

		panel.add(combo);
		add(panel);
	}
}

/**
 * This runnable modifies a combo box by randomly adding and removing numbers.
 * This can result in errors because the combo box methods are not synchronized
 * and both the worker thread and the event dispatch thread access the combo
 * box.
 */
class BadWorkerRunnable implements Runnable {

	/**
	 * Combo for worker
	 */
	private JComboBox<Integer> combo;
	
	/**
	 * Random generator
	 */
	private Random generator;

	/**
	 * Constructor
	 * @param aCombo ComboBox to be used.
	 */
	public BadWorkerRunnable(JComboBox<Integer> aCombo) {
		combo = aCombo;
		generator = new Random();
	}

	/**
	 * Run method.
	 */
	public void run() {
		try {
			while (true) {
				int i = Math.abs(generator.nextInt());
				if (i % 2 == 0)
					combo.insertItemAt(i, 0);
				else if (combo.getItemCount() > 0)
					combo.removeItemAt(i % combo.getItemCount());
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
		}
	}
}

/**
 * This runnable modifies a combo box by randomly adding and removing numbers.
 * In order to ensure that the combo box is not corrupted, the editing
 * operations are forwarded to the event dispatch thread.
 */
class GoodWorkerRunnable implements Runnable {
	
	/**
	 * Combobox to be used
	 */
	private JComboBox<Integer> combo;
	
	/**
	 * Random generator
	 */
	private Random generator;

	/**
	 * Constructor
	 * @param aCombo ComboBox to be used.
	 */
	public GoodWorkerRunnable(JComboBox<Integer> aCombo) {
		combo = aCombo;
		generator = new Random();
	}

	/**
	 * Run method.
	 */
	public void run() {
		try {
			while (true) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						int i = Math.abs(generator.nextInt());
						if (i % 2 == 0)
							combo.insertItemAt(i, 0);
						else if (combo.getItemCount() > 0)
							combo.removeItemAt(i % combo.getItemCount());
					}
				});
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
		}
	}

}
