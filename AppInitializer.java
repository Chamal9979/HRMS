import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args){
    launch(args);
    }
    public void start(Stage primaryStage) throws Exception{
        URL resource = getClass().getResource("HRMS/Login/Login.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Hunting Resource Management System");
    }
}
