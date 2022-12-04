package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import config.Config;

public class Server extends Application implements Runnable{
	
	public static boolean listening = false;
	Alert a = new Alert(AlertType.NONE);
	public class Player{
		public Player() {};
		String name, data;
		int id, point, time, move;	
	}
	
	/**
	 * User list
	 */
	static ArrayList<Player> playerList = new ArrayList<Player>(10);
	/**
	 * Primary stage
	 */
	static Stage primaryStage;
	
	/**
	 * Number of port.
	 */
	static int portNumber = 0;
	
	/**
	 * Socket variable.
	 */
	Socket sock;
	
	/**
	 * Server socket.
	 */
	static ServerSocket servsock;
	
	public Server() {
		; // No commands.
	}
	
	/**
	 * Variables for number clients.
	 */
	static int nclient = 0, nclients = 0;
	
	/**
	 * Variables for finalizing.
	 */
	static boolean finalize = false;
	
	/**
	 * log messages
	 */
	static StringBuilder log = new StringBuilder("");
	
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
       
        
		Image serverImage = new Image(getClass().getResourceAsStream("/images/serverImage.png"));
		ImageView serverImageView = new ImageView(serverImage); 
		serverImageView.setFitHeight(300); 
		serverImageView.setFitWidth(490); 
		serverImageView.setPreserveRatio(true);
		
		Label portLabel = new Label("Port:");
		portLabel.setPadding(new Insets(0, 0, 0, 55));
		portLabel.setStyle("-fx-font-weight: bold");
		
		TextField portTextField = new TextField(Integer.toString(Config.DEFAULT_PORT));
		portTextField.setMaxWidth(70);
		
		Button startButton = new Button("Start");
		startButton.setMaxWidth(70);
		startButton.setDisable(listening);
		
		Button resultsButton = new Button("Results");
		resultsButton.setMaxWidth(70);
		resultsButton.setDisable(!listening);
		
		CheckBox finalizeCheckBox = new CheckBox("Finalize");
		finalizeCheckBox.setSelected(finalize);
		
