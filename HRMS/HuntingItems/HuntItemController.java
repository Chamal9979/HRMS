package HRMS.HuntingItems;
import HRMS.ClientSelecting.SelectingController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.io.IOException;
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

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ClientSelecting/Selecting");
    }

    public void OkOnAction(ActionEvent actionEvent) throws IOException {
        List<String> selectedItems = new ArrayList<>();
        if (Bow.isSelected()) {
            selectedItems.add("Bow");
        }
        if (Gun.isSelected()) {
            selectedItems.add("Gun");
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ClientSelecting/Selecting.fxml"));
        AnchorPane pane = loader.load();
        SelectingController controller = loader.getController();
        controller.updateSelectedItems(selectedItems);

        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(pane));
        stage.centerOnScreen();
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
