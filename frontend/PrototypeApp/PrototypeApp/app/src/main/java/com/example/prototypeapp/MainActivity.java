package com.example.prototypeapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);

        bottomNav.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.dashboard) {
                fragmentManager.beginTransaction().replace(R.id.frameLayout, new Dashboard()).commit();
                return true;
            } else if (itemId == R.id.planner) {
                fragmentManager.beginTransaction().replace(R.id.frameLayout, new Planner()).commit();
                return true;
            } else if (itemId == R.id.details) {
                fragmentManager.beginTransaction().replace(R.id.frameLayout, new Details()).commit();
                return true;
            } else if (itemId == R.id.new_task) {
                fragmentManager.beginTransaction().replace(R.id.frameLayout, new NewTask()).commit();
                return true;
            }
            return false;
        });

        bottomNav.setSelectedItemId(R.id.dashboard);
    }
}