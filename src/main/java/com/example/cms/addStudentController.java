package com.example.cms;

import com.example.cms.Database.Database;
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

public class addStudentController {
    @FXML
    private AnchorPane addStudentPane;

    @FXML
    private TextField emailField;

    @FXML
    private TextField groupField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField subjectField;

    @FXML
    private TextField surnameField;

    public void addStudent(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if (nameField.getText().equals("") || surnameField.getText().equals("") || phoneField.getText().equals("") || emailField.getText().equals("") || subjectField.getText().equals("") || groupField.getText().equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
            statusLabel.setStyle("-fx-text-fill: red");
        } else {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

                ps = con.prepareStatement("INSERT INTO users (Ismi, Familiyasi, Telefon, Email, Fani, Guruhi) VALUES (?, ?, ?, ?, ?, ?)");

                ps.setString(1, nameField.getText());
                ps.setString(2, surnameField.getText());
                ps.setString(3, phoneField.getText());
                ps.setString(4, emailField.getText());
                ps.setString(5, subjectField.getText());
                ps.setString(6, groupField.getText());
                ps.executeUpdate();

                statusLabel.setText("Muvaffaqiyatli qo'shildi");
                statusLabel.setStyle("-fx-text-fill: green");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("manage-student.fxml"));
            addStudentPane.getChildren().removeAll();
            addStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
