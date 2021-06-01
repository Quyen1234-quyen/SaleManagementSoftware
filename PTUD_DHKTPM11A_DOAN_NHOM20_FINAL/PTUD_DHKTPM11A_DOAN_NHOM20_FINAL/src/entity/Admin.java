package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="Admin")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tenAdmin")
	private TaiKhoan tenAdmin;
	@Column(name="soDienThoai")
	private String soDienThoai;
	public Admin(TaiKhoan tenAdmin, String soDienThoai) {
		super();
		this.tenAdmin = tenAdmin;
		this.soDienThoai = soDienThoai;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan getTenAdmin() {
		return tenAdmin;
	}
	public void setTenAdmin(TaiKhoan tenAdmin) {
		this.tenAdmin = tenAdmin;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Admin [tenAdmin=" + tenAdmin.getTenTaiKhoan() + ", soDienThoai=" + soDienThoai + "]";
	}
}
