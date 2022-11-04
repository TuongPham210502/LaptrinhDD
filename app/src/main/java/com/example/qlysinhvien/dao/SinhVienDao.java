package com.example.qlysinhvien.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlysinhvien.database.DBHelper;
import com.example.qlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {
    private DBHelper csdl328;

    public SinhVienDao(Context context){
        csdl328 = new DBHelper(context);
    }

    public List<SinhVien> LoadAllSV(){
        String sqlSelectSV328 = "SELECT * FROM SinhVien";

        List<SinhVien> sinhVienList328 = new ArrayList<SinhVien>();
        SQLiteDatabase database328 = csdl328.getReadableDatabase();
        Cursor cursor328 = database328.rawQuery(sqlSelectSV328,null);
        cursor328.moveToFirst();
        while (!cursor328.isAfterLast()){
            int masv328 = cursor328.getInt(0);
            String hoten328 = cursor328.getString(1);
            int gioitinh328 = cursor328.getInt(2);
            String sdt328 = cursor328.getString(3);
            String email328 = cursor328.getString(4);
            SinhVien sinhVien328 = new SinhVien(masv328,hoten328,gioitinh328,sdt328,email328);
            sinhVienList328.add(sinhVien328);
            cursor328.moveToNext();
        }
        return sinhVienList328;
    }

    public void ThemSinhVien(SinhVien sv328){
        SQLiteDatabase database328 = csdl328.getWritableDatabase();
        ContentValues values328 = new ContentValues();
        //"INSERT INTO SinhVien(HoTen,GioiTinh,SoDT,Email) VALUES('Nguyen Van Nam',1,'0905123456','mail@mail.com')"
        values328.put("HoTen",sv328.getHoten());
        values328.put("GioiTinh",sv328.getGioitinh());
        values328.put("SoDT",sv328.getSoDT());
        values328.put("Email",sv328.getEmail());

        database328.insert("SinhVien","", values328);
    }

    public void CapNhatSinhVien(SinhVien sv328){
        SQLiteDatabase database328 = csdl328.getWritableDatabase();
        ContentValues values328 = new ContentValues();
        //"INSERT INTO SinhVien(HoTen,GioiTinh,SoDT,Email) VALUES('Nguyen Van Nam',1,'0905123456','mail@mail.com')"
        values328.put("HoTen",sv328.getHoten());
        values328.put("GioiTinh",sv328.getGioitinh());
        values328.put("SoDT",sv328.getSoDT());
        values328.put("Email",sv328.getEmail());
        String masv328 = String.valueOf(sv328.getMaSV());
        database328.update("SinhVien",values328, "MaSV = ?",new String[]{masv328});
    }

    public void XoaSinhVien(SinhVien sv328){
        SQLiteDatabase database328 = csdl328.getWritableDatabase();
        String masv328 = String.valueOf(sv328.getMaSV());
        database328.delete("SinhVien", "MaSV = ?",new String[]{masv328});
    }


}
