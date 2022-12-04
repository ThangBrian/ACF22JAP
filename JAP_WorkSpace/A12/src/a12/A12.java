package a12;

import java.util.Timer; 
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ColorPicker;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  

import Model.Data; 
/**
 * View as outer class and Controller as inner class
 * One more inner class for the splash window
 * @author Quoc Thang Tran
 */

public class A12 extends Application {
    public int seconds = 0; // For the timer
    Timer time;
    TimerTask timerTask;
    final ColorPicker colorPicker = new ColorPicker(Color.web("#80ff00"));   
    public Data instance = new Data();
    public static boolean show = false;
    static public Stage primaryStage;
	
	Button[][] buttonArr;
	
	public A12 () {}
	
	/*
	 * images
	 */	
	Image gameLogo = null;
	Image aboutImage = null;
	Image newImage = null;
	Image solutionImage = null;
	Image exitImage = null;
	Image colorsImage = null;
	Image aboutIcon = null;
	Image finishedImage = null;
	Image errorImage = null;
	Image wonImage = null;
	
	/*
	 * menus
	 */
	Menu game;
	Menu help;
	
	/*
	 * menu items
	 */
	MenuItem newOption;
	MenuItem solutionOption;
	MenuItem exitOption; 
	MenuItem aboutOption;	
	
	/*
	 * image's view
	 */
	ImageView logoView;
	ImageView aboutView;
	ImageView newView;
	ImageView solutionView;
	ImageView exitView;
	ImageView aboutIconView;
	ImageView finishedView;
	ImageView errorView;
	ImageView wonView;
	
	/*
	 * dialogs
	 */
	Dialog<Void> aboutDialog = new Dialog<Void>();
	Dialog<Void> finishedDialog = new Dialog<Void>();
	Dialog<Void> errorDialog = new Dialog<Void>();
	Dialog<Void> wonDialog = new Dialog<Void>();
	
	/*
	 * buttons
	 */
	Button aboutButton = new Button();
	Button shuffle = new Button("Shuffle");
	Button finish = new Button("Finish");
	Button submitButton = new Button("Submit");
	RadioButton design = new RadioButton(" Design");
	RadioButton play = new RadioButton("Play");
	final ToggleGroup group = new ToggleGroup();
	
	/*
	 * labels
	 */
	Label mode = new Label("Mode: ");
	Label dim = new Label("Dim: ");
	Label moves = new Label("Moves: ");
	Label points = new Label("Points: ");
	Label timer = new Label("Timer: ");
	Label type = new Label("Type: ");
	
	/*
	 * observable lists
	 */
	ObservableList<Integer> dimOptions = 
			FXCollections.observableArrayList(
					3,
					4,
					5					
					);
	ObservableList<String> options = 
			FXCollections.observableArrayList(
					"Number",
					"Text"
					);
	
	/*
	 * combo boxes
	 */
	ComboBox<Integer> dimComboBox = new ComboBox<Integer>(dimOptions);
	ComboBox<String> typeComboBox = new ComboBox<String>(options);
	
	/*
	 * text fields
	 */
	TextField movesTextField = new TextField("0");
	TextField pointsTextField = new TextField("0");
	TextField timerTextField = new TextField("0");
	TextField userInput = new TextField("Initial");
	
	/*
	 * text area
	 */
	TextArea movementsTextArea = new TextArea("");
	
	/**
	 * Get the primary stage
	 * @return primaryStage - primary stage
	 */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Set the primary stage
     * @param primaryStage - primary stage
     */
    public void setPrimaryStage(Stage primaryStage) {
        A12.primaryStage = primaryStage;
    }
    
    /**
     * Function to keep updating the timer every second
     */
    public void startTimer() { 
    	// Timer task
    	time = new Timer();
    	timerTask = new TimerTask() {
    		@Override
    		public void run() { 
    			++seconds;
    			timerTextField.setText(Integer.toString(seconds)); // Update UI
    		} 
    	}; 
    	try { 
    		time.scheduleAtFixedRate(timerTask, 0, 1000); 
    	}
    	catch(Exception e) { // Eventual treatment 
    		
    	}		
    }	
 
