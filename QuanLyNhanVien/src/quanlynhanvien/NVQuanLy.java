/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NVQuanLy extends NhanVien {
    private String chucVu;
    private double phuCapChucVu;

    NVQuanLy(){};
    
    NVQuanLy(String maNhanVien, String tenNhanVien, Date ngayVaoLam, double heSoLuong, String chucVu, double phuCapChucVu) {
        this.setMaNhanVien(maNhanVien);
        this.setTenNhanVien(tenNhanVien);
        this.setNgayVaoLam(ngayVaoLam);
        this.setHeSoLuong(heSoLuong);
        this.setChucVu(chucVu);
        this.setPhuCapChucVu(phuCapChucVu);
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public double getPhuCapChucVu() {
        return phuCapChucVu;
    }

    public void setPhuCapChucVu(double phuCapChucVu) {
        this.phuCapChucVu = phuCapChucVu;
    }
    
    @Override
    public double tinhLuongThucNhan() {
        return getHeSoLuong()*1150000 + getPhuCapChucVu();
    }
    
}
