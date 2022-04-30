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

public class updateCourseController {
    @FXML
    private TextField durationField;

    @FXML
    private TextField newNameField;

    @FXML
    private TextField oldNameField;

    @FXML
    private TextField priceField;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField teacherField;

    @FXML
    private AnchorPane updateCoursePane;

    boolean isNumeric = false;

    public void updateCourse(ActionEvent actionEvent) throws ClassNotFoundException, IOException {
        for (int i = 0; i < priceField.getText().length(); i++) {
            if (Character.isDigit(priceField.getText().charAt(i))) {
                isNumeric = true;
            }
        }

        if (newNameField.getText().equals("") || oldNameField.getText().equals("") || durationField.getText().equals("") || teacherField.getText().equals("") || priceField.getText().equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
            statusLabel.setStyle("-fx-text-fill: red");
        } else if (isNumeric) {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

                ps = con.prepareStatement("UPDATE courses SET Nomi = ?, Davomiyligi = ?, Oqituvchi = ?, Narxi = ? WHERE Nomi = ?");
                ps.setString(1, newNameField.getText());
                ps.setString(2, durationField.getText());
                ps.setString(3, teacherField.getText());
                ps.setInt(4, Integer.parseInt(priceField.getText()));
                ps.setString(5, oldNameField.getText());
                ps.executeUpdate();

                statusLabel.setText("Kurs ma'lumotlari yangilandi");
                statusLabel.setStyle("-fx-text-fill: green");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            statusLabel.setText("Ma'lumotlarni to'g'ri kiriting");
            statusLabel.setStyle("-fx-text-fill: red");
        }
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("manage-course.fxml"));
            updateCoursePane.getChildren().removeAll();
            updateCoursePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
