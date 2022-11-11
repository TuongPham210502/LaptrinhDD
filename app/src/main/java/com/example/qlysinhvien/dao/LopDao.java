package com.example.qlysinhvien.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlysinhvien.database.DBHelper;
import com.example.qlysinhvien.model.Lop;
import com.example.qlysinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class LopDao {
    private DBHelper csdl328;

    public LopDao(Context context){
        csdl328 = new DBHelper(context);
    }

    public ArrayList<Lop> LoadLop(){
        String sqlSelectLop328 = "SELECT * FROM Lop";

        ArrayList<Lop> lopList328 = new ArrayList<Lop>();
        SQLiteDatabase database328 = csdl328.getReadableDatabase();

        Cursor cursor328 = database328.rawQuery(sqlSelectLop328,null);
        cursor328.moveToFirst();
        while (!cursor328.isAfterLast()){

            int maLop328 = cursor328.getInt(0);
            String tenLop328 = cursor328.getString(1);
            Lop lop328 = new Lop(maLop328,tenLop328);

            lopList328.add(lop328);
            cursor328.moveToNext();
        }
        return lopList328;
    }
}
