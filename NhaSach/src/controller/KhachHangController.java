package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.KhachHangBean;
import dao.KhachHangDao;

/**
 * Servlet implementation class KhachHangController
 */
@WebServlet("/KhachHangController")
public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String hoTen = request.getParameter("hoTen");
		String diaChi = request.getParameter("diaChi");
		String soDienThoai = request.getParameter("soDienThoai");
		String email = request.getParameter("email");
		String tenDn = request.getParameter("tenDn");
		String pass = request.getParameter("pass");
		KhachHangBean khachHangBean = new KhachHangBean(hoTen, diaChi, soDienThoai, email, tenDn, pass);
		KhachHangDao khachHangDao = new KhachHangDao();
		try {
			if(khachHangDao.checkDuplicateTenDn(tenDn)) {
				khachHangDao.insertKhachHang(khachHangBean);
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("");
				System.out.println("Đăng ký thành công ở Controller!");
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Tên đăng nhập đã tồn tại!");
				System.out.println("Đăng ký thất bại ở Controller!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
