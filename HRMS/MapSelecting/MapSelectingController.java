package HRMS.MapSelecting;

import HRMS.ClientSelecting.SelectingController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MapSelectingController {

    @FXML
    private Button BackM;

    @FXML
    private CheckBox Map1;

    @FXML
    private CheckBox Map2;

    @FXML
    private CheckBox Map3;

    @FXML
    private CheckBox Map4;

    @FXML
    private Button OkM;

    public AnchorPane Context;

    private SelectingController selectingController;

    public void setSelectingController(SelectingController controller) {
        this.selectingController = controller;
    }

    public void BackOnActing(ActionEvent actionEvent) {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.close();
    }

    public void OkOnAction(ActionEvent actionEvent) {
        List<String> selectedMaps = new ArrayList<>();
        if (Map1.isSelected()) selectedMaps.add("Map1");
        if (Map2.isSelected()) selectedMaps.add("Map2");
        if (Map3.isSelected()) selectedMaps.add("Map3");
        if (Map4.isSelected()) selectedMaps.add("Map4");

        if (selectingController != null) {
            selectingController.updateSelectedMaps(selectedMaps);
        }

        Stage stage = (Stage) Context.getScene().getWindow();
        stage.close();
    }
}