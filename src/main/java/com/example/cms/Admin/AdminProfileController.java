package com.example.cms.Admin;

import com.example.cms.Database.AdminInformation;
import com.example.cms.Database.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
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
}
