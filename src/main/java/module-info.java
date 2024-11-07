module org.example.week9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.week9 to javafx.fxml;
    exports org.example.week9;
}