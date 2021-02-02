/* ///////////////////////////////////////////////////////////////////////////////////////////////////////////

	js_lnb Function	

/////////////////////////////////////////////////////////////////////////////////////////////////////////// */
$(window).load(function() {
	js_lnb();
});
function js_lnb(){
	var param = $("#lnb");
		param.btn = param.find(">.lnb_btn");
	
	//default
	param.addClass("on");
	$("#container").addClass("on");	
	param.btn.find(">span").addClass("on").text("메뉴닫기");	
		
	param.btn.click(function(){
		if($(this).find(">span").hasClass("on")){
			param.removeClass("on");
			$("#container").removeClass("on");
			$(this).find(">span").removeClass("on").text("메뉴열기");		
		} else {
			param.addClass("on");
			$("#container").addClass("on");
			$(this).find(">span").addClass("on").text("메뉴열기");
		}
	});
}




/* ///////////////////////////////////////////////////////////////////////////////////////////////////////////

	scroll Function	

/////////////////////////////////////////////////////////////////////////////////////////////////////////// */
$(document).ready(function() {
	$(".scroll").mCustomScrollbar({
		theme:"light"
	});
});