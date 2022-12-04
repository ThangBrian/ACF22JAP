package CST8221.week04;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main code for Buttons in JavaFX
 * 
 * @author sousap
 *
 */
public class ButtonFXDemo extends Application {
	
	/**
	 * Control id
	 */
	int idControl = 0;

	/**
	 * Default constructor
	 */
	public ButtonFXDemo() {
		; // Empty declarations
	}
	
	/**
	 * Start method
	 */
	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox();

		Button btn = new Button();
		btn.setText("Add New Button");
		btn.setId("Button " + idControl);
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				idControl++;
				Button tempButton = new Button();
				tempButton.setText("Button " + idControl);
				tempButton.setId("Button " + idControl);
				tempButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event2) {
						System.out.println("You clicked: " + ((Button) event2.getSource()).getId());
					}
				});

				root.getChildren().add(tempButton);
			}
		});

		root.getChildren().add(btn);

		Scene scene = new Scene(root, 300, 250);

		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Methods for execution
	 * @param args the command line arguments
	 */
	public void execute(String[] args) {
		launch(args);
	}
}