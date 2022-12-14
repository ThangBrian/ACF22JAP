package CST8221.week05;

//Liang: Chapter 34
//File Name: ContextMenuDemo.java 
//Modified by S. Ranev
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Sample of menus using JFX
 * @author sousap
 *
 */
public class JFXMenuDemo extends Application {
	
	/**
	 * Private field for 1st number.
	 */
	private TextField tfNumber1 = new TextField();
	
	/**
	 * Private field for 2nd number.
	 */
	private TextField tfNumber2 = new TextField();
	
	/**
	 * Private field for result.
	 */
	private TextField tfResult = new TextField();

	/**
	 * Default constructor
	 */
	public JFXMenuDemo() {
		; // No commands
	}
	
	/**
	 * Start - Default method to start Stage.
	 */
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		MenuBar menuBar = new MenuBar();

		Menu menuOperation = new Menu("Operation");
		Menu menuExit = new Menu("Exit");
		menuBar.getMenus().addAll(menuOperation, menuExit);

		MenuItem menuItemAdd = new MenuItem("Add");
		MenuItem menuItemSubtract = new MenuItem("Subtract");
		MenuItem menuItemMultiply = new MenuItem("Multiply");
		MenuItem menuItemDivide = new MenuItem("Divide");
		menuOperation.getItems().addAll(menuItemAdd, menuItemSubtract, menuItemMultiply, menuItemDivide);

		MenuItem menuItemClose = new MenuItem("Close");
		menuExit.getItems().add(menuItemClose);

		menuItemAdd.setAccelerator(KeyCombination.keyCombination("Ctrl+Alt+A"));
		menuItemSubtract.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		menuItemMultiply.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
		menuItemDivide.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));

		HBox hBox1 = new HBox(5);
		tfNumber1.setPrefColumnCount(2);
		tfNumber2.setPrefColumnCount(2);
		tfResult.setPrefColumnCount(2);
		hBox1.getChildren().addAll(new Label("Number 1:"), tfNumber1, new Label("Number 2:"), tfNumber2,
				new Label("Result:"), tfResult);
		hBox1.setAlignment(Pos.CENTER);

		HBox hBox2 = new HBox(5);
		Button btAdd = new Button("Add");
		Button btSubtract = new Button("Subtract");
		Button btMultiply = new Button("Multiply");
		Button btDivide = new Button("Divide");
		hBox2.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);
		hBox2.setAlignment(Pos.CENTER);

		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(menuBar, hBox1, hBox2);
		Scene scene = new Scene(vBox, 360, 250);
		primaryStage.setTitle("MenuDemo"); // Set the window title
		primaryStage.setScene(scene); // Place the scene in the window
		primaryStage.show(); // Display the window

		// Handle menu actions
		menuItemAdd.setOnAction(e -> perform('+'));
		menuItemSubtract.setOnAction(e -> perform('-'));
		menuItemMultiply.setOnAction(e -> perform('*'));
		menuItemDivide.setOnAction(e -> perform('/'));
		///menuItemClose.setOnAction(e -> System.exit(0));
		menuItemClose.setOnAction(e -> perform(' '));

		// Handle button actions
		btAdd.setOnAction(e -> perform('+'));
		btSubtract.setOnAction(e -> perform('-'));
		btMultiply.setOnAction(e -> perform('*'));
		btDivide.setOnAction(e -> perform('/'));
	}

	/**
	 * Perform Execution.
	 * @param operator
	 */
	private void perform(char operator) {
		// Warning:
		// It will throw a java.lang.NumberFormatException the entry is not a number.
		// The input should be validated before calling Double.parseDouble

		double number1 = Double.parseDouble(tfNumber1.getText());
		double number2 = Double.parseDouble(tfNumber2.getText());

		double result = 0;
		switch (operator) {
		case '+':
			result = number1 + number2;
			break;
		case '-':
			result = number1 - number2;
			break;
		case '*':
			result = number1 * number2;
			break;
		case '/':
			result = number1 / number2;
			break;
		default:
			result = 0;
			break;
		}

		tfResult.setText(result + "");
	};

	/**
	 * The main method is only needed for the IDE with limited JavaFX support. Not
	 * needed for running from the command line.
	 * @param args Command line arguments
	 */
	public static void execute(String[] args) {
		launch(args);
	}
}
