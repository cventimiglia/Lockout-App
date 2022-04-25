package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    EditText username, password;
    Button buttonlogin, signin;
    DataBaseInfo DBI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        buttonlogin = (Button) findViewById(R.id.buttonsignin1);
        DBI = new DataBaseInfo(this);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(Home.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpasss = DBI.checkusernamepassword(user, pass);
                    if (checkuserpasss == true) {
                        Toast.makeText(Home.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Home.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* This intent takes you to the Profiles menu bar */
                Intent intent = new Intent(getApplicationContext(),Profiles.class);
                startActivity(intent);

            }
        });

    }

}



