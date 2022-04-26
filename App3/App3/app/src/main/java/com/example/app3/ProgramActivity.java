package com.example.app3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class ProgramActivity extends AppCompatActivity {

    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        drawerLayout = findViewById(R.id.drawer_Layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle
                (this, drawerLayout, R.string.menu_Open,R.string.close_menu);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(actionBarDrawerToggle.onOptionsItemSelected(item)){
                    return true;
                }

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent intent1 = new Intent(ProgramActivity.this, Home.class);
                        startActivity(intent1);
                        return true;

                    case R.id.nav_camera:
                        Intent intent2 = new Intent(ProgramActivity.this, Camera.class);
                        startActivity(intent2);
                        return true;
                        /*Log.i("Menu_Drawer_Tag", "Camera item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break; */

                    case R.id.nav_users:
                        Intent intent3 = new Intent(ProgramActivity.this, Users.class);
                        startActivity(intent3);
                        return true;
                        /*Log.i("Menu_Drawer_Tag", "User item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break; */

                    case R.id.nav_profiles:
                        Intent intent4 = new Intent(ProgramActivity.this, Profiles.class);
                        startActivity(intent4);
                        return true;
                        /*Log.i("Menu_Drawer_Tag", "Profiles item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break; */

                    case R.id.nav_settings:
                        Intent intent5 = new Intent(ProgramActivity.this, Settings.class);
                        startActivity(intent5);
                        return true;
                        /*Log.i("Menu_Drawer_Tag", "Settings item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break; */

                    case R.id.nav_share:
                        Intent intent6 = new Intent(ProgramActivity.this, Share.class);
                        startActivity(intent6);
                        return true;
                        /*Log.i("Menu_Drawer_Tag", "Share item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;*/

                    case R.id.nav_location:
                        Intent intent7 = new Intent(ProgramActivity.this, Location.class);
                        startActivity(intent7);
                        return true;
                        /*Log.i("Menu_Drawer_Tag", "Donate item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;*/

                    case R.id.nav_logout:
                        Log.i("Menu_Drawer_Tag", "Logout item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent8 = new Intent(ProgramActivity.this, Home.class);
                        startActivity(intent8);
                        Toast.makeText(ProgramActivity.this, "You have been logged out", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return ProgramActivity.super.onOptionsItemSelected(item);
                }
                return true;
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.program_activity, menu);
        return true;
    }
}