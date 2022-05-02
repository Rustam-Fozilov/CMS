package com.example.cms.Admin;

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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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
    private Button btnManageTeacher;

    @FXML
    private Button btnMyProfile;

    @FXML
    private Button btnLogOut;

    @FXML
    private Rectangle rect1;

    @FXML
    private Rectangle rect2;

    @FXML
    private Rectangle rect3;

    @FXML
    private Rectangle rect4;

    @FXML
    private AnchorPane defaultAdminProfilePane;

    @FXML
    private BorderPane AdminPane;

    private int id;
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    } // getId 0 ga teng cqvoti prablema;

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
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Admin/admin-profile.fxml"));
            Parent root = loader.load();
            AdminProfileController ctrl2 = loader.getController();
            ctrl2.setId(getId());

            defaultAdminProfilePane.getChildren().removeAll();
            defaultAdminProfilePane.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void myProfile(ActionEvent actionEvent) {
        rect1.setVisible(true);
        rect2.setVisible(false);
        rect3.setVisible(false);
        rect4.setVisible(false);

        btnMyProfile.setTextFill(Color.rgb(0, 155, 255));
        btnMyProfile.setStyle("-fx-background-color: #fff");
        btnManageCourse.setTextFill(Color.BLACK);
        btnManageStudent.setTextFill(Color.BLACK);
        btnManageTeacher.setTextFill(Color.BLACK);

        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/admin-profile.fxml"));
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
        rect4.setVisible(false);

        btnManageCourse.setTextFill(Color.rgb(0, 155, 255));
        btnManageStudent.setTextFill(Color.BLACK);
        btnMyProfile.setTextFill(Color.BLACK);
        btnManageTeacher.setTextFill(Color.BLACK);
        btnManageCourse.setStyle("-fx-background-color: #fff");

        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Courses/manage-course.fxml"));
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
        rect4.setVisible(false);

        btnManageStudent.setTextFill(Color.rgb(0, 155, 255));
        btnManageStudent.setStyle("-fx-background-color: #fff");
        btnManageCourse.setTextFill(Color.BLACK);
        btnMyProfile.setTextFill(Color.BLACK);
        btnManageTeacher.setTextFill(Color.BLACK);

        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Students/manage-student.fxml"));
            defaultAdminProfilePane.getChildren().removeAll();
            defaultAdminProfilePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void manageTeacher(ActionEvent actionEvent) {
        rect4.setVisible(true);
        rect2.setVisible(false);
        rect1.setVisible(false);
        rect3.setVisible(false);

        btnManageTeacher.setTextFill(Color.rgb(0, 155, 255));
        btnManageTeacher.setStyle("-fx-background-color: #fff");
        btnManageCourse.setTextFill(Color.BLACK);
        btnMyProfile.setTextFill(Color.BLACK);
        btnManageStudent.setTextFill(Color.BLACK);

        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Teachers/manage-teacher.fxml"));
            defaultAdminProfilePane.getChildren().removeAll();
            defaultAdminProfilePane.getChildren().setAll(fxml);
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
