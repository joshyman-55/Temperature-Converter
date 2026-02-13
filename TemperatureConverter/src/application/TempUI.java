package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TempUI extends Application {

	@SuppressWarnings("exports")
	@Override
    public void start(Stage stage) {
        TempLayout root = new TempLayout();
        
        Scene scene = new Scene(root, 350, 400);
        
        stage.setTitle("Temperature Converter"); 
        stage.setScene(scene);                      
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
