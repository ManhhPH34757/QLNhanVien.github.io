package model;

public class NhanVien {
	private String maNhanVien;
	private String hoTen;
	private String diaChi;
	private String gioiTinh;
	private String password;
	
	public NhanVien() {
		
	}

	public NhanVien(String maNhanVien, String hoTen, String diaChi, String gioiTinh, String password) {
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.password = password;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
