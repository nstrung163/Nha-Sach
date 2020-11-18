package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	// request khác với session là: session như global còn request setAttrubute nó chỉ sử dụng trên 1 trang duy nhất
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		out.print("<html><body>Alo</body></html>");
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 String a1=request.getParameter("txta");
		 String b1=request.getParameter("txtb");
		 request.setAttribute("a", a1);
		 request.setAttribute("b", b1);
		 long kq=0;
		 if (a1 != null && b1 != null) {// neu co du lieu
			// long kq=0;
			long a = Long.parseLong(a1);
			long b = Long.parseLong(b1);
			if (request.getParameter("txtcong") != null)
				kq = a + b;
			if (request.getParameter("txttru") != null)
				kq = a - b;
		 }
//				 response.getWriter().print(kq);
		    
//		    } else 
//		    	response.sendRedirect("maytinh.jsp");
			request.setAttribute("kq", kq);
			RequestDispatcher rd = request.getRequestDispatcher("maytinh.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
