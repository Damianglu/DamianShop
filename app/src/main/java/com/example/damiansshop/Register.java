package com.example.damiansshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}