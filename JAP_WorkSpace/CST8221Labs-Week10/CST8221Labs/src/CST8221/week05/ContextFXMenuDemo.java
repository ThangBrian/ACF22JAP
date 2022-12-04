package CST8221.week05;

//Liang: Chapter 34
//File Name: ContextMenuDemo.java 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * ContextFXMenuDemo Menu for FX.
 * @author sousap
 *
 */
public class ContextFXMenuDemo extends Application {
	
	/**
	 * Default constructor
	 */
	public ContextFXMenuDemo() {
		; // No commands
	}
	
	/**
	 * Start method
	 */
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		ContextMenu contextMenu = new ContextMenu();
		MenuItem menuItemNew, menuItemOpen, menuItemPrint, menuItemExit;
		try {
			menuItemNew = new MenuItem("New", new ImageView("images/new.gif"));
		} catch (Exception e) {
			menuItemNew = new MenuItem("New");
		}
		try {
			menuItemOpen = new MenuItem("Open", new ImageView("images/open.gif"));
		} catch (Exception e) {
			menuItemOpen = new MenuItem("Open");
		}
		try {
			menuItemPrint = new MenuItem("Print", new ImageView("images/print.gif"));
		} catch (Exception e) {
			menuItemPrint = new MenuItem("Print");
		}
		menuItemExit = new MenuItem("Exit");
		contextMenu.getItems().addAll(menuItemNew, menuItemOpen, menuItemPrint, menuItemExit);

		Pane pane = new Pane();
		Scene scene = new Scene(pane, 350, 250);
		primaryStage.setTitle("ContextMenuDemo"); // Set the window title
		primaryStage.setScene(scene); // Place the scene in the window
		primaryStage.show(); // Display the window

		pane.setOnMousePressed(e -> {
			if (e.isSecondaryButtonDown())
				contextMenu.show(pane, e.getScreenX(), e.getScreenY());
		});

		menuItemNew.setOnAction(e -> System.out.println("New"));
		menuItemOpen.setOnAction(e -> System.out.println("Open"));
		menuItemPrint.setOnAction(e -> System.out.println("Print"));
		///menuItemExit.setOnAction(e -> System.exit(0));
		menuItemExit.setOnAction(e -> System.out.println("Dispose"));
	}


	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line. line.
	 * @param args Arguments
	 */
	public static void execute(String[] args) {
		launch(args);
	}
}