  	/**
  	 * Inner Controller Class
  	 */
  	public class Controller{	
  		EventHandler<WindowEvent> windowHandler = new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				instance.setFinished(true);	
			}
  		
  		};
  		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			@Override
			/**
			 * override the handle() in EventHandler to react to ActionEvent
			 */
			public void handle(ActionEvent event) {	
				if(event.getSource() == dimComboBox) { // dim is changed 
			    	instance.setDim(dimComboBox.getValue());
			    	instance.setSolution(null);
			    	instance.setInputGiven(false);
			    	try {
						start(getPrimaryStage());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(event.getSource() == typeComboBox) { // type is changed
					instance.setType(typeComboBox.getValue());
					if(typeComboBox.getValue().equalsIgnoreCase("Text"))
						instance.setInputGiven(false);
					else
						instance.setSolution(null);
					try {
						start(getPrimaryStage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (event.getSource() == aboutButton || event.getSource() == aboutOption) { // menu about or game's logo is clicked
					aboutDialog.show();
				}
				else if (event.getSource() == submitButton) { // submit button is clicked
					instance.setSolution(userInput.getText());
					instance.setInputGiven(true);
					try {
						start(getPrimaryStage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(event.getSource() == shuffle) { // shuffle button is clicked
					instance.shuffleGame();
					try {
						start(getPrimaryStage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(event.getSource() == finish) { // finish button is clicked
					finishedDialog.show();
					time.cancel();
		        	for(int i=0; i<buttonArr.length; i++) {
		            	for(int j=0; j<buttonArr[0].length; j++) {
		            		if(buttonArr[i][j] != null )
		            			buttonArr[i][j].setDisable(true);
		            	}
		            }		
		        	instance.setFinished(true);
				}				
				else if(event.getSource() == design || event.getSource() == newOption || event.getSource() == solutionOption) { // user choose design mode or create a new game or show the solution
					instance.setMode("design");
					instance.setPoints(0);
					instance.setMoves(0);
					instance.deleteMovements();
					instance.setWon(false);
					if(time!=null)
						time.cancel();
					seconds = 0;
					if(event.getSource() == newOption)
						instance.shuffleGame();
					if(event.getSource() == solutionOption)
						instance.setPlay();
					try {
						start(getPrimaryStage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(event.getSource() == play) { // play button is clicked
					instance.checkPoint();
					if(instance.getPoints() == instance.getDim()*instance.getDim()) {
						errorDialog.show();
					}
					else {
						instance.setMode("play");
						startTimer();
					}
					try {
						start(getPrimaryStage());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(event.getSource() == exitOption) // exit option is clicked
					Platform.exit();
				else if(event.getSource() == colorPicker) { // user choose a color
					instance.setColorCode(colorPicker.getValue());
					for (int i =0;i<buttonArr.length;i++){
		    	      for(int j =0;j<buttonArr[0].length;j++){   		
		    	    	  if(instance.getColor()[i][j] == 1 && buttonArr[i][j] != null){
		    	    		  String temp = '#' + instance.getColorCode().toString().substring(2, instance.getColorCode().toString().length()-2);
		    	    		  buttonArr[i][j].setStyle("-fx-background-color: " + temp + ";" );
		    	    	  }
		    	      }  				
			        }
				}
				else { // A tile is clicked
			    	for (int i =0;i<buttonArr.length;i++){
		    	      for(int j =0;j<buttonArr[0].length;j++){   		
		    	       	if(buttonArr[i][j] == event.getSource()) {
		    	       		if(instance.move(i, j)){
		    	       			if(instance.isWon()) {
		    	       				time.cancel();
		    	       				wonDialog.show();
		    	       			}
			    	       			try {
			    	       				start(getPrimaryStage());
			    	       			}
			    	       			catch(Exception e){
			    	       				e.printStackTrace();
			    	       			}
		    	       			
		    	       		}
		    	       		break;
		    	       	}
		    	        	
		    	      }  				
		        	}
				}
				event.consume();
			}
  		};
  		
  		EventHandler<DialogEvent> dialogHandler = new EventHandler<DialogEvent>() {
			@Override
			/**
			 * override the handle() in EventHandler to react to DialogEvent
			 */
			public void handle(DialogEvent event) {	
				if(event.getSource() == aboutDialog) { // close button is clicked
					aboutDialog.hide();
				}
				else if(event.getSource() == finishedDialog) // close button is clicked
					finishedDialog.hide();
				else if(event.getSource() == errorDialog){ // close button is clicked
					errorDialog.hide();
				}
				else if(event.getSource() == wonDialog) { // close button is clicked
					wonDialog.hide();
				}
				event.consume();
			}
  		};
  	}
  	Controller control = new Controller();
  	
  	/**
  	 * Inner class for splash window
  	 */
  	public class splashWindow{
  		/**
  		 * constructor to show the dialog
  		 */
  		public splashWindow(){
  			try {
	        	aboutImage = new Image(getClass().getResourceAsStream("/images/gameabout.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
  			aboutView = new ImageView(aboutImage);
  			aboutDialog.getDialogPane().setLayoutX(180);
	        aboutDialog.getDialogPane().setPrefSize(400, 400);
	        aboutDialog.getDialogPane().setStyle("-fx-background-color: #FFFFFF;");
  			aboutDialog.show();
  			startTimerWindow();
  		}
  		
  		/**
  		 * Close the dialog after 5 seconds
  		 */
  	    public void startTimerWindow() { 
  	    	// Timer task
  	    	time = new Timer();
  	    	timerTask = new TimerTask() {
  	    		@Override
  	    		public void run() { 
  	    			Platform.runLater(new Runnable() {
  	    				@Override
  	    				public void run() {
  	    					aboutDialog.hide();
  	    					instance.setShowed(true);
  	    					try {
	    	       				start(getPrimaryStage());
	    	       			}
	    	       			catch(Exception e){
	    	       				e.printStackTrace();
	    	       			}
    	       			
  	    				}
  	    			});
  	    			time.cancel();
  	    		} 
  	    	}; 
  			try { 
  				time.schedule(timerTask, 5000);
  			}
  			catch(Exception e) { // Eventual treatment 
  				e.printStackTrace();
  			}		
  	    }
  	}
  	
	/**
	 * Create the pane (a square) for playing 
	 * @return grid - the GridPane that contains the square of numbers or texts
	 */
	public GridPane getPlayPane() {
		    GridPane grid = new GridPane();
		    grid.setHgap(0);
		    grid.setVgap(0);
		    grid.setPadding(new Insets(50, 20, 0, 20));
		    
		    int n = instance.getDim();
		    int[][] arr = instance.getPlay();
		    
		    /*
		     * Create the square
		     */
	        for (int i = 0; i < n; i++) {
	            ColumnConstraints colConst = new ColumnConstraints();
	            colConst.setPercentWidth(60.0 / n);
	            grid.getColumnConstraints().add(colConst);
	        }
	        for (int i = 0; i < n; i++) {
	            RowConstraints rowConst = new RowConstraints();
	            rowConst.setPercentHeight(60.0 / n);
	            grid.getRowConstraints().add(rowConst);         
	        }
	        /*
	         * Add buttons to the square
	         */
	        buttonArr = new Button[instance.getDim()][instance.getDim()];
	        for (int i=0; i<n; i++) {
	        	for(int j=0; j<n; j++) {
	        		if(arr[i][j] != 0) {
		        		buttonArr[i][j] = new Button();
		        		if(instance.getType().equalsIgnoreCase("Number") || (instance.getType().equalsIgnoreCase("Text") && instance.getInputGiven()==false))
		        			buttonArr[i][j].setText(Integer.toString(arr[i][j]));
		        		else
		        			buttonArr[i][j].setText(Character.toString((char)arr[i][j]));
		        		buttonArr[i][j].setMinWidth(grid.getColumnConstraints().get(j).getPercentWidth()*7.6);
		        		buttonArr[i][j].setMinHeight(grid.getRowConstraints().get(i).getPercentHeight()*7.6);
		        		if(instance.getColor()[i][j] == 1 && instance.getMode().equalsIgnoreCase("play") && buttonArr[i][j] != null) {
		        			String temp = '#' + instance.getColorCode().toString().substring(2, instance.getColorCode().toString().length()-2);
		        			buttonArr[i][j].setStyle("-fx-background-color: " + temp + ";" );
		        		}
		        		grid.add(buttonArr[i][j] , j, i);
		        		buttonArr[i][j].addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        		}
	        	}
	        }
		    grid.setGridLinesVisible(true);
		    return grid;
	  }
	
	/**
	 * Create the function pane - include functionalities before, during and after playing the game
	 * @return grid - the grid pane that includes functionalities
	 */
	  public GridPane getFunctionPane() {
		    GridPane grid = new GridPane();
		    grid.setHgap(0);
		    grid.setVgap(0);
		    grid.setPadding(new Insets(50, 0, 0, -320));
		    
		    /*
		     * Configure the pane
		     */
		    final int numCols = 5;
	        final int numRows = 15;
	        for (int i = 0; i < numCols; i++) {
	            ColumnConstraints colConst = new ColumnConstraints();
	            colConst.setPercentWidth(99.0 / numCols);
	            grid.getColumnConstraints().add(colConst);
	        }
	        for (int i = 0; i < numRows; i++) {
	            RowConstraints rowConst = new RowConstraints();
	            rowConst.setPercentHeight(80.0 / numRows);
	            grid.getRowConstraints().add(rowConst);         
	        }
	        
	        /*
	         * Load images
	         */
	        try {
//	        	gameLogo = new Image(new FileInputStream("src/images/gamelogo.png"));
	        	gameLogo = new Image(getClass().getResourceAsStream("/images/gamelogo.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}; 
	        
	        try {
	        	aboutImage = new Image(getClass().getResourceAsStream("/images/game.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        try {
	        	newImage = new Image(getClass().getResourceAsStream("/images/iconnew.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        try {
	        	solutionImage = new Image(getClass().getResourceAsStream("/images/iconsol.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        try {
	        	exitImage = new Image(getClass().getResourceAsStream("/images/iconext.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        try {
	        	aboutIcon = new Image(getClass().getResourceAsStream("/images/iconabt.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        try {
	        	finishedImage = new Image(getClass().getResourceAsStream("/images/gameend.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        try {
	        	errorImage = new Image(getClass().getResourceAsStream("/images/gameerr.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	       
	        
	        try {
	        	wonImage = new Image(getClass().getResourceAsStream("/images/gamewinner.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	  
	    	
	        /*
	         * Create views
	         */
	    	logoView = new ImageView(gameLogo); 
	    	aboutView = new ImageView(aboutImage);
	    	newView = new ImageView(newImage);
	    	solutionView = new ImageView(solutionImage);
	    	exitView = new ImageView(exitImage);
	    	aboutIconView = new ImageView(aboutIcon); 
	    	finishedView = new ImageView(finishedImage);
	    	errorView = new ImageView(errorImage);
	    	wonView = new ImageView(wonImage);
	        
	    	/*
	    	 * Configure views
	    	 */
	    	logoView.setFitHeight(130); 
	    	logoView.setFitWidth(190); 
	        aboutView.setFitHeight(400);
	        aboutView.setFitWidth(400);
	        logoView.setPreserveRatio(true);  
	        aboutView.setPreserveRatio(true);
	        
	        /*
	         * Configure aboutDialog
	         */
	        aboutDialog.setGraphic(aboutView);
	        ButtonType buttonTypeClose = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
	        aboutDialog.getDialogPane().getButtonTypes().clear();
	        aboutDialog.getDialogPane().getButtonTypes().add(buttonTypeClose);
	        aboutDialog.getDialogPane().setLayoutX(100);
	        aboutDialog.getDialogPane().setPrefSize(400, 400);
	        aboutDialog.getDialogPane().setStyle("-fx-background-color: #FFFFFF;");
	        
	        /*
	         * Configure finished dialog
	         */
	        finishedDialog.setGraphic(finishedView);
	        ButtonType buttonTypeClose1 = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
	        finishedDialog.getDialogPane().getButtonTypes().clear();
	        finishedDialog.getDialogPane().getButtonTypes().add(buttonTypeClose1);
	        finishedDialog.getDialogPane().setLayoutX(100);
	        finishedDialog.getDialogPane().setPrefSize(400, 400);
	        finishedDialog.getDialogPane().setStyle("-fx-background-color: #FFFFFF;");
	        
	        /*
	         * Configure error dialog
	         */
	        errorDialog.setGraphic(errorView);
	        ButtonType buttonTypeClose2 = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
	        errorDialog.getDialogPane().getButtonTypes().clear();
	        errorDialog.getDialogPane().getButtonTypes().add(buttonTypeClose2);
	        errorDialog.getDialogPane().setLayoutX(100);
	        errorDialog.getDialogPane().setPrefSize(400, 400);
	        errorDialog.getDialogPane().setStyle("-fx-background-color: #FFFFFF;");
	        
	        /*
	         * Configure wonDialog
	         */
	        wonDialog.setGraphic(wonView);
	        ButtonType buttonTypeClose3 = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
	        wonDialog.getDialogPane().getButtonTypes().clear();
	        wonDialog.getDialogPane().getButtonTypes().add(buttonTypeClose3);
	        wonDialog.getDialogPane().setLayoutX(100);
	        wonDialog.getDialogPane().setPrefSize(400, 400);
	        wonDialog.getDialogPane().setStyle("-fx-background-color: #FFFFFF;");
	        
	        /*
	         * configure aboutButton, mode label, design button, play button
	         */
	        aboutButton.setGraphic(logoView);
	        aboutButton.setPrefSize(80,150);
	        aboutButton.addEventHandler(ActionEvent.ACTION, control.eventHandler);        
	        mode.setStyle("-fx-font-weight: bold");      	        
	        design.setPadding(new Insets(0, 0, 0, 50));	        
	        design.setToggleGroup(group);
	        play.setToggleGroup(group);
	        design.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        play.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        
	        /*
	         * Disable tiles if mode is design
	         */
	        if(instance.getMode().equalsIgnoreCase("design")) {
	        	design.setSelected(true);
	        	timerTextField.setText("0");
	        	for(int i=0; i<buttonArr.length; i++) {
	            	for(int j=0; j<buttonArr[0].length; j++) {
	            		if(buttonArr[i][j] != null )
	            			buttonArr[i][j].setDisable(true);
	            	}
	            }
	        	dimComboBox.setDisable(false);
	        	typeComboBox.setDisable(false);
	        	shuffle.setDisable(false);
	        	finish.setDisable(true);
	        }
	        
	        /*
	         * Enable buttons if mode is play
	         */
	        if(instance.getMode().equalsIgnoreCase("play") && instance.isWon() == false) {
	        	play.setSelected(true);
				for(int i=0; i<buttonArr.length; i++) {
	            	for(int j=0; j<buttonArr[0].length; j++) {
	            		if(buttonArr[i][j] != null )
	            			buttonArr[i][j].setDisable(false);
	            	}
	            }
				dimComboBox.setDisable(true);
				typeComboBox.setDisable(true);
				shuffle.setDisable(true);
				finish.setDisable(false);
	        }
	        
	        /*
	         * Disable finish button if the user won
	         */
	        if(instance.isWon()) {
	        	finish.setDisable(true);
	        	for(int i=0; i<buttonArr.length; i++) {
	            	for(int j=0; j<buttonArr[0].length; j++) {
	            		if(buttonArr[i][j] != null )
	            			buttonArr[i][j].setDisable(true);
	            	}
	            }
	        }
	        /*
	         * Configure dim label
	         */
	        dim.setStyle("-fx-font-weight: bold");
	        dim.setPadding(new Insets(0, 0, 0, 20));
	        
	        /*
	         * Configure moves label
	         */
	        moves.setStyle("-fx-font-weight: bold");
	        moves.setPadding(new Insets(0, 0, 0, 10));
	        
	        /*
	         * Configure points label
	         */
	        points.setStyle("-fx-font-weight: bold");
	        points.setPadding(new Insets(0, 0, 0, 10));
	        
	        /*
	         * Configure dimComboBox
	         */
	        dimComboBox.setMaxWidth(50);
	        dimComboBox.getSelectionModel().select(instance.getDim()==0?0:instance.getDim()-3);
	        dimComboBox.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        
	        /*
	         * Configure shuffle and finish buttons
	         */
	        shuffle.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        finish.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        
	        /*
	         * Configure type label
	         */
	        type.setStyle("-fx-font-weight: bold");
	        type.setPadding(new Insets(0, 0, 0, 18));
	        
	        /*
	         * Configure typeComboBox
	         */
	        typeComboBox.setMaxWidth(90);
	        typeComboBox.getSelectionModel().select(instance.getType().equals("Number")?0:1);
	        typeComboBox.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        
	        /*
	         * Configure movesTextField
	         */
	        movesTextField.setMaxWidth(60);
	        movesTextField.setText(Integer.toString(instance.getMoves()));
	        movesTextField.setEditable(false);

	        /*
	         * Configure pointsTextField
	         */
	        pointsTextField.setMaxWidth(60);
	        pointsTextField.setText(Integer.toString(instance.getPoints()));
	        pointsTextField.setEditable(false);

	        /*
	         * Configure movementsTextArea
	         */
	        movementsTextArea.setMaxWidth(310);
	        movementsTextArea.setMaxHeight(1000);
	        movementsTextArea.setStyle("-fx-background-color: #FFFACD;");
	        movementsTextArea.setText(instance.getMovements().toString());
	        movementsTextArea.setEditable(false);
	                
	        /*
	         * Configure timer label
	         */
	        timer.setStyle("-fx-font-weight: bold");
	        
	        /*
	         * Configure timerTextField
	         */
	        timerTextField.setMaxWidth(60);
	        timerTextField.setEditable(false);
	        
	        /*
	         * add components to the pane
	         */
	        grid.add(aboutButton, 1, 0,2,2);
	        grid.add(mode, 1, 2);
	        grid.add(design, 1, 2, 2, 1);
	        grid.add(play, 3, 2);
	        grid.add(dim, 0, 3);
	        grid.add(dimComboBox, 1, 3, 2, 1);
	        grid.add(shuffle, 2, 3);
	        grid.add(finish, 1, 4);
	        grid.add(type, 0, 5);
	        grid.add(moves, 0, 6);
	        grid.add(movesTextField, 1, 6);
	        grid.add(points, 2, 6);
	        grid.add(pointsTextField, 3, 6);
	        grid.add(movementsTextArea, 0, 7, 5, 7);
	        grid.add(typeComboBox, 1, 5, 2, 1);
	        grid.add(timer, 0, 15);
	        grid.add(timerTextField, 1, 15);	        
 		    return grid;
	  }
	  
	  /**
	   * Create the pane for user to type in their's text.
	   * @return textPane - the flow pane that includes a text field and a submit button
	   */
	  public FlowPane getBottomTextField() {
		  	FlowPane textPane = new FlowPane();
		  	userInput.setMinWidth(200);
		  	submitButton.addEventHandler(ActionEvent.ACTION, control.eventHandler);
		  	textPane.getChildren().addAll(userInput, submitButton);
		  	textPane.setPadding(new Insets(-250, 0, 0, 150));
		  	return textPane;
	  }
	  
	  /**
	   * The menus at the top of the application
	   * @return horizontalBox - box that contains menus
	   */
	  public HBox getMenu() {
		  	/*
		  	 * Configure the first menu (Game menu)
		  	 */
		  	game = new Menu("Game");	        
	        newOption = new MenuItem("New");
	        solutionOption = new MenuItem("Solution");
	        exitOption = new MenuItem("Exit"); 
	        
	        newOption.setGraphic(newView);
	        solutionOption.setGraphic(solutionView);
	        exitOption.setGraphic(exitView);
	        
	        newOption.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        solutionOption.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        exitOption.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        
	        game.getItems().add(newOption);
	        game.getItems().add(solutionOption);
	        game.getItems().add(exitOption);	  
	        
	        MenuBar bar1 = new MenuBar();
	        bar1.getMenus().add(game);
	        
	        /*
	         * Configure the second menu(Help menu)
	         */
	        help = new Menu("Help");	        
	        aboutOption = new MenuItem("About");
	        aboutOption.setGraphic(aboutIconView);
	        aboutOption.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        help.getItems().add(aboutOption);
	        MenuBar bar2 = new MenuBar();
	        bar2.getMenus().add(help);
	        if(instance.getMode().equalsIgnoreCase("design"))
	        	colorPicker.setVisible(false);
	        else
	        	colorPicker.setVisible(true);
	        colorPicker.addEventHandler(ActionEvent.ACTION, control.eventHandler);
	        
	        HBox horizontalBox = new HBox(bar1, bar2, colorPicker);
	        return horizontalBox;
	  }

	@Override
	/**
	 * override the function start (the starting point of the JavaFx application)
	 * @param primaryStage - the primary stage
	 * @throws Exception
	 */
	public void start(Stage primaryStage) throws Exception{
		if(instance.isShowed() == false)
			new splashWindow();
		setPrimaryStage(primaryStage);
		primaryStage.setResizable(false);
		primaryStage.setTitle("My First JavaFX App");
		BorderPane root = new BorderPane();
		root.setLeft(getPlayPane());
		if(instance.getType().equals("Text") && !instance.getInputGiven() && instance.getMode().equalsIgnoreCase("design")){
			root.setBottom(getBottomTextField());
		}
		root.setRight(getFunctionPane());	
		root.setTop(getMenu());
		Scene scene = new Scene(root, 800, 800);
		primaryStage.setScene(scene);
		if(instance.isShowed())
			primaryStage.show();
  		primaryStage.setOnCloseRequest(control.windowHandler);
	}
	
	/**
	 * Main function
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}

