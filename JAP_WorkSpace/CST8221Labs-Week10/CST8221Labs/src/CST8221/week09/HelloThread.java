package CST8221.week09;

/**
 * HelloThread class.
 * @author sousap
 *
 */
public class HelloThread extends Thread {

	/**
	 * Default construtor.
	 */
	public HelloThread() {
		; // No commands
	}
	
	/**
	 * Run method.
	 */
    public void run() {
        System.out.println("Hello from a thread!");
    }

    /**
     * Main method.
     * @param args Arguments.
     */
    public static void main(String args[]) {
        (new HelloThread()).start();
    }

}