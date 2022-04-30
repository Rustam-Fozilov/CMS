package com.example.cms;

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

public class deleteCourseController {
    @FXML
    private AnchorPane deleteCoursePane;

    @FXML
    private TextField nameField;

    @FXML
    private Label statusLabel;

    @FXML
    void deleteCourse(ActionEvent event) throws ClassNotFoundException, SQLException {
        if (nameField.getText().equals("")) {
            statusLabel.setText("Maydon to'ldirilishi shart");
            statusLabel.setStyle("-fx-text-fill: red");
        } else {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

                ps = con.prepareStatement("DELETE FROM courses WHERE Nomi = ?");
                ps.setString(1, nameField.getText());
                ps.executeUpdate();

                statusLabel.setText("Kurs ma'lumotlari o'chirildi");
                statusLabel.setStyle("-fx-text-fill: green");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("manage-course.fxml"));
            deleteCoursePane.getChildren().removeAll();
            deleteCoursePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
