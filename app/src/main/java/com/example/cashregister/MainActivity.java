package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;

import android.widget.TextView;
import android.content.DialogInterface;


import android.widget.ListView;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;

import android.app.AlertDialog;

import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<ProductStock> listOfProducts;

    ProductStock currentItem;

    String currentInput = "";

    Double totalSellingPrice;



    Double Total;
    int itemIndex = -1;

    int selectQty;

    TextView productType, totalProduct, quantityProduct;
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buyButton, buttonCancel, managerButton;

    ListView listView;

    ProductBaseAdapter newAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        productType = (TextView) findViewById(R.id.selectedProduct);
        totalProduct = (TextView) findViewById(R.id.totalAmount);
        quantityProduct = (TextView) findViewById(R.id.quant);
        listView = (ListView) findViewById(R.id.listv);


        listOfProducts = ((myApp) getApplication()).getAllProducts();


        newAdapter = new ProductBaseAdapter(listOfProducts, this);
        listView.setAdapter(newAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                currentItem = ((myApp)getApplication()).getAllProducts().get(position);
                productType.setText(currentItem.getProductName());

                if(currentInput != ""){
                    Double ttalPrice = currentItem.getPrice() * Integer.parseInt(currentInput);
                    totalProduct.setText(String.valueOf(ttalPrice));
                }
                itemIndex = position;

                        }
        });

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonCancel = findViewById(R.id.buttoncancel);
        buyButton = findViewById(R.id.buybut);
        managerButton = findViewById(R.id.managerButton);


        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buyButton.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        managerButton.setOnClickListener(this);



    }

public void purchase(int itemIndex, int selectQty){

int availableQty = ((myApp)getApplication()).getAllProducts().get(itemIndex).getStockQuantity();
    ((myApp)getApplication()).getAllProducts().get(itemIndex).setStockQuantity(availableQty - selectQty);

    totalSellingPrice = currentItem.getPrice() * selectQty;
   String itemType = currentItem.getProductName();
    totalProduct.setText (String.format("%.2f", totalSellingPrice));
    totalSellingPrice = Double.parseDouble(String.format("%.2f", totalSellingPrice));
        Date purchaseTime = Calendar.getInstance().getTime();


    History purchaseHistory = new History(itemType, totalSellingPrice, selectQty,purchaseTime);

    ((myApp)getApplication()).addNewHistoryItem(purchaseHistory);



     //implement all methods about this

        newAdapter.productStockArrayList = ((myApp)getApplication()).getAllProducts();
        newAdapter.notifyDataSetChanged();
}

void clearScreen(){
        quantityProduct.setText("");
        productType.setText("");
        itemIndex = -1;
        totalProduct.setText("");
        currentInput="";


    }


    public void onClick(View view) {

        String values;
        switch (view.getId()) {
            case R.id.buttoncancel:
                clearScreen();
                break;

           case R.id.buybut:
               if(itemIndex != -1 && currentInput != ""){
                   int selectedQty = Integer.parseInt(currentInput);

                   purchase(itemIndex,selectedQty);
                   AlertDialog.Builder builder = new AlertDialog.Builder(this);

                   builder.setMessage("You have purchased " + selectedQty + " " + currentItem.getProductName() + " for " + totalSellingPrice);
                builder.setTitle("Thank You For Your Purchase");
                   builder.show();
                   builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       //setonClikcListener to Ok Button
                       public void onClick(DialogInterface dialog, int id) {
                           // open a report activity
                           //reset the textfields/textViews
                           quantityProduct.setText("");
                           quantityProduct.setHint("Quantity");
                           totalProduct.setText("");
                           totalProduct.setHint("Total");
                           productType.setText("");
                           productType.setHint("Product Type");
                       }
                   });

               }


                break;
            case R.id.managerButton:
                Intent managerintent  = new Intent(this, ManagerActivity.class);
                startActivity(managerintent);
                break;
            default:
             values = ((Button)view).getText().toString();
                    currentInput += values;
                    quantityProduct.setText(currentInput);


                    if(itemIndex != -1 ) {
                        Double itemPrice = currentItem.getPrice();
                        String quantity = quantityProduct.getText().toString();
                        int quantityAmt = Integer.parseInt(quantity);
                        Total = itemPrice * quantityAmt;
                        String totalAmount = Double.toString(Total);
                        totalProduct.setText(totalAmount);


                    }
               if (Integer.parseInt(quantityProduct.getText().toString()) > listOfProducts.get(itemIndex).getStockQuantity()) {
                    Toast.makeText(this, "No enough quantity in the stock", Toast.LENGTH_SHORT).show();;
                    //resets quantity, productType and total textViews to blank
                    quantityProduct.setText("");
                    quantityProduct.setHint("Quantity");
                    totalProduct.setText("");
                    totalProduct.setHint("Total");
                  productType.setText("");
                   productType.setHint("Product Type");
                }





        }
    }
}