package HRMS.MapSelecting;

import HRMS.ClientSelecting.SelectingController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.io.IOException;
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

    public void BackOnActing(ActionEvent actionEvent) throws IOException {
        setUi("ClientSelecting/Selecting");
    }

    public void OkOnAction(ActionEvent actionEvent) throws IOException {
        List<String> selectedMaps = new ArrayList<>();
        if (Map1.isSelected()) {
            selectedMaps.add("Map1");
        }
        if (Map2.isSelected()) {
            selectedMaps.add("Map2");
        }
        if (Map3.isSelected()) {
            selectedMaps.add("Map3");
        }
        if (Map4.isSelected()) {
            selectedMaps.add("Map4");
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ClientSelecting/Selecting.fxml"));
        AnchorPane pane = loader.load();
        SelectingController controller = loader.getController();
        controller.updateSelectedMaps(selectedMaps);

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
