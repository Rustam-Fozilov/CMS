package com.example.cms.Teacher;

import com.example.cms.Database.AdminInformation;
import com.example.cms.Database.Database;
import com.example.cms.Database.TeacherInformation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TeacherProfileController implements Initializable {
    @FXML
    private Circle avatar;

    @FXML
    private Label labelFIO;

    @FXML
    private Label labelPassword;

    @FXML
    private Label labelPhone;

    @FXML
    private Label labelSubject;

    @FXML
    private Label labelUsername;

    @FXML
    private AnchorPane myProfilePane;

    @FXML
    private VBox vboxProfile;

    private int id;
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image img = new Image("avatar2.jpg");
        avatar.setFill(new ImagePattern(img));

        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setColor(Color.rgb(170, 213, 255));
        dropShadow.setHeight(24);
        dropShadow.setWidth(24);
        dropShadow.setOffsetY(8);
        dropShadow.setRadius(22);
        vboxProfile.setEffect(dropShadow);
    }

    public void show() {
        try {
            Database db = new Database();
            db.getTeacherInformation();
            ArrayList<TeacherInformation> teachersInformation = db.getTeachersInformation();

            for (TeacherInformation teacher : teachersInformation) {
                if (this.getId() == teacher.getTeacher_id()) {
                    labelFIO.setText(teacher.getFio());
                    labelPhone.setText(teacher.getTelefon());
                    labelSubject.setText(teacher.getFani());
                    labelPassword.setText(teacher.getParol());
                    labelUsername.setText(teacher.getUsername());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
