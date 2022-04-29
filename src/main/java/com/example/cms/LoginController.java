package com.example.cms;

import com.example.cms.JDBC.AdminInformation;
import com.example.cms.JDBC.Database;
import com.example.cms.JDBC.TeacherInformation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField uname;

    @FXML
    private PasswordField passwd;

    private User currentUser;

    public void accessToLogin() throws IOException, ClassNotFoundException {
        Database database = new Database();
        database.getAdminInformation();
        database.getTeacherInformation();

        String username = uname.getText();
        String password = passwd.getText();

        ArrayList<AdminInformation> adminsInformation = database.getAdminsInformation();
        ArrayList<TeacherInformation> teachersInformation = database.getTeachersInformation();

        boolean isLogged = true;

//        for (AdminInformation admin: adminsInformation) {
//            if (admin.getUsername().equals(username) && admin.getParol().equals(password)) {
//                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("admin-menu.fxml"));
//                Parent root2 = loader.load();
//                AdminMenuController ctrl = loader.getController();
//                ctrl.setId(admin.getAdmin_id());
////                System.out.println(admin.getAdmin_id());
//
//                btnLogin.getScene().getWindow().hide();
//                Stage login = new Stage();
//                Parent root = FXMLLoader.load(getClass().getResource("admin-menu.fxml"));
//                Scene scene = new Scene(root);
//                login.setTitle("Admin panel");
//                login.setResizable(false);
//                login.setScene(scene);
//                login.show();
//            } else {
//                isLogged = false;
//            }
//        }

        for (int i = 0; i < adminsInformation.size(); i++) {
            if (adminsInformation.get(i).getUsername().equals(username) && adminsInformation.get(i).getParol().equals(password)) {
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("admin-menu.fxml"));
                Parent root2 = loader.load();
                AdminMenuController ctrl = loader.getController();
                ctrl.setId(adminsInformation.get(i).getAdmin_id()); // jonatilayotganda admin id sini tori jonatvoti, lekn AdminMenuControllerda bu id sout qlib korilsa faqat 0 cqvoti

                btnLogin.getScene().getWindow().hide();
                Stage login = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("admin-menu.fxml"));
                Scene scene = new Scene(root);
                login.setTitle("Admin panel");
                login.setResizable(false);
                login.setScene(scene);
                login.show();
            } else {
                isLogged = false;
            }
        }

        for (TeacherInformation teacher : teachersInformation) {
            if (teacher.getUsername().equals(username) && teacher.getParol().equals(password)) {
                btnLogin.getScene().getWindow().hide();
                Stage login = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("teacher-menu.fxml"));
                Scene scene = new Scene(root);
                login.setTitle("Teacher panel");
                login.setResizable(false);
                login.setScene(scene);
                login.show();
            } else {
                isLogged = false;
            }
        }

        if (!isLogged) {
            label.setText("username yoki parol xato :(");
            label.setStyle("-fx-text-fill: red");
        }
    }

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
        btnLogin.setEffect(dropShadow);
    }

    public User getCurrentUser(){
        return this.currentUser;
    }

    public void enter(KeyEvent event) throws IOException, ClassNotFoundException {
        KeyCode kc = event.getCode();
        if(kc == KeyCode.ENTER) {
            accessToLogin();
            String username = uname.getText();
            String password = passwd.getText();

            if (username != null && password != null) {
                btnLogin.requestFocus();
            }
        }

    }
}
