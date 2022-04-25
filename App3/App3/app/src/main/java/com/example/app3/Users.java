package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Users extends AppCompatActivity {

    EditText username, password, retypepassword;
    Button signup, signin;
    DataBaseInfo DBI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        retypepassword = (EditText) findViewById(R.id.retypepassword);
        signup = (Button) findViewById(R.id.buttonsignup);
        signin = (Button) findViewById(R.id.buttonsignin);
        DBI = new DataBaseInfo(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String retypepass = retypepassword.getText().toString();

                if (user.equals("") || pass.equals("") || retypepass.equals(""))
                    Toast.makeText(Users.this, "Please enter all information", Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(retypepass)){
                        Boolean checkuser = DBI.checkusername(user);
                        if (checkuser == false){
                            Boolean insert = DBI.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(Users.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Home.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Users.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                       else {
                            Toast.makeText(Users.this, "User is already in the System! Please Sign In.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Users.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* This intent takes you to the Home menu bar */
                Intent intent = new Intent(getApplicationContext(),Home.class);
                startActivity(intent);

            }
        });
    }

}