package com.example.cms;

import com.example.cms.JDBC.AdminInformation;
import com.example.cms.JDBC.Database;
import com.example.cms.JDBC.TeacherInformation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class LoginController {
    @FXML
    private Label label;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField uname;

    @FXML
    private PasswordField passwd;

    public void accessToLogin() throws IOException, ClassNotFoundException {
        Database database = new Database();
        database.getAdminInformation();
        database.getTeacherInformation();

        String username = uname.getText();
        String password = passwd.getText();

        ArrayList<AdminInformation> adminsInformation = database.getAdminsInformation();
        ArrayList<TeacherInformation> teachersInformation = database.getTeachersInformation();

        boolean isLogged = true;

        for (AdminInformation admin : adminsInformation) {
            if (admin.getUsername().equals(username) && admin.getParol().equals(password)) {
                btnLogin.getScene().getWindow().hide();
                Stage login = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("admin-menu.fxml")));
                Scene scene = new Scene(root);
                login.setTitle("Admin panel");
                login.setResizable(false);
                login.setScene(scene);
                login.show();
            } else {
                isLogged = false;
            }
        }

        for (TeacherInformation teacher : teachersInformation) {
            if (teacher.getUsername().equals(username) && teacher.getParol().equals(password)) {
                btnLogin.getScene().getWindow().hide();
                Stage login = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("teacher-menu.fxml")));
                Scene scene = new Scene(root);
                login.setTitle("Teacher panel");
                login.setResizable(false);
                login.setScene(scene);
                login.show();
            } else {
                isLogged = false;
            }
        }

        if (!isLogged) {
            label.setText("username yoki parol xato :(");
            label.setStyle("-fx-text-fill: red");
        }
    }
}
