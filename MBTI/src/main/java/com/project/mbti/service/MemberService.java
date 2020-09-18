package com.project.mbti.service;

import com.project.mbti.vo.Member;

public interface MemberService {
	
	public Member getMember(String id);
	
	public int overlapIdCheck(String id);
	
	public void addMember(Member member);
	
	public int memberPassCheck(String id, String password);
	
	public void updateMember(Member member);
	
	public void deleteMember(Member member);
}
