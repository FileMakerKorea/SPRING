<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id = "mainWrap">
 <div class = "hospWrap">
	<table class="hSummaryT">
		<tr>
			<td class="hSummaryTh NTT" rowspan="2">no</td>
			<td class="hSummaryTh NTT" rowspan="2">구분번호</td>
			<td class="hSummaryTh NTT" rowspan="2">센터명</td>
			<td class="hSummaryTh NTT" rowspan="2">수량</td>
			<td class="hSummaryTh NTT" rowspan="2">사용</td>
			<td class="hSummaryTh NTT" rowspan="2">미사용</td>
			<td class="hSummaryTh NTT" colspan="4">남 rh+</td>
			<td class="hSummaryTh NTT" colspan="4">남 rh-</td>
			<td class="hSummaryTh NTT" colspan="4">여 rh+</td>
			<td class="hSummaryTh NTT" colspan="4">여 rh-</td>
		</tr>
		<tr>
			<td class="hSummaryTh NTT">a</td>
			<td class="hSummaryTh NTT">b</td>
			<td class="hSummaryTh NTT">o</td>
			<td class="hSummaryTh NTT">ab</td>
			<td class="hSummaryTh NTT">a</td>
			<td class="hSummaryTh NTT">b</td>
			<td class="hSummaryTh NTT">o</td>
			<td class="hSummaryTh NTT">ab</td>
			<td class="hSummaryTh NTT">a</td>
			<td class="hSummaryTh NTT">b</td>
			<td class="hSummaryTh NTT">o</td>
			<td class="hSummaryTh NTT">ab</td>
			<td class="hSummaryTh NTT">a</td>
			<td class="hSummaryTh NTT">b</td>
			<td class="hSummaryTh NTT">o</td>
			<td class="hSummaryTh NTT">ab</td>
		</tr>

		<c:if test="${ not empty regCenterList }">
			<c:forEach var="h" items="${ regCenterList }" varStatus="status">

				<tr>
					<td class="hSummaryTd">></td>
					<td class="hSummaryTd">${ h.centerId }</td>
					<td class="hSummaryTd">${ h.centerName }</td>
					<td class="hSummaryTd">${ h.bloodTotal }</td>
					<td class="hSummaryTd">${ h.bloodUsed }</td>
					<td class="hSummaryTd">${ h.bloodNotUsed }</td>
					<td class="hSummaryTd">${ h.maleRhpA }</td>
					<td class="hSummaryTd">${ h.maleRhpB }</td>
					<td class="hSummaryTd">${ h.maleRhpO }</td>
					<td class="hSummaryTd">${ h.maleRhpAB }</td>
					<td class="hSummaryTd">${ h.maleRhmA }</td>
					<td class="hSummaryTd">${ h.maleRhmB }</td>
					<td class="hSummaryTd">${ h.maleRhmO }</td>
					<td class="hSummaryTd">${ h.maleRhmAB }</td>
					<td class="hSummaryTd">${ h.femaleRhpA }</td>
					<td class="hSummaryTd">${ h.femaleRhpB }</td>
					<td class="hSummaryTd">${ h.femaleRhpO }</td>
					<td class="hSummaryTd">${ h.femaleRhpAB }</td>
					<td class="hSummaryTd">${ h.femaleRhmA }</td>
					<td class="hSummaryTd">${ h.femaleRhmB }</td>
					<td class="hSummaryTd">${ h.femaleRhmO }</td>
					<td class="hSummaryTd">${ h.femaleRhmAB }</td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="22" class="hospitalListPage"><c:if
						test="${ startPage > pageGroup }">
						<a href="hospMain?pageNum=${ startPage - pageGroup }">[이전]</a>
					</c:if> <c:forEach var="i" begin="${ startPage }" end="${ endPage }">

						<c:if test="${ i == currentPage }">[ ${ i } ]</c:if>
						<c:if test="${ i != currentPage }">
							<a href="hospMain?pageNum=${ i }">[ ${ i } ]</a>
						</c:if>
					</c:forEach> <c:if test="${ endPage < pageCount }">
						<a href="hospMain?pageNum=${ startPage + pageGroup }"> [다음]</a>
					</c:if></td>
			</tr>
		</c:if>
		<c:if test="${ empty regCenterList }">
			<tr>
				<td colspan="22" class="hospitalListTdSpan">"${ word }" 등록된 자료가
					존재하지 않습니다</td>
			</tr>
		</c:if>
	</table>
 </div>
</div>

