package com.example.cms;

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

public class ManageStudentController implements Initializable {
    @FXML
    private Button btnAddStudent;

    @FXML
    private Button btnDeleteStudent;

    @FXML
    private Button btnShowStudent;

    @FXML
    private Button btnUpdateStudent;

    @FXML
    private AnchorPane manageStudentPane;

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

        btnAddStudent.setEffect(dropShadow);
        btnUpdateStudent.setEffect(dropShadow);
        btnShowStudent.setEffect(dropShadow);
        btnDeleteStudent.setEffect(dropShadow);
    }

    public void addStudent(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("add-student.fxml"));
            manageStudentPane.getChildren().removeAll();
            manageStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("update-student.fxml"));
            manageStudentPane.getChildren().removeAll();
            manageStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("delete-student.fxml"));
            manageStudentPane.getChildren().removeAll();
            manageStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStudent(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("show-student.fxml"));
            manageStudentPane.getChildren().removeAll();
            manageStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
