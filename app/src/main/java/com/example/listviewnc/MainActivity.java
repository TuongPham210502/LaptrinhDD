package com.example.listviewnc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvPhim;
    ArrayList<Phim> arrPhim;
    PhimAdapter adapter;
    Button btThem;
    EditText edtTenPhim, edtNamsx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter = new PhimAdapter(this,R.layout.dong_phim,arrPhim);
        lvPhim.setAdapter(adapter);

        btThem = (Button) findViewById(R.id.buttonThem);
        edtTenPhim = (EditText) findViewById(R.id.textTenphim);
        edtNamsx = (EditText)   findViewById(R.id.textNam);

        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenPhim = edtTenPhim.getText().toString();
                String namSX = edtNamsx.getText().toString();
                arrPhim.add(new Phim(R.drawable.img_1,tenPhim,namSX));
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void AnhXa(){
        lvPhim = (ListView) findViewById(R.id.listviewPhim);
        arrPhim = new ArrayList<>();

        arrPhim.add(new Phim(R.drawable.img_2,"Co dau 8 tuoi","2018"));
        arrPhim.add(new Phim(R.drawable.img_1,"Co dau 8 tuoi","2018"));
        arrPhim.add(new Phim(R.drawable.img_3,"Co dau 8 tuoi","2018"));
    }
}