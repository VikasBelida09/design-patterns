package org.example.VendingMachine;

import java.util.UUID;

public class Product {
    private String productId;
    private String productName;
    private String productDescription;
    private double price;
    private boolean isAvailable;
    public Product(String name, String desc, double price){
        this.productName=name;
        this.productDescription=desc;
        this.price=price;
        this.productId="PR"+ UUID.randomUUID().toString().substring(0,8);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
