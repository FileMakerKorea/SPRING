<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



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
	      	<input name="id" class="id memberFormInput" type="text" placeholder="아이디"/>
      	</div>
	      <div class="formLi">
	      	<input name="pass" class="pass memberFormInput" type="password" placeholder="비밀번호"/>
      	</div>
	      <div class="formLi">
	      	<input name="passChk" class="passChk memberFormInput" type="password" placeholder="비밀번호 확인"/>
      	</div>
	      <div class="formLi">
	      	<input name="name" class="name memberFormInput" type="text" placeholder="이름"/>
      	</div>
	      <div class="formLi">
	      	<input name="birthday" class="birthday memberFormInput" type="text" placeholder="생년월일 8자리"/>
      	</div>
	      <div class="formLi">
	      	<label>남<input name="gender" class="gender" type="radio" value="male"/></label>
	      	<label>여<input name="gender" class="gender" type="radio" value="female"/></label>
      	</div>
	      <div class="formLi">
	      	<input name="email" class="email email1" type="text" placeholder="이메일"/>
		      @
		      <input name="email" class="email email2" type="text"/>
		      <select class="domain">
		        <option value="manual">직접입력</option>
		        <option value="naver.com">naver.com</option>
		        <option value="google.com">google.com</option>
		        <option value="daum.net">daum.net</option>
		        <option value="hanmail.net">hanmail.net</option>
		        <option value="hotmail.net">hotmail.net</option>
		      </select>
	      </div>
	      <div class="formLi">
		      <select name="bType" class="bType">
		        <option value="none">혈액형</option>
		        <option value="a">A</option>
		        <option value="b">B</option>
		        <option value="o">O</option>
		        <option value="ab">AB</option>
		      </select>
		      <label>RH+<input name="rhType" class="rhType" type="radio" value="plus" checked/></label>
		      <label>RH-<input name="rhType" class="rhType" type="radio" value="minus"/></label>
	      </div>
	    </div>
    </div>
    <div class="line"></div>
    <div class="joinField">
    	<div class="joinInfo">
  			<span class="joinInfoSpan">선택항목</span>
  			<img class="optionalInfo" src="/mbti/resources/images/optionalAsk.png"/>
  			<div class="optionalInfoText">
  				<span>안내문구가 표시됩니다.<br/>안내문구가 표시됩니다.<br/>안내문구가 표시 됩니다.</span>
  			</div>
  		</div>
	    <div class="formInput">
	      <div class="formLi">
	      	<input name="mobile" class="mobile memberFormInput" type="text" placeholder="전화번호 ' - '없이 입력"/></div>
	      <div class="formLi">
	      	<input name="zipcode" class="zipcode" type="text" placeholder="우편번호"/><input class="memberFormBtn zipcodeBtn" type="button" value="우편번호 찾기">
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
    <div class="joinBtn"><input type="submit" class="memberFormBtn memberFormSubmit" value="회원가입"/> <input type="reset" class="memberFormBtn memberFormReset" value="다시쓰기"/></div>
  </form>
</div>