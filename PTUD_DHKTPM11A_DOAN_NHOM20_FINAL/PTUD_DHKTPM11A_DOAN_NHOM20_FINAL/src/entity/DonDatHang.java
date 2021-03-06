package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="DonDatHang")
public class DonDatHang implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="maDonDatHang")
	private int maDonDatHang;
	@Column(name="diaChiNhanHang")
	private String diaChiNhanHang;
	@Column(name="trangThaiDonHang")
	private String trangThaiDonHang;
	@Column(name="tongTien")
	private int tongTien;
	@Column(name="ngayDatHang",columnDefinition="DATETIME")
	private Date ngayDatHang;
	@ManyToOne()
	@JoinColumn(name="maKhachHang")
	private KhachHang khachHang;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tenNhanVien")
	private NhanVien nhanVien;
	@OneToMany(mappedBy="DonDatHang")
	private List<ChiTietDonDatHang> donDatHang;
	
	public DonDatHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonDatHang(int maDonDatHang, String diaChiNhanHang, String trangThaiDonHang, int tongTien, Date ngayDatHang,
			KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maDonDatHang = maDonDatHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.trangThaiDonHang = trangThaiDonHang;
		this.tongTien = tongTien;
		this.ngayDatHang = ngayDatHang;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}

	public int getMaDonDatHang() {
		return maDonDatHang;
	}

	public void setMaDonDatHang(int maDonDatHang) {
		this.maDonDatHang = maDonDatHang;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getTrangThaiDonHang() {
		return trangThaiDonHang;
	}

	public void setTrangThaiDonHang(String trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public List<ChiTietDonDatHang> getDonDatHang() {
		return donDatHang;
	}

	public void setDonDatHang(List<ChiTietDonDatHang> donDatHang) {
		this.donDatHang = donDatHang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DonDatHang [maDonDatHang=" + maDonDatHang + ", diaChiNhanHang=" + diaChiNhanHang + ", trangThaiDonHang="
				+ trangThaiDonHang + ", tongTien=" + tongTien + ", ngayDatHang=" + ngayDatHang + ", khachHang="
				+ khachHang + ", nhanVien=" + nhanVien + "]";
	}
	


	
	
	
	
	
}
