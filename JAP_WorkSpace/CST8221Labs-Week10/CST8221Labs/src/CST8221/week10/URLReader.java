package CST8221.week10;

import java.net.*;
import java.io.*;

/**
 * URLReader class
 * @author sousap
 *
 */
public class URLReader {

	/**
	 * Default URL link.
	 */
	String URLLINK = "http://www.google.com/";
	
	/**
	 * Default constructor.
	 */
	public URLReader() {
		; // No commands
	}
	
	/**
	 * Execute method.
	 * @throws Exception Connection exception.
	 */
	public void execute() throws Exception {

        URL url = new URL(URLLINK);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
