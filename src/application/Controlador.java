package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Controlador implements Initializable{
	@FXML
	private Pane pane1;

	@FXML
	private Pane pane2;

	@FXML
	private Pane pane3;

	@FXML
	private Pane pane4;
	
	@FXML
	private Pane panelOpaco;
	
	 @FXML
	 private AnchorPane panelMovible;
	
	 @FXML
	 private ImageView botonImagen;
	 
	 @FXML
	 private MediaView mediaView;

	
	public void initialize(URL location, ResourceBundle resources) {

		panelOpaco.setVisible(false);
		
		
		 TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),panelMovible);
	     translateTransition.setByX(-400);
	     translateTransition.play();
		
		//backgroundAnimation();
		
	     //VIDEO
         	Media media1= new Media(getClass().getResource("../images/video.mp4").toExternalForm());
	        MediaPlayer player=new MediaPlayer(media1);
	        mediaView.setMediaPlayer(player);
	        player.setVolume(0.5);
	        player.play();
         //////////////////////
         
	     
		 botonImagen.setOnMouseClicked(event -> {

	            panelOpaco.setVisible(true);
	          
	            
	            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5), panelOpaco);
	            fadeTransition1.setFromValue(0);
	            fadeTransition1.setToValue(0.6);
	            fadeTransition1.play();

	            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),panelMovible);
	            translateTransition1.setByX(+400);
	            translateTransition1.play();
	        });

		 		panelOpaco.setOnMouseClicked(event -> {

	            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5), panelOpaco);
	            fadeTransition1.setFromValue(0.6);
	            fadeTransition1.setToValue(0);
	            fadeTransition1.play();

	            fadeTransition1.setOnFinished(event1 -> {
	            	 panelOpaco.setVisible(false);
	            });

	            TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),panelMovible);
	            translateTransition1.setByX(-400);
	            translateTransition1.play();
	        });
		
		

	}
	
	 
	   
	
	private void backgroundAnimation() {

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(5),
				pane4);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		fadeTransition
				.setOnFinished(event -> {

					FadeTransition fadeTransition1 = new FadeTransition(
							Duration.seconds(3), pane3);
					fadeTransition1.setFromValue(1);
					fadeTransition1.setToValue(0);
					fadeTransition1.play();

					fadeTransition1.setOnFinished(event1 -> {
						FadeTransition fadeTransition2 = new FadeTransition(
								Duration.seconds(3), pane2);
						fadeTransition2.setFromValue(1);
						fadeTransition2.setToValue(0);
						fadeTransition2.play();

						fadeTransition2.setOnFinished(event2 -> {

							FadeTransition fadeTransition0 = new FadeTransition(
									Duration.seconds(3), pane2);
							fadeTransition0.setFromValue(0);
							fadeTransition0.setToValue(1);
							fadeTransition0.play();

							fadeTransition0.setOnFinished(event3 -> {

								FadeTransition fadeTransition11 = new FadeTransition(
										Duration.seconds(3), pane3);

								fadeTransition11.setFromValue(0);
								fadeTransition11.setToValue(1);
								fadeTransition11.play();

								fadeTransition11.setOnFinished(event4 -> {

									FadeTransition fadeTransition22 = new FadeTransition(
											Duration.seconds(3), pane4);

									fadeTransition22.setFromValue(0);
									fadeTransition22.setToValue(1);
									fadeTransition22.play();

									fadeTransition22.setOnFinished(event5 -> {

										backgroundAnimation();
									});

								});

							});

						});
					});

				});

	}
}

