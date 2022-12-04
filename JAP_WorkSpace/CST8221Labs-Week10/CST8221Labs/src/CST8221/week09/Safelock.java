package CST8221.week09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Random;

/**
 * Safe lock class (critical zone)
 * @author sousap
 *
 */
public class Safelock {
	
	/**
	 * Default constructor.
	 */
	public Safelock() {
		; // No commands
	}
	
	/**
	 * Inner class Friend
	 * @author sousap
	 *
	 */
    static class Friend {
    	
    	/**
    	 * Name of the friend
    	 */
        private final String name;
        
        /**
         * Lock space.
         */
        private final Lock lock = new ReentrantLock();

        /**
         * Constructor
         * @param name Name to be included
         */
        public Friend(String name) {
            this.name = name;
        }

        /**
         * Get Name to the environment.
         * @return Name.
         */
        public String getName() {
            return this.name;
        }

        /**
         * Method to check impediment of Bow access
         * @param bower To be included.
         * @return True/False if the bow is impeded.
         */
        public boolean impendingBow(Friend bower) {
            Boolean myLock = false;
            Boolean yourLock = false;
            try {
                myLock = lock.tryLock();
                yourLock = bower.lock.tryLock();
            } finally {
                if (! (myLock && yourLock)) {
                    if (myLock) {
                        lock.unlock();
                    }
                    if (yourLock) {
                        bower.lock.unlock();
                    }
                }
            }
            return myLock && yourLock;
        }
            
        /**
         * Bow method.
         * @param bower Friend to be included.
         */
        public void bow(Friend bower) {
            if (impendingBow(bower)) {
                try {
                    System.out.format("%s: %s has"
                        + " bowed to me!%n", 
                        this.name, bower.getName());
                    bower.bowBack(this);
                } finally {
                    lock.unlock();
                    bower.lock.unlock();
                }
            } else {
                System.out.format("%s: %s started"
                    + " to bow to me, but saw that"
                    + " I was already bowing to"
                    + " him.%n",
                    this.name, bower.getName());
            }
        }

        public void bowBack(Friend bower) {
            System.out.format("%s: %s has" +
                " bowed back to me!%n",
                this.name, bower.getName());
        }
    }

    /**
     * Loop for bow.
     * @author sousap
     *
     */
    static class BowLoop implements Runnable {
    	
    	/**
    	 * Bower used.
    	 */
        private Friend bower;
        
        /**
         * Bowee used.
         */
        private Friend bowee;

        /**
         * Constructor method.
         * @param bower
         * @param bowee
         */
        public BowLoop(Friend bower, Friend bowee) {
            this.bower = bower;
            this.bowee = bowee;
        }
    
        /**
         * Run method.
         */
        public void run() {
            Random random = new Random();
            for (;;) {
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {}
                bowee.bow(bower);
            }
        }
    }
            

    /**
     * Execute method.
     */
    public void execute() {
        final Friend alphonse =
            new Friend("Alphonse");
        final Friend gaston =
            new Friend("Gaston");
        new Thread(new BowLoop(alphonse, gaston)).start();
        new Thread(new BowLoop(gaston, alphonse)).start();
    }
}
