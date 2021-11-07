package com.example.javafx_gestion_bbdd_tarea_2_3.controladores;

import com.example.javafx_gestion_bbdd_tarea_2_3.dao.ProductoDAO;
import com.example.javafx_gestion_bbdd_tarea_2_3.modelos.Producto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.sql.SQLException;

public class ProductosController {

    private ProductoDAO productDAO = new ProductoDAO();
    private Producto productoAux;
    private ObservableList <Producto> datos;

    @javafx.fxml.FXML
    private TableColumn tcProductVendor;
    @javafx.fxml.FXML
    private Button btnBorrar;
    @javafx.fxml.FXML
    private TextField txtVendedor;
    @javafx.fxml.FXML
    private TextField txtStock;
    @javafx.fxml.FXML
    private TableColumn tcBuyPrice;
    @javafx.fxml.FXML
    private TableView<Producto> tvProductos;
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
    @javafx.fxml.FXML
    private TableColumn tcProductCode;

    public void initialize()  {

        cargarDatosTabla();
        productoAux = new Producto("","","",
                "","","",0,0d,0d);
        realizarBindingsProductoAux(productoAux);
        cargarGestorDobleCLick();
    }

    private void cargarDatosTabla () {
        datos = productDAO.obtenerProductos();

        tcProductCode.setCellValueFactory(new PropertyValueFactory<Producto, String>("productCode"));
        tcProductDescription.setCellValueFactory(new PropertyValueFactory<Producto, String>("productDescription"));
        tcProductLine.setCellValueFactory(new PropertyValueFactory<Producto, String>("productLine"));
        tcProductName.setCellValueFactory(new PropertyValueFactory<Producto, String>("productName"));
        tcProductScale.setCellValueFactory(new PropertyValueFactory<Producto, String>("productScale"));
        tcProductVendor.setCellValueFactory(new PropertyValueFactory<Producto, String>("productVendor"));

        tcBuyPrice.setCellValueFactory(new PropertyValueFactory<Producto, Double>("buyPrice"));
        tcMSRP.setCellValueFactory(new PropertyValueFactory<Producto, Double>("MSRP"));
        tcQuantityInStock.setCellValueFactory(new PropertyValueFactory<Producto, Integer>("quantityInStock"));

        tvProductos.setItems(datos);
    }

    private void realizarBindingsProductoAux ( Producto producto) {

        txtEscala.textProperty().bindBidirectional(productoAux.productScaleProperty());
        txtDescripcion.textProperty().bindBidirectional(producto.productDescriptionProperty());
        txtID.textProperty().bindBidirectional(producto.productCodeProperty());
        txtLinea.textProperty().bindBidirectional(producto.productLineProperty());
        txtNombre.textProperty().bindBidirectional(producto.productNameProperty());
        txtPrecioCompra.textProperty().bindBidirectional(producto.buyPriceProperty(),new NumberStringConverter());
        txtPrecioVenta.textProperty().bindBidirectional(producto.MSRPProperty(), new NumberStringConverter() );
        txtStock.textProperty().bindBidirectional(producto.quantityInStockProperty(), new NumberStringConverter() );
        txtVendedor.textProperty().bindBidirectional(producto.productVendorProperty());
    }

    // Detectar el doble click en la tabla y cargar los datos en los campos de edición
    private void cargarGestorDobleCLick () {
        tvProductos.setRowFactory(tv -> {
            TableRow<Producto> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    productoAux.setProductCode(row.getItem().getProductCode());
                    productoAux.setProductLine(row.getItem().getProductLine());
                    productoAux.setProductName(row.getItem().getProductName());
                    productoAux.setProductScale(row.getItem().getProductScale());
                    productoAux.setProductVendor(row.getItem().getProductVendor());
                    productoAux.setProductDescription(row.getItem().getProductDescription());
                    productoAux.setBuyPrice(row.getItem().getBuyPrice());
                    productoAux.setMSRP(row.getItem().getMSRP());
                    productoAux.setQuantityInStock(row.getItem().getQuantityInStock());
                }
            });
            return row;
        });
    }

    @javafx.fxml.FXML
    public void onActualizarClicked(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void onAltaClicked(ActionEvent actionEvent) {
        if ( ! productoAux.getProductCode().trim().equals("")) {
            if (productDAO.altaProducto(productoAux)) {
                cargarDatosTabla();
            }
        }
        else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Debe introducir un código de producto.", ButtonType.OK );
                alert.showAndWait();
            }


    }

    @javafx.fxml.FXML
    public void onBorrarClicked(ActionEvent actionEvent) {
    }
}
