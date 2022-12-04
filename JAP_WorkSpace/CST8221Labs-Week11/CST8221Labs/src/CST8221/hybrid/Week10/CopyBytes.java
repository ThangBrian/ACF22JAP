package CST8221.hybrid.Week10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Class CopyBytes
 * @author sousap
 *
 */
public class CopyBytes {
	
	/**
	 * Default constructor
	 */
	public CopyBytes() {
		; // Empty declarations
	}
	
	/**
	 * Execute method
	 * @throws IOException File exception.
	 */
    public void execute() throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}