package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;



public class ManagerActivity extends AppCompatActivity {
    Button historyBtn, restockBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        historyBtn = findViewById(R.id.historyButton);
        restockBtn = findViewById(R.id.restockButton);


        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ManagerActivity.this, RecyclerActivity.class);
                startActivity(intent1);
            }
        });

        restockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ManagerActivity.this, RestockActivity.class);
                startActivity(intent2);
            }
        });

    }

}
