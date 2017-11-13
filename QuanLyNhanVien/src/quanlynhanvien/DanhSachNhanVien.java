/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;


import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DanhSachNhanVien {

    ArrayList<NhanVien> danhSach = new ArrayList<NhanVien>();
    
    public boolean themNhanVien(NhanVien nv){
        danhSach.add(nv);
        return true;
    }
    
    public NhanVien timNhanVien(String maNhanVien){
        for (int i = 0; i < danhSach.size(); i++) {
            NhanVien nv = danhSach.get(i);
            if(nv.getMaNhanVien().equals(maNhanVien)){
                return nv;
            }
        }
        return null;
    }
    
    public boolean xoaNhanVien(String maNhanVien){
        for (int i = 0; i < danhSach.size(); i++) {
            NhanVien nv = danhSach.get(i);
            if(nv.getMaNhanVien().equals(maNhanVien)){
                danhSach.remove(i);
                return true;
            }
        }
        return false;
    }
//    
    public void getDanhSach(){
        for (int i = 0; i < danhSach.size(); i++) {
            NhanVien nv = danhSach.get(i);
            if(nv instanceof NVBanHang){
            NVBanHang nvbh = (NVBanHang) nv;
            System.out.println("Ma nhan vien : " + nvbh.getMaNhanVien());
            System.out.println("Ten nhan vien : " + nvbh.getTenNhanVien());
            System.out.println("Ngay vao lam : " + nvbh.getNgayVaoLam());
            System.out.println("He So Luong : " + nvbh.getHeSoLuong());
            System.out.println("Luong : " + nvbh.tinhLuongThucNhan());
            System.out.println("So San Pham Ban : " + nvbh.getSoSanPhamBan());
            } else {
                NVQuanLy nvql = (NVQuanLy) nv;
                System.out.println("Ma nhan vien : " + nvql.getMaNhanVien());
                System.out.println("Ten nhan vien : " + nvql.getTenNhanVien());
                System.out.println("Ngay vao lam : " + nvql.getNgayVaoLam());
                System.out.println("He So Luong : " + nvql.getHeSoLuong());
                System.out.println("Luong : " + nvql.tinhLuongThucNhan());
                System.out.println("Chuc Vu : " + nvql.getChucVu());
            }
        }
    }
    
    public NhanVien timNhanVienBanHangNhieuNhat(){
        int max = 0;
        int s = 0;
        for (int i = 0; i < danhSach.size(); i++) {
            NhanVien nv = danhSach.get(i);
            if(nv instanceof NVBanHang){
                NVBanHang nvbh = (NVBanHang) nv;
                if(nvbh.getSoSanPhamBan() > max){
                    max = nvbh.getSoSanPhamBan();
                    s = i;
                }
            }
        }
        return danhSach.get(s);
    }
    
}
