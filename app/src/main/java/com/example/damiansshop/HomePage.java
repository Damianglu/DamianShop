package com.example.damiansshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView mAdminTextView, mShopperTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mAdminTextView = findViewById(R.id.AdminTextView);
        mShopperTextView = findViewById(R.id.ShopperTextView);
    }
}