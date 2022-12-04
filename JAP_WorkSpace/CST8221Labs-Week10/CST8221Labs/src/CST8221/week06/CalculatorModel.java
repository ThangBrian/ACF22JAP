package CST8221.week06;
import java.lang.Math;

/**
 * Calculator model
 * @author sousap
 *
 */
public class CalculatorModel {

	// Holds the value of the sum of the numbers
	// entered in the view

	/**
	 * Basic property: result
	 */
	private int calculationValue;

	/**
	 * Default constructor.
	 */
	public CalculatorModel() {
		; // Empty command
	}
	
	/**
	 * Method to calculate operations.
	 * @param firstNumber First number.
	 * @param secondNumber Second number.
	 * @param op Operation to be done.
	 */
	public void calc(int firstNumber, int secondNumber, String op) {
		switch(op) {
		case "+":
			calculationValue = firstNumber + secondNumber;
			break;
		case "*":
			calculationValue = firstNumber * secondNumber;
			break;
		case "-":
			calculationValue = firstNumber - secondNumber;
			break;
		case "^":
			calculationValue = (int) Math.pow(firstNumber, secondNumber);
			break;
		case "/":
			if (secondNumber!=0)
				calculationValue = firstNumber / secondNumber;
			else
				calculationValue = 0;				
			break;
		default:
			calculationValue = 0;
			break;
		}
	}

	/**
	 * Getter for value calculated
	 * @return Value.
	 */
	public int getCalculationValue() {

		return calculationValue;

	}

}