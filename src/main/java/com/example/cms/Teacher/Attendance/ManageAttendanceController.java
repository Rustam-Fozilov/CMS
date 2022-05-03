package com.example.cms.Teacher.Attendance;

import com.example.cms.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageAttendanceController implements Initializable {
    @FXML
    private Button btnMakeAttendance;

    @FXML
    private Button btnShowAttendance;

    @FXML
    private AnchorPane manageAttendancePane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setColor(Color.rgb(179, 213, 255));
        dropShadow.setHeight(15);
        dropShadow.setWidth(15);
        dropShadow.setOffsetX(0);
        dropShadow.setOffsetY(8);
        dropShadow.setRadius(21);

        btnMakeAttendance.setEffect(dropShadow);
        btnShowAttendance.setEffect(dropShadow);
    }

    public void makeAttendance(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Attendance/make-attendance.fxml"));
            manageAttendancePane.getChildren().removeAll();
            manageAttendancePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAttendance(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Attendance/show-attendance.fxml"));
            manageAttendancePane.getChildren().removeAll();
            manageAttendancePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
