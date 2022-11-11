package com.example.architecture_styles;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private ListView list;
    private String[] array;
    private ArrayAdapter<String> adapter;
    private  Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
  /*  public void onBackPressed(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }  */

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.id_davgr){
            Intent intent = new Intent(MainActivity.this, ancient_greek_architecture.class);
            startActivity(intent);
        }
            else if (id == R.id.id_davrim){
            Intent intent = new Intent(MainActivity.this, ancient_roman_architecture.class);
            startActivity(intent);
        }
            else if (id == R.id.id_visant){
            Intent intent = new Intent(MainActivity.this, Byzantine_architecture.class);
            startActivity(intent);
        }
            else if (id == R.id.id_rom){
            Intent intent = new Intent(MainActivity.this, Roman_style.class);
            startActivity(intent);
        }
            else if (id == R.id.id_got){
            Intent intent = new Intent(MainActivity.this, Gothic_style.class);
            startActivity(intent);
        }
            else if (id == R.id.id_ren){
            Intent intent = new Intent(MainActivity.this, Renaissance.class);
            startActivity(intent);
        }
            else if (id == R.id.id_bar){
            Intent intent = new Intent(MainActivity.this, Baroque.class);
            startActivity(intent);
        }
            else if (id == R.id.id_roc){
            Intent intent = new Intent(MainActivity.this, Rococo.class);
            startActivity(intent);
        }
            else if (id == R.id.id_clas){
            Intent intent = new Intent(MainActivity.this, Classicism.class);
            startActivity(intent);
        }
            else if (id == R.id.id_ecl){
            Intent intent = new Intent(MainActivity.this, Eclecticism.class);
            startActivity(intent);
        }
            else if (id == R.id.id_modern){
            Intent intent = new Intent(MainActivity.this, Modern.class);
            startActivity(intent);
        }
            else if (id == R.id.id_avang){
            Intent intent = new Intent(MainActivity.this, Vanguard.class);
            startActivity(intent);
        }
            else if (id == R.id.id_modernism){
            Intent intent = new Intent(MainActivity.this, Modernism.class);
            startActivity(intent);
        }
            else if (id == R.id.id_postmodernism){
            Intent intent = new Intent(MainActivity.this, Postmodernism.class);
            startActivity(intent);
        }
            else if (id == R.id.id_deconstruct){
            Intent intent = new Intent(MainActivity.this, Deconstructivism.class);
            startActivity(intent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}