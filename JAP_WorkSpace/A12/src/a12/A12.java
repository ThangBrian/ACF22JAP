package a12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  

/**
 * Class that contains main method and the application's logics
 * @author Quoc Thang Tran
 */

public class A12 extends Application {

	/**
	 * Default constructor
	 */
	public A12() {}

	/**
	 * Main function
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * New Data instance
	 */
	Data instance = new Data();
	
	/**
	 * Create the pane (a square) for playing 
	 * @param dim - the square's dimension
	 * @param text - user's input if the type is "Text"
	 * @return grid - the grid pane that contains the square of numbers or texts
	 */
	public GridPane getPlayPane(int dim, String text) {
		    GridPane grid = new GridPane();
		    grid.setHgap(0);
		    grid.setVgap(0);
		    grid.setPadding(new Insets(50, 20, 0, 20));
		    
		    int n;
		    int count=0;
		    String[] arr = null;
		    
		    if(dim==0)
		    	n=3;
		    else {
		    	n=dim;
		    }
		    arr = new String[n*n-1];
		    if(text == null) {
			    for (int i = 0; i < n*n-1; i++) {
			    	arr[i] = Integer.toString(i+1);
			    }
		    }
		    else {
		    	for (int i = 0; i < n*n-1; i++) {
		    		if(i<instance.getInput().length())
			    		arr[i] = String.valueOf(instance.getInput().charAt(i));
			    	else
			    		arr[i] = "";
			    }
		    }
		    final int numCols = n;
	        final int numRows = n;
	        for (int i = 0; i < numCols; i++) {
	            ColumnConstraints colConst = new ColumnConstraints();
	            colConst.setPercentWidth(60.0 / numCols);
	            grid.getColumnConstraints().add(colConst);
	        }
	        for (int i = 0; i < numRows; i++) {
	            RowConstraints rowConst = new RowConstraints();
	            rowConst.setPercentHeight(60.0 / numRows);
	            grid.getRowConstraints().add(rowConst);         
	        }
	        for (int i=0; i<numRows; i++) {
	        	for(int j=0; j<numCols; j++) {
	        		if(i==numRows-1 && j == numCols-1)
	        			break;
	        		if(arr[count] == null)
	        			break;
	        		Button temp = new Button(arr[count++]);
	        		temp.setOnAction(new EventHandler<ActionEvent>() {
	        			@Override
	        			public void handle(ActionEvent e) {
	        				// button.setOnAction(null);
	//	        				temp.setText("0");
	        				temp.setEffect(null);
	        			}
	        		});
	        		temp.setMinWidth(grid.getColumnConstraints().get(j).getPercentWidth()*7.6);
	        		temp.setMinHeight(grid.getRowConstraints().get(i).getPercentHeight()*7.6);
	        		grid.add(temp , j, i);
	        	}
	        }
		    grid.setGridLinesVisible(true);
		    return grid;
	  }
	
