package controller;

import java.util.List;

import dao.AdminDao;
import entity.Admin;

public class XuLy_Admin {
	AdminDao daoAdmin=new AdminDao();
	// tim admin theo ten
	public Admin timAdminTheoTen(String ten) {
		Admin ad=daoAdmin.timAdminTheoTen(ten);
		return ad;
	}
	
	//tim admin theo so dien thoai
	public List<Admin> timAdminTheoSDT(String sdt){
		List<Admin> list= daoAdmin.timAdminTheoSoDienThoai(sdt);
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	
	//lay tat ca
	public List<Admin> getAllAdmin(){
		List<Admin> list=daoAdmin.getAllAdmin();
		return list;
	}
	
	//them admin
	public boolean themAdmin(Admin ad) {
		if(daoAdmin.themAdmin(ad)) {
			return true;
		}else {
			return false;
		}
	}
	//xoa 
	public boolean xoaAdmin(Admin ad) {
		if(daoAdmin.xoaAdmin(ad)) {
			return true;
		}else {
			return false;
		}
	}
	//sua
	public boolean suaAdmin(String ten,String sdt) {
		if(daoAdmin.suaAdmin(ten,sdt)) {
			return true;
		}else {
			return false;
		}
	}
}
