package CST8221.week10;

import java.net.*;

/**
 * Parse URL Class
 * @author sousap
 *
 */
public class ParseURL {
	
	/**
	 * Default constructor.
	 */
	public ParseURL() {
		; // No commands
	}
	
	/**
	 * Execute method.
	 * @throws Exception Exception class.
	 */
    public void execute() throws Exception {

        URL aURL = new URL("http://example.com/docs/books/tutorial"
                           + "/index.html?name=networking#DOWNLOADING");

        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
        System.out.println("filename = " + aURL.getFile());
        System.out.println("ref = " + aURL.getRef());
    }
}