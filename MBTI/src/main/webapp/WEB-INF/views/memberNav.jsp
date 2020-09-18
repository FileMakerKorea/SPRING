<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="normalLeftNav">
	<!-- EL로 선택된 항목에 leftLiOn 클래스 추가 -->
	<div class="normalLeftLi${ pageType eq 'normalMypage' ? ' leftLiOn' : ''}" ><a href="/mbti/normal/normalMypage">나의 헌혈 정보</a></div>
	<div class="normalLeftLi${ pageType eq 'certificateAdd' ? ' leftLiOn' : ''}"><a href="/mbti/normal/certificateAdd">헌혈 정보 입력</a></div>
	<div class="normalLeftLi${ pageType eq 'memberUpdate' ? ' leftLiOn' : ''}"><a href="/mbti/normal/memberUpdate">정보 수정</a></div>
</div>
