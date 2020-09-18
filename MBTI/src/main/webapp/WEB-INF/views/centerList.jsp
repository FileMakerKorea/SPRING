<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>

 
 table {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
	margin: 65px auto;
}
 th {
    width: 155px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #ce4869 ;
}
 td {
    width: 155px;
    padding: 10px;
    border-bottom: 1px solid #ccc;
    background: #eee;
    vertical-align: middle;
}
</style>
<script type="text/javascript">
function getCenterCode(centerId, centerName){
     opener.document.getElementById("codeInput").value = centerId ;
     opener.document.getElementById("codeNameInput").value = centerName;

     self.close();
}


</script>
<div id = "mainWrap">
 <div class = "centerListWrap">
<table class="centerListTable" width = "1000px">
	<tr>
		<td class="centerTitle" colspan="5">
			<h2>센터 리스트</h2>
		</td>
	</tr>
	<tr>
		<td colspan="5">
			<form name="centerSearchForm" id="centerSearchForm">
				<select name="type" id="type" >
					<option value="cLocal">지역</option>
					<option value="cName">센터명</option>
					<option value="cAddr">주소</option>
				</select>
				<input type="text" name="keyword" id="keyword" />
				<input type="submit" value="검색" />
			</form></br>
		</td>
	</tr>
	<%-- 검색 요청일 경우만 아래를 화면에 표시 한다. --%>
	<c:if test="${ searchOption }">
	<tr>
		<td colspan="4" id="searchComment">
			"${ word  }" 검색 결과</td>
	</tr>
	<tr>
		<%-- 검색 요청일 경우 일반 게시 글 리스트로 이동할 수 있도록 링크를 설정했다. --%>
		<td colspan="4" class="centerListLink"><a href="centerList">전체 센터 리스트</a></td>
	</tr>	
	</c:if>
	
	<tr>
		<!-- <th class="centerListId">아이디</th> -->
		<th class="centerListLocal">지역</th>
		<th class="centerListName">센터명</th>
		<th class="centerListAddr">주소</th>
		<th class="centerListPhone">연락처</th>
	</tr>
<%-- 
	검색 요청 이면서 검색된 리스트가 존재할 경우
	게시 글 상세보기로 링크를 적용할 때 type과 keyword 
	파라미터를 적용해 링크를 설정한다. 
--%>	
<c:if test="${ searchOption and not empty centerList }">
	<c:forEach var="b" items="${ centerList }" varStatus="status">		
	<tr class="centerListTr">
		<!-- <td class="centerListTdId">
		..</td> -->
		<td class="centerListTdLocal"><a href = "#" onclick = "getCenterCode('${ b.cId }', '${ b.cName }');">${b.cLocal}</a></td>
		<td class="centerListTdName">${ b.cName }</td>
		<td class="centerListTdAddr">${ b.cAddr }</td>
		<td class="centerListTdPhone">${ b.cPhone }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" class="centerListPage">
			<%--
			/* 현재 페이지 그룹의 시작 페이지가 pageGroup보다 크다는 것은
			 * 이전 페이지 그룹이 존재한다는 것으로 현재 페이지 그룹의 시작 페이지에
			 * pageGroup을 마이너스 하여 링크를 설정하면 이전 페이지 그룹의
			 * startPage로 이동할 수 있다.
		 	 **/
		 	 --%>
		 	<c:if test="${ startPage > pageGroup }">
				<a href="centerList?pageNum=${ startPage - pageGroup }
					&type=${ type }&keyword=${ keyword }">[이전]</a>
			</c:if>	
			<%--
			/* 현재 페이지 그룹의 startPage 부터 endPage 만큼 반복하면서
		 	 * 현재 페이지와 같은 그룹에 속한 페이지를 화면에 출력하고 링크를 설정한다.
		 	 * 현재 페이지는 링크를 설정하지 않는다.
		 	 **/
		 	--%>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
				<c:if test="${ i == currentPage }">
					[ ${ i } ]
				</c:if>			
				<c:if test="${ i != currentPage }">
					<a href="centerList?pageNum=${ i }&type=${ type }
						&keyword=${ keyword }">[ ${ i } ]</a>
				</c:if>			
			</c:forEach>
			<%-- 
			/* 현재 페이지 그룹의 마지막 페이지가 전체 페이지 보다 작다는 것은
			 * 다음 페이지 그룹이 존재한다는 것으로 현재 페이지 그룹의 시작 페이지에
			 * pageGroup을 플러스 하여 링크를 설정하면 다음 페이지 그룹의
			 * startPage로 이동할 수 있다.
		 	 **/
		 	 --%>
			<c:if test="${ endPage < pageCount }">
				<a href="centerList?pageNum=${ startPage + pageGroup }
					&type=${ type }&keyword=${ keyword }">[다음]</a>
			</c:if>		
		</td>
	</tr>
</c:if>	
	
<c:if test="${ not searchOption and not empty centerList }">
	<c:forEach var="b" items="${ centerList }" varStatus="status">		
	<tr class="centerListTr">
		<%-- <td class="centerListTdId">${ b.cId }</td> --%>
		<td class="centerListTdLocal"><a href = "#" onclick = "getCenterCode('${ b.cId }', '${ b.cName }');">${b.cLocal}</a></td>
		<td class="centerListTdName">${ b.cName }</td>
		<td class="centerListTdAddr">${ b.cAddr }</td>
		<td class="centerListTdPhone">${ b.cPhone }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="4" class="centerListPage">
		
		 	<c:if test="${ startPage > pageGroup }"> 
				<a href="centerList?pageNum=${ startPage - pageGroup }">
					[이전]</a>
			</c:if>	

			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
				<c:if test="${ i == currentPage }">
					[ ${ i } ]
				</c:if>			
				<c:if test="${ i != currentPage }">
					<a href="centerList?pageNum=${ i }">[ ${ i } ]</a>
				</c:if>			
			</c:forEach>

			<c:if test="${ endPage < pageCount }">
				<a href="centerList?pageNum=${ startPage + pageGroup }">
					[다음]</a>
			</c:if>		
		</td>
	</tr>
</c:if>
<%-- 검색 요청이면서 검색된 리스트가 존재하지 않을 경우 --%>
<c:if test="${ searchOption and empty centerList }">
	<tr>
		<td colspan="5" class="centerListTdSpan">
			"${ word }" 등록된 센터가 존재하지 않습니다</td>
	</tr>
</c:if>
</table>
 </div>
</div>




