package HRMS.StaffandUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StaffandUserController {
    public AnchorPane Context;

    public void Back1OnAction(ActionEvent actionEvent) throws IOException {
        setUi("Login/Login");
    }

    public void StaffOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Staff/Staff");
    }

    public void ClientOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Client/ClientService");
    }
    private void setUi(String location)throws IOException {
        Stage stage =(Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../"+location+".fxml"))));
        stage.centerOnScreen();
    }

}
