package com.example.cms.Teacher.Payment;

import com.example.cms.Database.CourseInformation;
import com.example.cms.Database.Database;
import com.example.cms.Database.UserInformation;
import com.example.cms.HelloApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MakePaymentController implements Initializable {
    @FXML
    private ComboBox courseComb;

    @FXML
    private ComboBox fioComb;

    @FXML
    private AnchorPane makePaymentPane;

    @FXML
    private ComboBox monthComb;

    @FXML
    private TextField priceField;

    @FXML
    private Label statusLabel;

    private boolean isNumeric = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Database db = new Database();
            db.getUserInformation();
            db.getCourseInformation();

            ArrayList<UserInformation> usersInformation = db.getUsersInformation();
            ArrayList<CourseInformation> coursesInformation = db.getCoursesInformation();
            ArrayList<String> studentsFIO = new ArrayList<>();
            ArrayList<String> courses = new ArrayList<>();

            for (UserInformation userInformation : usersInformation) {
                studentsFIO.add(userInformation.getFio());
            }

            for (CourseInformation courseInformation: coursesInformation) {
                courses.add(courseInformation.getNomi());
            }

            fioComb.setItems(FXCollections.observableArrayList(studentsFIO));
            courseComb.setItems(FXCollections.observableArrayList(courses));
            monthComb.setItems(FXCollections.observableArrayList("Yanvar", "Fevral", "Mart", "Aprel", "May", "Iyun", "Iyul", "Avgust", "Sentabr", "Oktabr", "Noyabr", "Dekabr"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void getStudentCourse(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        Database db = new Database();
        db.getUserInformation();
        db.getCourseInformation();

        ArrayList<UserInformation> usersInformation = db.getUsersInformation();
        ArrayList<String> studentCourseList = new ArrayList<>();

        try {
            Connection conn;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

            ps = conn.prepareStatement("SELECT Fani FROM users WHERE FIO = ?");
            ps.setString(1, fioComb.getValue().toString());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                studentCourseList.add(rs.getString("Fani"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        for (UserInformation user: usersInformation) {
            if (fioComb.getValue().equals(user.getFio())) {
                courseComb.setItems(FXCollections.observableArrayList(studentCourseList));
            }
        }
    }

    public void makePayment(ActionEvent actionEvent) throws IOException, ClassNotFoundException{
        LocalDate today = LocalDate.now();

        for (int i = 0; i < priceField.getText().length(); i++) {
            if (Character.isDigit(priceField.getText().charAt(i))) {
                isNumeric = true;
            } else if (priceField.getText().equals("")) {
                isNumeric = false;
            }
        }

        if (isNumeric) {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

                ps = con.prepareStatement("INSERT INTO payments (FIO, Fani, Miqdori, Oy, Sana) VALUES (?, ?, ?, ?, ?)");
                ps.setString(1, fioComb.getValue().toString());
                ps.setString(2, courseComb.getValue().toString());
                ps.setString(3, priceField.getText());
                ps.setString(4, monthComb.getValue().toString());
                ps.setString(5, today.toString());
                ps.executeUpdate();

                statusLabel.setText("Muvaffaqiyatli tugatildi");
                statusLabel.setStyle("-fx-text-fill: green");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            statusLabel.setText("To'gri ma'lumot kiriting");
            statusLabel.setStyle("-fx-text-fill: red");
        }
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Payment/manage-payment.fxml"));
            makePaymentPane.getChildren().removeAll();
            makePaymentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
