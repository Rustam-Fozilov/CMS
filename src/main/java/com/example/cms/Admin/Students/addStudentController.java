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

public class addStudentController {
    @FXML
    private AnchorPane addStudentPane;

    @FXML
    private TextField groupField;

    @FXML
    private TextField phoneField;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField subjectField;

    @FXML
    private TextField fioField;

    public void addStudent(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if (fioField.getText().equals("") || phoneField.getText().equals("") || subjectField.getText().equals("") || groupField.getText().equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
            statusLabel.setStyle("-fx-text-fill: red");
        } else {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

                ps = con.prepareStatement("INSERT INTO users (FIO, Telefon, Fani, Guruhi) VALUES (?, ?, ?, ?)");

                ps.setString(1, fioField.getText());
                ps.setString(2, phoneField.getText());
                ps.setString(3, subjectField.getText());
                ps.setString(4, groupField.getText());
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
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Students/manage-student.fxml"));
            addStudentPane.getChildren().removeAll();
            addStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
