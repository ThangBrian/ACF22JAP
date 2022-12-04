package CST8221.hybrid.Week02;

/* CST8221-JAP: HA 02, Example 4
   File name: MultipleStages.java 
*/
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.Modality;

/**
 * This class demonstrates how to create a JavaFX application with multiple
 * stages.
 * 
 * @version 1.19.1
 * @author S. Ranev, Daniel Cormier
 * @since JavaFX 8
 */
public class MultipleStages extends Application {
	
	/**
	 * Default constructor
	 */
	public MultipleStages() {
		; // Empty declarations
	}
	
	/**
	 * Override the start() method and create the GUI.
	 * 
	 * @throws java.lang.Exception Exception when JavaFX cannot be started in
	 *                             different stages
	 */
	@Override
	public void start(final Stage primaryStage) throws Exception {
		// set the primary stage
		primaryStage.setTitle("Primary Stage");
		primaryStage.setX(300);// set location on screen
		primaryStage.setWidth(800);
		primaryStage.setHeight(400);
		// make the GUI visible - show the primary stage.
		primaryStage.show();
		// set a secondary stage
		final Stage secondaryStage = new Stage();
		secondaryStage.setTitle("Secondary Stage");
		secondaryStage.setWidth(400);
		secondaryStage.setHeight(200);
		secondaryStage.setX(primaryStage.getX() + primaryStage.getWidth() / 2 - secondaryStage.getWidth() / 2);
		secondaryStage.setY(primaryStage.getY() + primaryStage.getHeight() / 2 - secondaryStage.getHeight() / 2);
		// make the second stage modal - the stage must be closed before the primary
		// stage can be used
		// comment the line bellow to see the difference - you can work with both stages
		secondaryStage.initModality(Modality.APPLICATION_MODAL);
		// Show this stage and wait for it to be hidden (closed) before returning to the
		// caller.
		secondaryStage.showAndWait();
	}

	/**
	 * The main() method is not required for JavaFX applications when the JAR file
	 * for the application is created with the JavaFX Packager tool which embeds the
	 * JavaFX Launcher in the JAR file. The main method is not needed if you launch
	 * the application from the command line. When you run a JavaFX application
	 * without a main() method, the Java Virtual Machine (JVM) will use
	 * automatically the static launch() method to run the application. However, it
	 * is useful to include the main() method so you can run the applications that
	 * were created without the JavaFX Launcher, such as when using an IDE in which
	 * the JavaFX tools are not fully integrated. Also, Swing applications that
	 * embed JavaFX code require the main() method.
	 * 
	 * @param args command line arguments
	 */
	public static void execute(String[] args) {
		Application.launch(args);
	}
}