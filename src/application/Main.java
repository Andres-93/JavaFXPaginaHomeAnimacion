package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private AnchorPane mypane;
	@Override
	public void start(Stage stage) {
		try {
			//Primero cargamos la vista fxml EN EL fxmlloader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPrincipal.fxml"));
			
			//Ahora sobre el panel mypane cargamos la vista que cargamos
			//en el FXMLoader
			mypane = (AnchorPane) loader.load();
			
			//añade la escena al stage y la titula
			stage.setTitle("Ejercicio Login con imagenes");
			stage.setScene(new Scene(mypane));
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
