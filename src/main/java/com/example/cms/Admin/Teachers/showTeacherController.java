package com.example.cms.Admin.Teachers;

import com.example.cms.Database.Database;
import com.example.cms.Database.StudentTable;
import com.example.cms.Database.TeacherTable;
import com.example.cms.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class showTeacherController implements Initializable {
    @FXML
    private TableColumn<TeacherTable, Integer> colId;

    @FXML
    private TableColumn<TeacherTable, String> colName;

    @FXML
    private TableColumn<TeacherTable, String> colPassword;

    @FXML
    private TableColumn<TeacherTable, String> colPhone;

    @FXML
    private TableColumn<TeacherTable, String> colSubject;

    @FXML
    private TableColumn<TeacherTable, String> colSurname;

    @FXML
    private TableColumn<TeacherTable, String> colUsername;

    @FXML
    private AnchorPane showTeacherPane;

    @FXML
    private TableView<TeacherTable> table;

    ObservableList<TeacherTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection conn = Database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM teachers");

            while (rs.next()) {
                list.add(new TeacherTable(
                        rs.getInt("TeacherId"),
                        rs.getString("Ismi"),
                        rs.getString("Familiyasi"),
                        rs.getString("Telefon"),
                        rs.getString("Fani"),
                        rs.getString("username"),
                        rs.getString("parol")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("teacher_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("ismi"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("familiyasi"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("fani"));
        colUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("parol"));
        table.setItems(list);
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Teachers/manage-teacher.fxml"));
            showTeacherPane.getChildren().removeAll();
            showTeacherPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
