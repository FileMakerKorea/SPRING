<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<article>
<style>

 
 table {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: center;
    line-height: 1.5;
	margin: auto;
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
    width: 200px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #eee;
    text-align: left;
}
.listThRegDate {
    width: 700px;
}
</style>

    <script type="text/javascript">
        function getCenterCode(centerId, centerName){
             opener.document.getElementById("codeInput").value = centerId ;
             opener.document.getElementById("codeNameInput").value = centerName;

             self.close();
        }
   </script>


<table class="listTable" width = "700px">
	<tr>
		<td class="centerTitle" colspan="5">
			<h2>센터리스트</h2>
		</td>
	</tr>
	<tr>
		<td colspan="5">
			<form name="searchForm" id="searchForm">
				<select name="type" id="type" >
					<option value=""></option>					
					<option value="writer">지역</option>
					<option value="content">센터명</option>
				</select>
				<input type="text" name="keyword" id="keyword" />
				<input type="submit" value="검색" />
			</form></br>
		</td>
	</tr>
	<%-- 검색 요청일 경우만 아래를 화면에 표시 한다. --%>
	<c:if test="${ searchOption }">
	<tr>
		<td colspan="5" id="searchComment">
			"${ word  }" 검색 결과</td>
	</tr>
	<tr>
		<%-- 검색 요청일 경우 일반 게시 글 리스트로 이동할 수 있도록 링크를 설정했다. --%>
		<td colspan="2" class="centerListLink"><a href="centerList">리스트</a></td>
	</tr>	
	</c:if>
	
	<tr>
		<th class="listThNo">아이디</th>
		<th class="listThTitle">지역</th>
		<th class="listThWriter">센터명</th>
		<th class="listThRegDate">주소</th>
		<th class="listThReadCount">연락처</th>
	</tr>
<%-- 
	검색 요청 이면서 검색된 리스트가 존재할 경우
	게시 글 상세보기로 링크를 적용할 때 type과 keyword 
	파라미터를 적용해 링크를 설정한다. 
--%>	
<c:if test="${ searchOption and not empty centerList }">
	<c:forEach var="b" items="${ centerList }" varStatus="status">		
	<tr class="listTr">
		<td class="listTdNo">
		<a th:onclick="|javascript:getCenterCode('${b.cId},${ b.cName } ')|">${ b.cId }</a></td>
		<td class="listTdTitle">${b.cLocal}</td>
		<td class="listTdWriter">${ b.cName }</td>
		<td class="listTdRegDate">${ b.cAdr }</td>
		<td class="listTdReadCount">${ b.cPnone }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" class="listPage">

		 	<c:if test="${ startPage > pageGroup }">
				<a href="centerList?pageNum=${ startPage - pageGroup }
					&type=${ type }&keyword=${ keyword }">[이전]</a>
			</c:if>	

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

			<c:if test="${ endPage < pageCount }">
				<a href="centerList?pageNum=${ startPage + pageGroup }
					&type=${ type }&keyword=${ keyword }">[다음]</a>
			</c:if>		
		</td>
	</tr>
</c:if>	
	
<c:if test="${ not searchOption and not empty centerList }">
	<c:forEach var="b" items="${ centerList }" varStatus="status">		
	<tr class="listTr">
		<td class="listTdNo">
		<a href = "#" onclick = "getCenterCode('${b.cId}', '${ b.cName }');">${ b.cId }...</a></td>
		<td class="listTdTitle">${b.cLocal}</td>
		<td class="listTdWriter">${ b.cName }</td>
		<td class="listTdRegDate">${ b.cAddr }</td>
		<td class="listTdReadCount">${ b.cPhone }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" class="listPage">
		
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
		<td colspan="5" class="listTdSpan">
			"${ keyword }"가 포함된 게시 글이 존재하지 않습니다.</td>
	</tr>
</c:if>
<%-- 일반 게시 글 리스트 요청이면서 게시 글 리스트가 존재하지 않을 경우 --%>
<c:if test="${ not searchOption and empty centerList }">
	<tr>
		<td colspan="5" class="listTdSpan"> 등록된 센터가 존재하지 않습니다.</td>
	</tr>
</c:if>
</table>
</article>



