package com.project.mbti.dao;

import java.util.List;

import com.project.mbti.vo.Center;

public interface CenterDao {
	// center 테이블에 접근하는 DAO
	/* 한 페이지에 보여 질 게시 글 리스트와 검색 리스트 요청 시 호출되는 메소드
	 * 현재 페이지에 해당하는 게시 글 리스트를 DB에서 읽어와 반환 하는 메소드
	 **/
	public abstract List<Center> centerList(
			int startRow, int num, String type, String keyword);

	
	public abstract int getCenterCount(String type, String keyword);
	
	public Center getCenter(String centerCode);
	
	public String getCenterCode(String centerName);
	
	public String getCenterName(String centerCode);

	public String centerCodeCheck(String orgCode);	
}
