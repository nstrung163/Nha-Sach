/*$('.close').on('click', function() {
	$('#dangNhapModal').hide();
	$('#dangKyModal').hide();
})*/


$(document).ready(function() {
	/*Check duplicate of tenDn*/
	var resultDuplicate = "";
	$('#tenDn').change(function() {
		var tenDn = $('#tenDn').val();
		var hoTen = $('#hoTen').val();
		var diaChi = $('#diaChi').val();
		var soDienThoai = $('#soDienThoai').val();
		var email = $('#email').val();
		var pass = $('#pass').val();
		$.ajax({
			type: 'POST',
			data: {
					tenDn: tenDn,
					hoTen: hoTen, 
					diaChi: diaChi, 
					soDienThoai: soDienThoai,
					email: email,
					pass: $('#pass').val(),
					},
			url: 'KhachHangController',
			success: function(result) {
				$('#result').html(result);
				resultDuplicate = $('#result').html();
				$("#formDangKy").submit(function(event) {
					if(!Boolean(resultDuplicate)) {
						alert( "Đăng ký thành công!" );
						event.preventDefault();
					} else {
						alert( "Tên đăng nhập đã bị trùng!" );
						event.preventDefault();
					}
				})
			}
		})
	})
	
	$('.dang-ky').on('click', function() {
		$('#dangKyModal').show();
		$('#dangNhapModal').hide();
	})
	$('.dang-nhap').on('click', function() {
		$('#dangNhapModal').show();
		$('#dangKyModal').hide();
	})
	
})
