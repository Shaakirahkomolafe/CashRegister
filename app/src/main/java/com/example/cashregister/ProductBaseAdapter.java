package com.example.cashregister;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
public class ProductBaseAdapter extends BaseAdapter {

    ArrayList<ProductStock> productStockArrayList;
    Context activityContext;

    public ProductBaseAdapter(ArrayList<ProductStock> productList, Context activityContext) {
        this.productStockArrayList = productList;
        this.activityContext = activityContext;

    }

    @Override
    public int getCount() {
        return productStockArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return productStockArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {

        View productRowView =  LayoutInflater.from(activityContext).inflate(R.layout.product_list_row, parent, false);

        TextView nameTextView = productRowView.findViewById(R.id.productName);
        TextView priceTextView = productRowView.findViewById(R.id.productPrice);
        TextView quantityTextView = productRowView.findViewById(R.id.productStock);

        nameTextView.setText(productStockArrayList.get(position).productName);
        String priceField = String.valueOf(productStockArrayList.get(position).productPrice);
        priceTextView.setText(priceField);
        quantityTextView.setText(productStockArrayList.get(position).stockQuantity);



        return productRowView;

    }
}