	/**
	 * Create the function pane - include functionalities(controllers) before, during and after playing the game
	 * @param primaryStage - the primary stage
	 * @return grid - the grid pane that includes functionalities (controllers)
	 */
	  public GridPane getFunctionPane(Stage primaryStage) {
		    GridPane grid = new GridPane();
		    grid.setHgap(0);
		    grid.setVgap(0);
		    grid.setPadding(new Insets(50, 0, 0, -320));
//		    grid.setStyle("-fx-background-color: #FFFACD;");

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
	        Image gameLogo = null;
	        try {
	        	gameLogo = new Image(new FileInputStream("C:\\Users\\tranq\\OneDrive\\Semester 4\\JAP\\JAP_WorkSpace\\A12\\src\\images\\gamelogo.png"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}; 
	        
	        Image aboutImage = null;
	        try {
	        	aboutImage = new Image(new FileInputStream("C:\\Users\\tranq\\OneDrive\\Semester 4\\JAP\\JAP_WorkSpace\\A12\\src\\images\\gameabout.png"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        ImageView imageView = new ImageView(gameLogo); 
	        ImageView aboutView = new ImageView(aboutImage);
	        imageView.setFitHeight(130); 
	        imageView.setFitWidth(190); 
	        aboutView.setFitHeight(400);
	        aboutView.setFitWidth(400);
	        imageView.setPreserveRatio(true);  
	        aboutView.setPreserveRatio(true);
	        
	        Dialog<String> aboutDialog = new Dialog<String>();
	        aboutDialog.setGraphic(aboutView);
	        aboutDialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
	        aboutDialog.getDialogPane().setLayoutX(100);
	        aboutDialog.getDialogPane().setPrefSize(400, 400);
	        aboutDialog.getDialogPane().setStyle("-fx-background-color: #FFFFFF;");
	        
	        
	        Button aboutButton = new Button();
	        aboutButton.setGraphic(imageView);
	        aboutButton.setPrefSize(80,150);
//	        aboutButton.setStyle("-fx-background-color: #808080;");
	        aboutButton.setOnAction(e -> {
	        	aboutDialog.show();
	        });
	        
	        Label mode = new Label("Mode: ");
	        mode.setStyle("-fx-font-weight: bold");
	        
	        RadioButton design = new RadioButton(" Design");
	        design.setPadding(new Insets(0, 0, 0, 50));
	        RadioButton play = new RadioButton("Play");
	        final ToggleGroup group = new ToggleGroup();
	        design.setToggleGroup(group);
	        design.setSelected(true);
	        play.setToggleGroup(group);
	        
	        Label dim = new Label("Dim: ");
	        dim.setStyle("-fx-font-weight: bold");
	        dim.setPadding(new Insets(0, 0, 0, 20));
	        
	        Label moves = new Label("Moves: ");
	        moves.setStyle("-fx-font-weight: bold");
	        moves.setPadding(new Insets(0, 0, 0, 10));

	        Label points = new Label("Points: ");
	        points.setStyle("-fx-font-weight: bold");
	        points.setPadding(new Insets(0, 0, 0, 10));
	        
	        ObservableList<Integer> dimOptions = 
	        	    FXCollections.observableArrayList(
	        	        3,
	        	        4,
	        	        5					
	        	    );
	        ComboBox<Integer> dimComboBox = new ComboBox<Integer>(dimOptions);
	        dimComboBox.setMaxWidth(50);
	        dimComboBox.getSelectionModel().select(instance.getDim()==0?0:instance.getDim()-3);
	        dimComboBox.setOnAction(e -> {
	        	instance.setDim(dimComboBox.getValue());
	        	try {
					start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        });
	        
	        Label type = new Label("Type: ");
	        type.setStyle("-fx-font-weight: bold");
	        type.setPadding(new Insets(0, 0, 0, 18));
	        
	        ObservableList<String> options = 
	        	    FXCollections.observableArrayList(
	        	        "Number",
	        	        "Text"
	        	    );
	        ComboBox<String> typeComboBox = new ComboBox<String>(options);
	        typeComboBox.setMaxWidth(90);
	        typeComboBox.getSelectionModel().select(instance.getType().equals("Number")?0:1);
	        typeComboBox.setOnAction(e -> {
	        	instance.setType(typeComboBox.getValue());
	        	try {
					start(primaryStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	        });
	        
	        TextField movesTextField = new TextField("0");
	        movesTextField.setMaxWidth(60);
	        
	        TextField pointsTextField = new TextField("0");
	        pointsTextField.setMaxWidth(60);
	        
	        TextField movementsTextField = new TextField("");
	        movementsTextField.setMaxWidth(310);
	        movementsTextField.setMaxHeight(1000);
	        movementsTextField.setStyle("-fx-background-color: #FFFACD;");
	        movementsTextField.setAlignment(Pos.TOP_LEFT);
	                
	        grid.add(aboutButton, 1, 0,2,2);
	        grid.add(mode, 1, 2);
	        grid.add(design, 1, 2, 2, 1);
	        grid.add(play, 3, 2);
	        grid.add(dim, 0, 3);
	        grid.add(dimComboBox, 1, 3, 2, 1);
	        grid.add(type, 0, 5);
	        grid.add(moves, 0, 6);
	        grid.add(movesTextField, 1, 6);
	        grid.add(points, 2, 6);
	        grid.add(pointsTextField, 3, 6);
	        grid.add(movementsTextField, 0, 7, 5, 7);
	        grid.add(typeComboBox, 1, 5, 2, 1);
//	        grid.setGridLinesVisible(true);
	        
 		    return grid;
	  }
	  
	  /**
	   * Create the pane for user to type in their's text.
	   * @param primaryStage - primary stage
	   * @return textPane - the flow pane that includes a text field and a submit button
	   */
	  public FlowPane getBottomTextField(Stage primaryStage) {
		  	FlowPane textPane = new FlowPane();
		  	TextField userInput = new TextField("Initial");
		  	userInput.setMinWidth(200);
		  	Button submitButton = new Button("Submit");
		  	submitButton.setOnAction(e -> {
		  		instance.setInput(userInput.getText());
		  		try {
					start(primaryStage);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		  	});
		  	textPane.getChildren().addAll(userInput, submitButton);
		  	textPane.setPadding(new Insets(-250, 0, 0, 150));
		  	return textPane;
	  }

	@Override
	/**
	 * override the function start (the starting point of the JavaFx application)
	 * @param primaryStage - the primary stage
	 * @throws Exception
	 */
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setResizable(false);
		primaryStage.setTitle("My First JavaFX App");
		BorderPane root = new BorderPane();
		if(instance.getType() == "Text" && instance.getInput() != null) {
			root.setLeft(getPlayPane(instance.getDim(), instance.getInput()));
		}
		else if(instance.getType() == "Number") {
			root.setLeft(getPlayPane(instance.getDim(), null));
			instance.setInput(null);
		}
		if(instance.getType().equals("Text") && instance.getInput() == null){
			root.setLeft(getPlayPane(instance.getDim(), null));
			root.setBottom(getBottomTextField(primaryStage));
		}
		root.setRight(getFunctionPane(primaryStage));	
		Scene scene = new Scene(root, 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

