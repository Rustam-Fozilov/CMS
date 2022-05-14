package com.example.cms.Admin;

import com.example.cms.Database.AdminInformation;
import com.example.cms.Database.Database;
import com.example.cms.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdminProfileController implements Initializable {
    @FXML
    private Label labelFIO;

    @FXML
    private Label labelPhone;

    @FXML
    private Label labelUsername;

    @FXML
    private Label labelPassword;

    @FXML
    private VBox vboxProfile;

    @FXML
    private Circle avatar;

    @FXML
    private AnchorPane myProfilePane;

    public int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image img = new Image("avatar.png");
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
            db.getAdminInformation();
            ArrayList<AdminInformation> adminsInformation = db.getAdminsInformation();

            for (AdminInformation admin : adminsInformation) {
                if (this.getId() == admin.getAdmin_id()) {
                    labelFIO.setText(admin.getFio());
                    labelPhone.setText(admin.getTelefon());
                    labelPassword.setText(admin.getParol());
                    labelUsername.setText(admin.getUsername());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateProfile(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Admin/update-admin-profile.fxml"));
            Parent root = loader.load();
            UpdateAdminProfileController ctrl = loader.getController();
            ctrl.setId(getId());
            myProfilePane.getChildren().removeAll();
            myProfilePane.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getUpdate(String fio, String phone, String username, String password) {
        labelFIO.setText(fio);
        labelPhone.setText(phone);
        labelUsername.setText(username);
        labelPassword.setText(password);
    }
}
