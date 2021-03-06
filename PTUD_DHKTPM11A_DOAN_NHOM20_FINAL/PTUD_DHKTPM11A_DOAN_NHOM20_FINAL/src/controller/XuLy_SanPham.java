package controller;

import java.util.List;

import dao.SanPhamDao;
import entity.SanPham;

public class XuLy_SanPham {
	SanPhamDao daoSP=new SanPhamDao();
	//tim san pham theo ma
	public SanPham timSanPhamTheoMa(int ma) {
		SanPham sp= daoSP.timTheoMaSanPham(ma);
		return sp;
	}
	//tim san pham theo ten
	public List<SanPham> timSanPhamTheoTen(String ten){
		System.out.println(ten);
		List<SanPham> list=daoSP.timTheoTenSanPham(ten);
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	//tim theo xuat xu san pham
	public List<SanPham> timSanPhamTheoXuatXu(String xuatXu){
		List<SanPham> list=daoSP.timTheoXuatXuSanPham(xuatXu);
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	//danh sach san pham
	public List<SanPham> getAllSanPham(){
		List<SanPham> list=daoSP.getAllSanPham();
		if(list.size()>0) {
			return list;
		}else {
			return null;
		}
	}
	// them san pham
	public boolean themSanPham(SanPham sp) {
		if(daoSP.themSanPham(sp)) {
			return true;
		}else {
			return false;
		}
	}
	// xoa san pham
	public boolean xoaSanPham(SanPham sp) {
		if(daoSP.xoaSanPhamTheoMa(sp.getMaSanPham())) {
			return true;
		}else {
			return false;
		}
	}
	// sua san pham
	public boolean suaSanPham(SanPham sp) {
		if(daoSP.suaSanPham(sp)) {
			return true;
		}else {
			return false;
		}
	}
	// san pham gan het hang
	public List<SanPham> sanPhamGanHetHang(List<SanPham> list) {
		List<SanPham> lst1=daoSP.SanPhamTonKhoGanHet(list);
		return lst1;
	}
	// update san pham
	public boolean UpdateSoLuongSanPham(int slsd,int idSP) {
		if(daoSP.UpdateSoLuongSanPham(slsd, idSP)) {
			return true;
		}else {
			return false;
		}
	}
	
}
