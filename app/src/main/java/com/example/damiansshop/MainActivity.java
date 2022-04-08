package com.example.damiansshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //Text Views
    TextView mSignInTextView, mRegisterTextView;
    //Edit Texts
    EditText mLoginEmail, mLoginPassword;
    //Buttons
    Button mLoginButton;
    //Firebase Authentication
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing TextViews
        mSignInTextView = findViewById(R.id.SignInTextView);
        mRegisterTextView = findViewById(R.id.RegisterTextView);
        //Initializing EditTexts
        mLoginEmail = findViewById(R.id.LoginEmail);
        mLoginPassword = findViewById(R.id.LoginPassword);
        //Initializing Buttons
        mLoginButton = findViewById(R.id.LoginButton);
        //Initializing Firebase authentication and user
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser!=null)
        {
            finish();
            startActivity(new Intent(MainActivity.this, Register.class));
        }

        mRegisterTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,Register.class));

            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= mLoginEmail.getText().toString().trim();
                String password = mLoginPassword.getText().toString().trim();

                if(email.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"All fields are required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                checkEmailVerification();
                                startActivity(new Intent(MainActivity.this,HomePage.class));


                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Account does not exist", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private void checkEmailVerification() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser.isEmailVerified()==true)
        {
            Toast.makeText(getApplicationContext(), "Logged In", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);

            finish();
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Verify your email please", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}