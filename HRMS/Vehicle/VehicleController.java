package HRMS.Vehicle;

import HRMS.ClientSelecting.SelectingController;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.List;

public class VehicleController {

    @FXML
    private Button BackV;

    @FXML
    private Button OkV;

    @FXML
    private CheckBox Vehicle1;

    @FXML
    private CheckBox Vehicle2;

    @FXML
    private CheckBox Vehicle3;

    public AnchorPane Context;

    public void OkOnAction(ActionEvent actionEvent) throws IOException {
        List<String> selectedVehicles = new ArrayList<>();
        if (Vehicle1.isSelected()) {
            selectedVehicles.add("Vehicle1");
        }
        if (Vehicle2.isSelected()) {
            selectedVehicles.add("Vehicle2");
        }
        if (Vehicle3.isSelected()) {
            selectedVehicles.add("Vehicle3");
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ClientSelecting/Selecting.fxml"));
        AnchorPane pane = loader.load();
        SelectingController controller = loader.getController();
        controller.updateSelectedVehicles(selectedVehicles);

        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(pane));
        stage.centerOnScreen();
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ClientSelecting/Selecting");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
