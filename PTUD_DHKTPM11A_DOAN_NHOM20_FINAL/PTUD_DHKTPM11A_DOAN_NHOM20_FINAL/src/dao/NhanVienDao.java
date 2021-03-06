package dao;

import java.util.List;

import javax.persistence.Query;

import entity.Admin;
import entity.NhanVien;

public class NhanVienDao extends AbstractCRUD<NhanVien> {
	TaiKhoanDao daoTK=new TaiKhoanDao();
	//tim nhan vien theo ten
	public NhanVien timNhanVienTheoTen(String ten){
		return em.find(NhanVien.class, ten);
	}
	//them nhan vien
	public boolean themNhanVien(NhanVien nv){
		try{
			if(timNhanVienTheoTen(nv.getTenNhanVien().getTenTaiKhoan())==null) {
				persist(nv);
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	//xoa nhan vien
	public boolean xoaNhanVienTheoTen(String ten){
		try{ 
			NhanVien nv=timNhanVienTheoTen(ten);
			if(nv!=null) {
				remove(nv);
				if(daoTK.xoaTaiKhoanTheoTen(nv.getTenNhanVien().getTenTaiKhoan())) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	//xoa nhan vien
	public boolean xoaNhanVien(NhanVien nv){
		try{
			NhanVien nv1=timNhanVienTheoTen(nv.getTenNhanVien().getTenTaiKhoan());
			if(nv1!=null) {
				remove(nv1);
				if(daoTK.xoaTaiKhoanTheoTen(nv1.getTenNhanVien().getTenTaiKhoan())) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	// sua nhan vien
	public boolean suaNhanVien(NhanVien nv1){
		try{
			NhanVien nv=timNhanVienTheoTen(nv1.getTenNhanVien().getTenTaiKhoan());
			if(nv!=null){
				nv.setCmndNV(nv1.getCmndNV());
				nv.setGioiTinh(nv1.getGioiTinh());
				nv.setDiaChi(nv1.getDiaChi());
				nv.setSoDienThoai(nv1.getSoDienThoai());
				merge(nv);
				return true;
				
			}
			else{
				return false;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	// danh sach nhan vien
	public List<NhanVien> getAllNhanVien(){
		try{
			String sql="select nv from NhanVien nv";
			Query q=em.createQuery(sql,NhanVien.class);
			List<NhanVien> list= q.getResultList();
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	//tim nhan vien theo sdt
	public List<NhanVien> timNhanVienTheoSoDienThoai(String soDienThoai){
		try{
			String sql="select nv from NhanVien nv where nv.soDienThoai like '%"+soDienThoai+"%'";
			Query q=em.createQuery(sql,NhanVien.class);
//			q.setParameter("sdt","%"+soDienThoai+"%" );
			List<NhanVien>list=q.getResultList();
			return list;
			
		}catch (Exception e) {
			// TODO: handle exception
			
			return null;
		}
	}
	// tim nhan vien theo cmnd
	public List<NhanVien> timNhanVienTheoCMND(String cmnd){
		try{
			String sql="select nv from NhanVien nv where nv.cmndNV like '%"+cmnd+"%'";
			Query q=em.createQuery(sql,NhanVien.class);
//			q.setParameter("cmnd","%"+cmnd+"%");
			List<NhanVien> list=q.getResultList();
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	// tim nhan vien theo gioi tinh
	public List<NhanVien> timNhanVienTheoGioiTinh(String gt){
		try{
			String sql="select nv from NhanVien nv where nv.gioiTinh like :gt";
			Query q=em.createQuery(sql,NhanVien.class);
			q.setParameter("gt", gt);
			List<NhanVien> list=q.getResultList();
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
