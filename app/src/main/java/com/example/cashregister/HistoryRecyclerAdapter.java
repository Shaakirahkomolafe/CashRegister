package com.example.cashregister;

import android.adservices.adselection.TestAdSelectionManager;
import android.view.ViewGroup;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.myViewHolder> {
        interface ProductListener{

                void onItemClicked(int i);


        }
    ArrayList<History> historyArrayList;
    Context context;

  ProductListener listener;



    public HistoryRecyclerAdapter(ArrayList<History> historyArrayList, Context context) {
        this.historyArrayList = historyArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public HistoryRecyclerAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View historyRowView =  LayoutInflater.from(context).inflate(R.layout.product_list_row, parent, false);
        return new myViewHolder(historyRowView);


    }

    @Override
    public void onBindViewHolder(@NonNull HistoryRecyclerAdapter.myViewHolder holder, int position) {
        TextView historyName=  holder.itemView.findViewById(R.id.productName);
        TextView totalPurchase=  holder.itemView.findViewById(R.id.productPrice);
        TextView totalQuantity =  holder.itemView.findViewById(R.id.productStock);

        historyName.setText(historyArrayList.get(position).getProduct());
        totalPurchase.setText(String.valueOf(historyArrayList.get(position).getProductP()));
        totalQuantity.setText(String.valueOf(historyArrayList.get(position).getProductQuantity()));


    }

    @Override
    public int getItemCount() {
        return historyArrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView historyName;
        TextView totalPurchase;
        TextView totalQuantity;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            historyName = itemView.findViewById(R.id.productName);
            totalPurchase = itemView.findViewById(R.id.productPrice);
            totalQuantity= itemView.findViewById(R.id.productStock);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
             listener.onItemClicked(getAdapterPosition());
            }
        }
    }

