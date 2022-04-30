package com.example.cms;

import com.example.cms.Database.CourseTable;
import com.example.cms.Database.Database;
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

public class showCourseController implements Initializable {
    @FXML
    private TableColumn<CourseTable, String> colDuration;

    @FXML
    private TableColumn<CourseTable, Integer> colId;

    @FXML
    private TableColumn<CourseTable, String> colName;

    @FXML
    private TableColumn<CourseTable, Integer> colPrice;

    @FXML
    private TableColumn<CourseTable, String> colTeacher;

    @FXML
    private AnchorPane showCoursePane;

    @FXML
    private TableView<CourseTable> table;

    ObservableList<CourseTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection conn = Database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from courses");

            while (rs.next()) {
                list.add(new CourseTable(
                        rs.getInt("courseId"),
                        rs.getString("Nomi"),
                        rs.getString("Davomiyligi"),
                        rs.getString("Oqituvchi"),
                        rs.getInt("Narxi")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("course_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("nomi"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("davomiyligi"));
        colTeacher.setCellValueFactory(new PropertyValueFactory<>("oqituvchi"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("narxi"));
        table.setItems(list);
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("manage-course.fxml"));
            showCoursePane.getChildren().removeAll();
            showCoursePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
