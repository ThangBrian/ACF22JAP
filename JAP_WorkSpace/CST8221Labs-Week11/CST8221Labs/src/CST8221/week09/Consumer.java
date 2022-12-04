package CST8221.week09;

import java.util.Random;

/**
 * Consumer class
 * @author sousap
 *
 */
public class Consumer implements Runnable {
	
	/**
	 * Drop entity.
	 */
    private Drop drop;

    /**
     * Constructor
     * @param drop Drop entity
     */
    public Consumer(Drop drop) {
        this.drop = drop;
    }

    /**
     * Run method.
     */
    public void run() {
        Random random = new Random();
        for (String message = drop.take();
             ! message.equals("DONE");
             message = drop.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
    }
}
