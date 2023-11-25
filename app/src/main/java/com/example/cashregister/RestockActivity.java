package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class RestockActivity extends AppCompatActivity {
    EditText newQuantity;

    Button okButton, cancelButton;

    ListView restockList;

    ProductBaseAdapter adapter;
    int restockIndex = -1;

    ProductStock currentItem;

    String Input = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.cancelButton);
        restockList = findViewById(R.id.restockList);
        newQuantity=findViewById(R.id.newQuantity);

        adapter = new ProductBaseAdapter(((myApp) getApplication()).allProducts, RestockActivity.this);
        restockList.setAdapter(adapter);

        restockList.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentItem = ((myApp) getApplication()).getAllProducts().get(position);

                restockIndex = position;

                Toast.makeText(RestockActivity.this,((myApp) getApplication()).allProducts.get(position).getProductName(), Toast.LENGTH_SHORT).show();


            }
        });

        newQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                name =((EditText)v).getText().toString();
                Input += name;
             newQuantity.setText(Input);


            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent managIntent  = new Intent(RestockActivity.this, ManagerActivity.class);
        startActivity(managIntent);
    }
});
        okButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (Input != " " && restockIndex != -1) {
            ProductStock pro = ((myApp) getApplication()).allProducts.get(restockIndex);
            pro.setStockQuantity(pro.getStockQuantity() + Integer.parseInt(newQuantity.getText().toString()));
            ((myApp) getApplication()).allProducts.set(restockIndex, pro);
            adapter.notifyDataSetChanged();
            restockIndex=-1;
           newQuantity.setText("");

        } else {
            Toast.makeText(RestockActivity.this, "All fields are required to be filled", Toast.LENGTH_SHORT).show();

        }

    }
});
    }





            }

