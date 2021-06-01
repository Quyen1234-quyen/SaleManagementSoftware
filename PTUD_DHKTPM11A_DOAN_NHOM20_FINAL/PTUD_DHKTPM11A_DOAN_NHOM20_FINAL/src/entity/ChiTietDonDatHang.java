package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ChiTietDonDatHang")
@IdClass(ChiTietDonDatHang_PK.class)
public class ChiTietDonDatHang implements Serializable{
	@Id
	@ManyToOne()
	@JoinColumn(name="maDonDatHang")
	private DonDatHang DonDatHang;
	@Id
	@ManyToOne()
	@JoinColumn(name="maSanPham")
	private SanPham SanPham;
	@Column(name="soLuong")
	private int soLuong;
	
	@Column(name="giaSanPham")
	private int giaSanPham;

	public DonDatHang getDonDatHang() {
		return DonDatHang;
	}

	public void setDonDatHang(DonDatHang donDatHang) {
		DonDatHang = donDatHang;
	}

	public SanPham getSanPham() {
		return SanPham;
	}

	public void setSanPham(SanPham sanPham) {
		SanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGiaSanPham() {
		return giaSanPham;
	}

	public void setGiaSanPham(int giaSanPham) {
		this.giaSanPham = giaSanPham;
	}

	@Override
	public String toString() {
		return "ChiTietDonDatHang [DonDatHang=" + DonDatHang + ", SanPham=" + SanPham + ", soLuong=" + soLuong
				+ ", giaSanPham=" + giaSanPham + "]";
	}
	
}
