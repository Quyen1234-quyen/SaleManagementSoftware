package test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import controller.XuLy_NhanVien;
import controller.XuLy_TaiKhoan;
import dao.MyEntityManagerFactory;
import entity.NhanVien;

public class Test_NhanVien {
	public static void main(String []args) {
		XuLy_NhanVien xlNV=new XuLy_NhanVien();
		XuLy_TaiKhoan xlTK=new XuLy_TaiKhoan();
		try {
			int chon;
			Scanner sc=new Scanner(System.in);
			System.out.println("1 : danh sach nhan vien");
			System.out.println("2 : tim nhan vien theo ten");
			System.out.println("2 : tim nhan vien theo cmnd");
			System.out.println("3 : tim nhan vien theo sdt");
			System.out.println("4 : tim nhan vien theo gioi tinh");
			System.out.println("5 : them nhan vien");
			System.out.println("6 : xoa nhan vien");
			System.out.println("7 : sua nhan vien");
			System.out.println("0 : thoat chuong trinh");
			do {
				chon=sc.nextInt();
				switch(chon) {
					case 1:
						List<NhanVien> list=xlNV.getAllNhanVien();
						System.out.println("danh sach nhan vien");
						for(NhanVien nv:list) {
							System.out.println(nv.toString());
						}
						break;
					case 2:
						sc.nextLine();
						System.out.println("nhap ten nhan vien can tim");
						String ten=sc.nextLine();
						if(xlNV.timNhanVienTheoTen(ten)!=null) {
							System.out.println("nhan vien ton tai");
							System.out.println(xlNV.timNhanVienTheoTen(ten).toString());
						}
						else {
							System.out.println("nhan vien khong ton tai");
						}
						break;
					case 3:
						sc.nextLine();
						System.out.println("nhap cmnd nhan vien can tim");
						String cmnd=sc.nextLine();
						if(xlNV.timNhanVienTheoCMND(cmnd)!=null) {
							System.out.println("nhan vien ton tai");
							System.out.println(xlNV.timNhanVienTheoCMND(cmnd).toString());
						}
						else {
							System.out.println("nhan vien khong ton tai");
						}
						break;
					case 4:
						sc.nextLine();
						System.out.println("nhap sdt nhan vien can tim");
						String sdt=sc.nextLine();
						if(xlNV.timNhanVienThoSDT(sdt)!=null) {
							System.out.println("nhan vien ton tai");
							System.out.println(xlNV.timNhanVienThoSDT(sdt).toString());
						}else {
							System.out.println("nhan vien khong ton tai");
						}
						break;
					case 5:
						break;
					case 6:
//						sc.nextLine();
//						System.out.println("nhap thong tin nhan vien can them");
//						System.out.println("ten nhan vien :");
//						String tennv=sc.nextLine();
//						System.out.println("cmnd nhan vien :");
//						String cmndnv=sc.nextLine();
//						System.out.println("gioi tinh nhan vien :");
//						String gtnv=sc.nextLine();
//						System.out.println("dia chi nhan vien :");
//						String dcnv=sc.nextLine();
//						System.out.println("so dien thoai nhan vien :");
//						String sdtnv=sc.nextLine();
						
//						NhanVien nv=new NhanVien(tennv, cmndnv, gtnv, dcnv, sdtnv);
						break;
					case 7:
						sc.nextLine();
						System.out.println("nhap ten nhan vien can xoa");
						String tennv=sc.nextLine();
						if(xlNV.xoaNhanVien(xlNV.timNhanVienTheoTen(tennv))) {
							System.out.println("xoa thanh cong");
						}else {
							System.out.println("xoa khong thanh cong");
						}
						break;
					case 8:
						sc.nextLine();
						System.out.println("nhap thong tin nhan vien can sua");
						System.out.println("ten nhan vien :");
						String tennv1=sc.nextLine();
						System.out.println("cmnd nhan vien :");
						String cmndnv=sc.nextLine();
						System.out.println("gioi tinh nhan vien :");
						String gtnv=sc.nextLine();
						System.out.println("dia chi nhan vien :");
						String dcnv=sc.nextLine();
						System.out.println("so dien thoai nhan vien :");
						String sdtnv=sc.nextLine();
//						NhanVien nv=new NhanVien(xlTK.timTheoTen(tennv1),cmndnv,gtnv,dcnv,sdtnv);
						NhanVien nv=new NhanVien();
						if(xlNV.suaNhanVien(nv)) {
							System.out.println("sua thanh cong");
						}else {
							System.out.println("sua khong thanh cong");
						}
						break;
					
					default:chon =0;
				}
				
			}while(chon!=0);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
