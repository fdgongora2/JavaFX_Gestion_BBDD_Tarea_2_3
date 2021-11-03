module com.example.javafx_gestion_bbdd_tarea_2_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_gestion_bbdd_tarea_2_3 to javafx.fxml;
    exports com.example.javafx_gestion_bbdd_tarea_2_3;
}