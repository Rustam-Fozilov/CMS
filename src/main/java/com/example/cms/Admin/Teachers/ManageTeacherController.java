package com.example.cms.Admin.Teachers;

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

public class ManageTeacherController implements Initializable {
    @FXML
    private Button btnAddTeacher;

    @FXML
    private Button btnDeleteTeacher;

    @FXML
    private Button btnUpdateTeacher;

    @FXML
    private Button btnShowTeacher;

    @FXML
    private AnchorPane manageTeacherPane;

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

        btnAddTeacher.setEffect(dropShadow);
        btnDeleteTeacher.setEffect(dropShadow);
        btnShowTeacher.setEffect(dropShadow);
        btnUpdateTeacher.setEffect(dropShadow);
    }

    public void addTeacher(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Teachers/add-teacher.fxml"));
            manageTeacherPane.getChildren().removeAll();
            manageTeacherPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacher(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Teachers/update-teacher.fxml"));
            manageTeacherPane.getChildren().removeAll();
            manageTeacherPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Teachers/delete-teacher.fxml"));
            manageTeacherPane.getChildren().removeAll();
            manageTeacherPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTeacher(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Teachers/show-teacher.fxml"));
            manageTeacherPane.getChildren().removeAll();
            manageTeacherPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
