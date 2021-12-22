module com.example.sankesandladders {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.sankesandladders to javafx.fxml;
    exports com.example.sankesandladders;
}