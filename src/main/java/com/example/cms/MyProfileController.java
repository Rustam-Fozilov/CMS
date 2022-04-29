package com.example.cms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
import java.util.ResourceBundle;

public class MyProfileController implements Initializable {
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
    private VBox vboxProfile;

    @FXML
    private Circle avatar;

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
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        LoginController loginController = fxmlLoader.getController();
//        User user = loginController.getCurrentUser();
//        labelEmail.setText(user.getEmail());
//        labelUsername.setText(user.getUsername());

    }
}
