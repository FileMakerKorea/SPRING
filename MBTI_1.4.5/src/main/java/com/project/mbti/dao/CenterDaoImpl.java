package com.project.mbti.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mbti.vo.Board;
import com.project.mbti.vo.Center;
import com.project.mbti.vo.Member;

@Repository
public class CenterDaoImpl implements CenterDao {

	private final String NAME_SPACE = "com.project.mbti.mappers.CenterMapper";

	private SqlSessionTemplate sqlSession;

	@Autowired
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Center> centerList(int startRow, int num, String type, String keyword) {

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

}
