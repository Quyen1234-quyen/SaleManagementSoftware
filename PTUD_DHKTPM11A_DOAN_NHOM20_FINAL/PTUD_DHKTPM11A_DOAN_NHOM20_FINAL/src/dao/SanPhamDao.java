package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;


import entity.SanPham;

public class SanPhamDao extends AbstractCRUD<SanPham> {
	//tim san pham theo ma
	public SanPham timTheoMaSanPham(int ma){
		return em.find(SanPham.class, ma);
	}
	// tim san pham theo ten
	public List<SanPham> timTheoTenSanPham(String ten1){
		try {
			String sql="select sp from SanPham sp where sp.tenSanPham like :ten";
			Query q=em.createQuery(sql,SanPham.class);
			q.setParameter("ten","%"+ten1+"%");
			List<SanPham> list=q.getResultList();
			return list;
		}catch(Exception e) {
			return null;
		}
	}
	//tim san pham theo xuat xu
	public List<SanPham> timTheoXuatXuSanPham(String xuatxu){
		try {
			String sql="select sp from SanPham sp where sp.xuatXuSanPham like :ten";
			Query q=em.createQuery(sql,SanPham.class);
			q.setParameter("ten","%"+xuatxu+"%");
			List<SanPham> list=q.getResultList();
			return list;
		}catch(Exception e) {
			return null;
		}
	}
	// them san pham
	public boolean themSanPham(SanPham sp) {
		try {
			if(timTheoMaSanPham(sp.getMaSanPham())==null) {
				persist(sp);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	//xoa san pham theo ma
	public boolean xoaSanPhamTheoMa(int ma) {
		try {
			SanPham sp=timTheoMaSanPham(ma);
			if(sp!=null) {
				remove(sp);
				return true;
			}
			else {
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
	}
	// xoa san pham
	public boolean xoaSanPham(SanPham sp) {
		try {
			xoaSanPhamTheoMa(sp.getMaSanPham());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	//sua san pham
	public boolean suaSanPham(SanPham sp) {
		try {
			SanPham spNew=timTheoMaSanPham(sp.getMaSanPham());
			if(spNew!=null) {
				spNew.setGiaSanPham(sp.getGiaSanPham());
				spNew.setTenSanPham(sp.getTenSanPham());
				spNew.setTonKhoSanPham(sp.getTonKhoSanPham());
				spNew.setXuatXuSanPham(sp.getXuatXuSanPham());
				merge(spNew);
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	// update so luong sp
	public boolean UpdateSoLuongSanPham(int slsd,int idSP) {
		try {
			SanPham sp=timTheoMaSanPham(idSP);
			if(sp!=null) {
				int slNew=sp.getTonKhoSanPham()-slsd;
				sp.setTonKhoSanPham(slNew);
				merge(sp);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	//danh sach san pham
	public List<SanPham> getAllSanPham(){
		String sql="select sp from SanPham sp";
		Query q=em.createQuery(sql,SanPham.class);
		List<SanPham> list=q.getResultList();
		return list;
	}
	//san pham gan het hang
	public List<SanPham> SanPhamTonKhoGanHet(List<SanPham> list) {
		List<SanPham>lst=list;
		List<SanPham> lst1=new ArrayList();
		for(SanPham sp:lst) {
			if(sp.getTonKhoSanPham()<5) {
				lst1.add(sp);
			}
		}
		return lst1;
	}
}
