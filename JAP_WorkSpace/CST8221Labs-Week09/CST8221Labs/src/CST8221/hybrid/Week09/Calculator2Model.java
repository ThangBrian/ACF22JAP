package CST8221.hybrid.Week09;

/**
 * Model to Calculator
 * @author sousap
 *
 */
public class Calculator2Model {

	// Holds the value of the sum of the numbers
	// entered in the view

	/**
	 * Calculation value
	 */
	private int calculationValue;

	/**
	 * Default constructor.
	 */
	public Calculator2Model() {
		; // No commands
	}
	
	/**
	 * Add numbers
	 * @param firstNumber First number to be used.
	 * @param secondNumber Second number to be used.
	 */
	public void addTwoNumbers(int firstNumber, int secondNumber) {

		calculationValue = firstNumber + secondNumber;

	}

	/**
	 * Get value calculated
	 * @return Value to be calculated.
	 */
	public int getCalculationValue() {

		return calculationValue;

	}

}
