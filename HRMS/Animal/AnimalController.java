package HRMS.Animal;

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

public class AnimalController {

    @FXML
    private CheckBox A1;

    @FXML
    private CheckBox A10;

    @FXML
    private CheckBox A2;

    @FXML
    private CheckBox A3;

    @FXML
    private CheckBox A4;

    @FXML
    private CheckBox A5;

    @FXML
    private CheckBox A6;

    @FXML
    private CheckBox A7;

    @FXML
    private CheckBox A8;

    @FXML
    private CheckBox A9;

    @FXML
    private Button BackA;

    @FXML
    private Button OkA;

    private List<String> selectedAnimals = new ArrayList<>();

    public AnchorPane Context;

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ClientSelecting/Selecting");
    }

    public void OkOnAction(ActionEvent actionEvent) throws IOException {
        selectedAnimals.clear(); // Clear previous selections
        if (A1.isSelected()) selectedAnimals.add("A1");
        if (A2.isSelected()) selectedAnimals.add("A2");
        if (A3.isSelected()) selectedAnimals.add("A3");
        if (A4.isSelected()) selectedAnimals.add("A4");
        if (A5.isSelected()) selectedAnimals.add("A5");
        if (A6.isSelected()) selectedAnimals.add("A6");
        if (A7.isSelected()) selectedAnimals.add("A7");
        if (A8.isSelected()) selectedAnimals.add("A8");
        if (A9.isSelected()) selectedAnimals.add("A9");
        if (A10.isSelected()) selectedAnimals.add("A10");

        // Navigate back to SelectingController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ClientSelecting/Selecting.fxml"));
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        SelectingController selectingController = loader.getController();
        selectingController.updateSelectedAnimals(selectedAnimals);

        stage.centerOnScreen();
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../" + location + ".fxml"))));
        stage.centerOnScreen();
    }
}
