package com.project.mbti.service;

import com.project.mbti.vo.Member;

public interface MemberService {
	
	public int login(String id, String password);
	
	public Member getMember(String id);
	
	public boolean overlapIdCheck(String id);
	
	public void addMember(Member member);
	
	public boolean memberPassCheck(String id, String password);
	
	public void updateMember(Member member);
	
}
