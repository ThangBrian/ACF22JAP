package CST8221.week10;

import java.net.*;
import java.util.*;
import static java.lang.System.out;

/**
 * Net list class
 * @author sousap
 *
 */
public class ListNets {

	/**
	 * Default constructor.
	 */
	public ListNets() {
		; // No commands
	}
	
	/**
	 * Execute methods
	 * @throws SocketException Exception for files.
	 */
    public void execute() throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
    }

    /**
     * Displays information from interfaces
     * @param netint Interface id
     * @throws SocketException Socket exception.
     */
    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        out.printf("Display name: %s\n", netint.getDisplayName());
        out.printf("Name: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf("InetAddress: %s\n", inetAddress);
        }
        out.printf("\n");
     }
}  
