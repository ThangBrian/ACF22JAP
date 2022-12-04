package CST8221.week10;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * Servlet example.
 * @author sousap
 *
 */
public class HelloServlet extends HttpServlet {
	
    /**
	 * Servlet ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public HelloServlet() {
		; // No commands
	}
	
	/**
	 * Service
	 * @param req Servlet Request
	 * @param res Servlet Response
	 */
	public void service(HttpServletRequest req, 
	    HttpServletResponse res) throws 
		ServletException, IOException {
			String str = 
			"<html>\n" +
            "<head><title>Hello WORLD</title></head>\n" +
            "<body>\n" +
            "<h1>Hello World from Servlet!</h1>\n" +
            "</body></html>";
		    PrintWriter p = res.getWriter();
			p.println(str);
	}
}
