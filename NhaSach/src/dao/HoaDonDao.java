package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.HoaDonBean;

public class HoaDonDao {
	
	DungChung dc = new DungChung();
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void insertHoaDon(HoaDonBean hoaDonBean) throws SQLException {
		
		String sql = "INSERT INTO hoadon values(?, ?, ?)";
		try {
			dc.KetNoi();
			ps = dc.cn.prepareStatement(sql);
			ps.setLong(1, hoaDonBean.getMaKh());
			ps.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			ps.setBoolean(3, hoaDonBean.isDaMua());
			ps.executeUpdate();
			System.out.println("Tạo hóa đơn thành công ở Dao");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Tạo hóa đơn thất bại ở Dao");
		}
		dc.cn.close();
	}
	public Long getMaMaxHoaDon() throws SQLException {
		long maxMaHoaDon = 0;
		String sql = "SELECT MAX(MaHoaDon) as MaxMaHoaDon FROM hoadon";
		try {
			dc.KetNoi();
			Statement st = dc.cn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				maxMaHoaDon = rs.getLong("MaxMaHoaDon");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		dc.cn.close();
		return maxMaHoaDon;
	}
}
