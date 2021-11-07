module com.example.javafx_gestion_bbdd_tarea_2_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mariadb.jdbc;
    requires java.sql;
    requires com.google.gson;

    opens com.example.javafx_gestion_bbdd_tarea_2_3 to javafx.fxml;
    exports com.example.javafx_gestion_bbdd_tarea_2_3;

    opens com.example.javafx_gestion_bbdd_tarea_2_3.controladores to javafx.fxml;
    exports com.example.javafx_gestion_bbdd_tarea_2_3.controladores;

    opens com.example.javafx_gestion_bbdd_tarea_2_3.modelos to javafx.fxml, com.google.gson;
    exports com.example.javafx_gestion_bbdd_tarea_2_3.modelos;

}