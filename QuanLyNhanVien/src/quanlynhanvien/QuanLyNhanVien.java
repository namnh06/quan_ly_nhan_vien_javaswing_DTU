/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlynhanvien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class QuanLyNhanVien {
     
    public static void main(String[] args) throws ParseException {
       DanhSachNhanVien ds = new DanhSachNhanVien();
        String dateFormat = "dd/MM/yyyy";
       NVQuanLy nvqltest = new NVQuanLy("q1","NamNH",new SimpleDateFormat(dateFormat).parse("06/10/2009"),3.5,"CTO",50000);
       ds.themNhanVien(nvqltest);
       NVBanHang nvbhtest = new NVBanHang("b2","NamNH BH",new SimpleDateFormat(dateFormat).parse("06/10/2015"),1.5,60);
       ds.themNhanVien(nvbhtest);
        NVBanHang nvbhtest1 = new NVBanHang("b3","ANamNH BH2",new SimpleDateFormat(dateFormat).parse("06/10/2012"),2.5,90);
       ds.themNhanVien(nvbhtest1);
       NVBanHang nvbhtest2 = new NVBanHang("b4","ANamNH BH3",new SimpleDateFormat(dateFormat).parse("02/11/2012"),1.8,40);
       ds.themNhanVien(nvbhtest2);
       QuanLyNhanVien.hoiYeuCau(ds);
    }
    
    public static void hoiYeuCau(DanhSachNhanVien ds) throws ParseException{
        Scanner sc = new Scanner(System.in);
        System.out.println("---***---");
        System.out.println("Ban muon lam gi ?");
        System.out.println("1. Them nhan vien");
        System.out.println("2. Tim nhan vien");
        System.out.println("3. Xoa nhan vien");
        System.out.println("4. Hien thi danh sach nhan vien");
        System.out.println("5. Tim nhan vien ban duoc nhieu san pham nhat");
        System.out.println("9. Thoat");
        System.out.println("---***---");
        switch(sc.nextInt()){
            case 1:
                QuanLyNhanVien.nhapThongTinNhanVien(ds);
                break;
            case 2:
                QuanLyNhanVien.timNhanVien(ds);
                break;
            case 3 :
                QuanLyNhanVien.xoaNhanVien(ds);
                break;
            case 4:
                ds.getDanhSach();
                break;
            case 5:
                QuanLyNhanVien.timNhanVienBanHangNhieuNhat(ds);
                break;
            case 9:
                System.exit(0);
            default:
                System.out.println("Chon sai roi, chon lai di");
                QuanLyNhanVien.hoiYeuCau(ds);
                break;
        }    
         QuanLyNhanVien.hoiYeuCau(ds);
    }
    private static void nhapThongTinNhanVien(DanhSachNhanVien ds) throws ParseException{
            int choice;
            String dateFormat = "dd/MM/yyyy";
            Scanner sc = new Scanner(System.in);
            System.out.println("Chon thong tin Nhan Vien de nhap :");
            System.out.println("1. Nhan Vien Quan Ly");
            System.out.println("2. Nhan Vien Ban Hang");
            System.out.println("Lua chon : ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    NVQuanLy nvql = new NVQuanLy();
                    System.out.println("Nhap thong tin cho Nhan Vien Quan Ly");
                    System.out.println("Nhap ma nhan vien : ");
                    nvql.setMaNhanVien(sc.nextLine());
                    System.out.println("Nhap ten nhan vien : ");
                    nvql.setTenNhanVien(sc.nextLine());
                    System.out.println("Nhap ngay vao lam : ");
                    nvql.setNgayVaoLam(new SimpleDateFormat(dateFormat).parse(sc.nextLine()));
                    System.out.println("Nhap he so luong : ");
                    nvql.setHeSoLuong(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Nhap chuc vu : ");
                    nvql.setChucVu(sc.nextLine());
                    System.out.println("Nhap phu cap chuc vu : ");
                    nvql.setPhuCapChucVu(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Nhap Xong !");
                    if(ds.themNhanVien(nvql)){
                        System.out.println("Them Xong !");
                    }
                    break;
                case 2:
                    NVBanHang nvbh = new NVBanHang();
                    System.out.println("Nhap thong tin cho Nhan Vien Ban Hang");
                    System.out.println("Nhap ma nhan vien : ");
                    nvbh.setMaNhanVien(sc.nextLine());
                    System.out.println("Nhap ten nhan vien : ");
                    nvbh.setTenNhanVien(sc.nextLine());
                    System.out.println("Nhap ngay vao lam : ");
                    nvbh.setNgayVaoLam(new SimpleDateFormat(dateFormat).parse(sc.nextLine()));
                    System.out.println("Nhap he so luong : ");
                    nvbh.setHeSoLuong(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Nhap so san pham ban : ");
                    nvbh.setSoSanPhamBan(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Nhap Xong !");
                    if(ds.themNhanVien(nvbh)){
                    System.out.println("Them Xong !");
                    }
                    break;
                default:
                    System.out.println("Ban lua chon sai roi, chon lai !");
                    QuanLyNhanVien.nhapThongTinNhanVien(ds);
                    break;
            }
            QuanLyNhanVien.hoiYeuCau(ds);
        }
    
    private static void timNhanVien(DanhSachNhanVien ds) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma so nhan vien can tim : ");
        String ma = sc.nextLine();
        if(ds.timNhanVien(ma) != null){
            NhanVien nv = ds.timNhanVien(ma);
            System.out.println("Nhan vien ban can tim co ten la : " + nv.getTenNhanVien());
            if(nv instanceof NVBanHang){
                System.out.println("So san pham ban hang la : " + ((NVBanHang) nv).getSoSanPhamBan());}
            else{
                System.out.println("Chuc vu la : " + ((NVQuanLy) nv).getChucVu());
            }
        }
    }

    private static void xoaNhanVien(DanhSachNhanVien ds) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma so nhan vien can xoa : ");
        if(ds.xoaNhanVien(sc.nextLine())){
            System.out.println("Xoa thanh cong !");
        } else {
            System.out.println("Khong tim thay nhan vien can xoa");
        }
    }

    private static void timNhanVienBanHangNhieuNhat(DanhSachNhanVien ds) {
        NVBanHang nv = (NVBanHang) ds.timNhanVienBanHangNhieuNhat();
        System.out.println("Ma nhan vien ban hang nhieu nhat la : " + nv.getMaNhanVien());
        System.out.println("Ten nhan vien ban hang nhieu nhat la : " + nv.getTenNhanVien());
        System.out.println("So san pham ban duoc la : " + nv.getSoSanPhamBan());
        
    }

  
    
}
