package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import entity.TaiKhoan;

public class TaiKhoanDao extends AbstractCRUD<TaiKhoan> {
	// tim tai khoan theo ten
	public TaiKhoan timTheoTenTaiKhoan(String ten){
		return em.find(TaiKhoan.class, ten);
	}
	// xoa tai khoan theo ten
	public boolean xoaTaiKhoanTheoTen(String ten){
		try{
			TaiKhoan tk=timTheoTenTaiKhoan(ten);
			if(tk!=null)
				remove(tk);
			return true;
			
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	// xoa tai khoan
	public boolean xoaTaiKhoan(TaiKhoan tk){
		try{
			xoaTaiKhoanTheoTen(tk.getTenTaiKhoan());
			return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	// doi mat khau
	public boolean doiMatKhau(String ten,String pass){
		try{
			TaiKhoan tk=timTheoTenTaiKhoan(ten);
			if(tk!=null){
				tk.setMatKhau(pass);
				merge(tk);
				return true;
			}else{
				return false;
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	// them tai khoan
	public boolean themTaiKhoan(TaiKhoan tk){
		try{
			
			if(timTheoTenTaiKhoan(tk.getTenTaiKhoan())==null) {
				persist(tk);
				return true;
			}else {
				return false;
			}
				
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	//cap nhat tai khoan
	public boolean suaTaiKhoan(TaiKhoan tk) {
		try {
			
			TaiKhoan tk1=timTheoTenTaiKhoan(tk.getTenTaiKhoan());
			if(tk1!=null) {
				tk1.setMatKhau(tk.getMatKhau());
				tk1.setPhanQuyen(tk.getPhanQuyen());
				tk1.setTrangthai(tk.getTrangthai());
				merge(tk1);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	// cap nhat trang thai lam viec
	public boolean updateTrangThaiDangLam(String ten) {
		try {
			TaiKhoan tk1=timTheoTenTaiKhoan(ten);
			if(tk1!=null){
				tk1.setTrangthai("1");
				merge(tk1);
				return true;
			}else{
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	// cap nhat trang thai khong lam viec
	public boolean updateTrangThaiKhongLam(String ten) {
		try {
			TaiKhoan tk1=timTheoTenTaiKhoan(ten);
			if(tk1!=null){
				tk1.setTrangthai("0");
				merge(tk1);
				return true;
			}else{
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	// get tat ca tai khoan
	public List<TaiKhoan> getAllTaiKhoan(){
		
		List<TaiKhoan>list=new ArrayList<TaiKhoan>();
		String sql ="select t from TaiKhoan t ";
		Query q = em.createQuery(sql, TaiKhoan.class);
		list = q.getResultList();
		return  list;
	}
}
