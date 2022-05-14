package com.example.cms.Teacher.Attendance;

import com.example.cms.Database.AttendanceTable;
import com.example.cms.Database.Database;
import com.example.cms.Database.PaymentTable;
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
import java.util.Date;
import java.util.ResourceBundle;

public class ShowAttendanceController implements Initializable {
    @FXML
    private TableColumn<AttendanceTable, Date> colDate;

    @FXML
    private TableColumn<AttendanceTable, String> colFIO;

    @FXML
    private TableColumn<AttendanceTable, Integer> colId;

    @FXML
    private TableColumn<AttendanceTable, String> colStatus;

    @FXML
    private TableColumn<AttendanceTable, String> colSubject;

    @FXML
    private AnchorPane showAttendancePane;

    @FXML
    private TableView<AttendanceTable> table;

    ObservableList<AttendanceTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection conn = Database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM attendance");

            while (rs.next()) {
                list.add(new AttendanceTable(
                        rs.getInt("AttendanceId"),
                        rs.getString("FIO"),
                        rs.getString("Fani"),
                        rs.getString("Statusi"),
                        rs.getDate("Sana")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("attendance_id"));
        colFIO.setCellValueFactory(new PropertyValueFactory<>("fio"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("fani"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("statusi"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("sana"));
        table.setItems(list);
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Attendance/manage-attendance.fxml"));
            showAttendancePane.getChildren().removeAll();
            showAttendancePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
