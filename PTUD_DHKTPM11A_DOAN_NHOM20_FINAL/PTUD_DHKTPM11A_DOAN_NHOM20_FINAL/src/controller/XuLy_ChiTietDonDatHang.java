package controller;

import java.util.List;

import dao.ChiTietDonDatHangDao;
import entity.ChiTietDonDatHang;

public class XuLy_ChiTietDonDatHang {
	ChiTietDonDatHangDao ctDao=new  ChiTietDonDatHangDao();
	//danh sach ChiTietDonDatHang
	public List<ChiTietDonDatHang> getAllChiTietDonDatHang(){
		if(ctDao.getAllChiTietDonDatHang()!=null) {
			return ctDao.getAllChiTietDonDatHang();
		}else {
			return null;
		}
	}
	// them chi tiet DonDatHang
	public boolean themChiTietDonDatHang(ChiTietDonDatHang ctddh) {
		if(ctDao.themChiTietDonDatHang(ctddh)) {
			return true;
		}else {
			return false;
		}
	}
	//xoa
	public boolean xoaChiTietDonDatHang(ChiTietDonDatHang ctdh) {
		if(ctDao.xoaChiTietDonDatHang(ctdh)) {
			return true;
		}else {
			return false;
		}
	}
	// chi tiet don dat hang theo ma don dat hang
	public List<ChiTietDonDatHang> getALLChiTietDonDatHangTheoMaDDH(int maDDH){
		if(ctDao.getALLChiTietDonDatHangTheoMaDDH(maDDH)!=null) {
			return ctDao.getALLChiTietDonDatHangTheoMaDDH(maDDH);
		}else {
			return null;
		}
	}
	
	public int tongTienDonDatHang(int maDDH) {
		return ctDao.tongTienDonDatHang(maDDH);
	}
}
