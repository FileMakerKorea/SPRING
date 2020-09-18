package com.project.mbti.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mbti.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String NAME_SPACE = "com.project.mbti.mappers.MemberMapper";	

	@Override
	public Member getMember(String id) {
		return sqlSession.selectOne(NAME_SPACE + ".getMember", id);
	}

	@Override
	public void addMember(Member member) {
		sqlSession.insert(NAME_SPACE + ".addMember", member);
	}

	@Override
	public String getMemberPass(String id) {
		return sqlSession.selectOne(NAME_SPACE + ".getMemberPass", id);
	}
		
	@Override
	public String getMemberId(String id) {		
		return sqlSession.selectOne(NAME_SPACE + ".getMemberId", id);
	}

	@Override
	public void updateMember(Member member) {
		sqlSession.update(NAME_SPACE + ".updateMember", member);
	}

}
