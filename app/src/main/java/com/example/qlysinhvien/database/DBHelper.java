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
        String sqlLopCreate328 = "CREATE TABLE IF NOT EXISTS Lop("+
                "MaLop INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "Lop VARCHAR(10))";
        sqLiteDatabase.execSQL(sqlLopCreate328);

        String sqlSinhVienCreate328 = "CREATE TABLE IF NOT EXISTS SinhVien("+
                "MaSV INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "HoTen VARCHAR(200), "+
                "GioiTinh INTEGER, "+
                "NamSinh VARCHAR(4), "+
                "Toan Float, "+
                "Tin float, "+
                "Anh float, "+
                "LopSV Varchar(10) CONSTRAINT LopSV REFERENCES Lop(Lop) ON UPDATE CASCADE ON DELETE CASCADE)";
        sqLiteDatabase.execSQL(sqlSinhVienCreate328);


        String sqlInsertLop1 = "INSERT INTO Lop (Lop) VALUES('20T1')";
        String sqlInsertLop2 = "INSERT INTO Lop (Lop) VALUES('20T2')";
        String sqlInsertLop3 = "INSERT INTO Lop (Lop) VALUES('20T3')";
        String sqlInsertLop4 = "INSERT INTO Lop (Lop) VALUES('22XD1')";
        String sqlInsertLop5 = "INSERT INTO Lop (Lop) VALUES('22DL1')";
        String sqlInsertLop6 = "INSERT INTO Lop (Lop) VALUES('22C1')";

        sqLiteDatabase.execSQL(sqlInsertLop1);
        sqLiteDatabase.execSQL(sqlInsertLop2);
        sqLiteDatabase.execSQL(sqlInsertLop3);
        sqLiteDatabase.execSQL(sqlInsertLop4);
        sqLiteDatabase.execSQL(sqlInsertLop5);
            sqLiteDatabase.execSQL(sqlInsertLop6);
    //SinhVien: MaSV, HoTen, GioiTinh, NamSinh,Toan,Tin,Anh,LopSV
        String sqlInsertSV1 = "INSERT INTO SinhVien(HoTen,GioiTinh,NamSinh,Toan,Tin,Anh,LopSV) VALUES('Nguyen Van Nam',1,'2002',8,8,8,'20T1')";
        String sqlInsertSV2 = "INSERT INTO SinhVien(HoTen,GioiTinh,NamSinh,Toan,Tin,Anh,LopSV) VALUES('Pham Thu Thao',0,'2002',8,8,8,'20T1')";
        String sqlInsertSV3 = "INSERT INTO SinhVien(HoTen,GioiTinh,NamSinh,Toan,Tin,Anh,LopSV) VALUES('Tran Thi Thu',0,'2002',8,8,8,'20T2')";
        String sqlInsertSV4 = "INSERT INTO SinhVien(HoTen,GioiTinh,NamSinh,Toan,Tin,Anh,LopSV) VALUES('Do Duy Khang',1,'2002',8,8,8,'20T3')";
        String sqlInsertSV5 = "INSERT INTO SinhVien(HoTen,GioiTinh,NamSinh,Toan,Tin,Anh,LopSV) VALUES('Tran Hai Binh',1,'2002',8,8,8,'20T3')";
        sqLiteDatabase.execSQL(sqlInsertSV1);
        sqLiteDatabase.execSQL(sqlInsertSV2);
        sqLiteDatabase.execSQL(sqlInsertSV3);
        sqLiteDatabase.execSQL(sqlInsertSV4);
        sqLiteDatabase.execSQL(sqlInsertSV5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
