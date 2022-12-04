package CST8221.hybrid.Week04;

/*  CST8221-JAP: HA 04 (see Lab 4 first)
    File name: TextFieldDemoFX.java
    Original source: Intro to Java Programming by Y. Liang, 10ed
    Modified by S. Ranev, D. Cormier
*/
import static javafx.application.Application.launch;

import CST8221.hybrid.Week04.RadioButtonFXDemo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This class demonstrates how to create and use a text field and password field
 * UI control. Right-click no the text field to see the context menu (pop-up
 * menu)
 * 
 * @version 1.19.1
 * @since JavaFX 8
 */
@SuppressWarnings("unused")
public class TextFieldDemoFX extends RadioButtonFXDemo {
	
	/**
	 * Default constructor.
	 */
	public TextFieldDemoFX() {
		; // No commands
	}
	
	/**
	 * getPane: Returns the pane.
	 */
	@Override // Override the getPane() method in the super class
	public BorderPane getPane(String textContent) {
		BorderPane pane = super.getPane(textContent);

		BorderPane paneForTextField = new BorderPane();
		paneForTextField.setPadding(new Insets(5, 5, 5, 5));
		paneForTextField.setStyle("-fx-border-color: green");
		paneForTextField.setLeft(new Label("Enter a new message: "));

		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_LEFT);// Pos.BOTTOM_RIGHT
		tf.setPromptText("Enter your message here");
		paneForTextField.setCenter(tf);
		pane.setTop(paneForTextField);
		// to triger this event the user must press Enter
		tf.setOnAction(e -> text.setText(tf.getText()));

		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Your password");
		pane.setBottom(passwordField);
		return pane;
	}

	/**
	 * Start method.
	 */
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place it in the stage
		Scene scene = new Scene(getPane("Programming with JavaFX"), 450, 200);
		primaryStage.setTitle("Text Filed Demo FX"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 * 
	 * @param args Not used
	 */
	public void execute(String[] args) {
		launch(args);
	}
}
