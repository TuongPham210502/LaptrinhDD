package com.example.apptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.profile);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_activity2();
            }
        });
    }

    public void open_activity2(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}