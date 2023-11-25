package com.example.cashregister;

import java.util.Date;

public class History {

    String Product;

    Double productP;

    int productQuantity;
    Date date;

    public History(String Product, Double productP, int productQuantity, Date date){
        this.Product = Product;
        this.productP = productP;
        this.productQuantity = productQuantity;
        this.date = date;

    }



    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public Double getProductP() {
        return productP;
    }

    public void setProductP(Double productP) {
        this.productP = productP;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }






}
