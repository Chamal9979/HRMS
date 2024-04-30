package HRMS.Login;

import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginController {
    public AnchorPane Context;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException{
        setUi("StaffandUser/StaffandUser");
    }

    public void ClearOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Login/Login");
    }

    private void setUi(String location)throws IOException{
        Stage stage =(Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../"+location+".fxml"))));
        stage.centerOnScreen();
    }

}
