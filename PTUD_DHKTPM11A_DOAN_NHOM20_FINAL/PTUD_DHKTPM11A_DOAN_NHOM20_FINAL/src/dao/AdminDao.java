package dao;

import java.util.List;

import javax.persistence.Query;

import entity.Admin;

public class AdminDao extends AbstractCRUD<Admin> {
	TaiKhoanDao daoTK=new TaiKhoanDao();
	// tim admin theo ten
	public Admin timAdminTheoTen(String ten) {
		return em.find(Admin.class,ten);
	}
	// tim theo sdt
	public List<Admin> timAdminTheoSoDienThoai(String sdt){
		try{
			String sql="select ad from Admin ad where ad.soDienThoai like :sdt";
			Query q=em.createQuery(sql,Admin.class);
			q.setParameter("sdt", "%"+sdt+"%");
			List<Admin> list=q.getResultList();
			return list;
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	// lay tat ca
	public List<Admin> getAllAdmin(){
		try {
			String sql="select ad from Admin ad";
			Query q=em.createQuery(sql,Admin.class);
			List<Admin> list=q.getResultList();
			
			return list;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	//them 
	public boolean themAdmin(Admin ad){
		try {
			
			if(timAdminTheoTen(ad.getTenAdmin().getTenTaiKhoan())==null)
				persist(ad);
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
	}
	//xoa
	public boolean xoaAdmin(Admin ad){
		try {
			if(timAdminTheoTen(ad.getTenAdmin().getTenTaiKhoan())!=null) {
				remove(ad);
				if(daoTK.xoaTaiKhoanTheoTen(ad.getTenAdmin().getTenTaiKhoan())) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	//xoa theo ten
	public boolean xoaAdminTheoTen(String ten){
		try {
			Admin ad=timAdminTheoTen(ten);
			if(ad!=null) {
				remove(ad);
				if(daoTK.xoaTaiKhoanTheoTen(ad.getTenAdmin().getTenTaiKhoan())) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	//sua
	public boolean suaAdmin(String ten,String sdt){
		try {
			Admin ad=timAdminTheoTen(ten);
			if(ad!=null){
				ad.setSoDienThoai(sdt);
				merge(ad);
				return true;
			}
			else{
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
