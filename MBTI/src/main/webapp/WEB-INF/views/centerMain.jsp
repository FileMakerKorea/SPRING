<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<div id="mainWrap">
 <div class = "centerWrap">
	<div class="centerDeliveryBtn">혈액출고</div>
	<div class="centerMain">
		<div class="cSummary">
			<div class="cSummaryWrap">
				<table class="cSummaryT">
					<tbody>
						<tr>
							<td class="tdSpace"></td>
							<td class="cSummaryTh cS1">no</td>
							<td class="cSummaryTh cS2">코드</td>
							<td class="cSummaryTh cS3">병원</td>
							<td class="cSummaryTh cS4">수량</td>
							<td class="tdSpace"></td>
						</tr>
						<tr><td></td><td class="line" colspan="4"></td><td></td></tr>
						<!-- 본문 tr 최대 16개 -->
						<c:if test="${ not empty countByHosp }">
							<c:forEach var="item" varStatus="i" items="${ countByHosp }">
								<tr class="cSummaryTr">
									<td class="tdSpace"></td>
									<td class="cSummaryTd">${ i.index + 1}</td>
									<td class="cSummaryTd cSummaryId">${ item.hId }</td>
									<td class="cSummaryTd cSummaryhName">${ item.hName }</td>
									<td class="cSummaryTd">${ item.count }</td>
									<td class="tdSpace"></td>									
								</tr>
							</c:forEach>
						</c:if>									
					</tbody>				
				</table>
			</div>
			<div class="line"></div>
			<!-- <div class="cSummaryFoot"><span class="cSInt"></span><span class="cSSpan"></span></div> -->
			<div></div>
		</div>
		<div class="cDetail">
			<div class="cDetailWrap">
				<div class="cDetailHead">
					<span class="toHosp"></span>
				</div>
				<table class="cDetailT clear">
					<tbody>
						<tr>
							<td class="tdSpace"></td>
							<td class="cDetailTh cD1">no</td>
							<td class="cDetailTh cD2">헌혈증번호</td>
							<td class="cDetailTh cD3">날짜</td>
							<td class="cDetailTh cD4">이름</td>
							<td class="cDetailTh cD5">성별</td>
							<td class="cDetailTh cD6">나이</td>
							<td class="cDetailTh cD7">구분</td>
							<td class="cDetailTh cD8">혈액형</td>
							<td class="cDetailTh cD9">상태</td>
							<td class="tdSpace"></td>
						</tr>
						<tr><td></td><td class="line" colspan="9"></td><td></td></tr>
						<!-- 본문 tr 최대 16개 -->
					</tbody>
				</table>
			</div>
			<div class="line"></div>
			<div></div>
		</div>
	</div>
</div>
<div class="deliveryModalWrap">
	<div class="deliveryModal">
		<form id="cDeilveryForm" name="cDeilveryForm">
			<div class="cDeliveryLi">
				<input class="cDeliveryDate" name="cDeliveryDate" type="text" placeholder="출고일선택" readonly/>
				<select class="cDeliveryHosp" name="cDeliveryHosp"></select>
				<input class="deliverySumbit" type="button" value="출고"/>
			</div>
			<select class="js-example-basic-multiple cDeliveryBlood" name="cDeliveryBlood" multiple="multiple"></select>
			<input class="centerId" name="centerId" type="hidden" value="${ center.cId }">
			<div class="deliveryModalClose"></div>			
		</form>
	</div>
 </div>
</div>

