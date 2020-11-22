<%@page import="bean.GioHangBean"%>
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
<title>Giỏ hàng</title>
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="asset/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="asset/plugins/font-awesome/css/all.min.css">
<link rel="stylesheet" href="asset/css/trang-chu.css">
<link rel="stylesheet" href="asset/css/gio-hang.css">
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
						         	<% GioHangBo gioHangBoSl = (GioHangBo) session.getAttribute("ssGioHang");
							        if ( gioHangBoSl == null) { %>
							        	<div class="so-luong-sp">0</div>
							        <% } else { %>
							        	<div class="so-luong-sp"><%=gioHangBoSl.ds.size() %></div>
							        <% } %>
						        </i>
						     </a>
						  </li>
						<li class="nav-item">
							<jsp:include page="dang-nhap.jsp"></jsp:include>
							<%if(request.getSession(false).getAttribute("user") == null) { %>
								<div class="text-center">
								  <a href="" type="button" class="nav-link btn" data-toggle="modal" data-target="#elegantModalForm">Đăng nhập</a>
								</div>
							<%} else { %>
								<div class="text-center">
								  <a href="<%=request.getContextPath()%>/DangXuatController" type="button" class="nav-link btn">Đăng xuất</a>
								</div>
							<% } %>
						</li>
						<jsp:include page="dang-nhap.jsp"></jsp:include>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="container main-content">
		<div class="gio-hang-area">
			<h4 class="dat-hang-title">Giỏ hàng của bạn</h4>
			<%if(gioHangBoSl == null) { %>
				<p class="gio-hang-trong">Giỏ hàng đang trống. Mời bạn 
					<button class="btn btn-primary btn-chon-mua-hang" type="button">
						<a class="tiep-tuc-mua-hang" href="SachController">chọn mua hàng</a>
					</button>
				</p>
			<% } %>
			<div>
				<div class="gio-hang">
					<%
						// Hiển thị sách trong session 
						GioHangBo gioHangBo = (GioHangBo) session.getAttribute("ssGioHang");
						if (gioHangBo != null) {
					%>
					<ul class="danh-sach-gio-hang">
						<%
							for (GioHangBean g: gioHangBo.ds) {
						
						%>
						<li class="chi-tiet-gio-hang">
							<div class="chi-tiet-trai"> 
								<img class="chi-tiet-anh" src="<%=g.getAnh()%>" alt="Chi tiết sản phẩm">
							</div>
							<div class="chi-tiet-phai">
								<div class="chi-tiet-phai-tren">
									<span class="ten-sach"><%=g.getTenSach()%></span>
								</div>
								<span class="tac-gia">Tác giả: <%=g.getTacGia()%></span>
								<div class="chi-tiet-phai-duoi">
									<form class="form-gio-hang" action="GioHangController?action=suaGioHang&maLoai=<%=g.getMaLoai()%>
																		&maSach=<%=g.getMaSach()%>&ts=<%=g.getTenSach()%>&anh=<%=g.getAnh()%>&tg=<%=g.getTacGia()%>&gia=<%=g.getGia()%>" method="post" >
										<div class="form-left">
											Giá: <span class="gia"><%=g.getGia()%>đ</span>
											<input class="so-luong" type="number" name="soLuongCapNhat" min="1" value="<%=g.getSoLuong()%>">
										</div>
										<div class="form-right">
											<span class="thanh-tien">Thành tiền: <%=g.getThanhTien()%>đ
											</span>
											<button class="btn btn-primary" type="submit">Cập nhật</button>
											<button class="btn btn-danger" type="submit">
												<a class="btn-xoa" href="GioHangController?action=xoaSach&maSach=<%=g.getMaSach()%>">Xóa</a>
											</button>
										</div>
									</form>
								</div>
							</div>
						</li>
						<%
							}
						%>
					</ul>
				</div>
			</div>
			<%
				if (gioHangBo.TongTien() != 0) {
			%>
			<div class="tong-tien-area">
				<span class="tong-tien">Tổng tiền: <%=gioHangBo.TongTien()%>đ
				</span>
				<div class="button-area">
					<button class="btn btn-primary" type="button">
						<a class="tiep-tuc-mua-hang" href="SachController">Tiếp tục mua hàng</a>
					</button>
					<%
						if(!(request.getSession(false).getAttribute("user") == null)) {
					%>
						<button class="btn btn-success" type="button"><a class="thanh-toan" href="<%=request.getContextPath()%>/HoaDonController">Thanh toán</a></button>
					<%} else { %>
						<button class="btn btn-success" type="button"><a class="thanh-toan" href="<%=request.getContextPath()%>/SachController">Đăng nhập để thanh toán</a></button>
					<% } %>
				</div>
			</div>
			<%
				} else {
			%>
			<p class="gio-hang-trong">Giỏ hàng đang trống. Mời bạn 
				<button class="btn btn-primary btn-chon-mua-hang" type="button">
					<a class="tiep-tuc-mua-hang" href="SachController">chọn mua hàng</a>
				</button>
			</p>
			
			<%
				}
			%>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>