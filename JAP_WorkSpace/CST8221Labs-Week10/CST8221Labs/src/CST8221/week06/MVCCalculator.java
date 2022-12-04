package CST8221.week06;
/**
 * Calculator MVC
 * @author sousap
 *
 */
public class MVCCalculator {
    
	/**
	 * Default (empty) constructor.
	 */
	public MVCCalculator() {
		; // No commands
	}
	
	/**
	 * Main method.
	 * @param args Command line.
	 */
    public static void main(String args[]) {
    	
    	CalculatorModel theModel = new CalculatorModel();
    	CalculatorView theView = new CalculatorView();
        CalculatorController theController = new CalculatorController
        		(theModel, theView);
        theController.start();
        
    }
}