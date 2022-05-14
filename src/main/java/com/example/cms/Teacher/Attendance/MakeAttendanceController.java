package com.example.cms.Teacher.Attendance;

import com.example.cms.Database.*;
import com.example.cms.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MakeAttendanceController implements Initializable {
    @FXML
    private TableColumn<AttendanceTable, String> colFio;

    @FXML
    private TableColumn<AttendanceTable, Integer> colId;

    @FXML
    private TableColumn<AttendanceTable, String> colStatus;

    @FXML
    private TableColumn<AttendanceTable, String> colSubject;

    @FXML
    private TableView<AttendanceTable> table;

    @FXML
    private AnchorPane makeAttendancePane;

    @FXML
    private Label statusLabel;

    ObservableList<AttendanceTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection conn = Database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT UserId, FIO, Fani FROM users");

            while (rs.next()) {
                list.add(new AttendanceTable(
                        rs.getInt("UserId"),
                        rs.getString("FIO"),
                        rs.getString("Fani")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("attendance_id"));
        colFio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("fani"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("select"));
        table.setItems(list);
    }

    public void makeAttendance(ActionEvent actionEvent){
        LocalDate localDate = LocalDate.now();

        try {
            Connection con;
            PreparedStatement ps;

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "1w3r5y7i9");

            ps = con.prepareStatement("INSERT INTO attendance (FIO, Fani, Statusi, Sana) VALUES (?, ?, ?, ?)");

            for (AttendanceTable list: list) {
                if (list.getSelect().isSelected()) {
                    System.out.println(list.getFio());
                    ps.setString(1, list.getFio());
                    ps.setString(2, list.getFani());
                    ps.setString(3, "bor");
                    ps.setString(4, localDate.toString());
                    ps.executeUpdate();
                } else {
                    ps.setString(1, list.getFio());
                    ps.setString(2, list.getFani());
                    ps.setString(3, "yo'q");
                    ps.setString(4, localDate.toString());
                    ps.executeUpdate();
                }
            }

            statusLabel.setText("Muvaffaqiyatli tugatildi");
            statusLabel.setStyle("-fx-text-fill: green");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Attendance/manage-attendance.fxml"));
            makeAttendancePane.getChildren().removeAll();
            makeAttendancePane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
