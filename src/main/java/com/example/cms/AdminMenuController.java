package com.example.cms;

import com.example.cms.JDBC.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    @FXML
    private VBox vBoxMenuBar;

    @FXML
    private VBox vboxProfile;

    @FXML
    private Button btnManageCourse;

    @FXML
    private Button btnManageStudent;

    @FXML
    private Button btnMyProfile;

    @FXML
    private Label labelFIO;

    @FXML
    private Label labelPhone;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelUsername;

    @FXML
    private Label labelPassword;

    @FXML
    private Rectangle rect1;

    @FXML
    private Rectangle rect2;

    @FXML
    private Rectangle rect3;

    @FXML
    private AnchorPane defaultAdminProfilePane;

    @FXML
    private BorderPane AdminPane;

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
            Parent fxml = FXMLLoader.load(getClass().getResource("my-profile.fxml"));
            defaultAdminProfilePane.getChildren().removeAll();
            defaultAdminProfilePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void myProfile(ActionEvent actionEvent) {
        rect1.setVisible(true);
        rect2.setVisible(false);
        rect3.setVisible(false);

        btnMyProfile.setTextFill(Color.rgb(0, 155, 255));
        btnManageCourse.setTextFill(Color.BLACK);
        btnManageStudent.setTextFill(Color.BLACK);
        btnMyProfile.setStyle("-fx-background-color: #fff");

        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("my-profile.fxml"));
            defaultAdminProfilePane.getChildren().removeAll();
            defaultAdminProfilePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageCourse(ActionEvent actionEvent) {
        rect2.setVisible(true);
        rect1.setVisible(false);
        rect3.setVisible(false);

        btnManageCourse.setTextFill(Color.rgb(0, 155, 255));
        btnManageStudent.setTextFill(Color.BLACK);
        btnMyProfile.setTextFill(Color.BLACK);
        btnManageCourse.setStyle("-fx-background-color: #fff");

        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("manage-course.fxml"));
            defaultAdminProfilePane.getChildren().removeAll();
            defaultAdminProfilePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageStudent(ActionEvent actionEvent) {
        rect3.setVisible(true);
        rect2.setVisible(false);
        rect1.setVisible(false);

        btnManageStudent.setTextFill(Color.rgb(0, 155, 255));
        btnManageCourse.setTextFill(Color.BLACK);
        btnMyProfile.setTextFill(Color.BLACK);
        btnManageStudent.setStyle("-fx-background-color: #fff");

        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("manage-student.fxml"));
            defaultAdminProfilePane.getChildren().removeAll();
            defaultAdminProfilePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logOut(ActionEvent actionEvent) {

    }
}
