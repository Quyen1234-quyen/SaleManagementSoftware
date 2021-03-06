package test;

import java.util.List;
import java.util.Scanner;

import controller.XuLy_NhanVien;
import controller.XuLy_SanPham;
import entity.SanPham;

public class Test_SanPham {
	public static void main(String []args) {
		XuLy_SanPham xlSP=new XuLy_SanPham();
		try {
			int chon;
			Scanner sc=new Scanner(System.in);
			System.out.println("1 :danh sach san pham");
			System.out.println("2 :tim san pham theo ma");
			System.out.println("3 :tim san phan theo ten");
			System.out.println("4 :them san pham");
			System.out.println("5 :xoa san pham");
			System.out.println("6 :sua san pham");
			System.out.println("7 :danh sach san pham gan het");
			System.out.println("8 :thoat chuong trinh");
			do {
				chon=sc.nextInt();
				switch(chon) {
					case 1:
						List<SanPham> list=xlSP.getAllSanPham();
						System.out.println("danh sach nhan vien");
						for(SanPham nv:list) {
							System.out.println(nv.toString());
						}
						break;
					case 2:
						sc.nextLine();
						System.out.println("nhap ma san pham can tim");
						int ma=sc.nextInt();
						if(xlSP.timSanPhamTheoMa(ma)!=null) {
							System.out.println("san pham ton tai");
							System.out.println(xlSP.timSanPhamTheoMa(ma).toString());
						}else {
							System.out.println("khong tim thay ");
						}
					case 3:
						sc.nextLine();
						System.out.println("nhap ten tai khoan can tim");
						String ten=sc.nextLine();
						if(xlSP.timSanPhamTheoTen(ten)!=null) {
							System.out.println("san pham ton tai");
							System.out.println(xlSP.timSanPhamTheoTen(ten).toString());
						}else {
							System.out.println("san pham khong ton tai");
						}
						
						break;
					case 4:
						sc.nextLine();
						System.out.println("Nhap thong tin san pham can them");
						System.out.println("gia san pham");
						int gia=sc.nextInt();
						System.out.println("ten san pham");
						sc.nextLine();
						String ten123=sc.nextLine();
						System.out.println("ton kho");
						int tonkho=sc.nextInt();
						System.out.println("XuatXu");
						sc.nextLine();
						String xuatXu=sc.nextLine();
						SanPham sp=new SanPham(ten123, gia, xuatXu, tonkho);
						if(xlSP.themSanPham(sp)) {
							System.out.println("them thanh cong");
						}
						else {
							System.out.println("them that bai");
						}
						break;
					case 5:
						sc.nextLine();
						System.out.println("nhap ma san pham can xoa");
						int masp=sc.nextInt();
						if(xlSP.xoaSanPham(xlSP.timSanPhamTheoMa(masp))) {
							System.out.println("xoa thanh cong");
						}else {
							System.out.println("xoa khong thanh cong");
						}
						break;
					case 6:
						sc.nextLine();
						System.out.println("Nhap thong tin san pham can sua");
						System.out.println("Nhap ma can sua");
						int ma1=sc.nextInt();
						if(xlSP.timSanPhamTheoMa(ma1)!=null) {
							System.out.println("gia san pham");
							int gia1=sc.nextInt();
							System.out.println("ten san pham");
							sc.nextLine();
							String ten13=sc.nextLine();
							System.out.println("ton kho");
							int tonkho1=sc.nextInt();
							System.out.println("XuatXu");
							sc.nextLine();
							String xuatXu1=sc.nextLine();
							SanPham sp123=new SanPham(ma1, ten13, gia1, xuatXu1, tonkho1);
							if(xlSP.suaSanPham(sp123)) {
								System.out.println("sau thanh cong");
							}else {
								System.out.println("sua khong thanh cong");
							}
						}else {
							System.out.println("san pham khong ton tai");
						}
						break;
					case 7:
						List<SanPham> list2=xlSP.sanPhamGanHetHang(xlSP.getAllSanPham());
						if(list2.size()>0) {
							System.out.println("danh sach san pham ton kho");
							for(SanPham sp1: list2) {
								System.out.println(sp1.toString());
							}
						}else {
							System.out.println("khong co");
						}
						
						break;
					default:chon=0;
				}
			}while(chon!=0);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
