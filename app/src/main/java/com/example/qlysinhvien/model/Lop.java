package com.example.qlysinhvien.model;

import java.io.Serializable;

public class Lop implements Serializable {
    private int idLop;
    private String lop;


    public Lop(int idLop, String lop) {
        this.idLop = idLop;
        this.lop = lop;
    }

    public int getIdLop() {
        return idLop;
    }

    public void setIdLop(int idLop) {
        this.idLop = idLop;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
