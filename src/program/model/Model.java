package program.model;

import javafx.beans.property.SimpleStringProperty;

public class Model {

    private SimpleStringProperty productName;
    private SimpleStringProperty productPrice;

    public Model(String productName, String productPrice) {
        this.productName = new SimpleStringProperty(productName);
        this.productPrice = new SimpleStringProperty(productPrice);
    }

    public String getProductName() {
        return productName.get();
    }

    public String getProductPrice() {
        return productPrice.get();
    }

    public void setProductName(String productName) {
        this.productName = new SimpleStringProperty(productName);
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = new SimpleStringProperty(productPrice);
    }
}
