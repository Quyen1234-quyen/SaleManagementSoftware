package controller;

import java.util.List;

import dao.NhanVienDao;
import entity.NhanVien;

public class XuLy_NhanVien {
	NhanVienDao daoNV=new NhanVienDao();
	
	//tim nhan vien theo ten
	public NhanVien timNhanVienTheoTen(String ten) {
		NhanVien nv=daoNV.timNhanVienTheoTen(ten);
		if(nv!=null) {
			return nv;
		}else {
			return null;
		}
	}
	//tim nhan vien theo sdt
	public List<NhanVien> timNhanVienThoSDT(String sdt){
		List<NhanVien> list=daoNV.timNhanVienTheoSoDienThoai(sdt);
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	//tim nhan vien theo cmnd
	public List<NhanVien> timNhanVienTheoCMND(String cmnd){
		List<NhanVien> list=daoNV.timNhanVienTheoCMND(cmnd);
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	// tim nhan vien theo gioi tinh
	public List<NhanVien> timNhanVienTheoGioiTinh(String gt){
		List<NhanVien> list=daoNV.timNhanVienTheoGioiTinh(gt);
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	//danh sach nhan vien
	public List<NhanVien> getAllNhanVien(){
		List<NhanVien> list=daoNV.getAllNhanVien();
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	//them nhan vien
	public boolean themNhanVien(NhanVien nv) {
		if(daoNV.themNhanVien(nv)) {
			return true;
		}else {
			return false;
		}
	}
	//xoa nhan vien
	public boolean xoaNhanVien(NhanVien nv) {
		if(daoNV.xoaNhanVien(nv)) {
			return true;
		}else {
			return false;
		}
	}
	//sua nhan vien
	public boolean suaNhanVien(NhanVien nv) {
		if(daoNV.suaNhanVien(nv)) {
			return true;
		}else {
			return false;
		}
	}
}
