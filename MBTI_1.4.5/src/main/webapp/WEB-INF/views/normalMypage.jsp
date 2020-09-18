<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- 일반회원의 마이페이지. 기본 화면에는 등록한 헌혈증 정보를 출력 -->
<div id="mainWrap">
  <div class="noBloodcard"> <!-- 등록된 헌혈증이 없을 때 -->
    <p>아직 등록된 헌혈증이 없습니다.<br/>
	    헌혈증을 등록하고 내가 나눈 생명을 확인하세요.<br/>
	    <a href="/mbti/normal/certificateAdd">헌혈증 등록하기</a></p>
  </div>
  <div class="bloodcardList"> <!-- 등록된 헌혈증이 있을 때 -->
    <div class="bloodcardTitle">
      <span class="cardTitle">헌혈증 번호</span>
      <span class="cardTitle">도착지</span>
      <span class="cardTitle">수혈일자</span>
    </div>
    <div class="line"></div>
    <div class="bloodcard">
      <span class="cardBody">123-12345-12</span>
      <span class="cardBody">서울대학교병원</span>
      <span class="cardBody">2020.07.12</span>
    </div>
    <!-- 헌혈증 정보 클릭하면 나타남 ajax 혹은 display: none;-->
    <div class="cardContent">
      <div class="cardItem"><span class="itemTh">헌혈 종류 : </span><span class="itemTd">전혈</span></div>
      <div class="cardItem"><span class="itemTh">용량 : </span><span class="itemTd">400ml</span></div>
      <div class="cardItem"><span class="itemTh">혈액원 : </span><span class="itemTd">서울남부혈액원</span></div>
      <div class="cardItem"><span class="itemTh">혈액원 등록일 : </span><span class="itemTd">2020.07.14</span></div>
      <div class="cardItem"><span class="itemTh">병원 : </span><span class="itemTd">서울대학교병원</span></div>
      <div class="cardItem"><span class="itemTh">병원 등록일 : </span><span class="itemTd">2020.07.14</span></div>
      <div class="cardItem"><span class="itemTh">사용 여부 : </span><span class="itemTd">사용</span></div>
      <div class="cardItem"><span class="itemTh">수혈자 : </span><span class="itemTd">홍길동/2020.07.14</span></div>
    </div>
    <div class="bloodcard">
      <span class="cardBody">721-16645-12</span>
      <span class="cardBody">서울혈액원</span>
      <span class="cardBody">-</span>
    </div>
    <div class="cardContent">
      <div class="cardItem"><span class="itemTh">헌혈 종류 : </span><span class="itemTd">전혈</span></div>
      <div class="cardItem"><span class="itemTh">용량 : </span><span class="itemTd">400ml</span></div>
      <div class="cardItem"><span class="itemTh">혈액원 : </span><span class="itemTd">서울남부혈액원</span></div>
      <div class="cardItem"><span class="itemTh">혈액원 등록일 : </span><span class="itemTd">2020.07.14</span></div>
      <div class="cardItem"><span class="itemTh">병원 : </span><span class="itemTd">서울대학교병원</span></div>
      <div class="cardItem"><span class="itemTh">병원 등록일 : </span><span class="itemTd">2020.07.14</span></div>
      <div class="cardItem"><span class="itemTh">사용 여부 : </span><span class="itemTd">사용</span></div>
      <div class="cardItem"><span class="itemTh">수혈자 : </span><span class="itemTd">홍길동/2020.07.14</span></div>
    </div>
  </div>
</div>