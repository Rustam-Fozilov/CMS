package com.example.cms.Teacher.Payment;

import com.example.cms.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManagePaymentController implements Initializable {
    @FXML
    private Button btnMakePayment;

    @FXML
    private Button btnUpdatePayment;

    @FXML
    private Button btnShowPayment;

    @FXML
    private AnchorPane managePaymentPane;

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

        btnMakePayment.setEffect(dropShadow);
        btnUpdatePayment.setEffect(dropShadow);
        btnShowPayment.setEffect(dropShadow);
    }

    public void makePayment(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Payment/make-payment.fxml"));
            managePaymentPane.getChildren().removeAll();
            managePaymentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updatePayment(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Payment/update-payment.fxml"));
            managePaymentPane.getChildren().removeAll();
            managePaymentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showPayment(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Payment/show-payment.fxml"));
            managePaymentPane.getChildren().removeAll();
            managePaymentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
