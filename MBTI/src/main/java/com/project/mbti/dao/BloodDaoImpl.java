package com.project.mbti.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mbti.vo.Blood;
import com.project.mbti.vo.BloodDetail;
import com.project.mbti.vo.HospitalCount;

@Repository
public class BloodDaoImpl implements BloodDao {

	private final String NAME_SPACE = "com.project.mbti.mappers.BloodMapper";

	@Autowired
	private SqlSessionTemplate sqlSession;	
		
	@Override
	public Blood getBlood(String bId) {
		return sqlSession.selectOne(NAME_SPACE + ".getBlood", bId);
	}

	@Override
	public void addBlood(Blood blood) {
		sqlSession.insert(NAME_SPACE + ".addBlood", blood);
	}

	@Override
	public void updateBlood(Blood blood) {
		sqlSession.update(NAME_SPACE + ".updateBlood", blood);
	}

	@Override
	public List<Blood> getMembersBloodList(String mId, int startRow, int count) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mId", mId);
		paramMap.put("startRow", startRow);
		paramMap.put("endRow", count);
		return sqlSession.selectList(NAME_SPACE + ".membersBloodList", paramMap);
	}

	@Override
	public List<Blood> getMembersBloodList(String mId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mId", mId);
		return sqlSession.selectList(NAME_SPACE + ".membersBloodList", paramMap);
	}

	@Override
	public int getMembersBloodCount(String mId) {
		return sqlSession.selectOne(NAME_SPACE + ".membersBloodCount", mId);
	}

	@Override
	public BloodDetail getStepwiseBloodDetail(Blood blood) {
		return sqlSession.selectOne(NAME_SPACE + ".stepwiseBloodDetail", blood);
	}

	@Override
	public List<Map<String, Object>> getMembersBloodStatus(String mId, String target) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("mId", mId);
		paramMap.put("target", target);

		return sqlSession.selectList(NAME_SPACE + ".membersBloodStatus", paramMap);
	}

	@Override
	public List<Map<String, Object>> getCentersBloodCountByHosp(String cId) {
		return sqlSession.selectList(NAME_SPACE + ".centersBloodCountByHosp", cId);
	}

	@Override
	public List<Map<String, Object>> getCentersBloodByHosp(String cId, String hId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("cId", cId);
		paramMap.put("hId", hId);
		
		return sqlSession.selectList(NAME_SPACE + ".centersBloodByHosp", paramMap);
	}

	@Override
	public List<String> getCentersUnUsedBloodId(String cId) {
		return sqlSession.selectList(NAME_SPACE + ".centersUnUsedBloodId", cId);
	}

	@Override
	public void deliverToHosp(String bId, String hId, Date bRegDate) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bId", bId);
		paramMap.put("hId", hId);
		paramMap.put("bRegDate", bRegDate);
		
		sqlSession.update(NAME_SPACE + ".deliverToHosp", paramMap);
	}

	// Part Tae Won
	@Override
	public List<HospitalCount> getCenterBloodList(String h_Id, int startRow, int num) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("h_Id", h_Id);
		params.put("startRow", startRow);
		params.put("num", num);
		
		return sqlSession.selectList(NAME_SPACE + ".getCenterBloodList", params);
	}

	@Override
	public int getCenterListCount(String h_Id) {
		return sqlSession.selectOne(NAME_SPACE + ".getCenterListCount", h_Id);
	}

	@Override
	public int getBloodCount(String h_id, String c_id, String m_gender, String rh_Type, String b_Type, String b_used) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("h_id", h_id);
		paramMap.put("c_id", c_id);
		paramMap.put("m_gender", m_gender);
		paramMap.put("rh_Type", rh_Type);
		paramMap.put("b_Type", b_Type);
		paramMap.put("b_used", b_used);
		return (int) sqlSession.selectOne(NAME_SPACE + ".getBloodCount", paramMap);
	}

	@Override
	public int getBloodTotalCount(String h_id, String c_id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("h_id", h_id);
		paramMap.put("c_id", c_id);	
		return (int) sqlSession.selectOne(NAME_SPACE + ".getBloodTotalCount", paramMap);
	}

	@Override
	public int getBloodTotalCount_No(String h_id, String c_id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("h_id", h_id);
		paramMap.put("c_id", c_id);
		return (int) sqlSession.selectOne(NAME_SPACE + ".getBloodTotalCount_No", paramMap);
	}

	
}
