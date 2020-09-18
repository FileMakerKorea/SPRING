package com.project.mbti.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mbti.vo.Blood;

@Repository
public class BloodDaoImpl implements BloodDao {

	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE = "com.project.mbti.mappers.BloodMapper";
	
	@Autowired
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
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

}
