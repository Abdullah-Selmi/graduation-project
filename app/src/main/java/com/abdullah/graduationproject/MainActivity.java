package com.abdullah.graduationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    View HomeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findHomeViews();
        ReadyForDrawer(savedInstanceState);
    }

    private void ReadyForDrawer(Bundle savedInstanceState) {
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
        toolbar.setTitle(R.string.app_name);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        if (SaveSharedPreference.getUserName(MainActivity.this).equals("")) {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new HomeFragment()).commit();
                    toolbar.setTitle(R.string.app_name);
                    break;
                case R.id.nav_profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ProfileFragment()).commit();
                    toolbar.setTitle(R.string.app_name);
                    break;
                case R.id.nav_favorite:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FavoriteFragment()).commit();
                    toolbar.setTitle(R.string.app_name);
                    break;
                case R.id.nav_water:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new WaterFragment()).commit();
                    toolbar.setTitle(R.string.app_name);
                    break;
                case R.id.nav_fruits_and_vegetables:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new FruitsAndVegetablesFragment()).commit();
                    toolbar.setTitle(R.string.app_name);
                    break;
                case R.id.nav_seeds:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new SeedsFragment()).commit();
                    toolbar.setTitle(R.string.app_name);
                    break;
                case R.id.nav_tools:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new ToolsFragment()).commit();
                    toolbar.setTitle(R.string.app_name);
                    break;
                case R.id.nav_worker:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new WorkerFragment()).commit();
                    toolbar.setTitle(R.string.app_name);
                    break;
            }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void findHomeViews() {
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        HomeView = navigationView.getHeaderView(0);
        drawerLayout = findViewById(R.id.drawerLayout);
    }
}