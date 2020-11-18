package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoaiBean;
import bo.GioHangBo;
import bo.LoaiBo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			LoaiBo loaiBo = new LoaiBo();
			ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
			request.setAttribute("dsLoaiSach", dsLoaiSach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Sửa giỏ hàng
		String action = request.getParameter("action") != null ? request.getParameter("action"): "none";
		switch (action) {
		case "suaGioHang":
			suaGioHang(request, response);
			break;
		case "xoaSach":
			xoaSach(request, response);
			break;
		case "themSach":
			themSach(request, response);
			break;
		default:
			hienThiGioHang(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void hienThiGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBo gioHangBo = new GioHangBo();
		gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
		session.setAttribute("ssGioHang", gioHangBo);
		request.getRequestDispatcher("gio-hang.jsp").forward(request, response);
	}
	
	private void themSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String maLoai = request.getParameter("maLoai");
		String maSach = request.getParameter("maSach");
		String tenSach = request.getParameter("ts");
		String anh = request.getParameter("anh");
		String tacGia = request.getParameter("tg");
		String gia = request.getParameter("gia");
		// Mua hàng lần đầu
		if (maSach != null) {
			GioHangBo gioHangBo;
			if (session.getAttribute("ssGioHang") == null) {
				gioHangBo = new GioHangBo();
				session.setAttribute("ssGioHang", gioHangBo);
			}
			gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
			gioHangBo.ThemSach(maLoai, maSach, tenSach, anh, tacGia, Double.parseDouble(gia), 1);
			session.setAttribute("ssGioHang", gioHangBo);
			response.sendRedirect("GioHangController");
//			request.getRequestDispatcher("Tam").forward(request, response);
		}
	}
	
	private void suaGioHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBo gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
		String maLoai	= request.getParameter("maLoai");
		String maSach	= request.getParameter("maSach");
		String tenSach	= request.getParameter("ts");
		String anh		= request.getParameter("anh");
		String tacGia 	= request.getParameter("tg");
		String gia 		= request.getParameter("gia");
		String soLuongSua	= request.getParameter("soLuongCapNhat");
		gioHangBo.suaGioHang(maLoai, maSach, tenSach, anh, tacGia, Double.parseDouble(gia), Integer.parseInt(soLuongSua));
		session.setAttribute("ssGioHang", gioHangBo);
		response.sendRedirect("GioHangController");
//		RequestDispatcher rd = request.getRequestDispatcher("gio-hang.jsp");
//		rd.forward(request, response);
	}
	
	private void xoaSach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GioHangBo gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
		gioHangBo.xoa(request.getParameter("maSach"));
		session.setAttribute("ssGioHang", gioHangBo);
		request.setAttribute("action", "xoaSach");
		response.sendRedirect("GioHangController");
		}
	
}
