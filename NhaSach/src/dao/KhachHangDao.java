package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.KhachHangBean;

public class KhachHangDao {
	
	DungChung dc = new DungChung();
	
	public String xacThucUser(KhachHangBean khachHangBean) throws Exception {
		String tenDn = khachHangBean.getTenDn();
		String pass = khachHangBean.getPass();
		ResultSet rs = null;
		String tenDnDB = "";
		String passDB = "";
		dc.KetNoi();
		Statement statement = dc.cn.createStatement();
		rs = statement.executeQuery("SELECT tendn, pass FROM KhachHang");
		try {
			while(rs.next()) {
				tenDnDB = rs.getString("tenDn");
				passDB = rs.getString("pass");
				
				if(tenDn.equals(tenDnDB) && pass.equals(passDB)) 
					return "user";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		dc.cn.close();
		return "Thông tin đăng nhập người dùng không hợp lệ!";
	}
	
	public String insertKhachHang(KhachHangBean khachHangBean) throws Exception {
		dc.KetNoi();
		String result = "Đăng ký thành công Dao!";
		String sql = "insert into KhachHang values(?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = dc.cn.prepareStatement(sql);
			ps.setString(1, khachHangBean.getHoTen());
			ps.setString(2, khachHangBean.getDiaChi());
			ps.setString(3, khachHangBean.getSoDienThoai());
			ps.setString(4, khachHangBean.getEmail());
			ps.setString(5, khachHangBean.getTenDn());
			ps.setString(6, khachHangBean.getPass());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result = "Đăng ký thất bại!";
		}
		System.out.println(result);
		dc.cn.close();
		return result;
	}
	public boolean checkDuplicateTenDn(String tenDn) throws Exception {
		
		boolean temp = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			dc.KetNoi();
			ps = dc.cn.prepareStatement("SELECT * FROM KhachHang WHERE tendn = ?");
			ps.setString(1, tenDn);
			rs = ps.executeQuery();
			temp = !rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		dc.cn.close();
		return temp;
	}
	public Long getMaKh(String tenDn) throws SQLException {
		long maKh = 0;
		try {
			dc.KetNoi();
			PreparedStatement ps = dc.cn.prepareStatement("SELECT makh FROM KhachHang WHERE tendn = ?");
			ps.setString(1, tenDn);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				maKh = rs.getLong("makh");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dc.cn.close();
		return maKh;
	}
}
