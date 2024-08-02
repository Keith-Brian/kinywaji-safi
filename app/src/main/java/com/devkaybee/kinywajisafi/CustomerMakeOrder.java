package com.devkaybee.kinywajisafi;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerMakeOrder extends AppCompatActivity {

    AutoCompleteTextView autoSelectBranch, autoSelectBrand;
    Button selectSmall, selectMedium, selectLarge, makeOrder;
    ArrayAdapter<String> branchAdapter, brandAdapter;
    Task<Void> reference;

    String[] branch = {"Main Branch","Branch 1", "Branch 2", "Branch 3"};
    String [] brand = {"Coca-la","Black Current", "Fanta", "Apple Juice"};

    String selectedBrand, selectedBranch, selectedSize, selectedPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_make_order);

        autoSelectBranch = findViewById(R.id.selectBranch);
        autoSelectBranch = findViewById(R.id.selectBrand);

        selectSmall = findViewById(R.id.smallSize);
        selectMedium = findViewById(R.id.mediumSize);
        selectLarge = findViewById(R.id.bigiSze);
        makeOrder = findViewById(R.id.makeOrder);

        brandAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item);
        branchAdapter = new ArrayAdapter<String>(this, R.layout.dropdown_item);

        autoSelectBranch.setAdapter(branchAdapter);
        autoSelectBrand.setAdapter(brandAdapter);

        autoSelectBranch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                selectedBranch = adapterView.getItemAtPosition(position).toString();

            }
        });

        autoSelectBrand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                selectedBrand = adapterView.getItemAtPosition(position).toString();

            }
        });

        selectSmall.setOnClickListener(v -> {
            selectedSize = "Small";
            selectedPrice = "Ksh 30";
        });

        selectMedium.setOnClickListener(v -> {
            selectedSize = "Medium";
            selectedPrice = "Ksh 45";
        });

        selectLarge.setOnClickListener(v -> {
            selectedSize = "Large";
            selectedPrice = "Ksh 60";
        });

        makeOrder.setOnClickListener(v -> {
           setMakeOrder();
        });
}

private void setMakeOrder(){
        Orders order = new Orders(selectedBranch, selectedBrand, selectedSize, selectedPrice);
        reference = FirebaseDatabase.getInstance().getReference("Orders").setValue(order)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                       Toast.makeText(this, "Order Placed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}