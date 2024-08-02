package com.devkaybee.kinywajisafi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewOrderAdapter extends RecyclerView.Adapter<ViewOrderAdapter.ViewHolder> {

    ArrayList<Orders> list;
    Context context;

    public ViewOrderAdapter(ArrayList<Orders> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.admin_view_order_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewOrderAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView branchName, brandName, selectedSize, itemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            branchName = findViewById(R.id.txtBranchName);
            brandName = findViewById(R.id.txtBrandName);
            selectedSize = findViewById(R.id.txtSize);
            itemPrice = findViewById(R.id.txtprice);
        }
    }
}
