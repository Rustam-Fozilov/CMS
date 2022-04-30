module com.example.cms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.cms to javafx.fxml;
    exports com.example.cms;
    exports com.example.cms.Database;
    opens com.example.cms.Database to javafx.fxml;
}