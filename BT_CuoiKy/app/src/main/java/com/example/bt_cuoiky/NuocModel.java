package com.example.bt_cuoiky;

public class NuocModel {
    String ten, xuatxu, anh, mota;

    NuocModel(){

    }

    public NuocModel(String ten, String xuatxu, String anh, String mota) {
        this.ten = ten;
        this.xuatxu = xuatxu;
        this.anh = anh;
        this.mota = mota;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
