package com.example.apptonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    private TextView txtTen,txtmota;
    private ImageView imgHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if (bundle==null){
            return;
        }
        Phim phim = (Phim) bundle.get("objPhim");

        txtTen = findViewById(R.id.txtTenphim);
        txtmota = findViewById(R.id.txtMota);
        imgHinh = findViewById(R.id.filmImg);

        txtTen.setText(phim.getTenPhim());
        txtmota.setText(phim.getMoTa());
        imgHinh.setImageResource(phim.getHinhPhim());
    }


}