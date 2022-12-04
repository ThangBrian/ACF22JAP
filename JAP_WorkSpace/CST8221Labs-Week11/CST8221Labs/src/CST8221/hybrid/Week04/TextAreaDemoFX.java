package CST8221.hybrid.Week04;

/*  CST8221-JAP: HA 04 
File name: TextAreaDemoFX.java
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

/**
 * This class demonstrates how to create and use a test area UI control.
 * Right-click inside the text area to invoke the pop-up (context) menu.
 * 
 * @author S. Ranev, D. Cormier
 * @version 1.20.1
 * @since JavaFX 8
 */
public class TextAreaDemoFX extends Application {
	
	/**
	 * Default constructor.
	 */
	public TextAreaDemoFX() {
		; // No commands
	}
	
	/**
	 * Start method.
	 */
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Declare and create a description pane
		BorderPane taContainer = new BorderPane();

		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Serif", 14));
		textArea.setWrapText(true);// enable text wrapping
		// textArea.setEditable(false);//disable text entry - use as display area
		textArea.setPromptText("Enter your text here...");// set text area prompt
		// if the text area is the only focusable control
		// the focus must be removed in order the prompt to appear
		textArea.setFocusTraversable(false);
		// textArea.setText("123456890");//displays text
		// textArea.positionCaret(0);// position the caret at column 0
		// Create a scroll pane to hold the text area
		ScrollPane scrollPane = new ScrollPane(textArea);
		taContainer.setCenter(scrollPane);
		
		/*
		 * You need not to use a ScrollPane. In JavaFX the TextArea control provides
		 * scroll bars if needed. Try it. Comment lines 37,38 above and uncomment line
		 * 43 below.Pay attention to line 28.
		 */
		//   taContainer.setCenter(textArea);

		taContainer.setPadding(new Insets(5, 5, 5, 5));
		// Create a scene and place it in the stage
		Scene scene = new Scene(taContainer, 400, 200);
		// set stage minimum size
		// primaryStage.setMinWidth(400); primaryStage.setMinHeight(200); 
		primaryStage.setTitle("Text Area Demo FX"); // Set the stage title
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
		Application.launch(args);
	}
}
