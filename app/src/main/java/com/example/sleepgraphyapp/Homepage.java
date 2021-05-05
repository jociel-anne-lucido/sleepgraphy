package com.example.sleepgraphyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homepage extends AppCompatActivity {

    private Button button_logout;

    FirebaseUser firebaseUser;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        button_logout = findViewById(R.id.logout_button);

        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

        button_logout.setOnClickListener(v -> {
            auth.signOut();
            Toast.makeText(Homepage.this, "Logout successful.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Homepage.this, LoginActivity.class));
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}