package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="SanPham")
public class SanPham  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="maSanPham")
	private int maSanPham;
	@Column(name="tenSanPham")
	private String tenSanPham;
	@Column(name="giaSanPham")
	private int giaSanPham;
	@Column(name="xuatXuSanPham")
	private String xuatXuSanPham;
	@Column(name="tonKhoSanPham")
	private int tonKhoSanPham;
	@OneToMany(mappedBy="SanPham")
	private List<ChiTietDonDatHang> sanPham;
	public SanPham(int maSanPham, String tenSanPham, int giaSanPham, String xuatXuSanPham, int tonKhoSanPham) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaSanPham = giaSanPham;
		this.xuatXuSanPham = xuatXuSanPham;
		this.tonKhoSanPham = tonKhoSanPham;
	}
	
	public SanPham(String tenSanPham, int giaSanPham, String xuatXuSanPham, int tonKhoSanPham) {
		super();
		this.tenSanPham = tenSanPham;
		this.giaSanPham = giaSanPham;
		this.xuatXuSanPham = xuatXuSanPham;
		this.tonKhoSanPham = tonKhoSanPham;
	}

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getGiaSanPham() {
		return giaSanPham;
	}
	public void setGiaSanPham(int giaSanPham) {
		this.giaSanPham = giaSanPham;
	}
	public String getXuatXuSanPham() {
		return xuatXuSanPham;
	}
	public void setXuatXuSanPham(String xuatXuSanPham) {
		this.xuatXuSanPham = xuatXuSanPham;
	}
	public int getTonKhoSanPham() {
		return tonKhoSanPham;
	}
	public void setTonKhoSanPham(int tonKhoSanPham) {
		this.tonKhoSanPham = tonKhoSanPham;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaSanPham=" + giaSanPham
				+ ", xuatXuSanPham=" + xuatXuSanPham + ", tonKhoSanPham=" + tonKhoSanPham + "]";
	}
	
	
	
	
	
	
	
}
