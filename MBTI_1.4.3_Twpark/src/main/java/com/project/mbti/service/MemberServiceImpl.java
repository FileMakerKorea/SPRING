package com.project.mbti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mbti.dao.MemberDao;
import com.project.mbti.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int login(String id, String password) {
		String dbPass = memberDao.getMemberPass(id);				
		
		int result = -1;
		
		if(dbPass == null) {
			return result;
		}
		if(dbPass.equals(password)){
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}

	@Override
	public Member getMember(String id) {
		return memberDao.getMember(id);
	}
	
	@Override
	public boolean overlapIdCheck(String id) {
		String dbId = memberDao.getMemberId(id);
		
		if(dbId == null) {
			return false;
		}
		return true;
	}

	@Override
	public void addMember(Member member) {
		memberDao.addMember(member);
	}

	@Override
	public boolean memberPassCheck(String id, String password) {
		return false;
	}

	@Override
	public void updateMember(Member member) {
		memberDao.updateMember(member);

	}
}
