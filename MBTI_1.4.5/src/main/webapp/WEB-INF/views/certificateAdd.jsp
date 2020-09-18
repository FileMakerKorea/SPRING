<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- 마이페이지 - 헌혈증 정보 입력 -->
<div id="mainWrap">
  <div class="cAddWrap">
    <div class="cAddInfo">
      <span>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.<br/>
        Nisl tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa.</span>
    </div>
    <form id="cAddForm" name="cAddForm" action="/mbti/normal/certificateProcess" method="POST">
      <input name="bId" class="cAddInput bId" type="text" placeholder="헌혈증 번호"/>
      <!--  -->
      <select name="bType">
     	<option value="A">A</option>
     	<option value="AB">AB</option>
     	<option value="B">B</option>
     	<option value="O">O</option>
      </select>
      <select name="rhType">
     	<option value="RH+">RH+</option>
     	<option value="RH-">RH-</option>
      </select>
      <!--  -->
      <input name="strbDate" class="cAddInput bDate" type="text" placeholder="헌혈일자(예: 20201020)"/>
      <input name="cId" id = "codeInput" class="cAddInput cId" type="text" placeholder="혈액원코드"/>
            <input class="centerFindBtn" type="button" value="혈액원찾기" onclick="centerCode()"/>
      <input name="cName" id = "codeNameInput" class="cAddInput cName" type="text" placeholder="혈액원명" />

      <input name="bIndex" class="cAddInput bIndex" type="text" placeholder="헌혈 구분(예: 전혈)"/>
      <input name="bVolume" class="cAddInput bVolume" type="text" placeholder="헌혈 용량"/><input type="submit" class="cAddSubmit" value="등록하기"/>
    </form>
  </div>
</div>