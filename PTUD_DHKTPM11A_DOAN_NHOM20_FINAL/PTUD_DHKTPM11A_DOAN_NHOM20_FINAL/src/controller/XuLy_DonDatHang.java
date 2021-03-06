package controller;

import java.util.List;

import dao.DonDatHangDao;
import entity.DonDatHang;
import entity.KhachHang;
import entity.NhanVien;

public class XuLy_DonDatHang {
	DonDatHangDao ddhDao=new DonDatHangDao();
	//tim don dat hang theo ma
	public DonDatHang timDonDatHangTheoMa(int ma) {
		if(ddhDao.timDonDatHangTheoMa(ma)!=null) {
			return ddhDao.timDonDatHangTheoMa(ma);
		}else {
			return null;
		}
	}
	//danh sach don dat hang
	public List<DonDatHang> getAllDonDatHang(){
		if(ddhDao.getAllDonDatHang()!=null) {
			return ddhDao.getAllDonDatHang();
		}else {
			return null;
		}
	}
	// tim hoa don theo ten nhan vien
	public List<DonDatHang> getDonDatHangTheoNhanVien(NhanVien nv){
		if(ddhDao.getDonDatHangTheoNhanVien(nv)!=null) {
			return ddhDao.getDonDatHangTheoNhanVien(nv);
		}else {
			return null;
		}
	}
	// tim don dat hang theo ma khach hang
	public List<DonDatHang> getDonDatHangTheoKhachHang(KhachHang kh){
		if(ddhDao.getDonDatHangTheoKhachHang(kh)!=null) {
			return ddhDao.getDonDatHangTheoKhachHang(kh);
		}else {
			return null;
		}
	}
	//tim don dat hang theo ngay thang nam
	public List<DonDatHang> getDonDatHangTheoNgayThangNam(int thang,int nam,String tt){
		if(ddhDao.getDonDatHangTheoNgayThangNam(thang, nam, tt)!=null) {
			return ddhDao.getDonDatHangTheoNgayThangNam(thang, nam, tt);
		}else {
			return null;
		}
	}
	//them don dat hang
	public boolean themDonDatHang(DonDatHang ddh) {
		if(ddhDao.themDonDatHang(ddh)) {
			return true;
		}else {
			return false;
		}
	}
	//xoa don dat hang
	public boolean xoaDonDatHang(DonDatHang ddh) {
		if(ddhDao.xoaDonDatHang(ddh)) {
			return true;
		}else {
			return false;
		}
	}
	//sua don dat hang
	public boolean suaDonDatHang(DonDatHang ddh) {
		if(ddhDao.suaDonDatHang(ddh)) {
			return true;
		}else {
			return false;
		}
	}
	//tong tien DonDatHang
	public int TongTienDonDatHang(List<DonDatHang> list) {
		return ddhDao.TongTienDonDatHang(list);
	}


		
}
