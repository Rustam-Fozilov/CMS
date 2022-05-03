package com.example.cms.Teacher;

import com.example.cms.Admin.AdminProfileController;
import com.example.cms.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TeacherMenuController implements Initializable {
    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnManageAttendance;

    @FXML
    private Button btnManagePayment;

    @FXML
    private Button btnMyProfile;

    @FXML
    private AnchorPane defaultTeacherProfilePane;

    @FXML
    private Rectangle rect1;

    @FXML
    private Rectangle rect2;

    @FXML
    private Rectangle rect3;

    @FXML
    private VBox vBoxMenuBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setColor(Color.rgb(230, 230, 230));
        dropShadow.setHeight(20);
        dropShadow.setWidth(20);
        dropShadow.setOffsetX(2);
        dropShadow.setOffsetY(0);
        dropShadow.setRadius(25);
        vBoxMenuBar.setEffect(dropShadow);

        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Teacher/teacher-profile.fxml"));
            Parent root = loader.load();

            defaultTeacherProfilePane.getChildren().removeAll();
            defaultTeacherProfilePane.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void myProfile(ActionEvent actionEvent) {
        rect1.setVisible(true);
        rect2.setVisible(false);
        rect3.setVisible(false);

        btnMyProfile.setTextFill(Color.rgb(0, 155, 255));
        btnMyProfile.setStyle("-fx-background-color: #fff");
        btnManageAttendance.setTextFill(Color.BLACK);
        btnManagePayment.setTextFill(Color.BLACK);

        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/teacher-profile.fxml"));
            defaultTeacherProfilePane.getChildren().removeAll();
            defaultTeacherProfilePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageAttendance(ActionEvent actionEvent) {
        rect1.setVisible(false);
        rect2.setVisible(true);
        rect3.setVisible(false);

        btnManageAttendance.setTextFill(Color.rgb(0, 155, 255));
        btnManageAttendance.setStyle("-fx-background-color: #fff");
        btnMyProfile.setTextFill(Color.BLACK);
        btnManagePayment.setTextFill(Color.BLACK);

        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Attendance/manage-attendance.fxml"));
            defaultTeacherProfilePane.getChildren().removeAll();
            defaultTeacherProfilePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void managePayment(ActionEvent actionEvent) {
        rect1.setVisible(false);
        rect2.setVisible(false);
        rect3.setVisible(true);

        btnManagePayment.setTextFill(Color.rgb(0, 155, 255));
        btnManagePayment.setStyle("-fx-background-color: #fff");
        btnMyProfile.setTextFill(Color.BLACK);
        btnManageAttendance.setTextFill(Color.BLACK);

        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Payment/manage-payment.fxml"));
            defaultTeacherProfilePane.getChildren().removeAll();
            defaultTeacherProfilePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOut(ActionEvent actionEvent) throws IOException {
        btnLogOut.getScene().getWindow().hide();
        Stage main = new Stage();
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        main.setScene(scene);
        main.show();
    }
}
