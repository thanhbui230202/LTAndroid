package com.example.bt_cuoiky;

public class LoaiNuoc {
    private String ten;
    private int anh;

    public LoaiNuoc(String ten, int anh) {
        this.ten = ten;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}
