package com.example.cms;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

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
}
