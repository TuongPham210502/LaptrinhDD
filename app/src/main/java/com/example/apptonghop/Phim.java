package com.example.apptonghop;

import java.io.Serializable;

public class Phim implements Serializable {
    private int hinhPhim;
    private String tenPhim;
    private String thGian;
    private String moTa;

    public Phim(int hinhPhim, String tenPhim, String thGian, String moTa) {
        this.hinhPhim = hinhPhim;
        this.tenPhim = tenPhim;
        this.thGian = thGian;
        this.moTa = moTa;
    }


    public int getHinhPhim() {
        return hinhPhim;
    }

    public void setHinhPhim(int hinhPhim) {
        this.hinhPhim = hinhPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getThGian() {
        return thGian;
    }

    public void setThGian(String thGian) {
        this.thGian = thGian;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}