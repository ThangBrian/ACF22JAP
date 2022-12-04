package CST8221.week06;


import java.awt.Color;

//This is the View
//Its only job is to display what the user sees
//It performs no calculations, but instead passes
//information entered by the user to whomever needs
//it. 

import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * View class for calculator
 * @author sousap
 *
 */
public class CalculatorView extends JFrame {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * First number for calculus
	 */
	private JTextField firstNumber = new JTextField(10);
	
	/**
	 * String List of operations
	 */
	private String[] ops = { "+", "-", "*", "/", "^" };
	
	/**
	 * Visual list for operations
	 */
	JComboBox<String> opList = new JComboBox<String>(ops);
	
	/**
	 * Second number for calculus
	 */
	private JTextField secondNumber = new JTextField(10);
	
	/**
	 * Button to perform the calculus
	 */
	private JButton calculateButton = new JButton("Calculate");
	
	/**
	 * Field for Solution 
	 */
	private JTextField calcSolution = new JTextField(10);

	/**
	 * Default constructor.
	 */
	CalculatorView() {

		// Sets up the view and adds the components

		JPanel calcPanel = new JPanel();

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600, 200);
		calcPanel.add(firstNumber);
		///calcPanel.add(additionLabel);
		calcPanel.add(opList);
		opList.setSelectedIndex(0);
		calcPanel.add(secondNumber);
		calcPanel.add(calculateButton);
		calcPanel.add(calcSolution);
		calcSolution.setEnabled(false);
		this.add(calcPanel);
		this.setTitle("MVC Demo: Calculator");

		// End of setting up the components --------

	}

	/**
	 * Getter for 1st num
	 * @return First number
	 */
	public int getFirstNumber() {

		return Integer.parseInt(firstNumber.getText());

	}

	/**
	 * Getter for 2nd num
	 * @return Second number
	 */
	public int getSecondNumber() {

		return Integer.parseInt(secondNumber.getText());

	}

	/**
	 * Getter for returning the solution
	 * @return Solution
	 */
	public int getCalcSolution() {

		return Integer.parseInt(calcSolution.getText());

	}

	/**
	 * Updates the solution in the interface
	 * @param solution Solution.
	 */
	public void setCalcSolution(int solution) {
		calcSolution.setBackground(Color.yellow);
		calcSolution.setText(Integer.toString(solution));

	}

	/**
	 * Getter for operation
	 * @return Operation to be done.
	 */
	public String getOp() {
		return (String) opList.getSelectedItem();
	}
	

	/**
	 * Updates the listener for Calculator
	 * @param listenForCalcButton
	 */
	void addCalculateListener(ActionListener listenForCalcButton) {

		calculateButton.addActionListener(listenForCalcButton);

	}


	/**
	 * Pop up message for errors
	 * @param errorMessage Message to be printed
	 */
	void displayErrorMessage(String errorMessage) {

		JOptionPane.showMessageDialog(this, errorMessage);

	}

}