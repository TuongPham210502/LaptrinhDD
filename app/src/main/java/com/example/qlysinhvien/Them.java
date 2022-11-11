package com.example.qlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.qlysinhvien.dao.SinhVienDao;
import com.example.qlysinhvien.model.SinhVien;

import java.util.ArrayList;

public class Them extends AppCompatActivity {
    private Button btnExit328,btnLuu328;

    private EditText edtHoten328, edtNamsinh328,edtToan,edtTin,edtAnh;
    private RadioGroup radioGroupGioitinh328;
    private RadioButton radioNam328,radioNu328;
    private int gioitinh328=1,masv328=0;
    private SinhVienDao svDao328;
    public static boolean capnhat328;
    private SinhVien sinhVien328;
    private Spinner spnLop;
    private String tenLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        final ArrayList<String> arrTenLop = new ArrayList<String>();

        svDao328 = new SinhVienDao(Them.this);
        AnhXa();
        spnLop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tenLop = arrTenLop.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        if(capnhat328==true){
            Intent intent = getIntent();
            sinhVien328 = (SinhVien) intent.getSerializableExtra("Sinhvien");

            edtHoten328.setText(sinhVien328.getHoten());
            edtNamsinh328.setText(sinhVien328.getNamSinh());
            edtToan.setText((int) sinhVien328.getDiemToan());
            edtTin.setText((int) sinhVien328.getDiemTin());
            edtAnh.setText((int) sinhVien328.getDiemAnh());
            gioitinh328 = sinhVien328.getGioitinh();
            if(gioitinh328==1){
                radioNam328.setChecked(true);
            }
            else{
                radioNu328.setChecked(true);
            }
        }

//        Toast.makeText(getApplicationContext(),String.valueOf(sinhVien.getMaSV()),Toast.LENGTH_LONG).show();
        radioGroupGioitinh328.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radioNam)
                    gioitinh328 = 1;
                else
                    gioitinh328 = 0;
            }
        });


        btnExit328.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnLuu328.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(capnhat328 == true){
                    try {
                        sinhVien328.setHoten(edtHoten328.getText().toString());
                        sinhVien328.setGioitinh(gioitinh328);
                        sinhVien328.setNamSinh(edtNamsinh328.getText().toString());
                        sinhVien328.setDiemToan(Float.valueOf(edtToan.getText().toString()));
                        sinhVien328.setDiemTin(Float.valueOf(edtTin.getText().toString()));
                        sinhVien328.setDiemAnh(Float.valueOf(edtAnh.getText().toString()));
                        svDao328.CapNhatSinhVien(sinhVien328);
                        Toast.makeText(getApplicationContext(),"Đã cập nhật",Toast.LENGTH_LONG).show();
                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Cập nhật thất bại!",Toast.LENGTH_LONG).show();
                    }

                }
                if(capnhat328 == false){
                    try {
                        String hoten = edtHoten328.getText().toString();
                        String namsinh = edtNamsinh328.getText().toString();
                        Float toan = Float.valueOf(edtToan.getText().toString());
                        Float tin = Float.valueOf(edtTin.getText().toString());
                        Float anh = Float.valueOf(edtAnh.getText().toString());
                        sinhVien328 = new SinhVien(masv328,hoten,gioitinh328,namsinh,toan,tin,anh,tenLop);
                        svDao328.ThemSinhVien(sinhVien328);
                        Toast.makeText(getApplicationContext(),"Đã thêm sinh viên",Toast.LENGTH_LONG).show();
                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Thêm sinh viên thất bại",Toast.LENGTH_LONG).show();
                    }

                }

//                clearText();
            }
        });
    }

//    private void clearText(){
//        edtHoten328.setText("");
//        edtNamsinh328.setText("");
//        edtToan.setText("");
//
//    }

    private void AnhXa() {
        edtHoten328 = findViewById(R.id.edtHoten);
        edtNamsinh328 = findViewById(R.id.edtNamsinh);
        edtToan = findViewById(R.id.edtToan);
        edtTin = findViewById(R.id.edtTin);
        edtAnh = findViewById(R.id.edtAnh);
        radioGroupGioitinh328 = findViewById(R.id.rdgGioitinh);
        radioNam328 = (RadioButton) findViewById(R.id.radioNam);
        radioNu328 = (RadioButton) findViewById(R.id.radioNu);
        spnLop = (Spinner) findViewById(R.id.spnLop);

        btnExit328 = findViewById(R.id.btnThoat);
        btnLuu328 = findViewById(R.id.btnLuu);
    }
}