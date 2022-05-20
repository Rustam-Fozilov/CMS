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

public class deleteTeacherController {
    @FXML
    private AnchorPane deleteTeacherPane;

    @FXML
    private TextField phoneField;

    @FXML
    private Label statusLabel;

    public void deleteTeacher(ActionEvent actionEvent) {
        if (phoneField.getText().equals("")) {
            statusLabel.setText("Maydon to'ldirilishi shart");
            statusLabel.setStyle("-fx-text-fill: red");
        } else {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1234");

                ps = con.prepareStatement("DELETE FROM teachers WHERE Telefon = ?");
                ps.setString(1, phoneField.getText());
                ps.executeUpdate();

                statusLabel.setText("O'qituvchi ma'lumotlari o'chirildi");
                statusLabel.setStyle("-fx-text-fill: green");
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Teachers/manage-teacher.fxml"));
            deleteTeacherPane.getChildren().removeAll();
            deleteTeacherPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
