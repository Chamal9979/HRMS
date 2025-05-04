package HRMS.HuntingItems;

import HRMS.ClientSelecting.SelectingController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class HuntItemController {

    @FXML
    private Button BackI;

    @FXML
    private CheckBox Bow;

    @FXML
    private CheckBox Gun;

    @FXML
    private Button OkI;

    public AnchorPane Context;

    private SelectingController selectingController;

    public void setSelectingController(SelectingController controller) {
        this.selectingController = controller;
    }

    public void BackOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.close();
    }

    public void OkOnAction(ActionEvent actionEvent) {
        List<String> selectedItems = new ArrayList<>();
        if (Bow.isSelected()) selectedItems.add("Bow");
        if (Gun.isSelected()) selectedItems.add("Gun");

        if (selectingController != null) {
            selectingController.updateSelectedItems(selectedItems);
        }

        Stage stage = (Stage) Context.getScene().getWindow();
        stage.close();
    }
}