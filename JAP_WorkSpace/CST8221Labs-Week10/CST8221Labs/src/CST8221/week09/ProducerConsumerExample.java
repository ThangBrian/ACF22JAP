package CST8221.week09;

/**
 * ProducerConsumerExample class.
 * @author sousap
 *
 */
public class ProducerConsumerExample {
	
	/**
	 * Default constructor.
	 */
	public ProducerConsumerExample() {
		; // No commands
	}
	
	/**
	 * Execute method.
	 */
    public void execute() {
        Drop drop = new Drop();
        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}
