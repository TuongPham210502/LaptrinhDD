package com.example.apptonghop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private LinearLayout layout_profile;
    private LinearLayout layout_listPhim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menuHome);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menuProfile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                    case R.id.menuHome:
                        return true;
                    case R.id.menuList:
                        startActivity(new Intent(getApplicationContext(),ListPhim.class));
                        overridePendingTransition(0,0);
                        finish();
                        return true;
                }
                return false;
            }
        });

        layout_profile = (LinearLayout) findViewById(R.id.profile);
        layout_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_profile();

            }
        });

        layout_listPhim = (LinearLayout) findViewById(R.id.phim);
        layout_listPhim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_listphim();
            }
        });
    }

    public void open_profile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }
    public void open_listphim(){
        Intent intent = new Intent(this, ListPhim.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        finish();
    }
}