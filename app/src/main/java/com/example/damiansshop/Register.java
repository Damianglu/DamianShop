package com.example.damiansshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    //Text Views
    TextView mRegisterTextView, mLoginTextView;
    //Edit Texts
    EditText mRegisterName,mRegisterEmail, mRegisterAddress, mRegisterCard, mRegisterPassword;
    //Buttons
    Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Initializing TextViews
        mRegisterTextView = findViewById(R.id.RegisterTextView);
        mLoginTextView = findViewById(R.id.LoginTextView);
        //Initializing EditTexts
        mRegisterName = findViewById(R.id.RegisterName);
        mRegisterEmail = findViewById(R.id.RegisterEmail);
        mRegisterAddress = findViewById(R.id.RegisterAddress);
        mRegisterCard = findViewById(R.id.RegisterCard);
        mRegisterPassword = findViewById(R.id.RegisterPassword);
        //Initializing Buttons
        mRegisterButton = findViewById(R.id.RegisterButton);


        mLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_login);
            }
        });
    }
}