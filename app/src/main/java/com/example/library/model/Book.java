package com.example.library.model;

public class Book {
    public String maSach;
    public String tenSach;
    public int giaThue;
    public String maLoai;
    public int giamGia;
    public String tacGia;
    public int SoluongCP;
    public String ViTri;

    public Book(String maSach, String tenSach, int giaThue, String maLoai, int giamGia, String tacGia, int SoluongCP, String ViTri) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.giaThue = giaThue;
        this.maLoai = maLoai;
        this.giamGia = giamGia;
        this.tacGia = tacGia;
        this.SoluongCP = SoluongCP;
        this.ViTri = ViTri;
    }

    public Book() {
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(int giaThue) {
        this.giaThue = giaThue;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoluongCP() {
        return SoluongCP;
    }

    public void setSoluongCP(int soluongCP) {
        SoluongCP = soluongCP;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String viTri) {
        ViTri = viTri;
    }
}