package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import dao.KhachHangDao;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tenDn = request.getParameter("tenDn");
		String pass = request.getParameter("pass");
		
		KhachHangBean khachHangBean = new KhachHangBean();
		khachHangBean.setTenDn(tenDn);
		khachHangBean.setPass(pass);
		
		KhachHangDao khachHangDao = new KhachHangDao();
		
		try {
			String xacNhanUser = khachHangDao.xacThucUser(khachHangBean);
			 if(xacNhanUser.equals("user")) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(10*60);
				session.setAttribute("user", tenDn);
				request.setAttribute("checkDangNhap", tenDn);
				request.setAttribute("tenDn", tenDn);
//				request.getRequestDispatcher("thanh-toan.jsp").forward(request, response);
				response.sendRedirect("SachController");
			} else {
				System.out.println("Thông báo lỗi: " + xacNhanUser);
				request.setAttribute("errMessage", xacNhanUser);
				request.getRequestDispatcher("dang-nhap.jsp").forward(request, response);
//				response.sendRedirect("SachController");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
