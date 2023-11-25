package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class HistoryDetail extends AppCompatActivity {
TextView detailProduct, detailPrice, purchaseDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

   detailProduct= findViewById(R.id.detailProduct);
         detailPrice= findViewById(R.id.detailPrice);
      purchaseDate=findViewById(R.id.purchaseDate);
        int  index = getIntent().getIntExtra("Index",0);

        History hist=((myApp) getApplication()).allHistoryList.get(index);

     detailProduct.setText(String.format("%s%s", detailProduct.getText().toString(), hist.getProduct()));
       detailPrice.setText(String.format("%s%s",detailPrice.getText().toString(), String.valueOf(hist.getProductP())));
      purchaseDate.setText(String.format("%s%s",purchaseDate.getText().toString(), String.valueOf(hist.getDate())));

    }
}