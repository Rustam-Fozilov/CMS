package com.example.cms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateStudentController {
    @FXML
    private AnchorPane updateStudentPane;

    @FXML
    private TextField groupField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField newEmailField;

    @FXML
    private TextField oldEmailField;

    @FXML
    private TextField phoneField;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField subjectField;

    @FXML
    private TextField surnameField;

    public void updateStudent(ActionEvent actionEvent) {
        if (nameField.getText().equals("") || surnameField.getText().equals("") || phoneField.getText().equals("") || newEmailField.getText().equals("") || oldEmailField.getText().equals("") || subjectField.getText().equals("") || groupField.getText().equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
            statusLabel.setStyle("-fx-text-fill: red");
        } else {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

                ps = con.prepareStatement("UPDATE users SET Ismi = ?, Familiyasi = ?, Telefon = ?, Email = ?, Fani = ?, Guruhi = ? WHERE Email = ?");
                ps.setString(1, nameField.getText());
                ps.setString(2, surnameField.getText());
                ps.setString(3, phoneField.getText());
                ps.setString(4, newEmailField.getText());
                ps.setString(5, subjectField.getText());
                ps.setString(6, groupField.getText());
                ps.setString(7, oldEmailField.getText());
                ps.executeUpdate();

                statusLabel.setText("Student ma'lumotlari yangilandi");
                statusLabel.setStyle("-fx-text-fill: green");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("manage-student.fxml"));
            updateStudentPane.getChildren().removeAll();
            updateStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
