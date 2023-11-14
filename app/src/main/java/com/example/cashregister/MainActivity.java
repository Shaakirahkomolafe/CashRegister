package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import android.widget.TextView;

import android.widget.ListView;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView productType, totalProduct, quantityProduct;
    Button button0,button1, button2, button3, button4, button5, button6, button7, button8,button9,buyButton, buttonCancel, managerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       productType = (TextView) findViewById(R.id.selectedProduct);
       totalProduct= (TextView) findViewById(R.id.totalAmount);
       quantityProduct= (TextView) findViewById(R.id.quant);



        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6= findViewById(R.id.button6);
        button7= findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonCancel= findViewById(R.id.buttoncancel);
        buyButton = findViewById(R.id.buybut);
        managerButton = findViewById(R.id.managerButton);




        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener (this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buyButton.setOnClickListener(this);
        managerButton.setOnClickListener(this);



    }
    public void onClick(View view) {

    }
    }
