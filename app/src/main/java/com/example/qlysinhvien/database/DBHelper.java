package com.example.qlysinhvien.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "QLySinhVien.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlSinhVienCreate328 = "CREATE TABLE IF NOT EXISTS SinhVien("+
                "MaSV INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "HoTen VARCHAR(200), "+
                "GioiTinh INTEGER, "+
                "SoDT VARCHAR(13), "+
                "Email VARCHAR(200))";
        sqLiteDatabase.execSQL(sqlSinhVienCreate328);

        String sqlInsertSV1 = "INSERT INTO SinhVien(HoTen,GioiTinh,SoDT,Email) VALUES('Nguyen Van Nam',1,'0905123456','mail@mail.com')";
        String sqlInsertSV2 = "INSERT INTO SinhVien(HoTen,GioiTinh,SoDT,Email) VALUES('Pham Binh',1,'0905123356','mail@mail.com')";
        String sqlInsertSV3 = "INSERT INTO SinhVien(HoTen,GioiTinh,SoDT,Email) VALUES('Tran Thi Thu',0,'0905443456','mail@mail.com')";
        sqLiteDatabase.execSQL(sqlInsertSV1);
        sqLiteDatabase.execSQL(sqlInsertSV2);
        sqLiteDatabase.execSQL(sqlInsertSV3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
