$(function(){

	/* 메인화면 모달창 */
	// 로그인 버튼 클릭 시 모달창 띄움
	$(".loginBtn").click(() => {
		$(".loginTypeWrap").css("display", "flex")
				
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

	$("#selectDomain").on("change", function() {
		var str = $(this).val();
		
		if(str == "manual") {	
			$("#email2").val("");
			$("#email2").prop("readonly", false);
			
		} else if(str == "naver.com"){	
			$("#email2").val("naver.com");			
			$("#email2").prop("readonly", true);
			
		} else if(str == "gmail.com") {		
			$("#email2").val("gmail.com");
			$("#email2").prop("readonly", true);
			
		} else if(str == "daum.net"){	
			$("#email2").val("daum.net");
			$("#email2").prop("readonly", true);
			
		} else if(str == "hanmail.net"){	
			$("#email2").val("hanmail.net");
			$("#email2").prop("readonly", true);
			
		} else if(str == "hotmail.net"){	
			$("#email2").val("hotmail.net");
			$("#email2").prop("readonly", true);
		}
	});

	$("#joinForm").on("submit", function() {
		
		return joinFormCheck();
	});
	
	$("#updateForm").on("submit", function() {
		
		return updateFormCheck();
	});
	
	$("#birthday").on("keyup", birthdayCheck);
});

/* 우편번호 검색 */
function findZipcode() {	
	new daum.Postcode({
		oncomplete: function(data) {
			var fullAddr = "";
			var extraAddr = "";
			
			if(data.userSelectedType === "R") { 
				fullAddr = data.roadAddress;				
			} else {
				fullAddr = data.jibunAddress;
			}
			
			if(data.userSelectedType === "R") {
				if(data.bname !== "") {
					extraAddr += data.bname;
				}
				
				if(data.buildingName != "") {
					extraAddr += extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
				}
				
				fullAddr += extraAddr !== "" ? "(" + extraAddr + ")" : "";
			}	
			
			document.querySelector(".zipcode").value = data.zonecode;
			document.querySelector(".address1").value = fullAddr;
			document.querySelector(".address2").focus();
		}
	}).open();
}

/*
	아이디 중복확인 창 띄움
	focusout이벤트로 처리 고려
*/
function overlapIdCheck() {
	var id = document.querySelector("input[name='id']");
	var url = "/mbti/normal/overlapIdCheck?id=" + id.value + "&currentPath=" + location.pathname;
	window.open(url, "memberIdCheck", "toolbar=no, location=no, status=no, menubar=no, width=400, height=200");
}

function birthdayCheck() {
	var regExp= /[^0-9]/g;
	if(regExp.test($(this).val())) {
		alert("생년월일은 숫자로만 적어주십시오.");
		$(this).val($(this).val().replace(regExp, ""));
	}
}

function updateFormCheck() {
	var pass = $("#pass").val();
	var passChk = $("#passChk").val();
	var bType = $("#bType").val();
	
	if(pass.length == 0) {		
		alert("비밀번호가 입력되지 않았습니다.\n비밀번호를 입력해주세요");
		return false;
	}
	
	if(passChk.length == 0) {		
		alert("비밀번호 확인이 입력되지 않았습니다.\n비밀번호 확인을 입력해주세요");
		return false;
	}
	
	if(pass != passChk) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		return false;
	}	
	
	if($("#bType").val() == "none") {		
		alert("혈액형이 선택되지 않았습니다.\n혈액형을 선택해주세요");
		return false;
	}
}
function joinFormCheck() {
	var id = $("#id").val();
	var pass = $("#pass").val();
	var passChk = $("#passChk").val();
	var name = $("#name").val();
	var birthday = $("#birthday").val();
	var email = $("#email").val();
	var email2 = $("#email2").val();
	var bType = $("#bType").val();
	
	if(id.length == 0) {		
		alert("아이디가 입력되지 않았습니다.\n아이디를 입력해주세요");
		return false;
	}
		
	if(pass.length == 0) {		
		alert("비밀번호가 입력되지 않았습니다.\n비밀번호를 입력해주세요");
		return false;
	}
	
	if(passChk.length == 0) {		
		alert("비밀번호 확인이 입력되지 않았습니다.\n비밀번호 확인을 입력해주세요");
		return false;
	}
	
	if(pass != passChk) {
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		return false;
	}	
	
	if(name.length == 0) {		
		alert("이름이 입력되지 않았습니다.\n이름을 입력해주세요");
		return false;
	}		
	
	if(birthday.length == 0) {		
		alert("생년월일이 입력되지 않았습니다.\n생년월일을 입력해주세요");
		return false;
	}
	
	if(birthday.length != 8) {		
		alert("생년월일은 8자 입니다.\n생년월일을 확인해주세요");
		return false;
	}

	if(email.length == 0) {		
		alert("이메일 아이디가 입력되지 않았습니다.\n이메일 아이디를 입력해주세요");
		return false;
	}	
	
	if(email2.length == 0) {		
		alert("이메일 도메인이 입력되지 않았습니다.\n이메일 도메인을 입력해주세요");
		return false;
	}
		
	if($("#bType").val() == "none") {		
		alert("혈액형이 선택되지 않았습니다.\n혈액형을 선택해주세요");
		return false;
	}
}
