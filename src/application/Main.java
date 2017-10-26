package application;
	
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	
	 private Stage stage;
	    private String audioFile = null;
	    private MediaPlayer player;
	    private Boolean fileinuse = false;
	    Label musicLabel = new Label("No File");
	    private double xOffset = 0;
	    private double yOffset = 0;
	    private static class Delta {
	        double x, y;
	    }

	    final Delta dragDelta = new Delta();
	    final BooleanProperty inDrag = new SimpleBooleanProperty(false);
	    public void chooseFile() throws MalformedURLException{
	            FileChooser chooser = new FileChooser();
	            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("select your media(*.mp3)", "*.mp3");
	            chooser.getExtensionFilters().add(filter);
	            File file = chooser.showOpenDialog(this.stage);
	            if ( file !=null){
	                musicLabel.setText(file.getPath());
	                this.audioFile = file.toURI().toURL().toString();
	            }else{
	                musicLabel.setText("Invalid Filename");
	                this.audioFile = null;
	            }
	            fileinuse = false;
	            player.stop();
	    }
	    
	    public void playFile(){
	            if(fileinuse == true){
	                player.play();
	            }else{
	                Media pick = new Media(this.audioFile);
	                player = new MediaPlayer(pick);
	                player.play();   
	            }
	            fileinuse = true;
	    }
	    
	    public void pauseFile(){
	            player.pause();
	    }
	    
	    public void stopFile(){
	            player.stop();
	    }

	@Override
	public void start(Stage primaryStage) {
		 try {
			 System.out.println("AAhg");
			musicLabel.setWrapText(true);
			
			
		//this.stage.initStyle(StageStyle.TRANSPARENT);
			   this.stage = primaryStage;
//			   Stage stage=new Stage();
//			   stage.initStyle(StageStyle.UTILITY);
//			stage.setOpacity(0);
			//this.stage=primaryStage;
			    
			    
			    
			  primaryStage.initStyle(StageStyle.TRANSPARENT);

			//    StackPane stackPane = new StackPane();

//			    stackPane.setStyle(
//			        "-fx-background-color: rgba(255, 255, 255, 0.5);" +
//			        "-fx-effect: dropshadow(gaussian, red, 50, 0, 0, 0);" +
//			        "-fx-background-insets: 50;"
//			    );

			    Parent root =FXMLLoader.load(getClass().getResource("/application/MainPlayer.fxml"));
	
	   
	    
//	        StackPane root = new StackPane();
//	        Button chooseButton = new Button("Choose MP3 File");
//	        Button playButton = new Button("Play");
//	        Button pauseButton = new Button("Pause");
//	        Button stopButton = new Button("Stop");
//	        HBox hbox1 = new HBox(20, chooseButton, playButton, pauseButton, stopButton);
//	        HBox hbox2 = new HBox(musicLabel);
//	        VBox vbox = new VBox(hbox1,hbox2);
//	        
//	        chooseButton.setOnAction((ActionEvent e) -> {
//	            try {
//	                this.chooseFile();
//	            } catch (MalformedURLException ex) {
//	                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//	            }
//	        });
//	        
//	        playButton.setOnAction((ActionEvent e) -> {
//	            this.playFile();
//	        });
//	        
//	        pauseButton.setOnAction((ActionEvent e) -> {
//	            this.pauseFile();
//	        });
//	        
//	        stopButton.setOnAction((ActionEvent e) -> {
//	            this.stopFile();
//	        });
//
//	        root.getChildren().add(vbox);
			    //Scene scene = new Scene(root);
			  
			    Scene scene = new Scene(root);
			    
			
			    
			    
			    scene.getRoot().setStyle("-fx-background-color: transparent");
			  
			    root.setOnMousePressed(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
		            	dragDelta.x = primaryStage.getX() - event.getScreenX();
		                dragDelta.y = primaryStage.getY() - event.getScreenY();
		                xOffset = event.getSceneX();
		                yOffset = event.getSceneY();		            }
		        });
			    root.setOnMouseDragged(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
		            	 primaryStage.setX(event.getScreenX() + dragDelta.x);
		                 primaryStage.setY(event.getScreenY() + dragDelta.y);
		                 primaryStage.getWidth();
		                 primaryStage.getHeight();
		                 primaryStage.getX();
		                 primaryStage.getY();
		                 inDrag.set(true);
		            }
		        });

			    scene.setFill(Color.TRANSPARENT);
			   
			    primaryStage.setTitle("Music Player");
			    primaryStage.setScene(scene);
			    primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

