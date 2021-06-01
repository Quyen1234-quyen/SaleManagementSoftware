package test;

import java.util.Scanner;

import controller.XuLy_DangNhap;

public class Test_DangNhap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XuLy_DangNhap xlDN=new XuLy_DangNhap();
		Scanner sc= new Scanner(System.in);
		System.out.println("nhap ten");
		String ten=sc.nextLine();
		System.out.println("nhap mat khau");
		String matKhau=sc.nextLine();
		System.out.println(xlDN.dangNhap(ten, matKhau));
	}

}
