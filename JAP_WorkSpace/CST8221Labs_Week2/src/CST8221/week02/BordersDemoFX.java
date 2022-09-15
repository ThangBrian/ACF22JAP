package CST8221.week02;

/* CST8221-JAP: LAB 02, Borders FX
   File name: BordersDemoFX.java
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * This class demonstrates how to create boarders using Java FX CSS. StackPane
 * and Label is used for demonstration, but border can be applied to any node
 * and region. Since Java 8 a new Border class has been introduced that can be
 * used instead of css styles (see SplashScreenDemoFX). You can see the use of
 * that class in SplashScreenDemoFX.java. For complete Java FX CSS reference
 * visit: http://docs.oracle.com/javafx/2/api/javafx/scene/doc-files/cssref.html
 * 
 * @version 1.19.1
 * @author Svillen Ranev, Daniel Cormier
 * @since JavaFX 8
 */
public class BordersDemoFX extends Application {
	
	/**
	 * Default constructor
	 */
	public BordersDemoFX() {
		; // Empty constructor
	}
	
	/** Defines css border style string */
	private final String cssStyle1 = "-fx-border-color: darkviolet;" + "-fx-border-insets: 5;" + "-fx-border-width: 5;"
			+ "-fx-border-style: dashed;";
	/** Defines css border style string */
	private final String cssStyle2 = "-fx-border-style: solid line-join bevel;" + "-fx-border-color: darkturquoise;"
			+ "-fx-border-insets:10.10.10.10;" + "-fx-border-width: 5";
	/** Defines css border style string */
	private final String cssStyle3 = "-fx-border-style: dotted;" + "-fx-border-color: seagreen;"
			+ "-fx-border-insets:10.10.10.10;" + "-fx-border-width: 5";
	/** Defines css border style string */
	private final String cssStyle4 = "-fx-border-color: #ff0000;-fx-border-insets:10.10.10.10;-fx-border-width: 10;-fx-border-radius:5";

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a border pane - layout manager
		BorderPane rootPane = new BorderPane();
		// Set the root pane border using the Border class
		rootPane.setBorder(new Border(
				new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(15.0))));
		// Place nodes in the pane
		rootPane.setTop(new CustomPane("Top", cssStyle3));
		rootPane.setRight(new CustomPane("Right", cssStyle1));
		rootPane.setBottom(new CustomPane("Bottom", cssStyle4));
		rootPane.setLeft(new CustomPane("Left", cssStyle1));
		rootPane.setCenter(new CustomPane("Center", cssStyle2));

		// Create a scene and place it in the stage
		Scene scene = new Scene(rootPane, 400, 400);
		primaryStage.setTitle("Border Demo FX CSS"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * This inner class defines a custom pane to hold a label in the center of the
	 * pane.
	 */
	private class CustomPane extends StackPane {
		public CustomPane(String title, String style) {
			this.setStyle(style);
			this.getChildren().add(new Label(title));
		}
	}

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 * 
	 * @param args not used
	 */
	public static void execute(String[] args) {
		Application.launch(args);
	}
}