package program.model;


import java.util.Date;

public class ProductModel {


    private String productName;
    private double productPrice;
    private Date addDate;

    public ProductModel(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.addDate = new Date();
    }

    public ProductModel(String productName, double productPrice, Date date) {
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

    public Date getAddDate() {
        return addDate;
    }

}