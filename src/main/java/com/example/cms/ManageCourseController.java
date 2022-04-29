package com.example.cms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageCourseController implements Initializable {
    @FXML
    private AnchorPane manageCoursePane;

    @FXML
    private Button btnAddCourse;

    @FXML
    private Button btnDeleteCourse;

    @FXML
    private Button btnShowCourse;

    @FXML
    private Button btnUpdateCourse;

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

        btnAddCourse.setEffect(dropShadow);
        btnUpdateCourse.setEffect(dropShadow);
        btnDeleteCourse.setEffect(dropShadow);
        btnShowCourse.setEffect(dropShadow);
    }

    public void addCourse(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("add-course.fxml"));
            manageCoursePane.getChildren().removeAll();
            manageCoursePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("update-course.fxml"));
            manageCoursePane.getChildren().removeAll();
            manageCoursePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("delete-course.fxml"));
            manageCoursePane.getChildren().removeAll();
            manageCoursePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCourse(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("show-course.fxml"));
            manageCoursePane.getChildren().removeAll();
            manageCoursePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
