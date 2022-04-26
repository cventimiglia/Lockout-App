package com.example.app3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LandingPage extends AppCompatActivity {
    private TextView greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        greeting.setText("Hello, " + auth.getCurrentUser().getDisplayName().toString());
    }
}
