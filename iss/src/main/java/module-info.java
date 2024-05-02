module com.example.iss {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.iss to javafx.fxml;
    exports com.example.iss;
}