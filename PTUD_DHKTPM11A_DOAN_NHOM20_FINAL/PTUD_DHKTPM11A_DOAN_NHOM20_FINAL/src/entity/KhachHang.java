package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="KhachHang")
public class KhachHang implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="maKhachHang")
	private String maKhachHang;
	@Column(name="tenKH")
	private String tenKH;
	@Column(name="cmndKH")
	private int cmndKH;
	@Column(name="diaChi")
	private String daiChi;
	@Column(name="gioiTinh")
	private String gioiTinh;
	@Column(name="soDienThoai")
	private int soDienThoai;
	@OneToMany(mappedBy="khachHang")
	private List<DonDatHang> DonDatHang;
	
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhachHang(String maKhachHang, String tenKH, int cmndKH, String daiChi, String gioiTinh, int soDienThoai) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKH = tenKH;
		this.cmndKH = cmndKH;
		this.daiChi = daiChi;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
	}

	public KhachHang(String tenKH, int cmndKH, String daiChi, String gioiTinh, int soDienThoai) {
		super();
		this.tenKH = tenKH;
		this.cmndKH = cmndKH;
		this.daiChi = daiChi;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
	}
	
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public int getCmndKH() {
		return cmndKH;
	}
	public void setCmndKH(int cmndKH) {
		this.cmndKH = cmndKH;
	}
	public String getDaiChi() {
		return daiChi;
	}
	public void setDaiChi(String daiChi) {
		this.daiChi = daiChi;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public List<DonDatHang> getDonDatHang() {
		return DonDatHang;
	}
	public void setDonDatHang(List<DonDatHang> donDatHang) {
		DonDatHang = donDatHang;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKH=" + tenKH + ", cmndKH=" + cmndKH + ", daiChi="
				+ daiChi + ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai + "]";
	}
	
	
	
	
	
	
	
	

}
