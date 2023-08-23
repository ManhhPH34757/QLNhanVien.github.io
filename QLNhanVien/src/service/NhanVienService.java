package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectDB;
import model.NhanVien;

public class NhanVienService {
	public ArrayList<NhanVien> listNV = new ArrayList<NhanVien>();
	Connection connection = new ConnectDB().Connect();
	PreparedStatement pStatement = null;
	Statement statement = null;
	ResultSet rSet = null;
	
	public void setArray() {
		String SQL = "select Ma, Ten, GioiTinh, DiaChi, MatKhau from NhanVien";
		try {
			statement = connection.createStatement();
			rSet = statement.executeQuery(SQL);
			listNV.clear();
			while (rSet.next()) {
				String maNV = rSet.getString(1);
				String tenNV = rSet.getString(2);
				String gioiTinh = rSet.getString(3);
				String diaChi = rSet.getString(4);
				String matKhau = rSet.getString(5);
				NhanVien nhanVien = new NhanVien(maNV, tenNV, diaChi, gioiTinh, matKhau);
				listNV.add(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String Add(NhanVien nhanVien) {
		String result = "";
		String SQL = "INSERT into[dbo].[NhanVien] ( [Ma], [Ten], [GioiTinh], [DiaChi], [MatKhau])\r\n"
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			pStatement = connection.prepareStatement(SQL);
			pStatement.setString(1, nhanVien.getMaNhanVien());
			pStatement.setString(2, nhanVien.getHoTen());
			pStatement.setString(3, nhanVien.getGioiTinh());
			pStatement.setString(4, nhanVien.getDiaChi());
			pStatement.setString(5, nhanVien.getPassword());
			pStatement.executeUpdate();
			result = "Add successfully";
		} catch (Exception e) {
			result = "Add fails";
		}
		return result;
	}
	
	public String Update(NhanVien nhanVien) {
		String result = "";
		String SQL = "UPDATE NhanVien SET Ten = ?, GioiTinh = ?, DiaChi = ?, MatKhau = ? WHERE Ma = ?";
		try {
			pStatement = connection.prepareStatement(SQL);
			pStatement.setString(5, nhanVien.getMaNhanVien());
			pStatement.setString(1, nhanVien.getHoTen());
			pStatement.setString(2, nhanVien.getGioiTinh());
			pStatement.setString(3, nhanVien.getDiaChi());
			pStatement.setString(4, nhanVien.getPassword());
			pStatement.executeUpdate();
			result = "Update successfully";
		} catch (Exception e) {
			result = "Update fails";
		}
		return result;
	}
	
	public String Delete(String maNV) {
		String result = "";
		String SQL = "DELETE FROM NhanVien WHERE Ma = ?";
		try {
			pStatement = connection.prepareStatement(SQL);
			pStatement.setString(1, maNV);
			pStatement.executeUpdate();
			result = "Delete successfully";
		} catch (Exception e) {
			result = "Delete fails";
		}
		return result;
	}
	
}
