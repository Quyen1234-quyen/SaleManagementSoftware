package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import entity.ChiTietDonDatHang;

public class ChiTietDonDatHangDao extends AbstractCRUD<ChiTietDonDatHang> {
	//danh sach ChiTietDonDatHang
	public List<ChiTietDonDatHang> getAllChiTietDonDatHang(){
		try {
			String sql="select ct from ChiTietDonDatHang ct";
			Query q=em.createQuery(sql,ChiTietDonDatHang.class);
			List<ChiTietDonDatHang> list=q.getResultList();
			return list;
		}catch(Exception e) {
			return null;
		}
	}
	// them chi tiet DonDatHang
	
	public boolean themChiTietDonDatHang(ChiTietDonDatHang ctddh) {
		try {
			if(ctddh!=null) {
				persist(ctddh);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	//xoa chi tiet don hang 
	public boolean xoaChiTietDonDatHang(ChiTietDonDatHang ctdh) {
		try {
			if(ctdh!=null) {
				remove(ctdh);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	// chi tiet don dat hang theo ma don dat hang
	public List<ChiTietDonDatHang> getALLChiTietDonDatHangTheoMaDDH(int maDDH){
		try {
			List<ChiTietDonDatHang> list=new ArrayList<ChiTietDonDatHang>();
			List<ChiTietDonDatHang> list1=getAllChiTietDonDatHang();
			for(ChiTietDonDatHang ctddh:list1) {
				if(ctddh.getDonDatHang().getMaDonDatHang()==maDDH) {
					list.add(ctddh);
				}
			}
			return list;
		}catch(Exception e) {
			return null;
		}
	}
	
	
	//
	public int tongTienDonDatHang(int maDDH) {
		try {
			int tien=0;
			List<ChiTietDonDatHang> list=getALLChiTietDonDatHangTheoMaDDH(maDDH);
			System.out.println(list.size()+"danh sach maddh");
			for(ChiTietDonDatHang ctddh:list) {
				tien=tien+ ctddh.getSoLuong()*ctddh.getGiaSanPham();
				System.out.println(tien +" tien");
			}
			
			return tien;
		}catch(Exception e) {
			return 0;
		}
	}
}
