package com.example.damiansshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    //Text Views
    TextView mRegisterTextView, mLoginTextView;
    //Edit Texts
    EditText mRegisterName,mRegisterEmail, mRegisterAddress, mRegisterCard, mRegisterPassword;
    //Buttons
    Button mRegisterButton;
    //Firebase Authentication
    private FirebaseAuth firebaseAuth;

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
        //Initialize Firebase Authentication
        firebaseAuth = FirebaseAuth.getInstance();


        mLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_login);
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mRegisterName.getText().toString().trim();
                String email = mRegisterEmail.getText().toString().trim();
                String address = mRegisterAddress.getText().toString().trim();
                String card = mRegisterCard.getText().toString().trim();
                String password = mRegisterPassword.getText().toString().trim();

                if(name.isEmpty() || email.isEmpty() || address.isEmpty() || card.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "All fields must be filled out",Toast.LENGTH_SHORT).show();
                }
                else if(password.length()<6)
                {
                    Toast.makeText(getApplicationContext(), "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show();
                }
                else if(card.length()<15 || card.length()>17)
                {
                    Toast.makeText(getApplicationContext(), "Card number must be 16 digits", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {

                            }
                        }
                    });
                }





            }
        });
    }
}


























