package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import android.content.Intent;


public class RecyclerActivity extends AppCompatActivity implements HistoryRecyclerAdapter.ProductListener{
    RecyclerView historyRecycler;

  HistoryRecyclerAdapter adapter;
    ArrayList<History> histories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        histories = ((myApp)getApplication()).allHistoryList;
        historyRecycler = findViewById(R.id.historyrecyclerview);
        adapter = new HistoryRecyclerAdapter(histories,this);
        adapter.listener = this;
        historyRecycler.setAdapter(adapter);
        historyRecycler.setLayoutManager(new LinearLayoutManager(this));

    }
    public void onItemClicked(int i) {
        Intent intent=new Intent(RecyclerActivity.this,HistoryDetail.class);
        intent.putExtra("Index",i);
        startActivity(intent);
    }
}