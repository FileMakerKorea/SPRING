<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!--
	템플릿 페이지들을
	정적인 페이지는 include지시자를 통하여 (하나의 java클래스로 컴파일),
	동적인 부분들은 표준액션태그의 include를 사용하여 (개별 java클래스로 컴파일) 포함한다.
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MBTI</title>
<script src="/mbti/resources/js/jquery-3.3.1.min.js"></script>
<script src="/mbti/resources/js/global.js"></script>
<script src="/mbti/resources/js/member.js"></script>
<script src="/mbti/resources/js/center.js"></script>
<link rel="stylesheet" type="text/css" href="/mbti/resources/css/global.css"/>
</head>
<body>
<div id="wrapper">
<%@include file="views/template/header.jsp" %>
<%@include file="views/template/topNav.jsp"%>
<c:if test="${ not empty param.nav }">
	<jsp:include page="${ param.nav }"/>
</c:if>
<jsp:include page="${ param.body }"/>
<%@include file="views/template/footer.jsp"%>
</div>
</body>
</html>