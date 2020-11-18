<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- ĐĂNG NHẬP -->
<form name="form" action="<%=request.getContextPath()%>/DangNhapController" method="post">
	<div class="modal fade" id="elegantModalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <!--Content-->
	    <div class="modal-content form-elegant">
	      <!--Header-->
	      <div class="modal-header text-center title-dang-ky ">
	        <h3 class="modal-title w-100 dark-grey-text font-weight-bold my-3" id="myModalLabel"><strong>Đăng ký</strong></h3>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <!--Body-->
	      <div class="modal-body mx-2">
	        <!--Body-->
	        <div class="md-form mb-4">
	          <label data-error="wrong" data-success="right" for="Form-email1">Họ và tên:</label>
	          <input type="text" id="form-ho-ten" class="form-control validate input-username" name="hoTen">
	        </div>
	        
	        <div class="md-form mb-2">
	          <label data-error="wrong" data-success="right" for="Form-dia-chi">Địa chỉ:</label>
	          <input type="text" id="Form-dia-chi" class="form-control validate input-username" name="diaChi">
	        </div>
	        
	        <div class="md-form mb-2">
	          <label data-error="wrong" data-success="right" for="Form-so-dien-thoai">Số Điện Thoại:</label>
	          <input type="text" id="Form-so-dien-thoai" class="form-control validate input-username" name="soDienThoai">
	        </div>
	        
	        <div class="md-form mb-2">
	          <label data-error="wrong" data-success="right" for="Form-email">Email:</label>
	          <input type="email" id="Form-email" class="form-control validate input-username" name="email">
	        </div>
	        
	        <div class="md-form mb-2">
	          <label data-error="wrong" data-success="right" for="Form-ten-dang-nhap">Tên đăng nhập:</label>
	          <input type="text" id="Form-ten-dang-nhap" class="form-control validate input-username" name="tenDangNhap">
	        </div>
	
			<div class="md-form mb-2">
	          <label data-error="wrong" data-success="right" for="Form-mat-khau">Mật khẩu:</label>
	          <input type="password" id="Form-mat-khau" class="form-control validate input-username" name="matKhau">
	        </div>
	        
	        <div class="md-form mb-3">
	          <label data-error="wrong" data-success="right" for="Form-mat-khau-2">Nhập lại mật khẩu:</label>
	          <input type="password" id="Form-mat-khau-2" class="form-control validate input-password" name="matKhau2">
	        </div>
	        
			<!-- Error Message -->
			<span style="color:red"> <%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage") %></span>
	
	        <div class="d-flex justify-content-center mb-2">
	        <button type="submit" class="btn blue-gradient btn-block btn-rounded z-depth-1a">Đăng ký</button>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>
</form>







