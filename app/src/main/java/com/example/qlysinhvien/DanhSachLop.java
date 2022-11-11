package com.example.qlysinhvien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.qlysinhvien.adapter.LopAdapter;
import com.example.qlysinhvien.dao.LopDao;
import com.example.qlysinhvien.model.Lop;
import com.example.qlysinhvien.model.SinhVien;

import java.util.ArrayList;

public class DanhSachLop extends AppCompatActivity implements InterfaceClickItem{
    private RecyclerView lvLop328;
    private ArrayList<Lop> lopList328;
    private LopAdapter lopAdapter328;
    private LopDao lopDao328;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_lop);
//
        lvLop328 = findViewById(R.id.lvLop);
        lopList328 = new ArrayList<Lop>();

        lopDao328 = new LopDao(DanhSachLop.this);
        lopList328 = lopDao328.LoadLop();

        lopAdapter328 = new LopAdapter(lopList328, new InterfaceClickItem() {
            @Override
            public void onItemClickLop(Lop lop) {
                goDSSV(lop);
            }

            @Override
            public void onItemClickSinhVien(SinhVien sinhVien) {

            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        lvLop328.setLayoutManager(gridLayoutManager);
        lvLop328.setAdapter(lopAdapter328);
    }

    @Override
    public void onItemClickLop(Lop lop) {

    }

    @Override
    public void onItemClickSinhVien(SinhVien sinhVien) {

    }
    private void goDSSV(Lop lop){
        Intent intent = new Intent(this,MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("objLop",lop);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}