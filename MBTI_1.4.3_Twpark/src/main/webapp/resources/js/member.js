$(function(){

	/* 메인화면 모달창 */
	// 로그인 버튼 클릭 시 모달창 띄움
	$(".loginBtn").click(function(e) {
		$(".loginTypeWrap").css("display", "flex");
				
	}); 
	
	// 모달창에서 X 클릭 시 모달창 숨김
	$(".loginTypeClose").click(function() {
		$(".loginTypeWrap").css("display", "none");
	});
	
	$(".loginOrgType").click(() => {
		$(".loginTypeWrap").css("display", "none");
		location.href = "/mbti/org/login";
	});
	
	$(".loginNormalType").click(() => {
		$(".loginTypeWrap").css("display", "none");
		location.href = "/mbti/normal/login";
	});
	
	
});