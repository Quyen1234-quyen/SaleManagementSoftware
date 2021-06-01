package entity;

import java.io.Serializable;

public class ChiTietDonDatHang_PK implements Serializable{
	private int DonDatHang;
	private int SanPham;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + DonDatHang;
		result = prime * result + SanPham;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonDatHang_PK other = (ChiTietDonDatHang_PK) obj;
		if (DonDatHang != other.DonDatHang)
			return false;
		if (SanPham != other.SanPham)
			return false;
		return true;
	}
	
}
