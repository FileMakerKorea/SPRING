<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- 사이트 헤더. 로그인 상황에 따라 .headerLink 내용 다르게 출력 -->
<div id="header">
  <div class="headerLogo">
    <a href="/mbti/main">
      <img src="/mbti/resources/images/mainIcon.png"/>
    </a>
  </div>
  <h2 class="headerTitle">
    My Blood Tracking Information
  </h2>
  <div class="headerRight">
    <div class="headerLinkWrap">
      <div class="headerLink loginBtn"><a>로그인</a></div>
      <div class="marker"></div>
      <div class="headerLink"><a href="/mbti/normal/join">회원가입</a></div>
      <div class="marker"></div>
      <div class="headerLink"><a href="/mbti/normal/normalMypage">내정보</a></div>
      <div class="marker"></div>
      <div class="headerLink"><a href="#">고객센터</a></div>
    </div>      
  </div>
  <!-- 로그인 유형을 표시하는 모달창 -->
  <div class="loginTypeWrap">
    <div class="loginType">
      <span class="loginTypeSpan">어떤 회원으로 로그인 하시겠습니까?</span>
      <div class="loginTypeClose"><img src="/mbti/resources/images/close1616.png"/></div>
      <!-- 디자인 쉽게 버튼으로 바꿀 수 있음 -->
      <img class="loginNormalType" src="/mbti/resources/images/일반회원.png"/>
      <img class="loginOrgType" src="/mbti/resources/images/기관회원.png"/>
    </div>
  </div>
</div>