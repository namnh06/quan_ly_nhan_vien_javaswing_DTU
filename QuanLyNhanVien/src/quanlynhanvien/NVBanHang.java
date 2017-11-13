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
public class NVBanHang extends NhanVien {
    private int soSanPhamBan;

    public NVBanHang() {
    };

    NVBanHang(String maNhanVien, String tenNhanVien, Date ngayVaoLam, double heSoLuong, int soSanPhamBan) {
        this.setMaNhanVien(maNhanVien);
        this.setTenNhanVien(tenNhanVien);
        this.setNgayVaoLam(ngayVaoLam);
        this.setHeSoLuong(heSoLuong);
        this.setSoSanPhamBan(soSanPhamBan);
    };

    public int getSoSanPhamBan() {
        return soSanPhamBan;
    }

    public void setSoSanPhamBan(int soSanPhamBan) {
        this.soSanPhamBan = soSanPhamBan;
    }
    
    private double tinhHoaHong(int soSanPhamBan){
        if(soSanPhamBan>=50 && soSanPhamBan<=100){
            return 500000;
        } else if(soSanPhamBan>100){
            return 1000000;
        } else {
            return 0;
        }
        
    }
    
    @Override
    public double tinhLuongThucNhan() {
        return getHeSoLuong()*1150000 + tinhHoaHong(getSoSanPhamBan());
    }
    
}
