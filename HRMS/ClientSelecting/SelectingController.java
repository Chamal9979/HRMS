package HRMS.ClientSelecting;

import HRMS.dbconnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SelectingController implements Initializable {

    @FXML
    private Button Animal;

    @FXML
    private TableColumn<UserSelection, String> AnimalsT;

    @FXML
    private Button Back3;

    @FXML
    private Button Booking;

    @FXML
    private Button Clear;

    @FXML
    private Button Items;

    @FXML
    private TableColumn<UserSelection, String> ItemsT;

    @FXML
    private Button Map;

    @FXML
    private TableColumn<UserSelection, String> MapT;

    @FXML
    private Button Submit;

    @FXML
    private TableColumn<UserSelection, String> UsernameT;

    @FXML
    private Button Vehicle;

    @FXML
    private TableColumn<UserSelection, String> VehicleT;

    @FXML
    private TableView<UserSelection> tableView;

    public AnchorPane Context;


    private static ObservableList<UserSelection> permanentData = FXCollections.observableArrayList();


    private String username = "";
    private String selectedAnimal = "";
    private String selectedMap = "";
    private String selectedItem = "";
    private String selectedVehicle = "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UsernameT.setCellValueFactory(new PropertyValueFactory<>("username"));
        AnimalsT.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        MapT.setCellValueFactory(new PropertyValueFactory<>("mapType"));
        ItemsT.setCellValueFactory(new PropertyValueFactory<>("itemType"));
        VehicleT.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));


        tableView.setItems(permanentData);
    }


    public void setUsername(String username) {
       this.username = username;

        addUserRow();
    }

    private void addUserRow() {
        if (!username.isEmpty()) {
            permanentData.add(new UserSelection(username, "", "", "", ""));
            tableView.refresh();
        }
    }



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
        permanentData.clear();
        tableView.getItems().clear();
    }

    public void SubmitOnAction(ActionEvent actionEvent) throws IOException {
        if (insertData()) {
            System.out.println("Data inserted successfully!");

            permanentData.clear();
            tableView.getItems().clear();
        } else {
            System.out.println("Failed to insert data!");

        }
    }

    public void BookingOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Booking/Booking");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    // Update methods to add to permanentData
    public void updateSelectedAnimals(List<String> selectedAnimals) {
        if (!selectedAnimals.isEmpty()) {
            selectedAnimal = selectedAnimals.get(0);
            updateData();
        }
    }

    public void updateSelectedMaps(List<String> selectedMaps) {
        for (String mapType : selectedMaps) {
            selectedMap = mapType;
            updateData();
        }
    }

    public void updateSelectedItems(List<String> selectedItems) {
        for (String itemType : selectedItems) {
            selectedItem = itemType;
            updateData();
        }
    }

    public void updateSelectedVehicles(List<String> selectedVehicles) {
        for (String vehicleType : selectedVehicles) {
            selectedVehicle = vehicleType;
            updateData();
        }
    }

    private void updateData() {
        for (UserSelection userSelection : permanentData) {
            if (userSelection.getUsername().equals(username)) {
                if (!selectedAnimal.isEmpty()) {
                    userSelection.setAnimalType(selectedAnimal);
                }
                if (!selectedMap.isEmpty()) {
                    userSelection.setMapType(selectedMap);
                }
                if (!selectedItem.isEmpty()) {
                    userSelection.setItemType(selectedItem);
                }
                if (!selectedVehicle.isEmpty()) {
                    userSelection.setVehicleType(selectedVehicle);
                }
                tableView.refresh();
                return;
            }
        }


        permanentData.add(new UserSelection(username, selectedAnimal, selectedMap, selectedItem, selectedVehicle));
        tableView.refresh();
    }

    public static class UserSelection {
        private String username;
        private String animalType;
        private String mapType;
        private String itemType;
        private String vehicleType;

        public UserSelection(String username, String animalType, String mapType, String itemType, String vehicleType) {
            this.username = username;
            this.animalType = animalType;
            this.mapType = mapType;
            this.itemType = itemType;
            this.vehicleType = vehicleType;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAnimalType() {
            return animalType;
        }

        public void setAnimalType(String animalType) {
            this.animalType = animalType;
        }

        public String getMapType() {
            return mapType;
        }

        public void setMapType(String mapType) {
            this.mapType = mapType;
        }

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }
    }

    private boolean insertData() {
        try (Connection connectdb = new dbconnect().getConnection()) {
            // Check if orderdetails table exists, if not, create it
            String createTableQuery = "CREATE TABLE IF NOT EXISTS orderdetails (\n" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    username VARCHAR(255),\n" +
                    "    vehicle_type VARCHAR(255),\n" +
                    "    item_type VARCHAR(255),\n" +
                    "    animal_type VARCHAR(255),\n" +
                    "    map_type VARCHAR(255)\n" +
                    ")";
            try (PreparedStatement createTableStmt = connectdb.prepareStatement(createTableQuery)) {
                createTableStmt.executeUpdate();
            }


            String insertDataQuery = "INSERT INTO orderdetails (username, vehicle_type, item_type, animal_type, map_type) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = connectdb.prepareStatement(insertDataQuery)) {
                for (UserSelection userSelection : permanentData) {
                    insertStmt.setString(1, userSelection.getUsername());
                    insertStmt.setString(2, userSelection.getVehicleType());
                    insertStmt.setString(3, userSelection.getItemType());
                    insertStmt.setString(4, userSelection.getAnimalType());
                    insertStmt.setString(5, userSelection.getMapType());

                    insertStmt.addBatch();
                }

                int[] rowsAffected = insertStmt.executeBatch();
                return rowsAffected.length > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
