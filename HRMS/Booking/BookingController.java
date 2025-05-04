package HRMS.Booking;

import HRMS.ClientSelecting.SelectingController;
import HRMS.dbconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class BookingController {

    @FXML
    private TextField usernameB;

    @FXML
    private TextField noOfPeopleB;

    @FXML
    private AnchorPane Context;

    @FXML
    private void okOnAction(ActionEvent event) {
        String username = usernameB.getText();
        String noOfPeople = noOfPeopleB.getText();

        if (!username.isEmpty() && !noOfPeople.isEmpty()) {
            if (insertBooking(username, Integer.parseInt(noOfPeople))) {
                try {
                    setUi("/HRMS/ClientSelecting/Selecting.fxml", username);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Failed to insert booking into database!");
            }
        } else {
            System.out.println("Username or Number of People is empty!");
        }
    }

    private boolean insertBooking(String username, int noOfPeople) {
        String insertQuery = "INSERT INTO booking (username, no_of_people, booking_date) VALUES (?, ?, ?)";
        try (Connection connection = new dbconnect().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, noOfPeople);
            preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void setUi(String location, String username) throws IOException {
        URL fxmlLocation = getClass().getResource(location);
        if (fxmlLocation == null) {
            throw new IOException("FXML file not found at: " + location);
        }

        System.out.println("Loading FXML from: " + fxmlLocation);
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        AnchorPane root = loader.load();
        SelectingController controller = loader.getController();
        controller.setUsername(username);

        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
    }
}