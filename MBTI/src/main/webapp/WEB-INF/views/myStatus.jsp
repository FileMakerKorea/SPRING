<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- 신청현황 누르면 보임. 등록한 헌혈증 정보를 출력 -->
<div id="mainWrap">
 <div class="myWrap">
  <span class="statusImg"><img src = "/mbti/resources/images/angel.png"/></span>
	<div class="myStatusWrap">
		<!-- 등록된 헌혈증이 없을 때 -->
		<c:if test="${ empty bloodDetailList }">		
		  <div class="noBloodcard">
		    <p>아직 등록된 헌혈증이 없습니다.<br/>
			    헌혈증을 등록하고 내가 나눈 생명을 확인하세요.<br/>
			    <a href="/mbti/normal/certificateAdd">헌혈증 등록하기</a></p>
		  </div>
	  </c:if>
	  <!-- 등록된 헌혈증이 있을 때 -->
	  <c:if test="${ not empty bloodDetailList }">
		  <div class="bloodcardList">
		    <div class="bloodcardTitle">
		      <span class="cardTitle">헌혈증 번호</span>
		      <span class="cardTitle">도착지</span>
		      <span class="cardTitle">헌혈일자</span>
		    </div>
		    <div class="line"></div>
		  	<c:forEach var="detail" items="${ bloodDetailList }">
			    <div class="bloodcard">
			      <span class="cardBody">${ detail.bId }</span>
			      <span class="cardBody">${ detail.hName  eq null ? detail.cName : detail.hName }</span>
			      <span class="cardBody">${ detail.bDate }</span>
			    </div>
			    <div class="cardContent">
			      <div class="cardItem"><span class="itemTh">헌혈 종류 : </span><span class="itemTd">${ detail.bIndex }</span></div>
			      <div class="cardItem"><span class="itemTh">용량 : </span><span class="itemTd">${ detail.bVolume }ml</span></div>
			      <div class="cardItem"><span class="itemTh">혈액원 : </span><span class="itemTd">${ detail.cName }</span></div>
			      <div class="cardItem"><span class="itemTh">혈액원 등록일 : </span><span class="itemTd">${ detail.bDate }</span></div>
			      <div class="cardItem"><span class="itemTh">병원 : </span><span class="itemTd">${ detail.hName eq null ? '-' : detail.hName }</span></div>
			      <div class="cardItem"><span class="itemTh">병원 등록일 : </span><span class="itemTd">${ detail.bRegDate eq null ? '-' : detail.bRegDate }</span></div>
			      <div class="cardItem"><span class="itemTh">사용 여부 : </span><span class="itemTd">${ detail.bUsed eq 'Y' ? '사용' : '미사용' }</span></div>
			      <div class="cardItem"><span class="itemTh">수혈자 :</span>
			      <span class="itemTd">${ detail.buName eq null ? '-' : detail.buName }${ detail.buDate eq null ? '' : detail.buDate }</span>			      	
		      	</div>
			    </div>
		    </c:forEach>
		  </div>
	  </c:if>
  </div>
 </div> 
</div>
