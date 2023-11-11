module com.example.bolsadevaloresjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires javafx.graphics;


    opens com.example.bolsadevaloresjavafx to javafx.fxml;
    exports com.example.bolsadevaloresjavafx;
}