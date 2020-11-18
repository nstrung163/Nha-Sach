package bo;

import java.util.ArrayList;

import bean.LoaiBean;
import dao.LoaiDao;

public class LoaiBo {
	LoaiDao loaiDao = new LoaiDao();
	/**
	 * Lấy địa chỉ đầu tiên của mảng bên LoaiBo
	 */
	ArrayList<LoaiBean> ds;

	public ArrayList<LoaiBean> getLoai() throws Exception {
		// Để trỏ đến 1 vùng nhớ của Dao
		ds = loaiDao.getLoaiSach();
		return ds;
	}
}
