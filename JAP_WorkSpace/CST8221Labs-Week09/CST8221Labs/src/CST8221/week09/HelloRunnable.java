package CST8221.week09;

/**
 * HelloRunnable that implements run.
 * @author sousap
 *
 */
public class HelloRunnable implements Runnable {

	/**
	 * Default constructor.
	 */
	public HelloRunnable() {
		; // No commands
	}
	
	/**
	 * Run method.
	 */
    public void run() {
        System.out.println("Hello from a thread!");
    }

    /**
     * Execute method
     */
    public void execute() {
        (new Thread(new HelloRunnable())).start();
    }

}
