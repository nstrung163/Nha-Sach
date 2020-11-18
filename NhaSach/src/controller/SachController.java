package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoaiBean;
import bean.Sachbean;
import bo.LoaiBo;
import bo.Sachbo;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/SachController")
public class SachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			Sachbo sachBo = new Sachbo();
			ArrayList<Sachbean> ds = sachBo.getsach();
			String maLoai = request.getParameter("maLoai");
			String keyword = request.getParameter("keyword");
			if ( maLoai != null ) {
				ds = sachBo.TimKiemSachTheoMa(maLoai);
			} else 
				if ( keyword != null) {
					ds = sachBo.TimKiemSachTheoTen(keyword);
				}
			// Loai sach
			LoaiBo loaiBo = new LoaiBo();
			ArrayList<LoaiBean> dsLoaiSach = loaiBo.getLoai();
			
			request.setAttribute("dssach", ds);
			request.setAttribute("dsLoaiSach", dsLoaiSach);
			
			RequestDispatcher rd = request.getRequestDispatcher("trang-chu.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
