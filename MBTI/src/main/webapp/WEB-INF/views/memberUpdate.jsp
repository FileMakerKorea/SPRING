<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<div id="mainWrap">
	<div class="memberUpdateWrap">
		<form id="updateForm" class="memberForm" name="updateForm" action="/mbti/normal/memberUpdateProcess" method="post">
			<div class="formInput">
	      <div class="formLi">
	      	<input name="id" id="id" class="memberFormInput" type="text" value="${ member.mId }" readonly/>
      	</div>
	      <div class="formLi">
	      	<input name="pass" id="pass" class="memberFormInput" type="password" placeholder="비밀번호 변경"/>
      	</div>
	      <div class="formLi">
	      	<input name="passChk" id="passChk" class="memberFormInput" type="password" placeholder="비밀번호 확인"/>
      	</div>
	      <div class="formLi">
	      	<input name="name" id="name" class="memberFormInput" type="text" value="${ member.mName }" readonly/>
      	</div>
	      <div class="formLi">
	      	<input name="birthday" id="birthday" class="memberFormInput" type="text" value="${ member.mBirth }" readonly/>
      	</div>
	      <div class="formLi">
	      	<label>남<input name="gender" class="gender" type="radio" value="male"${ member.mGender eq '남' ? ' checked' : '' }/></label>
	      	<label>여<input name="gender" class="gender" type="radio" value="female"${ member.mGender eq '여' ? ' checked' : '' }/></label>
      	</div>
	      <div class="formLi">
	      	<input name="email" id="email" class="email email1" type="text" value="${ member.mEmail.split('@')[0] }"/>
		      @
		      <input name="email" id="email2" class="email email2" type="text" value="${ member.mEmail.split('@')[1] }"/>
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
		      <select name="bType" class="bType" id="bType">
		        <option value="none">혈액형</option>
		        <option value="A"${ member.mBType eq 'A' ? ' selected' : '' }>A</option>
		        <option value="B"${ member.mBType eq 'B' ? ' selected' : ''}>B</option>
		        <option value="O"${ member.mBType eq 'O' ? ' selected' : ''}>O</option>
		        <option value="AB"${ member.mBType eq 'AB' ? ' selected' : ''}>AB</option>
		      </select>
		      <label>RH+<input name="rhType" class="rhType" type="radio" value="RH+" ${ member.mRhType eq 'RH+' ? 'checked' : '' }/></label>
		      <label>RH-<input name="rhType" class="rhType" type="radio" value="RH-" ${ member.mRhType eq 'RH-' ? 'checked' : '' }/></label>
	      </div>
	      <div class="formLi">
	      	<input name="mobile" class="mobile memberFormInput" type="text" placeholder="전화번호 ' - '없이 입력" value="${ member.mCell }"/></div>
	      <div class="formLi">
	      	<input name="zipcode" class="zipcode" type="text" value="${ zipcode }"/><input class="memberFormBtn zipcodeBtn" type="button" onclick="findZipcode()" value="우편번호 찾기">
      	</div>
	      <div class="formLi">
	      	<input name="address1" class="address1" type="text" value="${ address1 }"/>
      	</div>
	      <div class="formLi">
	      	<input name="address2" class="address2" type="text" placeholder="상세주소" value="${ address2 }"/>
      	</div>
	      <div class="formLi">
	      	<input name="height" class="height memberFormInput" placeholder="키(cm)" value="${ member.mHeight }"/>
      	</div>
	      <div class="formLi">
	      	<input name="weight" class="weight memberFormInput" placeholder="몸무게(kg)" value="${ member.mWeight }"/>
      	</div>
	    </div>
	    <div class="updateBtn"><input type="submit" class="memberFormBtn memberUpdateSubmit" value="정보수정"/> <input type="reset" class="memberFormBtn memberUpdateReset" value="다시쓰기"/></div>
		</form>
	</div>
</div>
