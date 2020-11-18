<%@page import="bo.GioHangBo"%>
<%@page import="bo.LoaiBo"%>
<%@page import="bean.LoaiBean"%>
<%@page import="bean.Sachbean"%>
<%@page import="bo.Sachbo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhà Sách HH</title>
<link rel="stylesheet" href="asset/css/normalize.css"> 
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="asset/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="asset/plugins/font-awesome/css/all.min.css">
<link rel="stylesheet" href="asset/css/trang-chu.css">

</head>
<body>
	<div class="container menu-top">
		<nav class="navbar navbar-expand-lg navbar-light">
		 	<div class="nav-right">
				<a class="navbar-brand" href="SachController">Trang chủ</a>
			  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
			  	<span class="navbar-toggler-icon"></span>
			   	</button>
		 	</div>
		 	<div class="nav-left">
			  	<div class="collapse navbar-collapse" id="navbarNavDropdown">
			    	<ul class="navbar-nav">
			    	  <li class="nav-item">
				        <a class="nav-link" href="#">Lịch sử mua hàng</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="GioHangController">
				        <i class="gio-hang fas fa-shopping-cart">
				         	<% GioHangBo gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
					        if (gioHangBo == null) { %>
					        	<div class="so-luong-sp">0</div>
					        <% } else { %>
					        	<div class="so-luong-sp"><%=gioHangBo.ds.size() %></div>
					        <% } %>
				        </i>
				        </a>
				      </li>
			    	  <li class="nav-item">
							<%-- <jsp:include page="dang-nhap.jsp"></jsp:include> --%>
							<jsp:include page="dang-ky.jsp"></jsp:include>
							<%if(request.getSession(false).getAttribute("user") == null ) { %>
								<div class="text-center">
								  <a href="" type="button" class="nav-link btn" data-toggle="modal" data-target="#elegantModalForm">Đăng nhập</a>
								</div>
							<%} else { %>
								<div class="text-center">
								  <a href="<%=request.getContextPath()%>/DangXuatController" type="button" class="nav-link btn">Đăng xuất</a>
								</div>
							<% } %>
						</li>
			   		</ul>
			  	</div>
		 	</div>
		</nav>
	</div>
	<section class="container search-box">
		<form class="form-inline my-2 my-lg-0 " action="SachController" method="POST"> 
	      <input  type="search" name="keyword" class="form-control mr-sm-2 lab-search " placeholder="Tên sách, Tên tác giả" aria-label="Search">
	      <button type="submit" name="submitTimKiem" class="btn btn-outline-success my-2 my-sm-0 btn-search" >Tìm kiếm</button>
	    </form>
	</section>
	<div class="container main-content">
		<div class="menu-left col-xl-2">
			<ul class="list-group">
				<li class="list-group-item list-group-item-danh-muc ">Danh mục sách</li>
			<% // Hiển thị loại sách
				ArrayList<LoaiBean> dsLoaiSach = (ArrayList<LoaiBean>) request.getAttribute("dsLoaiSach");
				for(LoaiBean loaiSach: dsLoaiSach) { 
			%>
				<li class="list-group-item">
					<a href="SachController?maLoai=<%=loaiSach.getMaLoai()%>" class="list-group-item-link"><%=loaiSach.getTenLoai() %></a>
				</li>
			<% } %>
			</ul>
		</div>
		<div class="menu-right col-xl-10">
			<div class="list-book ">
				<%
					Sachbo sachBo = new Sachbo();
					ArrayList<Sachbean> ds = (ArrayList<Sachbean>) request.getAttribute("dssach");
					int  n = ds.size();
					for (int i = 0; i < n; i++) {
						Sachbean ss = ds.get(i);
				%>
				<div class="list-book-item col-xl-3">
				    <img class="book-img-top" src="<%=ds.get(i).getAnh()%>" alt="Image">
				    <div class="book-content">
				      <p class="book-text book-title"><%=ds.get(i).getTensach()%></p>
				      <p class="book-text book-author">Tác giả: <%=ds.get(i).getTacgia()%></p>
				      <p class="book-text book-price">Giá: <%=ds.get(i).getGia()%></p>
				      <a class="book-by" href="GioHangController?action=themSach&maLoai=<%=ss.getMaloai()%>&maSach=<%=ss.getMasach()%>
				      	&ts=<%=ss.getTensach()%>&anh=<%=ss.getAnh()%>&tg=<%=ss.getTacgia()%>&gia=<%=ss.getGia()%>">
						<img alt="Đặt mua" src="asset/img/buynow.jpg">
					  </a>
				    </div>
		 		</div>
		 		<%
					}
				%>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="asset/plugins/jquery/jquery-3.5.1.min.js"></script>
	<script type="text/javascript" src="asset/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="asset/js/main.js"></script>
</body>
</html>