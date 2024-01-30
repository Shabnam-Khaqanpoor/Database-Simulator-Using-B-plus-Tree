module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfxrt;
    requires rt;
//    requires jfxrt;
//    requires rt;
//    requires rt;
//    requires jfxrt;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}