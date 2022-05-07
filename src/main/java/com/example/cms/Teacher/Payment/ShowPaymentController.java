package com.example.cms.Teacher.Payment;

import com.example.cms.Database.Database;
import com.example.cms.Database.PaymentTable;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class ShowPaymentController implements Initializable {
    @FXML
    private TableColumn<PaymentTable, Integer> colAmount;

    @FXML
    private TableColumn<PaymentTable, LocalDate> colDate;

    @FXML
    private TableColumn<PaymentTable, String> colFIO;

    @FXML
    private TableColumn<PaymentTable, Integer> colId;

    @FXML
    private TableColumn<PaymentTable, String> colMonth;

    @FXML
    private TableColumn<PaymentTable, String> colSubject;

    @FXML
    private AnchorPane showPaymentPane;

    @FXML
    private TableView<PaymentTable> table;

    ObservableList<PaymentTable> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection conn = Database.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM payments");

            while (rs.next()) {
                list.add(new PaymentTable(
                        rs.getInt("PaymentId"),
                        rs.getString("FIO"),
                        rs.getString("Fani"),
                        rs.getInt("Miqdori"),
                        rs.getString("Oy"),
                        rs.getDate("Sana")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("payment_id"));
        colFIO.setCellValueFactory(new PropertyValueFactory<>("fio"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("fani"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("miqdori"));
        colMonth.setCellValueFactory(new PropertyValueFactory<>("oy"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("sana"));
        table.setItems(list);
    }

    public void goBack(ActionEvent actionEvent) {
        try {
            Parent fxml = FXMLLoader.load(HelloApplication.class.getResource("Teacher/Payment/manage-payment.fxml"));
            showPaymentPane.getChildren().removeAll();
            showPaymentPane.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
