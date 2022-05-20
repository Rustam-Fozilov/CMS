package com.example.cms.Admin.Teachers;

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

public class addTeacherController {
    @FXML
    private AnchorPane addTeacherPane;

    @FXML
    private TextField fioField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField subjectField;

    @FXML
    private TextField groupField;

    @FXML
    private TextField usernameField;

    public void addTeacher(ActionEvent actionEvent) {
        if (fioField.getText().equals("") || phoneField.getText().equals("") || subjectField.getText().equals("") || groupField.getText().equals("") || usernameField.getText().equals("") || passwordField.getText().equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
            statusLabel.setStyle("-fx-text-fill: red");
        } else {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1234");

                ps = con.prepareStatement("INSERT INTO teachers (FIO, Telefon, Fani, Guruhi, username, parol) VALUES (?, ?, ?, ?, ?, ?)");

                ps.setString(1, fioField.getText());
                ps.setString(2, phoneField.getText());
                ps.setString(3, subjectField.getText());
                ps.setString(4, groupField.getText());
                ps.setString(5, usernameField.getText());
                ps.setString(6, passwordField.getText());
                ps.executeUpdate();

                statusLabel.setText("Muvaffaqiyatli qo'shildi");
                statusLabel.setStyle("-fx-text-fill: green");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Teachers/manage-teacher.fxml"));
            addTeacherPane.getChildren().removeAll();
            addTeacherPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
