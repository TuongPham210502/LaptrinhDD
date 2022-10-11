package com.example.apptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout_profile;
    private LinearLayout layout_listPhim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
    public void open_listphim(){
        Intent intent = new Intent(this, ListPhim.class);
        startActivity(intent);
    }
}