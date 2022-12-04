package CST8221.week09;

import java.util.Random;

/**
 * Producer class
 * @author sousap
 *
 */
public class Producer implements Runnable {
    
	/**
	 * Private drop (content).
	 */
	private Drop drop;

	/**
	 * Constructor.
	 * @param drop Drop element.
	 */
    public Producer(Drop drop) {
        this.drop = drop;
    }

    /**
     * Run method.
     */
    public void run() {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            drop.put(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {}
        }
        drop.put("DONE");
    }
}
