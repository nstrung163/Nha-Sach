/**
 * 
 */
$(document).ready(function () {
  $(".dang-nhap").click(function () {
    $(".modal").css("display", "flex");
  });
});

$(document).ready(function () {
  $(".btn-close").click(function () {
    $(".modal").css("display", "none");
    $(".btn-close").css("outline", "none");
    $(".btn-close").css("border", "0");
  });
});