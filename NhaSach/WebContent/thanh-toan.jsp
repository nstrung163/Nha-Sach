<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thanh toán</title>
<link rel="stylesheet" href="asset/css/normalize.css"> 
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,900;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="asset/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="asset/plugins/font-awesome/css/all.min.css">
<link rel="stylesheet" href="asset/css/trang-chu.css">
</head>
<%if(request.getSession(false).getAttribute("user") == null) { %>
	<jsp:forward page="dang-nhap.jsp"></jsp:forward>
<%} %>
<body>
	Welcome <%=request.getAttribute("userName") %>
</body>
</html>