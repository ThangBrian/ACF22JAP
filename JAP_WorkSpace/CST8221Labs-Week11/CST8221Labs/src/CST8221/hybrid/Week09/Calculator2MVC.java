package CST8221.hybrid.Week09;

/**
 * MVC Class
 * @author sousap
 *
 */
public class Calculator2MVC {
    
	/**
	 * Default contructor.
	 */
	public Calculator2MVC() {
		; // No statement
	}
	
	/**
	 * Execute method.
	 */
    public void execute() {
    	
    	Calculator2Model theModel = new Calculator2Model();
    	Calculator2View theView = new Calculator2View();
        Calculator2Controller theController = new Calculator2Controller
        		(theModel, theView);
        theController.start();
        
    }
}