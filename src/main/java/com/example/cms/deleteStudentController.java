package com.example.cms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class deleteStudentController {
    @FXML
    private AnchorPane deleteStudentPane;

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("manage-student.fxml"));
            deleteStudentPane.getChildren().removeAll();
            deleteStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
