module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens com.example.project1 to javafx.fxml;
}