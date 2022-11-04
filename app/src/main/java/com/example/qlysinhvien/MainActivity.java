package com.example.qlysinhvien;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qlysinhvien.adapter.SinhVienAdapter;
import com.example.qlysinhvien.dao.SinhVienDao;
import com.example.qlysinhvien.model.SinhVien;

import org.xml.sax.Parser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnThem328;

    private ListView lvSinhvien328;
    private List<SinhVien> sinhVienList328;
    private SinhVienAdapter sinhVienAdapter328;
    private SinhVienDao sinhVienDao328;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSinhvien328 = findViewById(R.id.lv_sinhvien);

        sinhVienList328 = new ArrayList<SinhVien>();

        sinhVienDao328 = new SinhVienDao(MainActivity.this);
        sinhVienList328 = sinhVienDao328.LoadAllSV();

//        sinhVienList.add(new SinhVien(132,"Nguyen Nam",1,"0905213422","ngnam@email.com"));
//        sinhVienList.add(new SinhVien(123,"Nguyen Van Binh",1,"0905213422","ngbinh@email.com"));
//        sinhVienList.add(new SinhVien(123,"Tran Thi Thu",0,"0905213422","tranthu@email.com"));

        sinhVienAdapter328 = new SinhVienAdapter(getApplicationContext(),sinhVienList328);
        lvSinhvien328.setAdapter(sinhVienAdapter328);

        btnThem328 = findViewById(R.id.btnThem);
        btnThem328.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Them.class);
                Them.capnhat328 = false;
                startActivity(intent);
            }
        });

        SuKienClickItemList();
        SuKienLongClickList();
    }

    private void SuKienClickItemList(){
        lvSinhvien328.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sinhVien = sinhVienList328.get(i);
                Them.capnhat328 = true;
                Intent intent = new Intent(MainActivity.this,Them.class);
                intent.putExtra("Sinhvien",sinhVien);
                startActivity(intent);
            }
        });
    }

    private void SuKienLongClickList()
    {
        lvSinhvien328.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sinhVien = sinhVienList328.get(i);

                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thông báo")
                                .setMessage("Bạn có chắc chắn muốn xóa không?")
                                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                sinhVienDao328.XoaSinhVien(sinhVien);
                                                Toast.makeText(MainActivity.this,"Xóa thành công",Toast.LENGTH_SHORT).show();
                                                onResume();
                                            }
                                        })
                                        .setNegativeButton("Hủy",null).show();
                return false;
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        sinhVienList328.clear();
        sinhVienList328.addAll(sinhVienDao328.LoadAllSV());
        sinhVienAdapter328.notifyDataSetChanged();
    }
}