package program.model;


public class ProductModel {


    private String productName;
    private double productPrice;

    public ProductModel(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }


}