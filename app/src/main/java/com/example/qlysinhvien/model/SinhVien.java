package com.example.qlysinhvien.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int MaSV;
    private String Hoten;
    private int Gioitinh;
    private String NamSinh;
    private float DiemToan;
    private float DiemTin;
    private float DiemAnh;
    private String Lop;

    public SinhVien(){}

    public SinhVien(int maSV, String hoten, int gioitinh, String namSinh, float diemToan, float diemTin, float diemAnh, String lop) {
        MaSV = maSV;
        Hoten = hoten;
        Gioitinh = gioitinh;
        NamSinh = namSinh;
        DiemToan = diemToan;
        DiemTin = diemTin;
        DiemAnh = diemAnh;
        Lop = lop;
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

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String namSinh) {
        NamSinh = namSinh;
    }

    public int getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        Gioitinh = gioitinh;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }

    public float getDiemToan() {
        return DiemToan;
    }

    public void setDiemToan(float diemToan) {
        DiemToan = diemToan;
    }

    public float getDiemTin() {
        return DiemTin;
    }

    public void setDiemTin(float diemTin) {
        DiemTin = diemTin;
    }

    public float getDiemAnh() {
        return DiemAnh;
    }

    public void setDiemAnh(float diemAnh) {
        DiemAnh = diemAnh;
    }
}
