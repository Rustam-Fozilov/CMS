package com.example.cms.Admin.Students;

import com.example.cms.Database.Database;
import com.example.cms.Database.StudentTable;
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

public class showStudentController implements Initializable {
    @FXML
    private TableColumn<StudentTable, Integer> colId;

    @FXML
    private TableColumn<StudentTable, String> colFIO;

    @FXML
    private TableColumn<StudentTable, String> colPhone;

    @FXML
    private TableColumn<StudentTable, String> colGroup;

    @FXML
    private TableColumn<StudentTable, String> colSubject;

    @FXML
    private TableView<StudentTable> table;

    @FXML
    private AnchorPane showStudentPane;

    ObservableList<StudentTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection conn = Database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM users");

            while (rs.next()) {
                list.add(new StudentTable(
                        rs.getInt("UserId"),
                        rs.getString("FIO"),
                        rs.getString("Telefon"),
                        rs.getString("Fani"),
                        rs.getString("Guruhi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        colFIO.setCellValueFactory(new PropertyValueFactory<>("fio"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("fani"));
        colGroup.setCellValueFactory(new PropertyValueFactory<>("guruhi"));
        table.setItems(list);
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Admin/Students/manage-student.fxml"));
            showStudentPane.getChildren().removeAll();
            showStudentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
