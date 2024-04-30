package HRMS.HuntingItems;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL LATITUDE E7440
 */
public class HuntItemController {
    public AnchorPane Context;


    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ClientSelecting/Selecting");
    }

    public void OkOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ClientSelecting/Selecting");
    }

    private void setUi(String location)throws IOException {
        Stage stage =(Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../"+location+".fxml"))));
        stage.centerOnScreen();
    }
}