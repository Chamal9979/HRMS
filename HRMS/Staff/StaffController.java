package HRMS.Staff;

import HRMS.dbconnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;  // Import ObservableList here
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    @FXML
    private AnchorPane Context;

    @FXML
    private Button booking;

    @FXML
    private ImageView staffback;

    @FXML
    private TableView<UserSelection> orderDetailsTable;

    @FXML
    private TableColumn<UserSelection, String> usernameColumn;

    @FXML
    private TableColumn<UserSelection, String> animalTypeColumn;

    @FXML
    private TableColumn<UserSelection, String> mapTypeColumn;

    @FXML
    private TableColumn<UserSelection, String> itemTypeColumn;

    @FXML
    private TableColumn<UserSelection, String> vehicleTypeColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        animalTypeColumn.setCellValueFactory(new PropertyValueFactory<>("animalType"));
        mapTypeColumn.setCellValueFactory(new PropertyValueFactory<>("mapType"));
        itemTypeColumn.setCellValueFactory(new PropertyValueFactory<>("itemType"));
        vehicleTypeColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
    }

    @FXML
    public void BackOnAction(MouseEvent actionEvent) throws IOException {
        setUi("StaffandUser/StaffandUser");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    @FXML
    void showOnAction(ActionEvent event) {
        loadOrderDetails();
    }

    private void loadOrderDetails() {
        try (Connection connectdb = new dbconnect().getConnection();
             Statement statement = connectdb.createStatement()) {

            String query = "SELECT * FROM orderdetails";
            ResultSet resultSet = statement.executeQuery(query);

            ObservableList<UserSelection> orderDetailsList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String animalType = resultSet.getString("animal_type");
                String mapType = resultSet.getString("map_type");
                String itemType = resultSet.getString("item_type");
                String vehicleType = resultSet.getString("vehicle_type");

                orderDetailsList.add(new UserSelection(username, animalType, mapType, itemType, vehicleType));
            }

            orderDetailsTable.setItems(orderDetailsList);

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}
