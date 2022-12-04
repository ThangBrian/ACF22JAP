package CST8221.hybrid.Week09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

// The Controller coordinates interactions
// between the View and Model

/**
 * Class Calculator2 using Controller
 * @author sousap
 *
 */
public class Calculator2Controller {

	/**
	 * View entity (MVC)
	 */
	private Calculator2View theView;

	/**
	 * Model entity (MVC)
	 */
	private Calculator2Model theModel;

	/**
	 * Time initialization
	 */
	private int seconds = 0;

	/**
	 * Timer
	 */
	Timer timer = new Timer();

	/**
	 * Timer Task
	 */
	TimerTask timerTask;

	/**
	 * Constructor
	 * @param theModel Model to be used
	 * @param theView View to be used
	 */
	public Calculator2Controller(Calculator2Model theModel, Calculator2View theView) {
		this.theModel = theModel;
		this.theView = theView;
	}

	
	/**
	 * Starts the game Timer (showed as Appendix)
	 */
	public void startTimer() {
		seconds = 0;
		// Timer task
		timerTask = new TimerTask() {
			public void run() {
				seconds++;
				try {
					theView.resetTimer(seconds);
				} catch (Exception e) {
					///System.err.println(e); // Eventual errors when initializing text					
				}
			}
		};

		// Timer schedule
		try {
			timer.scheduleAtFixedRate(timerTask, 0, 1000);			
		} catch(Exception e) {
			///System.err.println(e); // Eventual errors when game finished
		}

	}
	
	/**
	 * Start method
	 */
	public void start() {
		// Tell the View that when ever the calculate button
		// is clicked to execute the actionPerformed method
		// in the CalculateListener inner class
		theView.setResizable(false);
		theView.setVisible(true);
		theView.addCalculateListener(new CalculateListener());
		startTimer();
	}

	/**
	 * Listener for the class
	 * @author sousap
	 *
	 */
	class CalculateListener implements ActionListener {

		/**
		 * Action performed (event)
		 */
		public void actionPerformed(ActionEvent e) {

			Object eventSource = e.getSource();
			if (eventSource == theView.calculateButton) {
				int firstNumber, secondNumber = 0;
				try {
					firstNumber = theView.getFirstNumber();
					secondNumber = theView.getSecondNumber();
					theModel.addTwoNumbers(firstNumber, secondNumber);
					theView.setCalcSolution(theModel.getCalculationValue());
				}
				catch (NumberFormatException ex) {
					theView.displayErrorMessage("You Need to Enter 2 Integers");
				}
			} // CalculateButton
			else if (eventSource == theView.getClear()){
				theView.clear();
				seconds = -1;
			}

		}

	}

}