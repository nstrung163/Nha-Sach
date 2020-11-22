package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.LoaiBean;

public class LoaiDao {
	public ArrayList<LoaiBean> getLoaiSach() throws Exception {
		
		ArrayList<LoaiBean> ds = new ArrayList<LoaiBean>();
		//B1: Ket noi vao csdl
		DungChung dc = new DungChung();
		dc.KetNoi();
		//B2: Cho thuc hien cau lenh sql
		String sql = "SELECT * FROM LOAI";
		//B3: Cho thuc hien cau len sql
		PreparedStatement cmd = dc.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		//B4: Duyet qua cac loai va luu vao ds
		while(rs.next()) {
			String maLoai = rs.getString("maLoai");
			String tenLoai = rs.getString("tenLoai");
			LoaiBean loai = new LoaiBean(maLoai, tenLoai);
			ds.add(loai);
		} 
		rs.close();
		dc.cn.close();
		return ds;
		
	}
}
