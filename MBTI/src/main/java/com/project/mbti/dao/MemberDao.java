package com.project.mbti.dao;

import com.project.mbti.vo.Member;

public interface MemberDao {
	
	// member 테이블에 접근하는 DAO
	public Member getMember(String id);
	
	public void addMember(Member member);
	
	public int overlapIdCheck(String id);
	
	public String getMemberId(String id);
	
	public String getMemberPass(String id);
	
	public void updateMember(Member member);
	
	public void deleteMember(Member member);
}
