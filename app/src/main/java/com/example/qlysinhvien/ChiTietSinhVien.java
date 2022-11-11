package com.example.qlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.qlysinhvien.dao.SinhVienDao;
import com.example.qlysinhvien.model.Lop;
import com.example.qlysinhvien.model.SinhVien;

public class ChiTietSinhVien extends AppCompatActivity {
    private SinhVien sinhVien;
    private SinhVienDao sinhVienDao;
    private TextView txtTen, txtNgaySinh, txtLop,txtGioitinh, txtToan,txtTin,txtAnh,txtDiemTB;

    private Button btnCapnhat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sinh_vien);
        AnhXa();

        Intent intent = getIntent();
        sinhVien = (SinhVien) intent.getSerializableExtra("Sinhvien");

        setData();

        btnCapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChiTietSinhVien.this,Them.class);
                Them.capnhat328 = true;
                intent.putExtra("Sinhvien",sinhVien);
                startActivity(intent);
            }
        });

    }
    private void AnhXa(){
        txtTen = findViewById(R.id.chitietTen);
        txtNgaySinh = findViewById(R.id.chitietNamSinh);
        txtLop = findViewById(R.id.chitietLop);
        txtGioitinh = findViewById(R.id.chitietGtinh);
        txtToan = findViewById(R.id.chitietToan);
        txtTin = findViewById(R.id.chitietTin);
        txtAnh = findViewById(R.id.chitietAnh);
        txtDiemTB = findViewById(R.id.chitietDTB);
        btnCapnhat = findViewById(R.id.btnCapnhat);
    }
    private void setData(){
        txtTen.setText(sinhVien.getHoten());
        txtNgaySinh.setText("Năm sinh: "+ sinhVien.getNamSinh());
        txtLop.setText("Lớp: "+sinhVien.getLop());
        if (sinhVien.getGioitinh()==0){
            txtGioitinh.setText("Giới tính: Nữ");
        }
        else{
            txtGioitinh.setText("Giới tính: Nam");
        }
        txtToan.setText(String.valueOf(sinhVien.getDiemToan()));
        txtTin.setText(String.valueOf(sinhVien.getDiemTin()));
        txtAnh.setText(String.valueOf(sinhVien.getDiemAnh()));
        Float dtb = (Float) (sinhVien.getDiemToan()+sinhVien.getDiemTin()+sinhVien.getDiemAnh())/3;
        txtDiemTB.setText(String.format("%.2f", dtb));
    }
    @Override
    protected void onResume() {
        super.onResume();
        sinhVienDao = new SinhVienDao(ChiTietSinhVien.this);
        sinhVien = sinhVienDao.LoadOneSV(String.valueOf(sinhVien.getMaSV()));
        setData();
    }
}