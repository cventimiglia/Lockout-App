package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}

