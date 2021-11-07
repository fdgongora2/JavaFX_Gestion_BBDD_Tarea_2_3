package com.example.javafx_gestion_bbdd_tarea_2_3.dao;

import com.example.javafx_gestion_bbdd_tarea_2_3.modelos.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ProductoDAO {

    private final String servidor = "jdbc:mariadb://localhost:5555/noinch?useSSL=false";
    private final String usuario = "adminer";
    private final String passwd = "adminer";

    private Connection conexionBBDD;

    public ObservableList<Producto> obtenerProductos() {

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

    // Alta de un nuevo producto
    //
    public Boolean altaProducto(Producto producto) {

        int registrosAfectadosConsulta = 0;

        try {
            // Nos conectamos
            conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "INSERT INTO products ("
                    + " productCode ,"
                    + " productName ,"
                    + " productLine ,"
                    + " productScale ,"
                    + " productVendor ,"
                    + " productDescription ,"
                    + " quantityInStock ,"
                    + " buyPrice ,"
                    + " MSRP  )"
                    + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = conexionBBDD.prepareStatement(SQL);
            st.setString(1, producto.getProductCode());
            st.setString(2, producto.getProductName());
            st.setString(3, producto.getProductLine());
            st.setString(4, producto.getProductScale());
            st.setString(5, producto.getProductVendor());
            st.setString(6, producto.getProductDescription());

            st.setInt(7, producto.getQuantityInStock());
            st.setDouble(8, producto.getBuyPrice());
            st.setDouble(9, producto.getMSRP());

            // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
            // nos devuelve el número de registros afectados. Al ser un Insert nos debe devolver 1 si se ha hecho correctamente
            registrosAfectadosConsulta = st.executeUpdate();
            st.close();
            conexionBBDD.close();

            if (registrosAfectadosConsulta == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            return false;
        }
    }

    // Alta de un nuevo producto
    //
    public Boolean actualizarProducto(Producto producto) {

        int registrosAfectadosConsulta = 0;

        try {
            // Nos conectamos
            conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);
            String SQL = "UPDATE products "
                    + " SET "
                    + " productName = ? ,"
                    + " productLine = ? ,"
                    + " productScale = ? ,"
                    + " productVendor = ? ,"
                    + " productDescription = ? ,"
                    + " quantityInStock = ? ,"
                    + " buyPrice = ? ,"
                    + " MSRP = ?  "
                    + " WHERE productCode = ? ";

            PreparedStatement st = conexionBBDD.prepareStatement(SQL);

            st.setString(1, producto.getProductName());
            st.setString(2, producto.getProductLine());
            st.setString(3, producto.getProductScale());
            st.setString(4, producto.getProductVendor());
            st.setString(5, producto.getProductDescription());

            st.setInt(6, producto.getQuantityInStock());
            st.setDouble(7, producto.getBuyPrice());
            st.setDouble(8, producto.getMSRP());

            st.setString(9, producto.getProductCode());

            // Ejecutamos la consulta preparada (con las ventajas de seguridad y velocidad en el servidor de BBDD
            // nos devuelve el número de registros afectados. Al ser un Insert nos debe devolver 1 si se ha hecho correctamente
            registrosAfectadosConsulta = st.executeUpdate();
            st.close();
            conexionBBDD.close();

            if (registrosAfectadosConsulta == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error:" + e.toString());
            return false;
        }
    }
}

