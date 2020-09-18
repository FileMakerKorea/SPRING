package com.project.mbti.service;

import java.util.Map;

import com.project.mbti.vo.Center;

public interface CenterService {
	
	/* BoardDao를 이용해 게시판 테이블에서 한 페이지에 해당하는 게시 글
	 * 리스트와 페이징 처리에 필요한 데이터를 Map 객체로 반환 하는 메소드
	 **/
	public abstract Map<String, Object> centerList(int pageNum, String type, String keyword);

	public Center getCenter(String centerCode);
	
	public String getCenterName(String centerCode);
	
	public int centerCodeCheck(String centerName, String centerCode);
	
	public int centerCodeCheck(String orgCode);	
}
