module com.example.basicguijavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.basicguijavafx to javafx.fxml;
    exports com.example.basicguijavafx;
}