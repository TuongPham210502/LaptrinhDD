package com.example.apptonghop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    private ImageButton btBack;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.menuProfile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menuProfile:
                        return true;
                    case R.id.menuHome:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        finish();
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


        btBack = (ImageButton) findViewById(R.id.profileback);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog = new AlertDialog.Builder(ProfileActivity.this)
                        .setTitle("Thông báo")
                        .setMessage("Bạn có muốn đăng xuất không?")
                        .setPositiveButton("Có",null)
                        .setNegativeButton("Không",null)
                        .show();

                Button  yesBt = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                yesBt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        logout();
                    }
                });
            }
        });

    }
    public void logout(){
        Intent intent = new Intent( ProfileActivity.this, SignInActivity.class );
        intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
        startActivity( intent );
    }
}