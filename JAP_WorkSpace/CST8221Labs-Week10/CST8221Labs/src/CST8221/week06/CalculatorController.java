package CST8221.week06;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions between the View and Model

/**
 * Class Controller for calculator
 * 
 * @author sousap
 *
 */
public class CalculatorController {

	/**
	 * View component
	 */
	private CalculatorView theView;

	/**
	 * Model component
	 */
	private CalculatorModel theModel;

	/**
	 * Constructor
	 * 
	 * @param theModel Model to be used
	 * @param theView  View to be updated
	 */
	public CalculatorController(CalculatorModel theModel, CalculatorView theView) {
		this.theModel = theModel;
		this.theView = theView;
	}

	/**
	 * Starts the application
	 */
	public void start() {
		theView.setVisible(true);
		theView.addCalculateListener(new CalculateListener());
	}

	/**
	 * Listener (inner class) to Calculator
	 * 
	 * @author sousap
	 *
	 */
	class CalculateListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			int firstNumber, secondNumber = 0;

			try {

				String op = theView.getOp();

				firstNumber = theView.getFirstNumber();
				secondNumber = theView.getSecondNumber();

				theModel.calc(firstNumber, secondNumber, op);

				theView.setCalcSolution(theModel.getCalculationValue());

			}

			catch (NumberFormatException ex) {

				// System.out.println(ex);

				theView.displayErrorMessage("You Need to Enter 2 Integers");

			}

		}

	}

}