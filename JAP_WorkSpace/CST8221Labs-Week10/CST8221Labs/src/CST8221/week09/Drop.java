package CST8221.week09;

/**
 * Drop class.
 * @author sousap
 *
 */
public class Drop {

	/**
	 * Message sent from producer to consumer
	 */
    private String message;

    /**
     * True if consumer should wait for producer to send message,
     * false if producer should wait for consumer to retrieve message.
     */
    private boolean empty = true;

    /**
     * Default constructor
     */
    public Drop() {
    	; // No commands
    }
    
    /**
     * Take a message
     * @return Message taken.
     */
    public synchronized String take() {
        // Wait until message is
        // available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = true;
        // Notify producer that
        // status has changed.
        notifyAll();
        return message;
    }

    /**
     * Put message in the pool.
     * @param message Message to be put.
     */
    public synchronized void put(String message) {
        // Wait until message has
        // been retrieved.
        while (!empty) {
            try { 
                wait();
            } catch (InterruptedException e) {}
        }
        // Toggle status.
        empty = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        notifyAll();
    }
}
