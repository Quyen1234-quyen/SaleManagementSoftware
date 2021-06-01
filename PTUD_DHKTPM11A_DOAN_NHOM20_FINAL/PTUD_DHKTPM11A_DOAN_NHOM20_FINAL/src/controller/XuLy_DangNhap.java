package controller;

public class XuLy_DangNhap {
	XuLy_TaiKhoan xlTK=new XuLy_TaiKhoan();
	public String dangNhap(String ten,String matKhau) {
		if(xlTK.timTheoTen(ten)!=null && xlTK.timTheoTen(ten).getMatKhau().equalsIgnoreCase(matKhau)) {
			return xlTK.timTheoTen(ten).getTenTaiKhoan();
		}
		else {
			return "0";
		}
	}
	
}
