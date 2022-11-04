package com.example.qlysinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.qlysinhvien.dao.SinhVienDao;
import com.example.qlysinhvien.model.SinhVien;

public class Them extends AppCompatActivity {
    private Button btnExit328,btnLuu328;

    private EditText edtHoten328, edtEmail328,edtSDT328;
    private RadioGroup radioGroupGioitinh328;
    private RadioButton radioNam328,radioNu328;
    private int gioitinh328=1,masv328=0;
    private SinhVienDao svDao328;
    public static boolean capnhat328;
    private SinhVien sinhVien328;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);

        svDao328 = new SinhVienDao(Them.this);
        AnhXa();

        if(capnhat328==true){
            Intent intent = getIntent();
            sinhVien328 = (SinhVien) intent.getSerializableExtra("Sinhvien");
            edtHoten328.setText(sinhVien328.getHoten());
            edtSDT328.setText(sinhVien328.getSoDT());
            edtEmail328.setText(sinhVien328.getEmail());
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
                        sinhVien328.setEmail(edtEmail328.getText().toString());
                        sinhVien328.setSoDT(edtSDT328.getText().toString());
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
                        String sdt = edtSDT328.getText().toString();
                        String email = edtEmail328.getText().toString();
                        sinhVien328 = new SinhVien(masv328,hoten,gioitinh328,sdt,email);
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

    private void clearText(){
        edtHoten328.setText("");
        edtSDT328.setText("");
        edtEmail328.setText("");

    }

    private void AnhXa() {
        edtHoten328 = findViewById(R.id.edtHoten);
        edtSDT328 = findViewById(R.id.edtSDT);
        edtEmail328 = findViewById(R.id.edtEmail);
        radioGroupGioitinh328 = findViewById(R.id.rdgGioitinh);
        radioNam328 = (RadioButton) findViewById(R.id.radioNam);
        radioNu328 = (RadioButton) findViewById(R.id.radioNu);


        btnExit328 = findViewById(R.id.btnThoat);
        btnLuu328 = findViewById(R.id.btnLuu);
    }
}