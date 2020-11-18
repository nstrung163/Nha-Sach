package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.DangNhapBean;
import dao.DangNhapDao;

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
		
		String tenDangNhap = request.getParameter("tenDangNhap");
		String matKhau = request.getParameter("matKhau");
		
		DangNhapBean dangNhapBean = new DangNhapBean();
		dangNhapBean.setTenDangNhap(tenDangNhap);
		dangNhapBean.setMatKhau(matKhau);
		
		DangNhapDao dangNhapDao = new DangNhapDao();
		
		try {
			String xacNhanUser = dangNhapDao.xacThucUser(dangNhapBean);
			if(xacNhanUser.equals("admin")) {
				System.out.println("Đăng nhập với quyền: Admin");
				HttpSession session = request.getSession();
				session.setAttribute("admin", tenDangNhap);
				request.setAttribute("tenDangNhap", tenDangNhap);
				response.sendRedirect("SachController");
			} else if(xacNhanUser.equals("user")) {
				System.out.println("Đăng nhập với quyền: User");
				HttpSession session = request.getSession();
				session.setAttribute("user", tenDangNhap);
				session.setMaxInactiveInterval(10*60);
				request.setAttribute("tenDangNhap", tenDangNhap);
//				request.getRequestDispatcher("thanh-toan.jsp").forward(request, response);
				response.sendRedirect("SachController");
			} else {
				System.out.println("Thôn báo lỗi: " + xacNhanUser);
				request.setAttribute("errMessage", xacNhanUser);
				request.getRequestDispatcher("dang-nhap.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
