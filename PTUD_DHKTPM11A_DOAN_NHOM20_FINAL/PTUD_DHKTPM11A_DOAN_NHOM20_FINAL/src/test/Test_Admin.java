package test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import controller.XuLy_Admin;
import dao.MyEntityManagerFactory;
import entity.Admin;

public class Test_Admin {
	public static void main(String []args) {
		EntityManager em=MyEntityManagerFactory.getInstance().getEntityManager();
		XuLy_Admin xlAdmin=new XuLy_Admin();
		try {
			int chon;
			Scanner sc=new Scanner(System.in);
			System.out.println("1 : get all admin");
			System.out.println("2 : tim admin theo ten");
			System.out.println("3 : tim admin theo sdt");
			System.out.println("4 : xoa admin");
			System.out.println("5 : sua admin");
			System.out.println("0 : thoat chuong trinh");
			do {
				chon=sc.nextInt();
				switch(chon) {
					case 1:
						List<Admin> list=xlAdmin.getAllAdmin();
						System.out.println("danh sach admin");
						for(Admin ad:list) {
							System.out.println(ad.toString());
						}
						break;
					case 2:
						sc.nextLine();
						System.out.println("nhap ten tai khoan can tim");
						String ten=sc.nextLine();
						if(xlAdmin.timAdminTheoTen(ten)!=null) {
							System.out.println("admin ton tai:");
							System.out.println(xlAdmin.timAdminTheoTen(ten).toString());
						}else {
							System.out.println("admin khong ton tai");
						}
						break;
					case 3:
						sc.nextLine();
						System.out.println("nhap ten tai khoan can xoa");
						String ten1=sc.nextLine();
						if(xlAdmin.xoaAdmin(xlAdmin.timAdminTheoTen(ten1))) {
							System.out.println("xoathanhcong");
						}else {
							System.out.println("xoa khong thanh cong");
						}
						break;
					case 4:
						sc.nextLine();
						System.out.println("nhap ten tai khoan can sua");
						String ten12=sc.nextLine();
						if(xlAdmin.timAdminTheoTen(ten12)!=null) {
							System.out.println("tai khoan ton tai");
							System.out.println("nhap so dien thoai can chinh sua");
							String sdt=sc.nextLine();
							if(xlAdmin.suaAdmin(ten12,sdt)) {
								System.out.println("sua thanh cong");
							}else {
								System.out.println("sua khong thanh cong");
							}
						}else {
							System.out.println("tai khoan khong ton tai");
						}
						
						break;
					case 5:
						sc.nextLine();
						System.out.println("nhap sdt tai khoan can tim");
						String sdt1=sc.nextLine();
						if(xlAdmin.timAdminTheoSDT(sdt1)!=null) {
							System.out.println("tai khoan ton tai");
							System.out.println(xlAdmin.timAdminTheoSDT(sdt1).toString());
						}else {
							System.out.println("tai khoan khong ton tai");
						}
						break;
						
					default: chon=0;
				}
			}while(chon!=0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
