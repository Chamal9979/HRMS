package HRMS.Login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import HRMS.dbconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private PasswordField Pass;

    @FXML
    private TextField UserName;

    @FXML
    private Button LoginB;

    @FXML
    private Button SignUpB;

    public AnchorPane Context;

    public void LoginOnAction(ActionEvent actionEvent) {
        if (UserName.getText().isBlank() || Pass.getText().isBlank()) {
            System.out.println("Enter username and password correctly.\n");
        } else {
            validatelogin();
        }
    }

    public void SignUpOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SignUp/SignUp");
    }

    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        setUi("StaffandUser/StaffandUser");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) Context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    public void validatelogin() {
        String username = UserName.getText();
        String password = Pass.getText();

        try (Connection connectdb = new dbconnect().getConnection()) {

            String createTableQuery = "CREATE TABLE IF NOT EXISTS login (id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), password VARCHAR(255))";
            try (PreparedStatement createTableStmt = connectdb.prepareStatement(createTableQuery)) {
                createTableStmt.executeUpdate();
            }


            String checkAdminQuery = "SELECT COUNT(*) FROM login WHERE username = 'admin'";
            try (PreparedStatement checkAdminStmt = connectdb.prepareStatement(checkAdminQuery)) {
                try (ResultSet rs = checkAdminStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) == 0) {
                        String insertAdminQuery = "INSERT INTO login (username, password) VALUES ('admin', '12345')";
                        try (PreparedStatement insertAdminStmt = connectdb.prepareStatement(insertAdminQuery)) {
                            insertAdminStmt.executeUpdate();
                        }
                    }
                }
            }

            // Validate user credentials
            String loginQuery = "SELECT * FROM login WHERE username = ? AND password = ?";
            try (PreparedStatement loginStmt = connectdb.prepareStatement(loginQuery)) {
                loginStmt.setString(1, UserName.getText());
                loginStmt.setString(2, Pass.getText());

                try (ResultSet rs = loginStmt.executeQuery()) {
                    if (rs.next()) {
                        // Successful login
                        System.out.println("Login Successful");

                        setUi("ClientSelecting/Selecting");
                    } else {
                        // Failed login
                        System.out.println("Login Failed: Invalid credentials");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
