package com.example.javafx_gestion_bbdd_tarea_2_3.dao;

import com.example.javafx_gestion_bbdd_tarea_2_3.modelos.Producto;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {

    private final String servidor = "jdbc:mariadb://localhost:5555/noinch?useSSL=false";
    private final String usuario = "adminer";
    private final String passwd ="adminer";

    private Connection conexionBBDD;

    public ObservableList<Producto> obtenerProductos (){

        ObservableList<Producto> datosResultadoConsulta = FXCollections.observableArrayList();
        try {
            // Nos conectamos
            conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "SELECT * "
                    + "FROM products "
                    + "ORDER By productName";

            // Ejecutamos la consulta y nos devuelve una matriz de filas (registros) y columnas (datos)
            ResultSet resultadoConsulta = conexionBBDD.createStatement().executeQuery(SQL);

            // Debemos cargar los datos en el ObservableList (Que es un ArrayList especial)
            // Los datos que devuelve la consulta no son directamente cargables en nuestro objeto
            while (resultadoConsulta.next()) {
                datosResultadoConsulta.add(new Producto(
                        resultadoConsulta.getString("productCode"),
                        resultadoConsulta.getString("productName"),
                        resultadoConsulta.getString("productLine"),
                        resultadoConsulta.getString("productScale"),
                        resultadoConsulta.getString("productVendor"),
                        resultadoConsulta.getString("productDescription"),
                        resultadoConsulta.getInt("quantityInStock"),
                        resultadoConsulta.getDouble("buyPrice"),
                        resultadoConsulta.getDouble("MSRP"))
                );
                System.out.println("Row [1] added " + resultadoConsulta.toString());
            }
            conexionBBDD.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            conexionBBDD.close();
        } finally {
            return datosResultadoConsulta;
        }
    }

}
