<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- 기관 로그인인 경우 연결되는 페이지 -->
<div id="mainWrap">
	<!-- action, method는 자바스크립트로 유효성 검사 후 설정 -->
  <form class="loginForm" id="orgLoginForm" name="orgLoginForm" action="/mbti/org/loginProcess", method="POST">
	  <div class="loginFormInput">
	    <input name="orgName" class="loginId" type="text" placeholder="기관명"/>
	    <input name="orgCode" class="loginPass" type="password" placeholder="기관코드"/>
	    <input type="submit" class="loginSubmit" value="로그인"/>
	  </div>
	  <div class="line"></div>
	  <div class="formInfo">
	    <div class="fomrInfoLi">
	      <!-- <div class="formInfoSpan">~~~~~~~~~에 동참해주세요.&nbsp;&nbsp;&nbsp;<a href="#">기관 회원가입</a></div> -->
	      <!-- <div class="formInfoSpan">아이디/비밀번호를 잊어버리셨다면<a href="#">아이디/비밀번호 찾기</a></div> -->
	    </div>
	  </div>
  </form>
</div>
