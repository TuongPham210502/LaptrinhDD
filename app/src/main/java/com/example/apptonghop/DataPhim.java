package com.example.apptonghop;

public class DataPhim {
    private int HinhPhim;
    private String tenPhim;
    private String thoigian;

    public DataPhim(int hinhPhim, String tenPhim, String thoigian) {
        HinhPhim = hinhPhim;
        this.tenPhim = tenPhim;
        this.thoigian = thoigian;
    }

    public int getHinhPhim() {
        return HinhPhim;
    }

    public void setHinhPhim(int hinhPhim) {
        HinhPhim = hinhPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }
}
