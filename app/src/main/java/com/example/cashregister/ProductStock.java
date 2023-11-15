package com.example.cashregister;

import android.os.Parcelable;

import java.io.Serializable;

public class ProductStock implements Serializable {
    String productName;

    Double productPrice;

    int stockQuantity;


    public ProductStock(String productName, Double productPrice, int stockQuantity){
    this.productName = productName;
    this.productPrice = productPrice;
    this.stockQuantity = stockQuantity;
    }

     public double getPrice() {
        return productPrice;
    }

    public String getProductName(){
        return productName;
    }

    public int getStockQuantity(){
        return stockQuantity;
    }
}
