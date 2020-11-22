package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DungChung;

/**
 * Servlet implementation class TenDangNhapCheck
 */
@WebServlet("/TenDangNhapCheck")
public class TenDangNhapCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DungChung dc = new DungChung();
	PreparedStatement ps = null;
	ResultSet rs = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenDangNhapCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		String tenDn = request.getParameter("tenDn");
//		try {
//			dc.KetNoi();
//			ps = dc.cn.prepareStatement("SELECT * FROM KhachHang WHERE tendn = ?");
//			ps.setString(1, tenDn);
//			rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				response.setContentType("text/html");
//				PrintWriter out = response.getWriter();
//				out.print("Tên đăng nhập đã tồn tại!");
//			} else {
//				response.setContentType("text/html");
//				PrintWriter out = response.getWriter();
//				out.print("");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tenDn = request.getParameter("tenDn");
		try {
			dc.KetNoi();
			ps = dc.cn.prepareStatement("SELECT * FROM KhachHang WHERE tendn = ?");
			ps.setString(1, tenDn);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Tên đăng nhập đã tồn tại!");
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
