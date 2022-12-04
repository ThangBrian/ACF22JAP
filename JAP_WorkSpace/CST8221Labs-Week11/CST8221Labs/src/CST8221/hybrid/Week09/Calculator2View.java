package CST8221.hybrid.Week09;

//This is the View
//Its only job is to display what the user sees
//It performs no calculations, but instead passes
//information entered by the user to whomever needs
//it. 

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

/**
 * View calculator (using Frame)
 * @author sousap
 *
 */
public class Calculator2View extends JFrame {

	/**
	 * Local attribute - version ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * First number to be used in the calculus
	 */
	private JTextField firstNumber = new JTextField(10);

	/**
	 * Operation to be used
	 */
	private JLabel additionLabel = new JLabel("+");

	/**
	 * Second number to be used in the calculus
	 */
	private JTextField secondNumber = new JTextField(10);

	/**
	 * Calculation button
	 */
	public JButton calculateButton = new JButton("Calculate");

	/**
	 * Field to show the solution
	 */
	private JTextField calcSolution = new JTextField(10);
	
	/**
	 * Private Label for timer
	 */
	private JLabel timerLabel = new JLabel("Timer:");
	
	/**
	 * Timer text field
	 */
	public JTextField timerText = new JTextField(5);
	
	/**
	 * Button clear
	 */
	private JButton clearButton = new JButton("Clear");
	
	/**
	 * Clear button
	 * @return Button to clear
	 */
	public JButton getClear() {
		return clearButton;
	}
	
	/**
	 * Clear method
	 */
	public void clear() {
		firstNumber.setText("0");
		secondNumber.setText("0");
		calcSolution.setText("0");
	}
	
	/**
	 * Reset the timer
	 * @param seconds Number of seconds to reset.
	 */
	public void resetTimer(int seconds) {
		timerText.setText(Integer.toString(seconds));
	}

	/**
	 * Constructor
	 */
	public Calculator2View() {

		// Initializes
		clear();
		
		// Sets up the view and adds the components

		JPanel calcPanel = new JPanel();
		JPanel timerPanel = new JPanel();
		timerText.setEditable(false);
		timerPanel.setBackground(Color.YELLOW);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 200);
		calcPanel.add(firstNumber);
		calcPanel.add(additionLabel);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		this.add(calcPanel, BorderLayout.NORTH);
		
		timerPanel.add(timerLabel);
		timerPanel.add(timerText);		
		timerPanel.add(clearButton);		
		this.add(timerPanel, BorderLayout.SOUTH);
		
		this.setTitle("MVC Demo: Calculator");

		// End of setting up the components --------

	}

	/**
	 * Get the first number
	 * @return First number in the calc
	 */
	public int getFirstNumber() {

		return Integer.parseInt(firstNumber.getText());

	}

	/**
	 * Get the second number
	 * @return Second number in the calc
	 */
	public int getSecondNumber() {

		return Integer.parseInt(secondNumber.getText());

	}

	/**
	 * Get the solution
	 * @return Solution of the calculus
	 */
	public int getCalcSolution() {

		return Integer.parseInt(calcSolution.getText());

	}

	/**
	 * Set solution
	 * @param solution Solution to be shown
	 */
	public void setCalcSolution(int solution) {

		calcSolution.setText(Integer.toString(solution));

	}

	// If the calculateButton is clicked execute a method
	// in the Controller named actionPerformed

	/**
	 * Add the listener to calc
	 * @param Action listener to be set in the calculator
	 */
	void addCalculateListener(ActionListener listenForCalculator) {

		calculateButton.addActionListener(listenForCalculator);
		clearButton.addActionListener(listenForCalculator);

	}

	/**
	 * Open a popup that contains the error message passed
	 * @param Error message
	 */

	void displayErrorMessage(String errorMessage) {

		JOptionPane.showMessageDialog(this, errorMessage);

	}

}
