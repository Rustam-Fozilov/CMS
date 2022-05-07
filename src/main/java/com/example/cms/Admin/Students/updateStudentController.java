package com.example.cms.Admin.Students;

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

public class updateStudentController {
    @FXML
    private AnchorPane updateStudentPane;

    @FXML
    private TextField groupField;

    @FXML
    private TextField fioField;

    @FXML
    private TextField oldPhoneField;

    @FXML
    private TextField newPhoneField;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField subjectField;

    public void updateStudent(ActionEvent actionEvent) {
        if (fioField.getText().equals("") || newPhoneField.getText().equals("") || oldPhoneField.getText().equals("") || subjectField.getText().equals("") || groupField.getText().equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
            statusLabel.setStyle("-fx-text-fill: red");
        } else {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

                ps = con.prepareStatement("UPDATE users SET FIO = ?, Telefon = ?, Fani = ?, Guruhi = ? WHERE Telefon = ?");
                ps.setString(1, fioField.getText());
                ps.setString(2, newPhoneField.getText());
                ps.setString(3, subjectField.getText());
                ps.setString(4, groupField.getText());
                ps.setString(5, oldPhoneField.getText());
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
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Students/manage-student.fxml"));
            updateStudentPane.getChildren().removeAll();
            updateStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
