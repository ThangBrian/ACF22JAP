package CST8221.week10;

import java.net.*;
import java.util.*;
import static java.lang.System.out;

/**
 * List of Network intefaces.
 * @author sousap
 *
 */
public class ListNIFs {
	
	/**
	 * Default constructor.
	 */
	public ListNIFs() {
		; // No commands
	}
	
	/**
	 * Execute method
	 * @throws SocketException Socket exception.
	 */
    public void execute() throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        
        for (NetworkInterface netIf : Collections.list(nets)) {
            out.printf("Display name: %s\n", netIf.getDisplayName());
            out.printf("Name: %s\n", netIf.getName());
            displaySubInterfaces(netIf);
            out.printf("\n");
        }
    }

    /**
     * Display sub interfaces.
     * @param netIf Interface id.
     * @throws SocketException Socket exception.
     */
    static void displaySubInterfaces(NetworkInterface netIf) throws SocketException {
        Enumeration<NetworkInterface> subIfs = netIf.getSubInterfaces();
        
        for (NetworkInterface subIf : Collections.list(subIfs)) {
            out.printf("\tSub Interface Display name: %s\n", subIf.getDisplayName());
            out.printf("\tSub Interface Name: %s\n", subIf.getName());
        }
     }
}  
