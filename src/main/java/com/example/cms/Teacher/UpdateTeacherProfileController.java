package com.example.cms.Teacher;

import com.example.cms.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTeacherProfileController {
    @FXML
    private TextField fioField;

    @FXML
    private TextField groupField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField subjectField;

    @FXML
    private Label statusLabel;

    @FXML
    private AnchorPane updateProfilePane;

    @FXML
    private TextField usernameField;

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void updateProfile(ActionEvent actionEvent) {
        String fio = fioField.getText();
        String group = groupField.getText();
        String password = passwordField.getText();
        String phone = phoneField.getText();
        String subject = subjectField.getText();
        String username = usernameField.getText();

        if (fio.equals("") || group.equals("") || password.equals("") || phone.equals("") || subject.equals("") || username.equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Teacher/teacher-profile.fxml"));
                Parent root = loader.load();
                TeacherProfileController teacherProfileController = loader.getController();
                teacherProfileController.getUpdate(fio, phone, subject, username, password);
                updateInDatabase();

                updateProfilePane.getChildren().removeAll();
                updateProfilePane.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateInDatabase(){
        if (fioField.getText().equals("") || groupField.getText().equals("") || passwordField.getText().equals("") || phoneField.getText().equals("") || subjectField.getText().equals("") || usernameField.getText().equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
        } else {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1234");

                ps = con.prepareStatement("UPDATE teachers SET FIO = ?, Telefon = ?, Fani = ?, username = ?, parol = ? WHERE TeacherId = ?");
                ps.setString(1, fioField.getText());
                ps.setString(2, phoneField.getText());
                ps.setString(3, subjectField.getText());
                ps.setString(4, usernameField.getText());
                ps.setString(5, passwordField.getText());
                ps.setInt(6, getId());
                ps.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }

    }
}
