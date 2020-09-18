<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- topNav -->
<div id="topNav">
  <ul class="topNavUl">
    <li class="topNavLi"><!-- hover하면 .topNavItems표시 -->
      <div class="topNavTitle" onclick="location.href='/mbti/intro/introduction'">MBTI</div>      
    </li>
    <li class="topNavLi">
      <div class="topNavTitle" onclick="location.href='/mbti/normal/myStatus'">신청현황</div>
    </li>
    <li class="topNavLi">
      <div class="topNavTitle">정보알림방</div>
      <div class="topNavItems">
        <div class="topNavItem"><a href="/mbti/center/centerList">혈액 센터 현황</a></div>
        <div class="topNavItem"><a href="/mbti/hospital/hospitalList">병원 현황</a></div>
      </div>
    </li>
    <li class="topNavLi">
      <div class="topNavTitle" onclick="location.href='/mbti/board/boardList'">자유게시판</div>
    </li>
  </ul>
</div>
