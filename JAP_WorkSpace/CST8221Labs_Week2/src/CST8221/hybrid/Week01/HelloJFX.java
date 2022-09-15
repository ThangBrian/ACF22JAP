package CST8221.hybrid.Week01;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Example from Notes about basic JavaFX application
 * 
 * @author sousap
 *
 */
public class HelloJFX extends Application {

	/**
	 * Default constructor
	 */
	public HelloJFX() {
		; // Default constructor
	}

	/**
	 * Main function
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("My First JavaFX App");
		Label label = new Label("Hello World, JavaFX !");
		label.setAlignment(Pos.CENTER);
		Scene scene = new Scene(label, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
