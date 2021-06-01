package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="TaiKhoan")
public class TaiKhoan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="tenTaiKhoan")
	private String tenTaiKhoan;
	@Column(name="matKhau")
	private String matKhau;
	@Column(name="trangThai")
	private String trangThai;
	@Column(name="phanQuyen")
	private String phanQuyen;
	@OneToOne(cascade=CascadeType.ALL,mappedBy="tenNhanVien")
	@PrimaryKeyJoinColumn
	private NhanVien nhanVien;
	@OneToOne(cascade=CascadeType.ALL,mappedBy="tenAdmin")
	@PrimaryKeyJoinColumn
	private Admin admin;
	public TaiKhoan(String tenTaiKhoan, String matKhau,String trangthai,String phanQuyen) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.trangThai= trangthai;
		this.phanQuyen=phanQuyen;
	}
	public TaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan=tenTaiKhoan;
	}
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public String getTrangthai() {
		return trangThai;
	}
	public void setTrangthai(String trangthai) {
		this.trangThai = trangthai;
	}
	
	public String getPhanQuyen() {
		return phanQuyen;
	}
	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", trangThai=" + trangThai
				+ ", phanQuyen=" + phanQuyen + "]";
	}
	
	
	
	
	

}