		Button endButton = new Button("End");
		endButton.setMaxWidth(70);
		
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
				if(event.getSource() == startButton) { // dim is changed 					    	
					try {
						log.append("Starting Server Thread on port " + portNumber + "\n");
						servsock = new ServerSocket(portNumber);
						Thread servDaemon = new Thread(new Server());
						servDaemon.start();
						log.append("Server running on " + InetAddress.getLocalHost() + " at port " + portNumber + "!\n");
					} catch (Exception e) {
						a.setAlertType(AlertType.ERROR);
						a.setContentText("Error: " + e.toString());
						a.show();
					}
					listening = true;
					
				}
				if(event.getSource() == resultsButton) {
					try {
						a.setAlertType(AlertType.INFORMATION);
						StringBuilder temp = new StringBuilder();
						temp.append("Game results:\n");
						for(int i = 0; i<playerList.size(); i++) {
							temp.append("Player[" + playerList.get(i).id + "]: " + playerList.get(i).name +", points: "+ playerList.get(i).point + ", move: " + playerList.get(i).move + ", time: "+ playerList.get(i).time + "\n");						
						}
						a.setContentText(temp.toString());
						a.show();
					} catch (Exception e) {
						a.setAlertType(AlertType.ERROR);
						a.setContentText(e.toString());
						a.show();
					}
				}
				if(event.getSource() == finalizeCheckBox) {
					finalize = !finalize;
				}
				if(event.getSource() == endButton) { 
					log.append("Ending server...\n");	
					try {
						Server.this.start(primaryStage);
						Thread.sleep(2000);
					} catch (Exception e) {
						a.setAlertType(AlertType.ERROR);
						a.setContentText(e.toString());
						a.show();
					}
					System.exit(0);
				}
				try {
					Server.this.start(primaryStage);
				} catch (Exception e) {
					a.setAlertType(AlertType.ERROR);
					a.setContentText(e.toString());
					a.show();
				}
				event.consume();
			}
  		};
  		
		startButton.addEventHandler(ActionEvent.ACTION, eventHandler);
		resultsButton.addEventHandler(ActionEvent.ACTION, eventHandler);
		finalizeCheckBox.addEventHandler(ActionEvent.ACTION, eventHandler);
		endButton.addEventHandler(ActionEvent.ACTION, eventHandler);

		serverGUI.add(serverImageView, 2, 2, 3, 2);
		serverGUI.add(portLabel, 1, 7);
		serverGUI.add(portTextField, 2, 7);
		serverGUI.add(startButton, 3, 7);
		serverGUI.add(resultsButton, 4, 7);
		serverGUI.add(finalizeCheckBox, 5, 7);
		serverGUI.add(endButton, 6, 7);
		serverGUI.add(logTextArea, 1, 8, 8,8);
		serverGUI.setGridLinesVisible(false);
		return serverGUI;
	}
	
	public void start(Stage primaryStage) throws Exception{
		Server.primaryStage = primaryStage;
		primaryStage.setResizable(false);
		primaryStage.setTitle("My NumPuz Server");
		Scene scene = new Scene(getServerGUI(), 800, 800);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
    	if (args == null) {
            portNumber = Config.DEFAULT_PORT;    		
    	} else if (args.length < 1) {
            portNumber = Config.DEFAULT_PORT;
        } else {
            portNumber = Integer.parseInt(args[0]);
        }
		launch(args);
	}
	
	@Override
	public void run() {
		for (;;) {
			try {
				sock = servsock.accept();
				nclient += 1;
				nclients += 1;
				log.append("Connecting " + sock.getInetAddress() + " at port " + sock.getPort() + ".\n");
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	try {
							Server.this.start(primaryStage);
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
			} catch (IOException ioe) {
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
						a.setAlertType(AlertType.ERROR);
						a.setContentText(ioe.toString());
						a.show();
				    }
				});	
			}
			Worked w = new Worked(sock, nclient);
			w.start();
		}
	}
	
	/**
	 * Inner class for Theads.
	 * @author sousap
	 *
	 */
	class Worked extends Thread {
		
		/**
		 * Socket variable.
		 */
		Socket sock;
		
		/**
		 * Integers for client and positions.
		 */
		int clientid, poscerq;
		
		/**
		 * String for data.
		 */
		String strcliid, remainData, protocal, point, move;

		/**
		 * Default constructor.
		 * @param s Socket
		 * @param nclient Number of client.
		 */
		public Worked(Socket s, int nclient) {
			sock = s;
			clientid = nclient;
		}

		/**
		 * Run method.
		 */
		public void run() {
			String data;
			PrintStream out = null;
			BufferedReader in;
			try {
				out = new PrintStream(sock.getOutputStream());
				in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				out.println(clientid);
				if(playerList.size() == clientid-1)
					playerList.add(new Player());	
				playerList.get(clientid-1).id = clientid;		
				data = in.readLine();
				while (!data.equals("close")) {
					log.append("Client[" + clientid + "] sent: " + data + "\n");
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
					    	try {
								Server.this.start(primaryStage);
							} catch (Exception e) {
								a.setAlertType(AlertType.ERROR);
								a.setContentText(e.toString());
								a.show();
							}
					    }
					});	
					poscerq = data.indexOf(Config.PROTOCOL_SEPARATOR);
					strcliid = data.substring(0, poscerq);
					remainData = data.substring(poscerq+1);
					poscerq = remainData.indexOf(Config.PROTOCOL_SEPARATOR);
					if(poscerq!= -1)
						protocal = remainData.substring(0, poscerq);
					else
						protocal = remainData;
					switch(protocal) {
					case Config.PROTOCOL_HI:
						remainData = remainData.substring(poscerq+1);
						playerList.get(clientid-1).name = remainData;
						break;
					case Config.PROTOCOL_SENDGAME:
						remainData = remainData.substring(poscerq+1);
						playerList.get(clientid-1).data = remainData;
						break;
					case Config.PROTOCOL_RECVGAME:
						String dat = playerList.get(clientid-1).data;
						out.println(dat);
						break;
					case Config.PROTOCOL_DATA:
						remainData = remainData.substring(poscerq+1);
						poscerq = remainData.indexOf(Config.PROTOCOL_SEPARATOR);
						point = remainData.substring(0,poscerq);
						remainData = remainData.substring(poscerq+1);
						poscerq = remainData.indexOf(Config.PROTOCOL_SEPARATOR);
						move = remainData.substring(0,poscerq);
						remainData = remainData.substring(poscerq+1);
						playerList.get(clientid-1).point = Integer.parseInt(point);
						playerList.get(clientid-1).move = Integer.parseInt(move);
						playerList.get(clientid-1).time = Integer.parseInt(remainData);
						break;
					default:
						break;
					}
					data = in.readLine();
					Thread.sleep(1500);
				}
				log.append("Disconecting Client[" + clientid + "]: "+ playerList.get(clientid-1).name +"!\n");
				nclients -= 1;
				log.append("Current client number: " + nclients + "\n");
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
				    	try {
							Server.this.start(primaryStage);
						} catch (Exception e) {
							a.setAlertType(AlertType.ERROR);
							a.setContentText(e.toString());
							a.show();
						}
				    }
				});			
				if (nclients == 0 && finalize == true) {
					log.append("Ending server...\n");
					sock.close();
					Platform.runLater(new Runnable() {
					    @Override
					    public void run() {
					    	try {
								Server.this.start(primaryStage);
							} catch (Exception e) {
								a.setAlertType(AlertType.ERROR);
								a.setContentText(e.toString());
								a.show();
							}
					    }
					});		
					Thread.sleep(2000);
					System.exit(0);
				}
			} catch (IOException ioe) {
				Platform.runLater(new Runnable() {
				    @Override
				    public void run() {
						a.setAlertType(AlertType.ERROR);
						a.setContentText(ioe.toString());
						a.show();
				    }
				});		
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

}
