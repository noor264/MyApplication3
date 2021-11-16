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

    private EditText et_UsernameS, et_PasswordS;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_UsernameS = findViewById(R.id.etUsernameS);
        et_PasswordS= findViewById(R.id.etPasswordS);
        auth = FirebaseAuth.getInstance();
    }

    public void signup(View view) {

        // TODO: 1- Get data from screen
        String username = et_UsernameS.getText().toString();
        String password = et_UsernameS.getText().toString();

        // TODO: 2- Data validation
        if (username.trim().isEmpty() || password.trim().isEmpty())
        {
            Toast.makeText(this, "Username or password is missing!", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO: 3- Check username and password with Firebase Authentication
        auth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // TODO: commands if successful
                        } else {


                            Toast.makeText(Signup.this,
                                    "Username or password is empty!",
                                    Toast.LENGTH_SHORT).show();
                            return;

                        }}});
    }
}