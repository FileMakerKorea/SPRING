<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- 일반회원 로그인인 경우 연결되는 페이지 -->
<div id="mainWrap">
	<!-- action, method는 자바스크립트로 유효성 검사 후 설정 -->
  <form class="loginForm" id="normalLoginForm" name="normalLoginForm" action="/mbti/normal/loginProcess" method="POST">
		<div class="loginFormInput">
			<input name="id" class="loginId" type="text" placeholder="아이디"/>
			<input name="pass" class="loginPass" type="password" placeholder="비밀번호"/>
			<input type="submit" class="loginSubmit" value="로그인"/>
		</div>
		<div class="line"></div>
		<div class="formInfo">
			<div class="formInfoSpan">아직 회원이 아니시라면&nbsp;&nbsp;&nbsp;<a href="/mbti/normal/join">회원가입</a></div>
			<div class="formInfoSpan">아이디/비밀번호를 잊어버리셨다면&nbsp;&nbsp;&nbsp;<a href="#">아이디/비밀번호 찾기</a></div>
		</div>
  </form>
</div>