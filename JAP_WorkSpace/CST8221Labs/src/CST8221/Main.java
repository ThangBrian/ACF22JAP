/**
 * 
 */
package CST8221;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Main class application
 * 
 * @author sousap
 *
 */
public class Main extends JFrame implements ActionListener {

	/**
	 * Global var for Week
	 */
	public static final int WEEK = 0; // 0, 6, 0

	/**
	 * Global var for Lab
	 */
	public static final int LAB = 105; // 92, 62, 91

	/**
	 * Global flag for using JavaFX
	 */
	public static final boolean USESJAVAFX = true;

	/**
	 * Global variable to isolate JFX execution for first time.
	 */
	public static boolean JFXLaunched = false;

	/**
	 * Variable for week
	 */
	int week = WEEK;

	/**
	 * Variable for lab
	 */
	int lab = LAB;

	/**
	 * Variable for checking the use of JavaFX
	 */
	boolean usesJFX = USESJAVAFX;

	/**
	 * Basic serial version
	 */
	static final long serialVersionUID = 1L;

	/**
	 * Label for weeks
	 */
	JLabel weekLabel = new JLabel("Week:");

	/**
	 * String array for weeks
	 */
	String strWeek[] = { "0", "1", "2", "3" };

	/**
	 * Combo for week
	 */
	JComboBox<String> c1 = new JComboBox<String>(strWeek);

	/**
	 * Label for lab
	 */
	JLabel labLabel = new JLabel("Lab:");

	/**
	 * String arrays to fill combo boxes
	 */
	String strLab[][] = {
		{ "11", "21", "22", "23", "24", "31", "32" },
		{ "1", "2", "3", "4", "5", "6" },
		{ "1", "2", "3", "4" },
		{ "1", "2", "3", "4", "5", "6", "7", "8" }
	};

	/**
	 * Combo to select lab
	 */
	JComboBox<String> c2 = new JComboBox<String>(strLab[0]);

	/**
	 * Execute button
	 */
	JButton execButton = new JButton("Execute");

	/**
	 * Main panel
	 */
	JPanel mainPanel = new JPanel();

	/**
	 * Model for combo to select labs
	 */
	DefaultComboBoxModel<String> boxLab = new DefaultComboBoxModel<>();

	/**
	 * Default constructor
	 */
	public Main() {
		; // Default constructor
	}

	/**
	 * Main function
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		Main mainFrame = new Main();
		int week, lab;
		boolean usesJFX = false, debug = false;
		if (args.length > 0) {
			if (debug) {
				for (int i = 0; i < args.length; i++) {
					System.out.println("Par[" + i + "]=" + args[i]);
				}
			}
			week = Integer.parseInt(args[0]);
			lab = Integer.parseInt(args[1]);
			System.out.println("Week: " + week + " - Lab: " + lab);
			mainFrame.invokeLab(week, lab, usesJFX, args);
		} else {
			mainFrame.configure();
		}
	}

	/**
	 * Configuration
	 */
	public void configure() {
		c1.setBounds(100, 100, 75, 75);
		execButton.addActionListener(this);
		mainPanel.add(weekLabel);
		mainPanel.add(c1);
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				week = getWeek();
				String strWeek[] = strLab[week];
				boxLab.removeAllElements();
				boxLab = new DefaultComboBoxModel<>(strWeek);
				c2.setModel(boxLab);
			}
		});
		mainPanel.add(labLabel);
		mainPanel.add(c2);
		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab = getLab();
			}
		});
		mainPanel.add(execButton);
		add(mainPanel);
		setTitle("LabDemos - JAP (Fall 2021)");
		lab = getLab();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Method to invoke different labs, from different weeks.
	 * 
	 * @param args    - String parameters
	 * @param week    - Week number
	 * @param lab     - lab number
	 * @param usesJFX - boolean value to use JavaFX
	 */
	public void invokeLab(int week, int lab, boolean usesJFX, String[] args) {
		switch (week) {
		case 0: // Hybrid
			System.out.println("Starting Hybrid!");
			Week00_Hybrid labhybrid = new Week00_Hybrid();
			labhybrid.invokeHybrid(lab, usesJFX, args);
			break; // week 1
		case 1: // Week 1
			System.out.println("Starting Week 01 Examples!");
			Week01 labweek01 = new Week01();
			labweek01.invokeWeek01(lab, usesJFX, args);
			break; // week 1
		case 2: // Week 2
			System.out.println("Starting Week 02 Examples!");
			Week02 labweek02 = new Week02();
			labweek02.invokeWeek02(lab, usesJFX, args);
			break;
		case 3: // Week 3
			System.out.println("Starting Week 03 Examples!");
			Week03 labweek03 = new Week03();
			labweek03.invokeWeek03(lab, usesJFX, args);
			break;
		default: // invalid week
			String errorMessage = "No valid week!";
			displayErrorMessage(errorMessage);
			System.out.println(errorMessage);
		}
	}

	/**
	 * Get Week
	 * 
	 * @return Week number
	 */
	public int getWeek() {
		int week = 0;
		String str = (String) c1.getSelectedItem();
		week = Integer.valueOf(str);
		System.out.println("=> Week:" + week);
		return week;
	}

	/**
	 * Get Lab
	 * 
	 * @return Lab number
	 */
	public int getLab() {
		int lab;
		String str = (String) c2.getSelectedItem();
		if (str == null) {
			String strWeek[] = strLab[week];
			boxLab = new DefaultComboBoxModel<>(strWeek);
			c2.setModel(boxLab);
			c2.setSelectedIndex(0);
			str = (String) c2.getSelectedItem();
		}
		lab = Integer.valueOf(str);
		System.out.println("=> Lab:" + lab);
		return lab;
	}

	/**
	 * Add Listener
	 * 
	 * @param listenLab
	 */
	void addListener(ActionListener listenLab) {
		execButton.addActionListener(listenLab);
	}

	/**
	 * Display error message
	 * 
	 * @param errorMessage
	 */
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

	/**
	 * Action Performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			week = getWeek();
			lab = getLab();
			boolean usesJFX = true;
			String[] args = {};
			invokeLab(week, lab, usesJFX, args);
		} catch (NumberFormatException ex) {
			displayErrorMessage("Enter a valid Week and a valid the Lab!");
		}
	}

}
