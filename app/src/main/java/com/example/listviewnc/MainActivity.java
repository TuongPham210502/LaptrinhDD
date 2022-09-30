package com.example.listviewnc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import android.widget.Toast;


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
                arrPhim.add(new Phim(R.drawable.img_3,tenPhim,namSX));
                Toast.makeText(MainActivity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }
        });

        lvPhim.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrPhim.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this,"Xóa thành công",Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    private void AnhXa(){
        lvPhim = (ListView) findViewById(R.id.listviewPhim);
        arrPhim = new ArrayList<>();

        arrPhim.add(new Phim(R.drawable.img,"Aquaman","2020"));
        arrPhim.add(new Phim(R.drawable.img_1,"Avengers: Endgame","2018"));
        arrPhim.add(new Phim(R.drawable.img_2,"Tom and Jerry","2008"));
    }
}