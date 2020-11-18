package bo;

import java.util.ArrayList;

import bean.Sachbean;
import dao.Sachdao;

public class Sachbo {

	Sachdao sdao = new Sachdao();
	ArrayList<Sachbean> ds;

	/**
	 * Lấy toàn bộ sách
	 * 
	 * @return Danh sách sách
	 * @throws Exception 
	 */
	public ArrayList<Sachbean> getsach() throws Exception {
		ds = sdao.getsach();
		return ds;
	}
	
	/**
	 * Tìm kiếm sách theo mã
	 * 
	 * @param maLoai
	 * @return danh sách ketQuaTimKiem
	 * @throws Exception 
	 */
	public ArrayList<Sachbean> TimKiemSachTheoMa(String maLoai) throws Exception {
		ds = sdao.getsach();
		ArrayList<Sachbean> ketQuaTimKiem = new ArrayList<Sachbean>();
		for( Sachbean sach: ds ) {
			if(sach.getMaloai().trim().equalsIgnoreCase(maLoai.trim()))
				 ketQuaTimKiem.add(sach);
		}
		return ketQuaTimKiem;
	}
	
	/**
	 * Tìm kiếm sách theo tên
	 * 
	 * @param keyword
	 * @return danh sách ketQuaTimKiem
	 * @throws Exception 
	 */
	public ArrayList<Sachbean> TimKiemSachTheoTen (String keyword) throws Exception {
		ArrayList<Sachbean> ketQuaTimKiem = new ArrayList<Sachbean>();
		ds = sdao.getsach();
		for( Sachbean sach: ds) {
			if (sach.getTensach().toLowerCase().contains(keyword.toLowerCase()) || 
				sach.getTacgia().toLowerCase().contains(keyword.toLowerCase()))
				ketQuaTimKiem.add(sach);
		}
		return ketQuaTimKiem;
	}
	
	/**
	 * 
	 * Chi tiết sách
	 * 
	 * @param maSach
	 * @return Chi tiết sách
	 */
	public ArrayList<Sachbean> ChiTietSach(String maSach) {
		ArrayList<Sachbean> ketQuaTraVe =new ArrayList<Sachbean>();
		for (Sachbean sach: ds ) {
			if (sach.getMasach().toLowerCase().contains(maSach.toLowerCase()))
				ketQuaTraVe.add(sach);
		}
		return ketQuaTraVe;
	}
	
}
