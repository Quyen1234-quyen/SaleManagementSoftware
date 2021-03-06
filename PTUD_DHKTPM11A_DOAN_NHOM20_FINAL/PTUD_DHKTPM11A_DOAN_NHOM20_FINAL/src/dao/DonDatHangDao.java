package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import entity.DonDatHang;
import entity.KhachHang;
import entity.NhanVien;

public class DonDatHangDao extends AbstractCRUD<DonDatHang> {
	//tim don dat hang theo ma
	public DonDatHang timDonDatHangTheoMa(int ma) {
		return em.find(DonDatHang.class, ma);
	}
	
	//danh sach don dat hang
	public List<DonDatHang> getAllDonDatHang(){
		try {
			String sql="select ddh from DonDatHang ddh";
			Query q=em.createQuery(sql,DonDatHang.class);
			List<DonDatHang> list=q.getResultList();
			return list;
		}catch(Exception e) {
			return null;
		}
	}
	// tim hoa don theo ten nhan vien
	public List<DonDatHang> getDonDatHangTheoNhanVien(NhanVien nv){
		try {
			String sql="select ddh from DonDatHang ddh";
			Query q=em.createQuery(sql,DonDatHang.class);
			List<DonDatHang> ls=q.getResultList();
			String tenNV=nv.getTenNhanVien().getTenTaiKhoan();
			List<DonDatHang>list =new ArrayList<>();
			for(DonDatHang ddh:ls){
				if(ddh.getNhanVien().getTenNhanVien().getTenTaiKhoan().equals(tenNV)){
					list.add(ddh);
				}
			}
			return list;
			
		}catch(Exception e) {
			return null;
		}
	}
	// tim don dat hang theo ma san pham
	public List<DonDatHang> getDonDatHangTheoKhachHang(KhachHang kh){
		try {
			String sql="select ddh from DonDatHang ddh";
			Query q=em.createQuery(sql,DonDatHang.class);
			List<DonDatHang> ls=q.getResultList();
			String maKH=kh.getMaKhachHang();
			List<DonDatHang>list =new ArrayList<>();
			for(DonDatHang ddh:ls){
				if(ddh.getKhachHang().getMaKhachHang().equals(maKH)){
					list.add(ddh);
				}
			}
			return list;
			
		}catch(Exception e) {
			return null;
		}
	}
	//tim don dat hang theo ngay thang nam
	public List<DonDatHang> getDonDatHangTheoNgayThangNam(int thang,int nam,String tt){
		try {
			List<DonDatHang> ls = new ArrayList<DonDatHang>();
			Query qu = em.createQuery("select o FROM DonDatHang "
					+ "o where FUNCTION('MONTH',o.ngayDatHang) = :mon "
					+ "AND FUNCTION('YEAR',o.ngayDatHang)=:year "
					+"AND o.trangThai= :tt");
			qu.setParameter("mon", thang);
			qu.setParameter("year", nam);
			qu.setParameter("tt", tt);
			ls = qu.getResultList();
			return ls ;
		}catch(Exception e) {
			return null;
		}
	}
	//them don dat hang
	public boolean themDonDatHang(DonDatHang ddh) {
		try {
			if(timDonDatHangTheoMa(ddh.getMaDonDatHang())==null) {
				persist(ddh);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	//xoa don dat hang
	public boolean xoaDonDatHang(DonDatHang ddh) {
		try {
			if(timDonDatHangTheoMa(ddh.getMaDonDatHang())!=null) {
				remove(ddh);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	// sua don dat hang
	public boolean suaDonDatHang(DonDatHang ddh) {
		try {
			System.out.println("ma" +ddh.getMaDonDatHang());
			DonDatHang ddh1=timDonDatHangTheoMa(ddh.getMaDonDatHang());
			if(ddh1!=null) {
				ddh1.setDiaChiNhanHang(ddh.getDiaChiNhanHang());
				ddh1.setKhachHang(ddh.getKhachHang());
				ddh1.setNhanVien(ddh.getNhanVien());
				ddh1.setTongTien(ddh.getTongTien());
				merge(ddh);
				return true;
				
			}else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
	}
	//tong tien DonDatHang
	public int TongTienDonDatHang(List<DonDatHang> list) {
		int tien=0;
		for(DonDatHang ddh:list) {
			tien=+ddh.getTongTien();
		}
		return tien;
	}
}
