package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Sachbean;

public class Sachdao {

	/**
	 * Get all book
	 * 
	 * @return list book
	 * @throws Exception 
	 */
	public ArrayList<Sachbean> getsach() throws Exception {
		
		ArrayList<Sachbean> ds = new ArrayList<Sachbean>();
		DungChung dc = new DungChung();
		dc.KetNoi();
		String sql = "SELECT * FROM SACH";
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			String maloai = rs.getString("maloai");
			String anh = rs.getString("anh");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			String gia = rs.getString("gia");
			String masach = rs.getString("masach");
			Sachbean sach = new Sachbean(maloai, anh, tensach, tacgia, gia, masach);
			ds.add(sach);
		}
		rs.close();
		dc.cn.close();
		return ds;
		
	}
}