<script src="/mbti/resources/js/jquery-ui.min.js"></script>
<script src="/mbti/resources/js/select2.js"></script>
<script src="/mbti/resources/js/datepicker-ko.js"></script>
<link rel="stylesheet" type="text/css" href="/mbti/resources/css/jquery-ui.min.css"/>
<link rel="stylesheet" type="text/css" href="/mbti/resources/css/select2.css"/>
<script>

	var cSummaryTrs = document.querySelectorAll(".cSummaryTr");
	cSummaryTrs.forEach(tr => {
	  tr.addEventListener("click", function () {
	    var url = "/mbti/org/bloodDetailByHosp";
	    var hId = this.querySelector(".cSummaryId").textContent;
	    var data = "hId=" + hId;
	
	    $.ajax({
	      url: url,
	      type: "post",
	      data: data,
	      dataType: "json",
	      success: result => {
					var toHosp = document.querySelector("span.toHosp");
					toHosp.textContent = result.hName;
		      
		      var tableBody = document.querySelector(".cDetailT tbody");

	        tableBody.querySelectorAll(".cDetailTr").forEach(tr => {
		        tr.remove();
		      });

	        result.list.forEach((l, i) => {
		        var bGroup = l.bType + l.rhType.substring(2, 3);
		        var isUsed = l.bUsed === "Y" ? "사용" : "미사용";
						$(
							 "<tr class='cDetailTr'>"+
							"  <td class='tdSpace'></td>"+
							"  <td class='cDetailTd'>"+(i+1)+"</td>"+
							"  <td class='cDetailTd'>"+l.bId+"</td>"+
							"  <td class='cDetailTd'>"+l.bRegDate+"</td>"+
							"  <td class='cDetailTd'>"+l.mName+"</td>"+
							"  <td class='cDetailTd'>"+l.mGender+"</td>"+
							"  <td class='cDetailTd'>"+l.mAge+"</td>"+
							"  <td class='cDetailTd'>"+l.bIndex+"</td>"+
							"  <td class='cDetailTd'>"+bGroup+"</td>"+
							"  <td class='cDetailTd'>"+isUsed+"</td>"+
							"  <td class='tdSpace'></td>"+
							"</tr>"
							).appendTo(tableBody);						
	        	
	        });
	      }
	    });
	  });
	});

	/* 센터 메인 모달창 */
		
		
	$(".cDeliveryDate").datepicker();
	var hospSelect = $(".cDeliveryHosp").select2();
	var bloodSelect = $(".cDeliveryBlood").select2();
				
	$(".centerDeliveryBtn").click(() => {
		document.querySelector(".cDeliveryHosp .select2-choice .select2-chosen").textContent = "병원선택";
		bloodSelect.select2({
			placeholder: "헌혈증추가"
		});

		$(".deliveryModalWrap").css("display", "flex");
		
		var url = "/mbti/hospital/allNameCode";
		// select option으로 병원 이름 넣기
		$.ajax({
			url: url,
			type: "post",
			dataType: "json",
			success: result => {
				var selectBox = $(".cDeliveryHosp");
				result.forEach(r => {
					$("<option style='display: none;' value='"+r.hId+"'>"+r.hName+"</option>").appendTo(selectBox);
				});
				
			}
			
		});

		// select option으로 헌혈증 아이디 넣기
		var url = "/mbti/center/unUsedBloodId";
		var cId = document.querySelector(".centerId").value
		var data = "cId=" + cId
		$.ajax({
			url: url,
			type: "post",
			data: data,
			dataType: "json",
			success: result => {
				var selectBox = $(".cDeliveryBlood");
				result.forEach(r => {
					$("<option style='display: none;' value='"+r+"'>"+r+"</option>").appendTo(selectBox);
				});
			}

		});
		
	});
	
	$(".deliveryModalClose").click(() => {
		$(".deliveryModalWrap").css("display", "none");
		document.querySelector(".cDeliveryHosp .select2-choice .select2-chosen").textContent = "";
	});

	$(".deliverySumbit").click(() => {

		var url = "/mbti/center/deliverToHosp";
		var form = document.querySelector("#cDeilveryForm");
		form.action = url;
		form.method = "post";
		form.submit();
		
		var cDeliveryDate = form.cDeliveryDate.value;
		var cDeliveryHosp = form.cDeliveryHosp.value;
		var cDeliveryBlood = form.cDeliveryBlood.value;

		var data = "cDeliveryDate=" + cDeliveryDate + "&cDeliveryHosp=" + cDeliveryHosp + "&cDeliveryBlood=" + cDeliveryBlood;
		$.ajax({
			url: url,
			type: "post",
			data: data,
			dataType: "json",
			success: result=> {
				alert(result.hName + "으로 " + result.deliverCount + "개의 혈액을 보냈습니다." + "일시: " + result.deliverDate);
			}
	
		});


	});


	
	
	
</script>
