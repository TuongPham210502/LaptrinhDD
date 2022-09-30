package com.example.listviewnc;

public class Phim {
    private int hinh;
    private String ten;
    private String namsx;

    public Phim(int hinh, String ten, String namsx) {
        this.hinh = hinh;
        this.ten = ten;
        this.namsx = namsx;
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

    public String getNamsx() {
        return namsx;
    }

    public void setNamsx(String namsx) {
        this.namsx = namsx;
    }
}
