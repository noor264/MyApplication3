package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {

    private EditText etUsername,etPassword;
    private Utilities utils;
    private FirebaseServices fbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        connectComponents();
    }

    private void connectComponents() {
        etUsername = findViewById(R.id.etUsernameS);
        etPassword = findViewById(R.id.etPasswordS);
        utils = Utilities.getInstance();
        fbs = FirebaseServices.getInstance();
    }

    public void signup(View view) {

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (username.trim().isEmpty() || password.trim().isEmpty())
        {
            Toast.makeText(this, "Some fields are empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!utils.validateEmail(username) || !utils.validatePassword(password))
        {
            Toast.makeText(this, "Incorrect email or password!", Toast.LENGTH_SHORT).show();
            return;
        }

        fbs.getAuth().createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Signup.this, "successfully registered", Toast.LENGTH_SHORT).show();

                        } else {
                            // TODO: what to do if fails
                        }
                    }
                });


    }
}