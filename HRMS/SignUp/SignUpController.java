package HRMS.SignUp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    public AnchorPane Context;

    public void EnterOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Login/Login");

    }

    public void ClearOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUp/SignUp");
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Login/Login");
    }
    private void setUi(String location)throws IOException {
        Stage stage =(Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
