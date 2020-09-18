package com.project.mbti.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mbti.vo.Hospital;

@Repository
public class HospitalDaoImpl implements HospitalDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE = "com.project.mbti.mappers.HospitalMapper";
	
	@Override
	public Hospital getHospital(String hospName) {
		return sqlSession.selectOne(NAME_SPACE + ".getHospital", hospName);
	}
	
	@Override
	public String getHospitalCode(String hospName) {
		return sqlSession.selectOne(NAME_SPACE + ".getHospitalCode", hospName);
	}
	
	@Override
	public String getHospitalName(String hospCode) {
		return sqlSession.selectOne(NAME_SPACE + ".getHospitalName", hospCode);
	}
	
	@Override
	public List<Map<String, Object>> getAllHospitalNameCode() {
		return sqlSession.selectList(NAME_SPACE + ".getAllHospitalNameCode");
	}

	@Override
	public List<Hospital> hospitalList(
			int startRow, int num, String type, String keyword) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("startRow", startRow);
		params.put("num", num);
		params.put("type", type);
		params.put("keyword", keyword);
		
		return sqlSession.selectList(NAME_SPACE + ".hospital"
				+ "List", params);
	}
	
	@Override
	public int getHospitalCount(String type, String keyword) {

		Map<String, String> params = new HashMap<String, String>();	
		
		params.put("type", type);
		params.put("keyword", keyword);
		
		return sqlSession.selectOne(NAME_SPACE + ".getHospitalCount", params);
	}

	@Override
	public String hospitalCodeCheck( String orgCode)  {
		return sqlSession.selectOne(NAME_SPACE + ".hospitalCodeCheck", orgCode);
	}
	
}
