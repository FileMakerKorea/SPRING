package com.project.mbti.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mbti.vo.Center;

@Repository
public class CenterDaoImpl implements CenterDao {
	
	private final String NAME_SPACE = "com.project.mbti.mappers.CenterMapper";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<Center> centerList(
			int startRow, int num, String type, String keyword) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("startRow", startRow);
		params.put("num", num);
		params.put("type", type);
		params.put("keyword", keyword);
		
		return sqlSession.selectList(NAME_SPACE + ".centerList", params);
	}
	
	@Override
	public int getCenterCount(String type, String keyword) {

		Map<String, String> params = new HashMap<String, String>();	
		
		params.put("type", type);
		params.put("keyword", keyword);
		
		return sqlSession.selectOne(NAME_SPACE + ".getCenterCount", params);
	}
	
	@Override
	public Center getCenter(String centerCode) {
		return sqlSession.selectOne(NAME_SPACE + ".getCenter", centerCode); 
	}
	
	@Override
	public String getCenterCode(String centerName) {
		return sqlSession.selectOne(NAME_SPACE + ".getCenterCode", centerName);
	}

	@Override
	public String getCenterName(String centerCode) {
		return sqlSession.selectOne(NAME_SPACE + ".getCenterName", centerCode);
	}

	@Override
	public String centerCodeCheck(String orgCode) {
		return sqlSession.selectOne(NAME_SPACE + ".centerCodeCheck", orgCode);
	}
	
	
}
