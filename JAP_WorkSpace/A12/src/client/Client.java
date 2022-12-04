package client;

import java.io.*;
import java.net.*;

import a12.A12;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import config.Config;

public class Client extends Application implements Runnable{
	A12 newA12 = new A12();
	Random rand = new Random();
	Alert a = new Alert(AlertType.NONE);
	static StringBuilder log = new StringBuilder(""); 
	static StringBuilder message = new StringBuilder(""); 
	static StringBuilder messageP1 = new StringBuilder(""); 
	static Stage primaryStage;
	static boolean connected = false;
	static boolean newGame = false;
	static boolean sendGame = false;
	static boolean receiveGame = false;
	static boolean sendData = false;
	static boolean playing = false;
	static String closeSocket = null;
	static int[][] play;
	/**
	 * Number of port.
	 */
	static int portNumber = 0;
	
	/**
	 * Variable for hostname.
	 */
	static String hostName = "";
	
	
	public GridPane getServerGUI(){
		GridPane serverGUI = new GridPane();
		serverGUI.setHgap(0);
		serverGUI.setVgap(0);
		serverGUI.setPadding(new Insets(50, 20, 0, 20)); 
		
	    final int numCols = 9;
        final int numRows = 15;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(99.0 / numCols);
            serverGUI.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(80.0 / numRows);
            serverGUI.getRowConstraints().add(rowConst);         
        }
       
        
		Image clientImage = new Image(getClass().getResourceAsStream("/images/clientImage.png"));
		ImageView clientImageView = new ImageView(clientImage); 
		clientImageView.setFitHeight(300); 
		clientImageView.setFitWidth(490); 
		clientImageView.setPreserveRatio(true);
		
		Label userLabel = new Label("User:");
		userLabel.setPadding(new Insets(0, 0, 0, 50));
		userLabel.setStyle("-fx-font-weight: bold");
		
		TextField userTextField = new TextField(Config.DEFAULT_USER);
		
		Label serverLabel = new Label("Server:");
		serverLabel.setPadding(new Insets(0, 0, 0, 40));
		serverLabel.setStyle("-fx-font-weight: bold");
		
		TextField serverTextField = new TextField(Config.DEFAULT_ADDR);
		
		Label portLabel = new Label("Port:");
		portLabel.setPadding(new Insets(0, 0, 0, 50));
		portLabel.setStyle("-fx-font-weight: bold");
		
		TextField portTextField = new TextField(Integer.toString(Config.DEFAULT_PORT));
		
		Button connectButton = new Button("Connect");
		connectButton.setMaxWidth(70);
		connectButton.setDisable(connected);
		
		Button endButton = new Button("End");
		endButton.setMaxWidth(70);
		endButton.setDisable(!connected);
		
		Button newGameButton = new Button("New game");
		newGameButton.setMaxWidth(80);
		newGameButton.setDisable(!connected);

		Button sendGameButton = new Button("Send game");
		sendGameButton.setMaxWidth(80);
		sendGameButton.setDisable(!connected);
		
		Button receiveGameButton = new Button("Receive game");
		receiveGameButton.setMaxWidth(165);
		receiveGameButton.setDisable(!connected);
		
		Button sendDataButton = new Button("Send data");
		sendDataButton.setMaxWidth(70);
		sendDataButton.setDisable(!connected );
		
		Button playButton = new Button("Play");
		playButton.setMaxWidth(70);
		playButton.setDisable(!connected || playing);
		
		TextArea logTextArea = new TextArea(log.toString());
		logTextArea.setMaxWidth(585);
		logTextArea.setMaxHeight(1000);
		logTextArea.setEditable(false);
		
        EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			@Override
			/**
			 * override the handle() in EventHandler to react to ActionEvent
			 */
			public void handle(ActionEvent event) {	
				if(event.getSource() == connectButton) { // dim is changed 
					Thread clientThread = new Thread(new Client());
					clientThread.start();
				}
				if(event.getSource() == endButton) { // dim is changed 
					connected = false;
					closeSocket = "close";
				}
				if(event.getSource() == newGameButton) { // dim is changed
					newA12.instance.setDim(rand.nextInt(2)+3);
					newA12.instance.setSolution(null);
					newA12.instance.setInputGiven(false);
					newA12.instance.shuffleGame();
					play = newA12.instance.getPlay();
					newGame = true;
				}
				if(event.getSource() == sendGameButton) { // dim is changed 
					sendGame = true;
				}
				if(event.getSource() == receiveGameButton) { // dim is changed 
					receiveGame = true;
				}
				if(event.getSource() == sendDataButton) { // dim is changed 
					sendData = true;
				}
				if(event.getSource() == playButton) { // dim is changed 
					try {
						playing = true;
						start(primaryStage);
						newA12.start(new Stage());
					} catch (Exception e) {
						a.setAlertType(AlertType.ERROR);
						a.setContentText(e.toString());
						a.show();
					}
				}
				try {
					start(primaryStage);
				} catch (Exception e) {
					a.setAlertType(AlertType.ERROR);
					a.setContentText(e.toString());
					a.show();
				}
				event.consume();
			}
  		};
  		
  		connectButton.addEventHandler(ActionEvent.ACTION, eventHandler);
  		endButton.addEventHandler(ActionEvent.ACTION, eventHandler);
  		newGameButton.addEventHandler(ActionEvent.ACTION, eventHandler);
  		sendGameButton.addEventFilter(ActionEvent.ACTION, eventHandler);
  		receiveGameButton.addEventFilter(ActionEvent.ACTION, eventHandler);
  		sendDataButton.addEventFilter(ActionEvent.ACTION, eventHandler);
  		playButton.addEventFilter(ActionEvent.ACTION, eventHandler);

  		
		serverGUI.add(clientImageView, 2, 2, 4, 2);
		serverGUI.add(userLabel, 1, 7);
		serverGUI.add(userTextField, 2, 7);
		serverGUI.add(serverLabel, 3, 7);
		serverGUI.add(serverTextField, 4, 7);
		serverGUI.add(portLabel, 5, 7);
		serverGUI.add(portTextField, 6, 7);
		serverGUI.add(connectButton, 7, 7);
		serverGUI.add(endButton, 8, 7);
		serverGUI.add(newGameButton, 2, 8);
		serverGUI.add(sendGameButton, 3, 8);
		serverGUI.add(receiveGameButton, 4, 8, 2 ,1);
		serverGUI.add(sendDataButton, 6, 8);
		serverGUI.add(playButton, 7, 8);
		serverGUI.add(logTextArea, 1, 10, 8,8);
		serverGUI.setGridLinesVisible(false);
		return serverGUI;
	}
	
	public void start(Stage primaryStage) throws Exception{
		Client.primaryStage = primaryStage;
		primaryStage.setResizable(false);
		primaryStage.setTitle("My NumPuz Client");
		Scene scene = new Scene(getServerGUI(), 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		if (args == null) {
			portNumber = Config.DEFAULT_PORT;
			hostName = Config.DEFAULT_ADDR;
		} else if (args.length != 2) {
			hostName = Config.DEFAULT_ADDR;
			portNumber = Config.DEFAULT_PORT;
		} else {
			hostName = args[0];
			portNumber = Integer.parseInt(args[1]);
		}
		launch(args);
	}


	@Override
	public void run() {
		try {
			log.append("Connecting with server on " + hostName + " at port " + portNumber + "\n");
			log.append("Starting Server Thread on port " + portNumber + "\n");
			Socket sock = new Socket(hostName, portNumber);
			connected = true;
			BufferedReader dis = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintStream dat = new PrintStream(sock.getOutputStream());
			String strcliid = dis.readLine();
			log.append("Client ID: " + strcliid + "\n");
			dat.println(strcliid + "#P0#" + hostName);
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
			    	try {
						start(primaryStage);
					} catch (Exception e) {
						Platform.runLater(new Runnable() {
						    @Override
						    public void run() {
								a.setAlertType(AlertType.ERROR);
								a.setContentText(e.toString());
								a.show();
						    }
						});	
					}
			    }
			});
			String dim, type;
			String serverData, remainData;
			int pos;
			while (connected == true) {
				if(newGame || sendGame || receiveGame || sendData || newA12.instance.isFinished() || newA12.instance.isWon()) {
					if(newGame) {
						message.append("New Game: ");
						message.append(newA12.instance.getDim() + "#" );
						message.append(newA12.instance.getType() + "#");
						for(int i=0; i<play.length; i++) {
							for(int j=0; j<play[0].length; j++) {
								if(i==play.length-1 && j == play[0].length-1)
									message.append(play[i][j]);
								else
									message.append(play[i][j] + Config.FIELD_SEPARATOR);
							}
						}		
						log.append(message.toString()+"\n");
						message.delete(0, message.length());
						newGame = false;
					}
					if(sendGame) {
						messageP1.append(strcliid + "#P1#");
						messageP1.append(newA12.instance.getDim() + "#" );
						messageP1.append(newA12.instance.getType() + "#");
						int[][] tempSolution = newA12.instance.getSolution();
						for(int i=0; i<tempSolution.length; i++) {
							for(int j=0; j<tempSolution[0].length; j++) {
								if(i==tempSolution.length-1 && j == tempSolution[0].length-1)
									messageP1.append(tempSolution[i][j]);
								else
									messageP1.append(tempSolution[i][j] + Config.FIELD_SEPARATOR);
							}
						}
						dat.println(messageP1.toString());
						dat.flush();
						log.append("Client id[" +strcliid+ "] sent: "  + messageP1.toString()+"\n");	
						messageP1.delete(0, messageP1.length());
						sendGame = false;
					}
					else if(receiveGame) {
						dat.println(strcliid + "#P2");
						dat.flush();
						log.append("Client id[" +strcliid+ "] sent: "  + strcliid + "#P2\n");	
						serverData = dis.readLine();
						log.append("Server sent: " + serverData + "\n");
						if(serverData.length() == 4) {
							Platform.runLater(new Runnable() {
								@Override
								public void run() {
									try {
										a.setAlertType(AlertType.ERROR);
										a.setContentText("There is no configuration store on server. Please send a configuration before retrieving one.");
										a.show();
									} catch (Exception e) {
										a.setAlertType(AlertType.ERROR);
										a.setContentText(e.toString());
										a.show();
									}
								}
							});
						}
						else {
							pos = serverData.indexOf("#");
							dim = serverData.substring(0, pos);
							remainData = serverData.substring(pos+1);
							pos = remainData.indexOf("#");
							type = remainData.substring(0, pos);
							remainData = remainData.substring(pos+1);
							newA12.instance.setDim(Integer.parseInt(dim));
							newA12.instance.setType(type);
							if(type.equalsIgnoreCase("Number")) {
								newA12.instance.setSolution(null);
							}
							else {
								remainData.replace(Config.FIELD_SEPARATOR, "");
								newA12.instance.setSolution(remainData);
							}
						}					
						receiveGame = false;
					}
					else if(sendData) {
						int move = newA12.instance.getMoves();
						int point = newA12.instance.getPoints();
						int time = newA12.seconds;
						dat.println(strcliid + "#P3#" + point + "#" + move + "#" + time);
						dat.flush();
						log.append("Client id[" +strcliid+ "] sent: "  + strcliid + "#P3#" + point + "#" + move + "#" + time+ "\n");	
						sendData = false;
					}
					if(newA12.instance.isFinished() || newA12.instance.isWon()) {
						newA12.instance.setFinished(false);
						newA12.instance.setWon(false);
						playing = false;
					}
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							try {
								start(primaryStage);
							} catch (Exception e) {
								a.setAlertType(AlertType.ERROR);
								a.setContentText(e.toString());
								a.show();
							}
						}
					});
				}
				Thread.sleep(1500);	
			}
			dat.println(closeSocket);
			dat.flush();
			sock.close();
		} catch (Exception e) {
			Platform.runLater(new Runnable() {
			    @Override
			    public void run() {
					a.setAlertType(AlertType.ERROR);
					a.setContentText(e.toString());
					a.show();
			    }
			});	
		}
	}
}
