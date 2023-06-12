/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PC
 */
public class Grade {
    private int id;
    private String maSV;
    private String HoTenSV;
    private double TiengAnh;
    private double TinHoc;
    private double GDTC;
    public double DiemTB;

    public Grade() {
    }

    public Grade(int id, String maSV, String HoTenSV, double TiengAnh, double TinHoc, double GDTC, double DiemTB) {
        this.id = id;
        this.maSV = maSV;
        this.HoTenSV = HoTenSV;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
        this.DiemTB = DiemTB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTenSV() {
        return HoTenSV;
    }

    public void setHoTenSV(String HoTenSV) {
        this.HoTenSV = HoTenSV;
    }

    public double getTiengAnh() {
        return TiengAnh;
    }

    public void setTiengAnh(double TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public double getTinHoc() {
        return TinHoc;
    }

    public void setTinHoc(double TinHoc) {
        this.TinHoc = TinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }

    public double getDiemTB() {
        return DiemTB;
    }

    public void setDiemTB(double DiemTB) {
        this.DiemTB = DiemTB;
    }
    
}
