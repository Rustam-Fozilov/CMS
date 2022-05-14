package com.example.cms.Admin;

import com.example.cms.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAdminProfileController {
    @FXML
    private TextField fioField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private Label statusLabel;

    @FXML
    private AnchorPane updateProfilePane;

    @FXML
    private TextField usernameField;

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void updateProfile(ActionEvent actionEvent) {
        String fio = fioField.getText();
        String phone = phoneField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (fioField.getText().equals("") || phoneField.getText().equals("") || usernameField.getText().equals("") || passwordField.getText().equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("Admin/admin-profile.fxml"));
                Parent root = loader.load();
                AdminProfileController adminProfileController = loader.getController();
                adminProfileController.getUpdate(fio, phone, username, password);
                updateInDatabase();

                updateProfilePane.getChildren().removeAll();
                updateProfilePane.getChildren().setAll(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateInDatabase(){
        if (fioField.getText().equals("") || phoneField.getText().equals("") || usernameField.getText().equals("") || passwordField.getText().equals("")) {
            statusLabel.setText("Barcha maydonlar to'ldirilishi shart");
        } else {
            try {
                Connection con;
                PreparedStatement ps;

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

                ps = con.prepareStatement("UPDATE admins SET FIO = ?, Telefon = ?, username = ?, parol = ? WHERE AdminId = ?");
                ps.setString(1, fioField.getText());
                ps.setString(2, phoneField.getText());
                ps.setString(3, usernameField.getText());
                ps.setString(4, passwordField.getText());
                ps.setInt(5, getId());
                ps.executeUpdate();
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }

    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/admin-profile.fxml"));
            updateProfilePane.getChildren().removeAll();
            updateProfilePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
