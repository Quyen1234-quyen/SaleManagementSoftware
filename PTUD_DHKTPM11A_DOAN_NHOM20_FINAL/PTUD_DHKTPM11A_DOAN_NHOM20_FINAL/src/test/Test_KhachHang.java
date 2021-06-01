package test;

import java.util.List;
import java.util.Scanner;

import controller.XuLy_KhachHang;
import entity.KhachHang;

public class Test_KhachHang {
	public static void main(String []args) {
		XuLy_KhachHang xlKH=new XuLy_KhachHang();
		try {
			int chon;
			Scanner sc=new Scanner(System.in);
			System.out.println("1 : them khach hang");
			System.out.println("2 : danh sach khach hang");
			System.out.println("3 : xoa khach hang");
			System.out.println("4 : sua khach hang");
			System.out.println("5 : tim ten");
			System.out.println("6 : tim cmnd");
			System.out.println("7 : tim sdt");
			System.out.println("8 : tim gt");
			System.out.println("0 : thoat chuong trinh");
			do {
				chon=sc.nextInt();
				switch(chon) {
					case 1:
						sc.nextLine();
						System.out.println("nhap thong tin khach hang");
						System.out.println("ten nhan vien :");
						String tenkh=sc.nextLine();
						System.out.println("cmnd nhan vien :");
						String cmndkh=sc.nextLine();
						System.out.println("gioi tinh nhan vien :");
						String gtkh=sc.nextLine();
						System.out.println("dia chi nhan vien :");
						String dckh=sc.nextLine();
						System.out.println("so dien thoai nhan vien :");
						String sdtkh=sc.nextLine();
						
//						KhachHang kh=new KhachHang(tenkh, cmndkh, gtkh,cmndkh, sdtkh);
						KhachHang kh=new KhachHang();
						if(xlKH.themKhachHang(kh)) {
							System.out.println("them thanh cong");
						}else {
							System.out.println("them khong thanh cong");
						}
						break;
					case 2:
						List<KhachHang> list=xlKH.getAllKhachHang();
						System.out.println("danh sach khach hang");
						if(list!=null) {
							for(KhachHang kh1:list) {
								System.out.println(kh1.toString());
							}
						}
						System.out.println("xong");
						break;
					case 3:
						sc.nextLine();
						System.out.println("nhap ma khach hang can xoa");
						int ma =sc.nextInt();
						String maa=String.valueOf(ma);
						if(xlKH.xoaKhachHang(xlKH.timKhachHangTheoMa(maa))) {
							System.out.println("xoa thanh cong");
						}else {
							System.out.println("xoa that bai");
						}
						break;
					case 4:
						sc.nextLine();
						System.out.println("nhap ma khach hang can sua");
						int ma1 =sc.nextInt();
						String maa1=String.valueOf(ma1);
						if(xlKH.suaKhachHang(xlKH.timKhachHangTheoMa(maa1))) {
							sc.nextLine();
							System.out.println("nhap thong tin khach hang");
							System.out.println("ten nhan vien :");
							String tenkh1=sc.nextLine();
							System.out.println("cmnd nhan vien :");
							String cmndkh1=sc.nextLine();
							System.out.println("gioi tinh nhan vien :");
							String gtkh1=sc.nextLine();
							System.out.println("dia chi nhan vien :");
							String dckh1=sc.nextLine();
							System.out.println("so dien thoai nhan vien :");
							String sdtkh1=sc.nextLine();
//							KhachHang kh2=new KhachHang(maa1, tenkh1, cmndkh1, dckh1, gtkh1, sdtkh1);
							KhachHang kh2=new KhachHang();
							if(xlKH.suaKhachHang(kh2)) {
								System.out.println("sua thanh cong");
							}else {
								System.out.println("sua khong thanh cong");
							}
						}else {
							System.out.println("san pham khong ton tai");
						}
						break;
					case 5:
						sc.nextLine();
						System.out.println("nhap ma khach hang can tim");
						int ma3 =sc.nextInt();
						String maa3=String.valueOf(ma3);
						KhachHang kh4=xlKH.timKhachHangTheoMa(maa3);
						if(kh4!=null) {
							System.out.println("khach hang tim dc");
							System.out.println(kh4.toString());
						}else {
							System.out.println("kh khong tim tahy");
						}
						sc.nextLine();
						System.out.println("nhap ten khach hang can tim");
						String ten3 =sc.nextLine();
						if(xlKH.timKhachHangTheoTen(ten3)!=null) {
							for(KhachHang kh5:xlKH.timKhachHangTheoTen(ten3)) {
								System.out.println(kh5.toString());
							}
						}
						break;
					case 6:
						System.out.println(xlKH.timKhachHangTheoCMND("5454"));
						break;
					case 7:
						break;
					case 8:
						break;
						
					default :chon =0;
				}
				
			}while(chon!=0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
