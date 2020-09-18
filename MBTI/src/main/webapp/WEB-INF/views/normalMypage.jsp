<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- 일반회원의 마이페이지. 기본 화면에는 등록한 헌혈증 정보를 출력 -->
<div id="mainWrap">
	<div class="mypageWrap">
		<div class="memberInfo">
			<span class="memberName">${ member.mName }</span><img class="memberBType" src="/mbti/resources/images/blood${ member.mBType.trim() }${ member.mRhType eq 'RH+' ? '+' : '-' }.png"/>
		</div>
		<div class="mypageLi">
			
			
			<!-- 헌혈증 등록 여부에 따라 -->
			<c:if test="${ empty totalCount }">
				<span class="mBloodStatus">등록된 헌혈증이 없습니다.</span><span>헌혈증 등록하기</span>
			</c:if>
			<c:if test="${ not empty totalCount }">
				<span class="mBloodStatus">등록된 헌혈증이 <strong>${ totalCount }개</strong> 있습니다.</span>
			</c:if>
		</div>
		<table class="memberBloodT">
			<tbody>
				<tr><td class="memberBloodTitle" colspan="2">${ member.mName }님의 헌혈 현황</td></tr>
				<c:if test="${ empty totalCount }">
					<tr><td class="memberNoBloodTh">헌혈증을 등록하면 통계를 확인할 수 있습니다.</td><td class="memberNoBloodTd"><a href="/mbti/normal/certificateAdd">등록하기</a></td></tr>
				</c:if>
				<c:if test="${ not empty totalCount }">
					<tr><td class="memberBloodTh">헌혈 구분</td><td class="memberBloodTd">
						<c:forEach var="bIndex" varStatus="i" items="${ bIndexList }">
							${ bIndex.bIndex }: ${ bIndex.count }회
						</c:forEach>
					</td></tr>
					<tr><td class="memberBloodTh">총 헌혈량</td><td class="memberBloodTd">${ volumeSum }ml</td></tr>
					<tr><td class="memberBloodTh">가장 많이 헌혈한 혈액원</td><td class="memberBloodTd">${ centerList.get(0).cName }: ${ centerList.get(0).count }회</td></tr>
					<c:if test="${ not empty hospList }">
						<tr><td class="memberBloodTh">혈액이 가장 많이 거쳐간 병원</td><td class="memberBloodTd">${ hospList.get(0).hName }: ${ hospList.get(0).count }회</td></tr>
					</c:if>
				</c:if>
			</tbody>
		</table>		
	</div>
</div>
