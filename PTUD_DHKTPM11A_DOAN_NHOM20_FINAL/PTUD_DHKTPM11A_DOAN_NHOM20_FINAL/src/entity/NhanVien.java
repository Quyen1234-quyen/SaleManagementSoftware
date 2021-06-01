package entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="NhanVien")
public class NhanVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tenNhanVien")
	private TaiKhoan tenNhanVien;
	@Column(name="cmndNV")
	private int cmndNV;
	@Column(name="gioiTinh")
	private String gioiTinh;
	@Column(name="diaChi")
	private String diaChi;
	@Column(name="soDienThoai")
	private int soDienThoai;
	@OneToMany(mappedBy="nhanVien",cascade=CascadeType.ALL)
	private List<DonDatHang> DonDatHang;
	public NhanVien(TaiKhoan tenNhanVien,int cmndNV, String gioiTinh, String diaChi, int soDienThoai) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.cmndNV = cmndNV;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(TaiKhoan tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public int getCmndNV() {
		return cmndNV;
	}
	public void setCmndNV(int cmndNV) {
		this.cmndNV = cmndNV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "NhanVien [tenNhanVien=" + tenNhanVien.getTenTaiKhoan() + ", cmndNV=" + cmndNV + ", gioiTinh=" + gioiTinh + ", diaChi="
				+ diaChi + ", soDienThoai=" + soDienThoai + "]";
	}
	
	

}
