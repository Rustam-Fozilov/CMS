package com.example.cms;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageCourseController implements Initializable {

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
}
