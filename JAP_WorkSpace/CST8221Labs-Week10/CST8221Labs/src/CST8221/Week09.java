package CST8221;

import javax.swing.JOptionPane;

import CST8221.week09.Deadlock;
import CST8221.week09.HelloRunnable;
import CST8221.week09.ProducerConsumerExample;
import CST8221.week09.Safelock;
import CST8221.week09.SimpleThreads;

/**
 * Class Week09
 * @author sousap
 *
 */
public class Week09 {

	// Error message
	String errorMessage = "";

	/**
	 * Default constructor.
	 */
	public Week09() {
		; // No commands
	}
	
	/**
	 * Week 09 Labs - Threads
	 * 
	 * @param lab Lab to be used
	 * @param usesJFX Boolean use for JavaFX 
	 * @param args Param arguments.
	 */
	public void invokeWeek09(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w91(); // Threads 1
			break;
		case 2:
			example_w92(); // Threads 2
			break;
		case 3:
			example_w93(); // Deadlock
			break;
		case 4:
			example_w94(); // Producer / Consumer
			break;
		case 5:
			example_w95(); // Lock
			break;
		default: // invalid lab
			errorMessage = "No valid Lab 8";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}

	
	// WEEK 09 ..........................................

	/**
	 * Method for week 9 - example 1 - Threads
	 */
	public void example_w91() {
		HelloRunnable threadDemo = new HelloRunnable();
		threadDemo.execute();
	}

	/**
	 * Method for week 9 - example 2 - Threads
	 */
	public void example_w92() {
		String[] msg = { "100" };
		try {
			SimpleThreads.execute(msg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method for week 9 - example 3 - Deadlock
	 */
	public void example_w93() {
		Deadlock threadDemo = new Deadlock();
		threadDemo.execute();
	}

	/**
	 * Method for week 9 - example 4 - Producer/Consumer
	 */
	public void example_w94() {
		ProducerConsumerExample threadDemo = new ProducerConsumerExample();
		threadDemo.execute();
	}

	/**
	 * Method for week 9 - example 5 - Lock
	 */
	public void example_w95() {
		Safelock threadDemo = new Safelock();
		threadDemo.execute();
	}
	
}
