<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!-- 마이페이지 - 헌혈증 정보 입력 -->
<div id="mainWrap">
  <div class="cAddWrap">
    <div class="cAddInfo">
      <span>소중한 생명을 살리는 헌혈에 동참해주셔서 감사합니다!<br/><br/>
        헌혈 후 수령하신 헌혈증의 정보를 바탕으로, 아래 정보 입력란에 알맞게 정보를 입력해주세요.</span>
    </div>
    <form id="cAddForm" name="cAddForm" action="/mbti/normal/certificateProcess" method="POST">
      <input name="bId" class="cAddInput bId" type="text" placeholder="헌혈증 번호"/>
      <input name="strbDate" class="cAddInput bDate" type="text" placeholder="헌혈일자(예: 20201020)"/>
      <input name="cName" id = "codeNameInput" class="cAddInput cName" type="text" placeholder="혈액원명" readonly/>
			<input class="centerFindBtn" type="button" value="혈액원찾기" onclick="centerCode()"/>
      <input name="bIndex" class="cAddInput bIndex" type="text" placeholder="헌혈 구분(예: 전혈)"/>
      <input name="bVolume" class="cAddInput bVolume" type="text" placeholder="헌혈 용량"/><input type="submit" class="cAddSubmit" value="등록하기"/>
      <input name="cId" id = "codeInput" class="cAddInput cId" type="hidden"/>
      <input name="mId" type="hidden" value="${ member.mId }"/>
      <input name="rhType" type="hidden" value="${ member.mRhType }"/>
      <input name="bType" type="hidden" value="${ member.mBType }"/>
    </form>
  </div>
</div>
