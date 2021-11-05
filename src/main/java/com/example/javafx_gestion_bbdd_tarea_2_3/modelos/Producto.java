package com.example.javafx_gestion_bbdd_tarea_2_3.modelos;

import javafx.beans.property.*;

public class Producto {

  private final StringProperty productCode;
  private final StringProperty productName;
  private final StringProperty productLine;
  private final StringProperty productScale;
  private final StringProperty productVendor;
  private final StringProperty productDescription;
  private final IntegerProperty quantityInStock;
  private final DoubleProperty buyPrice;
  private final DoubleProperty MSRP;

  public Producto(String productCode, String productName, String productLine, String productScale,
                  String productVendor, String productDescription, Integer quantityInStock, Double buyPrice,
                  Double MSRP) {
    this.productCode = new SimpleStringProperty(productCode);
    this.productName = new SimpleStringProperty(productName);
    this.productLine = new SimpleStringProperty(productLine);
    this.productScale = new SimpleStringProperty(productScale);
    this.productVendor = new SimpleStringProperty(productVendor);
    this.productDescription = new SimpleStringProperty( productDescription);
    this.quantityInStock = new SimpleIntegerProperty(quantityInStock);
    this.buyPrice = new SimpleDoubleProperty(buyPrice);
    this.MSRP = new SimpleDoubleProperty(MSRP);
  }

  @Override
  public String toString() {
    return "Producto{" +
            "productCode=" + productCode +
            ", productName=" + productName +
            ", productLine=" + productLine +
            ", productScale=" + productScale +
            ", productVendor=" + productVendor +
            ", productDescription=" + productDescription +
            ", quantityInStock=" + quantityInStock +
            ", buyPrice=" + buyPrice +
            ", MSRP=" + MSRP +
            '}';
  }

  public String getProductCode() {
    return productCode.get();
  }

  public StringProperty productCodeProperty() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode.set(productCode);
  }

  public String getProductName() {
    return productName.get();
  }

  public StringProperty productNameProperty() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName.set(productName);
  }

  public String getProductLine() {
    return productLine.get();
  }

  public StringProperty productLineProperty() {
    return productLine;
  }

  public void setProductLine(String productLine) {
    this.productLine.set(productLine);
  }

  public String getProductScale() {
    return productScale.get();
  }

  public StringProperty productScaleProperty() {
    return productScale;
  }

  public void setProductScale(String productScale) {
    this.productScale.set(productScale);
  }

  public String getProductVendor() {
    return productVendor.get();
  }

  public StringProperty productVendorProperty() {
    return productVendor;
  }

  public void setProductVendor(String productVendor) {
    this.productVendor.set(productVendor);
  }

  public String getProductDescription() {
    return productDescription.get();
  }

  public StringProperty productDescriptionProperty() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription.set(productDescription);
  }

  public int getQuantityInStock() {
    return quantityInStock.get();
  }

  public IntegerProperty quantityInStockProperty() {
    return quantityInStock;
  }

  public void setQuantityInStock(int quantityInStock) {
    this.quantityInStock.set(quantityInStock);
  }

  public double getBuyPrice() {
    return buyPrice.get();
  }

  public DoubleProperty buyPriceProperty() {
    return buyPrice;
  }

  public void setBuyPrice(double buyPrice) {
    this.buyPrice.set(buyPrice);
  }

  public double getMSRP() {
    return MSRP.get();
  }

  public DoubleProperty MSRPProperty() {
    return MSRP;
  }

  public void setMSRP(double MSRP) {
    this.MSRP.set(MSRP);
  }
}
