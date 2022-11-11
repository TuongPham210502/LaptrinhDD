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

    public List<SinhVien> LoadAllSV(String maLop){
        String sqlSelectSV328 = "SELECT * FROM SinhVien where LopSV = '"+maLop+ "'";

        List<SinhVien> sinhVienList328 = new ArrayList<SinhVien>();
        SQLiteDatabase database328 = csdl328.getReadableDatabase();
        Cursor cursor328 = database328.rawQuery(sqlSelectSV328,null);
        cursor328.moveToFirst();
        while (!cursor328.isAfterLast()){

            int masv328 = cursor328.getInt(0);
            String hoten328 = cursor328.getString(1);
            int gioitinh328 = cursor328.getInt(2);
            String namsinh328 = cursor328.getString(3);
            Float diemtoan = cursor328.getFloat(4);
            Float diemtin = cursor328.getFloat(5);
            Float diemanh = cursor328.getFloat(6);
            String lopsv = cursor328.getString(7);
            SinhVien sinhVien328 = new SinhVien(masv328,hoten328,gioitinh328,namsinh328,diemtoan,diemtin,diemanh,lopsv);

            sinhVienList328.add(sinhVien328);
            cursor328.moveToNext();
        }
        return sinhVienList328;
    }
    public SinhVien LoadOneSV(String maSV){
        SinhVien sinhVien;
        String sql = "SELECT * FROM SinhVien where MaSV = '"+ maSV +"'";
        SQLiteDatabase database = csdl328.getReadableDatabase();
        Cursor cursor328 = database.rawQuery(sql,null);
        cursor328.moveToFirst();

            int masv328 = cursor328.getInt(0);
            String hoten328 = cursor328.getString(1);
            int gioitinh328 = cursor328.getInt(2);
            String namsinh328 = cursor328.getString(3);
            Float diemtoan = cursor328.getFloat(4);
            Float diemtin = cursor328.getFloat(5);
            Float diemanh = cursor328.getFloat(6);
            String lopsv = cursor328.getString(7);
            sinhVien = new SinhVien(masv328,hoten328,gioitinh328,namsinh328,diemtoan,diemtin,diemanh,lopsv);

            cursor328.moveToNext();
        return sinhVien;
    }
    public void ThemSinhVien(SinhVien sv328){
        SQLiteDatabase database328 = csdl328.getWritableDatabase();
        ContentValues values328 = new ContentValues();
//SinhVien: MaSV, HoTen, GioiTinh, NamSinh,Toan,Tin,Anh,LopSV
        //INSERT INTO SinhVien(HoTen,GioiTinh,NamSinh,Toan,Tin,Anh,LopSV)
        values328.put("HoTen",sv328.getHoten());
        values328.put("GioiTinh",sv328.getGioitinh());
        values328.put("NamSinh",sv328.getNamSinh());
        values328.put("Toan",sv328.getDiemToan());
        values328.put("Tin",sv328.getDiemTin());
        values328.put("Anh",sv328.getDiemAnh());
        values328.put("LopSV",sv328.getLop());

        database328.insert("SinhVien","", values328);
    }

    public void CapNhatSinhVien(SinhVien sv328){
        SQLiteDatabase database328 = csdl328.getWritableDatabase();
        ContentValues values328 = new ContentValues();
        //"INSERT INTO SinhVien(HoTen,GioiTinh,SoDT,Email) VALUES('Nguyen Van Nam',1,'0905123456','mail@mail.com')"
        values328.put("HoTen",sv328.getHoten());
        values328.put("GioiTinh",sv328.getGioitinh());
        values328.put("NamSinh",sv328.getNamSinh());
        values328.put("Toan",sv328.getDiemToan());
        values328.put("Tin",sv328.getDiemTin());
        values328.put("Anh",sv328.getDiemAnh());
        values328.put("LopSV",sv328.getLop());

        String masv328 = String.valueOf(sv328.getMaSV());
        database328.update("SinhVien",values328, "MaSV = ?",new String[]{masv328});
    }

    public void XoaSinhVien(SinhVien sv328){
        SQLiteDatabase database328 = csdl328.getWritableDatabase();
        String masv328 = String.valueOf(sv328.getMaSV());
        database328.delete("SinhVien", "MaSV = ?",new String[]{masv328});
    }


}
