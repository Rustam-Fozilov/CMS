package com.example.cms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class addCourseController {
    @FXML
    private AnchorPane addCoursePane;

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
