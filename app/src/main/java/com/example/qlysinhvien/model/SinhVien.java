package com.example.qlysinhvien.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int MaSV;
    private String Hoten;
    private int Gioitinh;
    private String soDT;
    private String Email;

    public SinhVien(){}

    public SinhVien(int maSV, String hoten, int gioitinh, String soDT, String email) {
        this.MaSV = maSV;
        this.Hoten = hoten;
        this.Gioitinh = gioitinh;
        this.soDT = soDT;
        this.Email = email;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int maSV) {
        MaSV = maSV;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public int getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        Gioitinh = gioitinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
