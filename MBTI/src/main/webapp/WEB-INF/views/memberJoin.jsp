<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 일반회원 회원가입 페이지 -->
<div id="mainWrap">
	<h3 class="joinTitle">회원 가입</h3>
	<div class="joinTitleLine"></div>	
  <form id="joinForm" class="memberForm" name="joinForm" action="/mbti/normal/joinProcess" method="POST">
  	<div class="joinField">
  		<div class="joinInfo">
  			<div class="joinInfoSpan">필수항목</div>
  		</div>
	    <div class="formInput">
	      <div class="formLi">
	      	<input name="id" id="id" class="memberFormInput" type="text" placeholder="아이디"/>
	      	<div class="check" id="idCheck"></div>	
      	</div>
      	<div class="formLi">
	      	<input name="pass" id="pass" class="memberFormInput" type="password" placeholder="비밀번호"/>
      	</div>
	      <div class="formLi">
	      	<input name="passChk" id="passChk" class="memberFormInput" type="password" placeholder="비밀번호 확인"/>
      	</div>
	      <div class="formLi">
	      	<input name="name" id="name" class="memberFormInput" type="text" placeholder="이름"/>
      	</div>
	      <div class="formLi">
	      	<input name="birthday" id="birthday" class="memberFormInput" type="text" placeholder="생년월일 8자리"/>
      	</div>
	      <div class="formLi">
	      	<label>남<input name="gender" class="gender" type="radio" value="male" checked/></label>
	      	<label>여<input name="gender" class="gender" type="radio" value="female"/></label>
      	</div>
	      <div class="formLi">
	      	<input name="email" class="email email1" id="email" type="text" placeholder="이메일"/>
		      @
		      <input name="email" class="email email2" id="email2" type="text"/>
		      <select class="domain" id="selectDomain">
		        <option value="manual">직접입력</option>
		        <option value="naver.com">naver.com</option>
		        <option value="gmail.com">gmail.com</option>
		        <option value="daum.net">daum.net</option>
		        <option value="hanmail.net">hanmail.net</option>
		        <option value="hotmail.net">hotmail.net</option>
		      </select>
	      </div>
	      <div class="formLi">
		      <select name="bType" id="bType" class="bType">
		        <option value="none">혈액형</option>
		        <option value="A">A</option>
		        <option value="B">B</option>
		        <option value="O">O</option>
		        <option value="AB">AB</option>
		      </select>
		      <label>RH+<input name="rhType" class="rhType" type="radio" value="RH+" checked/></label>
		      <label>RH-<input name="rhType" class="rhType" type="radio" value="RH-"/></label>
	      </div>
	    </div>
    </div>
    <div class="line"></div>
    <div class="joinField">
    	<div class="joinInfo">
  			<span class="joinInfoSpan">선택항목</span>
  			<img class="optionalInfo" src="/mbti/resources/images/optionalAsk.png"/>
  			<div class="optionalInfoText">
  				<span>선택항목 미입력시 서비스 이용에 제약이 생길 수 있습니다.<br/>
  				정보수정으로 추후에 선택항목을 수정할 수 있습니다.</span>
  			</div>
  		</div>
	    <div class="formInput">
	      <div class="formLi">
	      	<input name="mobile" class="mobile memberFormInput" type="text" placeholder="전화번호 ' - '없이 입력"/></div>
	      <div class="formLi">
	      	<input name="zipcode" class="zipcode" type="text" placeholder="우편번호"/><input class="memberFormBtn zipcodeBtn" type="button" onclick="findZipcode()" value="우편번호 찾기">
      	</div>
	      <div class="formLi">
	      	<input name="address1" class="address1" type="text" placeholder="건물주소"/>
      	</div>
	      <div class="formLi">
	      	<input name="address2" class="address2" type="text" placeholder="상세주소"/>
      	</div>
	      <div class="formLi">
	      	<input name="height" class="height memberFormInput" placeholder="키(cm)"/>
      	</div>
	      <div class="formLi">
	      	<input name="weight" class="weight memberFormInput" placeholder="몸무게(kg)"/>
      	</div>
	    </div>
    </div>
    <div class="joinBtn"><input type="submit" class="memberFormBtn memberJoinSubmit" id="reg_submit" value="회원가입"/> <input type="reset" class="memberFormBtn memberJoinReset" value="다시쓰기"/></div>
  </form>
  <form id="overlapCheckForm">

  	<input type="hidden" name="isIdChecked"/>
  	<input type="hidden" name="checkId"/>
  </form>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#id").on("keyup", function() {

			if($(this).val().length <= 4) {
				$('#idCheck').html('<span style="color:red">아이디는 5자이상 입력해주세요.</span>');
				
			} else {			
				$.ajax({
					type : 'POST',
					url : 'overlapIdCheck',
					data : {
						"id" : $('#id').val()
					},
					success : function(data) {
						console.log(data);
						if ($.trim(data) == 0) {
							$('#idCheck').html('<span style="color:blue">사용 가능한 아이디입니다.</span>');
						} else {
							$('#idCheck').html('<span style="color:red">중복된 아이디입니다.</span>');
						}
					}
				});
			}
		});		
	});
</script>
