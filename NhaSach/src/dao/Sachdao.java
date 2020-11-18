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
//		ds.add(new Sachbean("tin", "b1.jpg", "Objective-C", "Xuan Anh", "90000", "s1"));
//		ds.add(new Sachbean("toan", "b2.jpg", "Số Phận", "Anh Bao", "80000", "s2"));
//		ds.add(new Sachbean("tin", "b3.jpg", "Số Phân 2", "Quoc Cuong", "70000", "s3"));
//		ds.add(new Sachbean("ly", "b4.jpg", "Kinh Doanh", "Thai Duong", "500000", "s4"));
//		ds.add(new Sachbean("ly", "b5.jpg", "Tư duy ", "Cong Hoa", "100000", "s5"));
		
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
