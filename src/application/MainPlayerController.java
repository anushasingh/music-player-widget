package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.logging.Logger;

import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainPlayerController implements Initializable {
	@FXML
	private Button dummy;
	@FXML
	private ImageView speaker;
	
	@FXML
	private ImageView speaker2;
	
	@FXML
	private ImageView bars;
	
	
	@FXML
	private ImageView playi;
	
	@FXML
	private ImageView stopi;
	
	@FXML
	private ImageView openi;
	
	@FXML
	private ImageView closei;
	
	
	
	
	 private Stage stage;
	  private String audioFile = null;
	    private MediaPlayer player;
	    private Boolean fileinuse = false;
	    private boolean flag=false;
	    Label musicLabel = new Label("No File");
	
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
       //  File file = new File("src/images/dd.gif");
        //     Image image = new Image(file.toURI().toString());
            speaker.setImage(new Image("/images/dd.gif"));
            speaker2.setImage(new Image("/images/dd.gif"));
         //   File file2 = new File("src/images/ee.gif");
           // Image image2 = new Image(file2.toURI().toString());
           bars.setImage(new Image("/images/ee.gif"));
//            Image image = new Image(getClass().getResourceAsStream("/src/images/dd.gif"));
//            speaker.setImage(image);
//          //  String path = file.getAbsolutePath();
//            bars.setImage(new Image(getClass().getResourceAsStream("src/images/ee.gif")));
//            
//            
//            
//            try {
//                InputStream inputStream = new FileInputStream(path);
//                Image image2 = new Image(inputStream);
//               speaker.setImage(image2);
//            } catch (FileNotFoundException ex) {
//               // Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null, ex);
//            }
            
            flag=true;
            
    }
    
    public void pauseFile(){
            player.pause();
            flag=false;
            speaker.setImage(null);
         //   File file = new File("src/images/speakerstop.png");
       //     Image image = new Image(file.toURI().toString());
      
            speaker.setImage(new Image("/images/speakerstop.png"));
            speaker2.setImage(new Image("/images/speakerstop.png"));
            
        //    File file2 = new File("src/images/barsstop.png");
       //     Image image2 = new Image(file2.toURI().toString());
           bars.setImage(new Image("/images/barsstop.png"));
           
         
           
           
    }
    
    public void stopFile(){
            player.stop();
            flag=false;
          //  File file = new File("src/images/speakerstop.png");
          //  Image image = new Image(file.toURI().toString());
      
            speaker.setImage(new Image("/images/speakerstop.png"));
            speaker2.setImage(new Image("/images/speakerstop.png"));
        //    File file2 = new File("src/images/barsstop.png");
        //    Image image2 = new Image(file2.toURI().toString());
           bars.setImage(new Image("/images/barsstop.png"));
       //    File file3 = new File("src/images/play2.png");
       //    Image image3 = new Image(file3.toURI().toString());
         playi.setImage(new Image("/images/play2.png"));
    }
public void playpause()
{
	if(flag==true)
	{
		this.pauseFile();
		
		  File file4 = new File("src/images/play2.png");
          Image image4 = new Image(file4.toURI().toString());
        playi.setImage(new Image("/images/play2.png"));
	}
	else
	{
		this.playFile();
		  File file3 = new File("src/images/pause.png");
          Image image3 = new Image(file3.toURI().toString());
        playi.setImage(new Image("/images/pause.png"));
	}
}
    
    
    
    
//    chooseButton.setOnAction((ActionEvent e) -> {
//        try {
//            this.chooseFile();
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    });
//    
//    playButton.setOnAction((ActionEvent e) -> {
//        this.playFile();
//    });
//    
//    pauseButton.setOnAction((ActionEvent e) -> {
//        this.pauseFile();
//    });
//    
//    stopButton.setOnAction((ActionEvent e) -> {
//        this.stopFile();
//    });

	@FXML
	private void closeButtonAction(){
	    // get a handle to the stage
	    Stage stage = (Stage) dummy.getScene().getWindow();
	    // do what you have to do
	    
	    stage.close();
	    
	    
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//File file = new File("src/dd.gif");
      //  Image image = new Image(file.toURI().toString());
      //  imageView.setImage(image);
     //   Animation ani = new AnimatedGif(getClass().getResource("src/dd.gif").toExternalForm(), 1000);

//	Stage stage = new Stage();
//		stage.initModality(Modality.WINDOW_MODAL);
//		stage.initOwner(pane.getScene().getWindow());
//		stage.setScene(new Scene(content));
//		stage.show();
		//Stage currentStage = (Stage)close.getScene().getWindow();
	//	stage.initOwner(currentStage);
	//	currentStage.initStyle(StageStyle.UNDECORATED);

		playi.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				playi.setFitWidth(30);
				playi.setFitHeight(19);
			}

		});
		playi.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				playi.setFitWidth(25);
				playi.setFitHeight(17);
			}

		});
		
		stopi.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				stopi.setFitWidth(21);
				stopi.setFitHeight(20);
			}

		});
		stopi.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				stopi.setFitWidth(19);
				stopi.setFitHeight(18);
			}

		});
		
		openi.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				openi.setFitWidth(21);
				openi.setFitHeight(22);
			}

		});
		openi.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				openi.setFitWidth(19);
				openi.setFitHeight(20);
			}

		});
		
		closei.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				closei.setFitWidth(27);
				closei.setFitHeight(20);
			}

		});
		closei.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				closei.setFitWidth(25);
				closei.setFitHeight(18);
				
			}

		});
		
		
		
		
		
	}
	
	
	
}
