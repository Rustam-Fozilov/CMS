module com.example.cms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.cms to javafx.fxml;
    exports com.example.cms;
    exports com.example.cms.Database;
    opens com.example.cms.Database to javafx.fxml;
    exports com.example.cms.Admin;
    opens com.example.cms.Admin to javafx.fxml;
    exports com.example.cms.Teacher;
    opens com.example.cms.Teacher to javafx.fxml;
    exports com.example.cms.Admin.Courses;
    opens com.example.cms.Admin.Courses to javafx.fxml;
    exports com.example.cms.Admin.Students;
    opens com.example.cms.Admin.Students to javafx.fxml;
}