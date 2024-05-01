package HRMS.ClientSelecting;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

/**
 * FXML Controller class
 *
 * @author DELL LATITUDE E7440
 */
public class SelectingController {
    public AnchorPane Context;

    public void Back3OnAction(ActionEvent actionEvent) throws IOException {
        setUi("Login/Login");
    }

    public void MapOnAction(ActionEvent actionEvent) throws IOException {
        setUi("MapSelecting/MapSelecting");
    }

    public void VehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Vehicle/Vehicle");
    }

    public void AnimalOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Animal/Animal");
    }

    public void ItemsOnAction(ActionEvent actionEvent) throws IOException {
        setUi("HuntingItems/HuntItems");
    }

    public void ClearOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ClientSelecting/Selecting");
    }
    public void SubmitOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StaffandUser/StaffandUser");
    }
    public void BookingOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Booking/Booking");
    }

    private void setUi(String location)throws IOException {
        Stage stage =(Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../"+location+".fxml"))));
        stage.centerOnScreen();
    }



}