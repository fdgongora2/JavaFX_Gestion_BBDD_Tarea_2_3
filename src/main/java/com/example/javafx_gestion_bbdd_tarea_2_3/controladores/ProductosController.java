package com.example.javafx_gestion_bbdd_tarea_2_3.controladores;

import com.example.javafx_gestion_bbdd_tarea_2_3.dao.ProductoDAO;
import com.example.javafx_gestion_bbdd_tarea_2_3.modelos.Producto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class ProductosController {

    private ProductoDAO productDAO = new ProductoDAO();
    private ObservableList <Producto> datos;

    @javafx.fxml.FXML
    private TableColumn tcProductVendor;
    @javafx.fxml.FXML
    private Button btnBorrar;
    @javafx.fxml.FXML
    private TableColumn tcProductCode;
    @javafx.fxml.FXML
    private TextField txtVendedor;
    @javafx.fxml.FXML
    private TextField txtStock;
    @javafx.fxml.FXML
    private TableColumn tcBuyPrice;
    @javafx.fxml.FXML
    private TableView tvProductos;
    @javafx.fxml.FXML
    private TableColumn tcQuantityInStock;
    @javafx.fxml.FXML
    private TextField txtID;
    @javafx.fxml.FXML
    private TextField txtNombre;
    @javafx.fxml.FXML
    private TextField txtEscala;
    @javafx.fxml.FXML
    private TableColumn tcProductDescription;
    @javafx.fxml.FXML
    private TextField txtPrecioCompra;
    @javafx.fxml.FXML
    private TableColumn tcProductScale;
    @javafx.fxml.FXML
    private Button btnAlta;
    @javafx.fxml.FXML
    private TableColumn tcMSRP;
    @javafx.fxml.FXML
    private TextField txtPrecioVenta;
    @javafx.fxml.FXML
    private TextField txtLinea;
    @javafx.fxml.FXML
    private TableColumn tcProductName;
    @javafx.fxml.FXML
    private TableColumn tcProductLine;
    @javafx.fxml.FXML
    private TextField txtDescripcion;
    @javafx.fxml.FXML
    private Button btnActualizar;

    public void initialize()  {
        datos = productDAO.obtenerProductos();
        tvProductos.setItems(datos);
        tcProductVendor.setCellValueFactory(new PropertyValueFactory<Producto, String>("productCode"));

    }
}
