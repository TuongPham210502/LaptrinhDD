package com.example.listviewnc;

public class Banbe {
    private int hinh;
    private String ten;
    private String gtinh;
    private String tuoi;

    public Banbe(int hinh, String ten, String gtinh, String tuoi) {
        this.hinh = hinh;
        this.ten = ten;
        this.gtinh = gtinh;
        this.tuoi = tuoi;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGtinh() {
        return gtinh;
    }

    public void setGtinh(String gtinh) {
        this.gtinh = gtinh;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }
}
