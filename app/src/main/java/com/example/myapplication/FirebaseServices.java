package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseServices extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_services);
    }
        private static FirebaseServices instance;
        private FirebaseAuth auth;
        private FirebaseFirestore firestore;
        private FirebaseStorage storage;

        public FirebaseAuth getAuth() {
            return auth;
        }

        public FirebaseFirestore getFirestore() {
            return firestore;
        }

        public FirebaseStorage getStorage() {
            return storage;
        }

        public FirebaseServices() {
            auth = FirebaseAuth.getInstance();
            firestore = FirebaseFirestore.getInstance();
            storage = FirebaseStorage.getInstance();
        }

        public static FirebaseServices getInstance() {
            if (instance == null)
            {
                instance = new FirebaseServices();
            }

            return instance;
        }
    }