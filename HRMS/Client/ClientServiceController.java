package HRMS.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientServiceController {
    public AnchorPane Context;

    public void EnterOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ClientSelecting/Selecting");
    }

    public void ClearOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Client/ClientService");
    }
    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StaffandUser/StaffandUser");
    }
    private void setUi(String location)throws IOException {
        Stage stage =(Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../"+location+".fxml"))));
        stage.centerOnScreen();
    }


}
