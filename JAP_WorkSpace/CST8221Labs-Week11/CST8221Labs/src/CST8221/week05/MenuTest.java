package CST8221.week05;

//Fig. 22.6: MenuTest.java
//Testing MenuFrame.
import javax.swing.JFrame;

/**
 * Menu test
 * @author sousap
 *
 */
public class MenuTest {
	
	/**
	 * Default constructor.
	 */
	public MenuTest() {
		; // No commands
	}
	
	/**
	 * Execute function.
	 */
	public static void execute() {
		MenuFrame menuFrame = new MenuFrame();
		menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menuFrame.setSize(500, 200);
		menuFrame.setVisible(true);
	}
} // end class MenuTest

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
