package CST8221;


import javax.swing.JOptionPane;

import CST8221.week11.EchoClient;
import CST8221.week11.EchoServer;
import CST8221.week11.KnockKnockClient;
import CST8221.week11.KnockKnockServer;
import CST8221.week11.ThreadClient;
import CST8221.week11.ThreadServer;
import CST8221.week11.DaytimeClient;
import CST8221.week11.DaytimeServer;
import CST8221.week11.LocalServer;
import CST8221.week11.LookForServices;

/**
 * Class for Week11.
 * @author sousap
 *
 */
public class Week11 {

	// Error message
	String errorMessage = "";

	/**
	 * Default constructor.
	 */
	public Week11() {
		; // No commands
	}
	
	/**
	 * Week 11 Labs - Networking 1
	 * 
	 * @param lab Lab number.
	 * @param usesJFX JavaFX identification.
	 * @param args Param arguments.
	 */
	public void invokeWeek11(int lab, boolean usesJFX, String[] args) {
		switch (lab) {
		case 1:
			example_w111(); // Look for ports (client)
			break;
		case 2:
			example_w112(); // Look for servers (server)
			break;
		case 3:
			example_w113(); // Date service (server)
			break;
		case 4:
			example_w114(); // Date service(client)
			break;
		case 5:
			example_w115(); // Echo protocol (server)
			break;
		case 6:
			example_w116(); // Echo protocol (client)
			break;
		case 7:
			example_w117(); // Knock protocol (server)
			break;
		case 8:
			example_w118(); // Knock protocol (client)
			break;
		case 9:
			example_w119(); // Thread server
			break;
		case 10:
			example_w120(); // Thread client
			break;
		default: // invalid lab
			errorMessage = "No valid Lab 11";
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	}

	/**
	 * Method for week 11 - example 3 - lookForServices
	 */
	public void example_w111() {
		String[] args = {"localhost"};
		LookForServices netSample = new LookForServices();
		try {
			netSample.execute(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method for week 11 - example 6 - Local servers
	 */
	public void example_w112() {
		LocalServer netSample = new LocalServer();
		netSample.execute();
	}
	
	/**
	 * Method for week 11 - example 5 - Date server
	 */
	public void example_w113() {
		DaytimeServer netSample = new DaytimeServer();
		netSample.execute();
	}
	
	/**
	 * Method for week 11 - example 4 - Date client
	 */
	public void example_w114() {
		DaytimeClient netSample = new DaytimeClient();
		netSample.execute();
	}
	

	/**
	 * Method for week 11 - example 1a - Echo protocol Server
	 */
	public void example_w115() {
		String[] args = {"1000"};
		EchoServer.main(args);
	}
	
	/**
	 * Method for week 11 - example 1b - Echo protocol Client
	 */
	public void example_w116() {
		/* TO_DO: Invoke the EchoServer before */
		///EchoServer.main(null);
		String[] args = {"localhost", "1000"};
		EchoClient.main(args);
	}

	/**
	 * Method for week 11 - example 2a - Knock protocol (Server)
	 */
	public void example_w117() {
		String[] args = {"2000"};
		KnockKnockServer.main(args);
	}
	
	/**
	 * Method for week 11 - example 2b - Knock protocol (Client)
	 */
	public void example_w118() {
		String[] args = {"localhost", "2000"};
		KnockKnockClient.main(args);
	}
	
	/**
	 * Method for week 11 - example 2a - Knock protocol (Server)
	 */
	public void example_w119() {
		String[] args = {"3000"};
		ThreadServer.main(args);
	}
	
	/**
	 * Method for week 11 - example 2b - Knock protocol (Client)
	 */
	public void example_w120() {
		String[] args = {"localhost", "3000"};
		ThreadClient.main(args);
	}
	
}
