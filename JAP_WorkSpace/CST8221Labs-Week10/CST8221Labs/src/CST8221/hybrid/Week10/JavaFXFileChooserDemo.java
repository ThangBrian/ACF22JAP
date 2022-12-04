package CST8221.hybrid.Week10;

/*  CST8221-JAP: HA#07
File name: FileChooserDemoFX.java
*/

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * This class demonstrates how to use the JavaFX FileChooser class. Link:
 * http://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
 * 
 * @author Oracle JavaFX Documentation, modified by Sv. Ranev
 * @version 1.19.1
 * @since JavaFX 2.0
 * @see javax.swing.JFileChooser
 * @see javax.swing.filechooser.FileNameExtensionFilter
 */

public final class JavaFXFileChooserDemo extends Application {

	/**
	 * Private desktop.
	 */
	private Desktop desktop = Desktop.getDesktop();

	/**
	 * Default constructor.
	 */
	public JavaFXFileChooserDemo() {
		; // No commands
	}
	
	/**
	 * Start method.
	 */
	@Override
	public void start(final Stage stage) {
		stage.setTitle("File Chooser Sample");

		final FileChooser fileChooser = new FileChooser();
		final Button openButton = new Button("Open a Picture...");
		final Button openMultipleButton = new Button("Open Pictures...");

		openButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				configureFileChooser(fileChooser);
				File file = fileChooser.showOpenDialog(stage);
				if (file != null) {
					openFile(file);
				}
			}
		});

		openMultipleButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(final ActionEvent e) {
				configureFileChooser(fileChooser);
				List<File> list = fileChooser.showOpenMultipleDialog(stage);
				if (list != null) {
					for (File file : list) {
						openFile(file);
					}
				}
			}
		});

		final GridPane inputGridPane = new GridPane();

		GridPane.setConstraints(openButton, 0, 1);
		GridPane.setConstraints(openMultipleButton, 1, 1);
		inputGridPane.setHgap(6);
		inputGridPane.setVgap(6);
		inputGridPane.getChildren().addAll(openButton, openMultipleButton);

		final Pane rootGroup = new VBox(12);
		rootGroup.getChildren().addAll(inputGridPane);
		rootGroup.setPadding(new Insets(20, 40, 12, 80));

		stage.setScene(new Scene(rootGroup, 400, 80));
		stage.show();
	}

	/**
	 * Method to configure file chooser
	 * @param fileChooser Name of file
	 */
	private static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("View Pictures");
		// set initial folder
		fileChooser.setInitialDirectory(
				// new File(System.getProperty("user.home"))
				new File(".")// current folder
		);
		// set filters
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
	}

	/**
	 * Opens a file
	 * @param file File to be opened.
	 */
	private void openFile(File file) {
		try {
			/*
			 * The line below will open your desktop application currently associated with
			 * the extension of the file.
			 */
			desktop.open(file);
		} catch (IOException ex) {
			// write the exception into a log file
			Logger.getLogger(JavaFXFileChooserDemo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * Execute method.
	 * @param args Arguments to use.
	 */
	public void execute(String[] args) {
		Application.launch(args);
	}
}
