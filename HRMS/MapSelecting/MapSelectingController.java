package HRMS.MapSelecting;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MapSelectingController {
    public AnchorPane Context;
    public void BackOnActing(ActionEvent actionEvent) throws IOException {
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
