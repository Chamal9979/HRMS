package HRMS.SignUp;

import HRMS.dbconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUpController {

    @FXML
    private TextField Password2;

    @FXML
    private TextField NICNo;

    @FXML
    private TextField ContactNo;

    @FXML
    private TextField Name;

    @FXML
    private TextField Password1;

    @FXML
    private TextField Email;

    @FXML
    private TextArea Address;

    @FXML
    private Button Enter1;

    @FXML
    private Button Clear;

    @FXML
    public AnchorPane Context;

    public void EnterOnAction(ActionEvent actionEvent) throws IOException {
        if (insertData()) {
            setUi("Login/Login");
        } else {
            System.out.println("error");
        }
    }

    public void ClearOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUp/SignUp");
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Login/Login");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    private boolean insertData() {
        try (Connection connectdb = new dbconnect().getConnection()) {
            // Check if login table exists, if not, create it
            String createTableQuery = "CREATE TABLE IF NOT EXISTS UserDetails (\n" +
                    "    user_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    name VARCHAR(255) NOT NULL,\n" +
                    "    contact_no VARCHAR(15) NOT NULL,\n" +
                    "    email VARCHAR(255) UNIQUE NOT NULL,\n" +
                    "    password VARCHAR(255) NOT NULL,\n" +
                    "    address VARCHAR(255),\n" +
                    "    nic VARCHAR(15) UNIQUE NOT NULL\n" +
                    ");";
            try (PreparedStatement createTableStmt = connectdb.prepareStatement(createTableQuery)) {
                createTableStmt.executeUpdate();
            }

            // Insert user details
            String insertDataQuery = "INSERT INTO UserDetails (name, contact_no, email, password, address, nic) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertStmt = connectdb.prepareStatement(insertDataQuery)) {
                insertStmt.setString(1, Name.getText());
                insertStmt.setString(2, ContactNo.getText());
                insertStmt.setString(3, Email.getText());
                insertStmt.setString(4, Password1.getText());
                insertStmt.setString(5, Address.getText());
                insertStmt.setString(6, NICNo.getText());

                int rowsAffected = insertStmt.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
