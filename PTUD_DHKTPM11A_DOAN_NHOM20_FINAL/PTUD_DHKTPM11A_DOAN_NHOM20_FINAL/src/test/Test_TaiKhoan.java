package test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import controller.XuLy_TaiKhoan;
import dao.MyEntityManagerFactory;
import entity.TaiKhoan;

public class Test_TaiKhoan {
	public static void main(String []agrs) {
		EntityManager em=MyEntityManagerFactory.getInstance().getEntityManager();
		XuLy_TaiKhoan xlTK= new XuLy_TaiKhoan();
		
		try {
			
			int chon;
			Scanner sc=new Scanner(System.in);
			System.out.println("1 :liet ke tat ca tai khoan");
			System.out.println("2 :tim tai khoan theo ten");
			System.out.println("3 :xoa tai khoan");
			System.out.println("4 :sua mat khau tai khoan");
			System.out.println("5 :cap nhat tai khoan dang lam");
			System.out.println("6 :cap nhat tai khoan khong lam");
			System.out.println("0 :thoat chuong trinh");
			do {
				chon=sc.nextInt();
				switch(chon) {
				case 1:
					List<TaiKhoan> list=xlTK.getAllTaiKhoan();
					System.out.println("tat ca tai khoan");
					for(TaiKhoan tk:list) {
						System.out.println(tk.toString());
					}
					System.out.println("xong");
					break;
				case 2:
					sc.nextLine();
					System.out.println("nhap ten tai khoan can tim");
					String ten=sc.nextLine();
					TaiKhoan tk=xlTK.timTheoTen(ten);
					if(tk!=null) {
						System.out.println("tai khoan ton tai :");
						System.out.println(tk.toString());
					}else {
						System.out.println("tai khoan khong ton tai");
					}
					System.out.println("xong");
					break;
				case 3:
					sc.nextLine();
					System.out.println("nhap ten tai khoan can xoa");
					String tenTK1=sc.nextLine();
					System.out.println("tai khoan can xoa ");
					if(xlTK.timTheoTen(tenTK1)!=null) {
						System.out.println(xlTK.timTheoTen(tenTK1).toString());
					}else {
						System.out.println("tai khoan khong ton tai");
					}
					if(xlTK.xoaTaiKhoan(xlTK.timTheoTen(tenTK1))) {
						System.out.println("xoa thanh cong");
					}else {
						System.out.println("xoa khong thanh cong");
					}
					System.out.println("xong");
					break;
				case 4:
					sc.nextLine();
					System.out.println("nhap ten tai khoan can sua");
					String tenTK =sc.nextLine();
					TaiKhoan tk1=xlTK.timTheoTen(tenTK);
					if(tk1!=null) {
						System.out.println("tai khoan ton tai");
						System.out.println(tk1.toString());
					}else {
						System.out.println("tai khoan khong ton tai");
					}
					
					if(tk1!=null) {
						System.out.println("nhap mat khau moi");
						String matkhau=sc.nextLine();
						if(xlTK.doiMatKhauTaiKhoan(tk1.getTenTaiKhoan(), matkhau)) {
							System.out.println("sua thanh cong");
						}else {
							System.out.println("sua khong thanh cong");
						}
					}
					System.out.println("xong");
					break;
				case 5:
					sc.nextLine();
					System.out.println("nhap ten tai khoan muon kich hoat dang lam");
					String ten12 =sc.nextLine();
					if(xlTK.updateTKDangLam(ten12)) {
						System.out.println("cap nhat thanh cong");
					}else {
						System.out.println("cap nhat that bai");
					}
					
					break;
				case 6:
					sc.nextLine();
					System.out.println("nhap ten tai khoan muon kich hoat khong lam");
					String ten123 =sc.nextLine();
					if(xlTK.updateTKKhongLam(ten123)) {
						System.out.println("cap nhat thanh cong");
					}else {
						System.out.println("cap nhat that bai");
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
