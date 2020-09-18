<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="mainWrap">
<div class = "boardWrap">
<form name="checkForm" id="checkForm">
	<input type="hidden" name="no" id="no" value="${ board.no }"/>
	<input type="hidden" name="pass" id="rPass" />
	<input type="hidden" name="pageNum" value="${ pageNum }" />	
	<%-- 
		검색 리스트에서 들어온 요청일 경우 다시 keyword에 해당하는 
		검색 리스트로 돌려보내기 위해서 아래의 파라미터가 필요하다.
	 --%>
	<c:if test="${ searchOption }">
		<input type="hidden" name="type" value="${ type }" />
		<input type="hidden" name="keyword" value="${ word }" />
	</c:if>
</form>
<table class="contentTable">
	<tr>
		<td colspan="4" class="boardTitle">
			<h3>자유게시판</h3>
		</td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr>
		<td class="contentTh">제목</td>
		<td class="contentTd">${ board.title }</td>
		<td class="contentTh" id="contentNo">NO</td>
		<td class="contentTd">${ board.no }</td>		
	</tr>
	<tr>
		<td class="contentTh">글쓴이</td>
		<td class="contentTd">${ board.writer }</td>
		<td class="contentTh" id="contentRegDate">작성일</td>
		<td class="contentTd"><fmt:formatDate value="${ board.regDate }" 
			pattern="yyyy-MM-dd HH:mm:ss" /></td>		
	</tr>
	<tr>		
		<td class="contentTh">비밀번호</td>
		<td class="contentTd"><input type="text" name="pass" id="pass"></td>
		<td class="contentTh" id="contentReadCount">조회수</td>
		<td class="contentTd">${ board.readCount }</td>
	</tr>	
	<tr>
		<td class="contentTh">파&nbsp;&nbsp;&nbsp;&nbsp;일</td>
		<td class="contentTd" colspan="3">
		<c:if test="${ empty board.file1 }">
			첨부파일 없음
		</c:if>
		<c:if test="${ not empty board.file1 }">
			<a href="fileDownload?fileName=${ board.file1 }">file1 다운로드</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="fileDownload?fileName=${ fileName }">fileName 다운로드</a>
		</c:if>
		</td>		
	</tr>
	<tr>		
		<td class="readContent" colspan="4">
			<pre>${ board.content }</pre>
		</td>
	</tr>	
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4" class="tdSpan">
			<input type="button" id="detailUpdate" value="수정하기"/>
			&nbsp;&nbsp;<input type="button" id="detailDelete" value="삭제하기" />
			<%-- 일반 게시 글 리스트에서 온 요청이면 일반 게시 글 리스트로 돌려 보낸다. --%>
			<c:if test="${ not searchOption }">		
				&nbsp;&nbsp;<input type="button" value="목록보기" 
					onclick="javascript:window.location.href=
						'boardList?pageNum=${ pageNum }'"/>
			</c:if>
			<%-- 
				검색 리스트에서 온 요청이면 검색 리스트의 동일한 페이지로 돌려보낸다. 
			--%>
			<c:if test="${ searchOption }">
				&nbsp;&nbsp;<input type="button" value="목록보기" 
					onclick="javascript:window.location.href=
						'boardList?pageNum=${ pageNum }&type=${ type }&keyword=${ keyword }'"/>
				<%-- 
					위의 쿼리 스트링을 작성할 때 같은 줄에서 띄어쓰기 하는 것은 문제되지
					않지만 줄 바꿔서 작성하게 되면 스크립트 에러가 발생한다.
				--%>		
			</c:if>				
		</td>
	</tr>
</table>
</div>
</div>
