package HRMS.Vehicle;

import HRMS.ClientSelecting.SelectingController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    private SelectingController selectingController;

    public void setSelectingController(SelectingController controller) {
        this.selectingController = controller;
    }

    public void OkOnAction(ActionEvent actionEvent) {
        List<String> selectedVehicles = new ArrayList<>();
        if (Vehicle1.isSelected()) selectedVehicles.add("Vehicle1");
        if (Vehicle2.isSelected()) selectedVehicles.add("Vehicle2");
        if (Vehicle3.isSelected()) selectedVehicles.add("Vehicle3");

        if (selectingController != null) {
            selectingController.updateSelectedVehicles(selectedVehicles);
        }

        Stage stage = (Stage) Context.getScene().getWindow();
        stage.close();
    }

    public void BackOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.close();
    }
}