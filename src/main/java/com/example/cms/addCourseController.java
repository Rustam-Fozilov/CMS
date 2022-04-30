package com.example.cms;

import com.example.cms.Database.AdminInformation;
import com.example.cms.Database.CourseInformation;
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
import java.util.ArrayList;

public class addCourseController {
    @FXML
    private AnchorPane addCoursePane;

    @FXML
    private TextField durationField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField teacherField;

    @FXML
    private Label statusLabel;

    boolean isNumeric = true;

    public void addCourse(ActionEvent actionEvent) throws IOException, ClassNotFoundException, SQLException {
        Database database = new Database();
        database.getCourseInformation();

        // ArrayList<CourseInformation> coursesInformation = database.getCoursesInformation();

        for (int i = 0; i < priceField.getText().length(); i++) {
            if (Character.isDigit(priceField.getText().charAt(i))) {
                isNumeric = true;
            } else {
                isNumeric = false;
            }
        }

        if (isNumeric) {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

                ps = con.prepareStatement("INSERT INTO courses (Nomi, Davomiyligi, Oqituvchi, Narxi) VALUES (?, ?, ?, ?)");

                ps.setString(1, nameField.getText());
                ps.setString(2, durationField.getText());
                ps.setString(3, teacherField.getText());
                ps.setInt(4, Integer.parseInt(priceField.getText()));
                ps.executeUpdate();

                statusLabel.setText("Muvaffaqiyatli bajarildi");
                statusLabel.setStyle("-fx-text-fill: green");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            statusLabel.setText("Xatolik bor ma'lumotlarni to'g'ri kiriting");
            statusLabel.setStyle("-fx-text-fill: red");
        }

    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("manage-course.fxml"));
            addCoursePane.getChildren().removeAll();
            addCoursePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
