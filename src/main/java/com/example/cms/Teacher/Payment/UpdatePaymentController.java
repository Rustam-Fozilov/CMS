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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class UpdatePaymentController implements Initializable {
    @FXML
    private ComboBox courseComb;

    @FXML
    private ComboBox monthComb;

    @FXML
    private ComboBox updateCombFIO;

    @FXML
    private TextField priceField;

    @FXML
    private Label statusLabel;

    @FXML
    private AnchorPane updatePaymentPane;

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
                studentsFIO.add(userInformation.getIsmi() + " " + userInformation.getFamiliyasi());
            }

            for (CourseInformation courseInformation: coursesInformation) {
                courses.add(courseInformation.getNomi());
            }

            updateCombFIO.setItems(FXCollections.observableArrayList(studentsFIO));
            courseComb.setItems(FXCollections.observableArrayList(courses));
            monthComb.setItems(FXCollections.observableArrayList("Yanvar", "Fevral", "Mart", "Aprel", "May", "Iyun", "Iyul", "Avgust", "Sentabr", "Oktabr", "Noyabr", "Dekabr"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updatePayment(ActionEvent actionEvent) throws IOException, ClassNotFoundException{
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

                ps = con.prepareStatement("UPDATE payments SET (FIO, Fani, Miqdori, Oy, Sana) WHERE FIO = ?");

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
            updatePaymentPane.getChildren().removeAll();
            updatePaymentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
