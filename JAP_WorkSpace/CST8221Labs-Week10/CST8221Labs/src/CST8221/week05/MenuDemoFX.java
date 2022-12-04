package CST8221.week05;

/**CST8221 - JAP, Unit 5
 * MenuDemoFX.java
 * Author: Sv. Ranev
 * Version: 1.19.1
 * Demonstrates how to build an application menu using JavaFX 8
 * 
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Platform;
import java.util.List;
import javafx.scene.layout.BorderPane;

/**
 * Creating Menus with JavaFX 8
 * 
 * @author Svillen Ranev
 * @since JavaFX 8
 */
public class MenuDemoFX extends Application {
	
	/**
	 * Default constructor.
	 */
	public MenuDemoFX() {
		; // No commands
	}
	
	/* the Application method init() is called before the start() method */
	/**
	 * Init method.
	 */
	@Override
	public void init() {
		// retreive the command line arguments
		Application.Parameters param = super.getParameters();
		List<String> list = param.getUnnamed();
		if (list != null && !list.isEmpty())
			for (int i = 0; i < list.size(); ++i)
				System.out.println(list.get(i));
	}

	/**
	 * Start method.
	 */
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Menu Demo JavaFX");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 350, 250, Color.WHITE);
		// create a menu bar
		MenuBar menuBar = new MenuBar();
		// File menu - new, save, exit
		Menu menu = new Menu("_File");// mnemonic using _and parsing true
		// add menu items(new, save, exit) to the File menu
		MenuItem newmi = new MenuItem("_New"); // _ is used to create mnemonic
		newmi.setMnemonicParsing(true);// enable mnemonic using _ and parsing true
		// set the accelerator key combination
		newmi.setAccelerator(KeyCombination.keyCombination("Ctrl+Alt+N"));
		// register an event handler
		newmi.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("New Menu Item Selected");
			}
		});

		menu.getItems().add(newmi);
		MenuItem save = new MenuItem("Save");
		save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		save.setOnAction((ActionEvent) -> System.out.println("Save Menu Item Selected"));

		menu.getItems().add(save);
		menu.getItems().add(new SeparatorMenuItem());
		MenuItem exit = new MenuItem("Exit");
		try {
			exit.setGraphic(new ImageView(new Image("images/exit.gif")));
		} catch (Exception e) {
			;
		}
		exit.setAccelerator(KeyCombination.keyCombination("Alt+F4"));

		exit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("Exit Menu Item Selected");
				Platform.exit();
			}
		});

		menu.getItems().add(exit);

		menuBar.getMenus().add(menu);

		// Edit Menu
		Menu edit = new Menu("Edit");
		// disable the menu
		// edit.setDisable(true);
		try {
			edit.getItems().add(new MenuItem("Cut", new ImageView(new Image("images/cut.gif"))));
		} catch (Exception e) {
			edit.getItems().add(new MenuItem("Cut"));
		}
		edit.getItems().add(new MenuItem("Copy"));
		edit.getItems().add(new MenuItem("Paste"));

		Menu options = new Menu("Options");
		options.getItems().add(new CheckMenuItem("Read Only "));

		ToggleGroup tGroup = new ToggleGroup();

		RadioMenuItem insert = new RadioMenuItem("Insert");
		insert.setToggleGroup(tGroup);

		RadioMenuItem overtype = new RadioMenuItem("Overtype");
		overtype.setToggleGroup(tGroup);
		overtype.setSelected(true);

		options.getItems().add(insert);
		options.getItems().add(overtype);
		edit.getItems().add(options);

		menuBar.getMenus().add(edit);

		// Help
		Menu help = new Menu("Help");
		help.getItems().add(new MenuItem("Index"));
		help.getItems().add(new MenuItem("About"));

		menuBar.getMenus().add(help);

		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		root.setTop(menuBar);
		// root.getChildren().add(menuBar);
//create a pop-up menu -  ContextMenu in JavaFX      
		final ContextMenu contextMenu = new ContextMenu();
		MenuItem cut;
		try {
			cut = new MenuItem("Cut", new ImageView(new Image("images/cut.gif")));
		} catch (Exception e) {
			cut = new MenuItem("Cut");
		}
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");
		contextMenu.getItems().addAll(cut, copy, paste);
		cut.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Cut...");
			}
		});
		// In case the context menu is linked to a Node that is a Control
		// you simply have to use the line textArea.setContextMenu(contextMenu)
		// assuming that you have a TextArea control:
		TextArea textArea = new TextArea();
		textArea.setContextMenu(contextMenu);
		root.setCenter(textArea);
		/*
		 * // In case a ContextMenu is linked to a Node that is not a Control // (a Pane
		 * or a Shape, for example), you don't have a setContextMenu(...) method, // so
		 * you have to use an event handler: root.setOnMousePressed(new
		 * EventHandler<MouseEvent>() {
		 * 
		 * @Override public void handle(MouseEvent event) { if
		 * (event.isSecondaryButtonDown()) { contextMenu.show(root, event.getScreenX(),
		 * event.getScreenY()); } } });
		 */

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Execute method.
	 * @param args the command line arguments
	 */
	public static void execute(String[] args) {
		Application.launch(args);
	}

}
