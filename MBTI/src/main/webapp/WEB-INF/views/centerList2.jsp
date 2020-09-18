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
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    background: #ce4869 ;
}
 td {
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #eee;
}
</style>
<script type="text/javascript">
function getCenterCode(centerId, centerName){
     opener.document.getElementById("codeInput").value = centerId ;
     opener.document.getElementById("codeNameInput").value = centerName;

     self.close();
}


</script>
  <table class="centerListTable" width = "618px">

	<tr>
		<td colspan="3">
			<form name="centerSearchForm" id="centerSearchForm">
				<select name="type" id="type" >
					<option value="cLocal">지역</option>
					<option value="cName">센터명</option>
					<option value="cAddr">주소</option>
				</select>
				<input type="text" name="keyword" id="keyword" />
				<input type="submit" value="검색" />
			</form>
		</td>
	</tr>
	<%-- 검색 요청일 경우만 아래를 화면에 표시 한다. --%>
	<c:if test="${ searchOption }">
	<tr>
		<td colspan="3" id="searchComment">
			"${ word  }" 검색 결과</td>
	</tr>
	</c:if>
	
	<tr>
		<th class="centerListLocal">지역</th>
		<th class="centerListName">센터명</th>
		<th class="centerListAddr">주소</th>
	</tr>

<c:if test="${ searchOption and not empty centerList }">
	<c:forEach var="b" items="${ centerList }" varStatus="status">		
	<tr class="centerListTr">
		<td class="centerListTdLocal"><a href = "#" onclick = "getCenterCode('${ b.cId }', '${ b.cName }');">${b.cLocal}</a></td>
		<td class="centerListTdName">${ b.cName }</td>
		<td class="centerListTdAddr">${ b.cAddr }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="3" class="centerListPage">
		 	<c:if test="${ startPage > pageGroup }">
				<a href="centerList2?pageNum=${ startPage - pageGroup }
					&type=${ type }&keyword=${ keyword }">[이전]</a>
			</c:if>	
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
				<c:if test="${ i == currentPage }">
					[ ${ i } ]
				</c:if>			
				<c:if test="${ i != currentPage }">
					<a href="centerList2?pageNum=${ i }&type=${ type }
						&keyword=${ keyword }">[ ${ i } ]</a>
				</c:if>			
			</c:forEach>
			<c:if test="${ endPage < pageCount }">
				<a href="centerList2?pageNum=${ startPage + pageGroup }
					&type=${ type }&keyword=${ keyword }">[다음]</a>
			</c:if>		
		</td>
	</tr>
</c:if>	
	
<c:if test="${ not searchOption and not empty centerList }">
	<c:forEach var="b" items="${ centerList }" varStatus="status">		
	<tr class="centerListTr">
		<td class="centerListTdLocal">${ b.cLocal }</a></td>
		<td class="centerListTdName"><a href = "#" onclick = "getCenterCode('${ b.cId }', '${ b.cName }');">${b.cName}</a></td>
		<td class="centerListTdAddr">${ b.cAddr }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="3" class="centerListPage">
		 	<c:if test="${ startPage > pageGroup }"> 
				<a href="centerList2?pageNum=${ startPage - pageGroup }">
					[이전]</a>
			</c:if>	

			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
				<c:if test="${ i == currentPage }">
					[ ${ i } ]
				</c:if>			
				<c:if test="${ i != currentPage }">
					<a href="centerList2?pageNum=${ i }">[ ${ i } ]</a>
				</c:if>			
			</c:forEach>

			<c:if test="${ endPage < pageCount }">
				<a href="centerList2?pageNum=${ startPage + pageGroup }">
					[다음]</a>
			</c:if>		
		</td>
	</tr>
</c:if>
<c:if test="${ searchOption and empty centerList }">
	<tr>
		<td colspan="3" class="centerListTdSpan">
			"${ word }"? 등록된 센터가 존재하지 않습니다</td>
	</tr>
</c:if>
  </table>



