package com.example.cashregister;

import android.app.Application;

import java.util.ArrayList;

public class myApp extends Application {

    ArrayList<ProductStock> allProducts ;

    ArrayList<History> allHistoryList = new ArrayList<>();

    public ArrayList<History> getAllHistoryList() {
        return allHistoryList;
    }

    public void addNewHistoryItem(History purchaseItem){
        allHistoryList.add(purchaseItem);

    }


    public ArrayList<ProductStock> getAllProducts() {
        if (allProducts == null) {
            allProducts = new ArrayList<>(4);
            allProducts.add(new ProductStock("Pants", 20.44, 10));
            allProducts.add(new ProductStock("Shoes", 10.44, 100));
            allProducts.add(new ProductStock("Hats", 5.9, 30));
            allProducts.add(new ProductStock("Shirts", 25.05, 20));

        }
            return allProducts;


    }
}
