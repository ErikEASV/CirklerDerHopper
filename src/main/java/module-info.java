module com.example.cirklerderhopper {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cirklerderhopper to javafx.fxml;
    exports com.example.cirklerderhopper;
}