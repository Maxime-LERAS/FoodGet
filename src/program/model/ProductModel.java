package program.model;


import java.time.LocalDateTime;
import java.util.Date;

public class ProductModel {


    private String productName;
    private double productPrice;
    private LocalDateTime addDate;

    public ProductModel(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.addDate = LocalDateTime.now();
    }

    public ProductModel(String productName, double productPrice, LocalDateTime date) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.addDate = date;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public LocalDateTime getAddDate() {
        return addDate;
    }

}