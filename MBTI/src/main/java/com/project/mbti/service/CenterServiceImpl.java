package com.project.mbti.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mbti.dao.CenterDao;
import com.project.mbti.vo.Center;


// 이 클래스가 서비스 계층(비즈니스 로직)의 컴포넌트(Bean) 임을 선언하고 있다.
@Service
public class CenterServiceImpl implements CenterService {
	
	private static final int PAGE_SIZE = 7;
	private static final int PAGE_GROUP = 10;

	@Autowired
	private CenterDao centerDao;

	@Override
	public Map<String, Object> centerList(
			int pageNum, String type, String keyword) {
		
		int currentPage = pageNum;	
		int startRow = (currentPage - 1) * PAGE_SIZE;		
		int listCount = 0;
		boolean searchOption = (type.equals("null") 
				|| keyword.equals("null")) ? false : true; 
		
		listCount = centerDao.getCenterCount(type, keyword);	

			List<Center> centerList = centerDao.centerList(
					startRow, PAGE_SIZE, type, keyword);

			int pageCount = 
					listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);

			int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1
					- (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);		

			int endPage = startPage + PAGE_GROUP - 1;
			
			if(endPage > pageCount) {
				endPage = pageCount;
			}
			
			Map<String, Object> modelMap = new HashMap<String, Object>();		
			
			modelMap.put("centerList", centerList);
			modelMap.put("pageCount", pageCount);
			modelMap.put("startPage", startPage);
			modelMap.put("endPage", endPage);
			modelMap.put("currentPage", currentPage);
			modelMap.put("listCount", listCount);
			modelMap.put("pageGroup", PAGE_GROUP);
			modelMap.put("searchOption", searchOption);
			
			if(searchOption) {

				try {
					modelMap.put("keyword", URLEncoder.encode(keyword, "utf-8"));
				} catch (UnsupportedEncodingException e) {					
					e.printStackTrace();
				}
				modelMap.put("word", keyword);
				modelMap.put("type", type);
			}
					
			return modelMap;	
	}
	
	@Override
	public Center getCenter(String centerCode) {
		return centerDao.getCenter(centerCode);
	}
	
	@Override
	public String getCenterName(String centerCode) {
		return centerDao.getCenterName(centerCode);
	}

	@Override
	public int centerCodeCheck(String centerName, String centerCode) {
		String dbCode = centerDao.getCenterCode(centerName);
		
		int result = -1;
		
		if(dbCode == null) {
			return result;
		} 
		
		if(dbCode.equals(centerCode)){
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	@Override
	public int centerCodeCheck(String orgCode) {
		String dbCode = centerDao.centerCodeCheck(orgCode);
		if(dbCode != null){
			return 1;
		} else {
			return 0;
		}
	}
	
}
