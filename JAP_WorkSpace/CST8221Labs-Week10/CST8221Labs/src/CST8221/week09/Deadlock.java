package CST8221.week09;

/**
 * Deadlock class
 * @author sousap
 *
 */
public class Deadlock {
	
	/**
	 * Default constructor.
	 */
	public Deadlock() {
		; // No commands
	}
	
	/**
	 * Friend class.
	 * @author sousap
	 *
	 */
    static class Friend {
    	
    	/**
    	 * String name.
    	 */
        private final String name;

        /**
         * Constructor
         * @param name Name to be used.
         */
        public Friend(String name) {
            this.name = name;
        }
        
        /**
         * Getter: name
         * @return
         */
        public String getName() {
            return this.name;
        }
        
        /**
         * Bow method.
         * @param bower Bower to be used.
         */
        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                + "  has bowed to me!%n", 
                this.name, bower.getName());
            bower.bowBack(this);
        }
        
        /**
         * Bowback method
         * @param bower Friend class used.
         */
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                + " has bowed back to me!%n",
                this.name, bower.getName());
        }
    }

    /**
     * Execute method
     */
    public void execute() {
        final Friend alphonse =
            new Friend("Alphonse");
        final Friend gaston =
            new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}
