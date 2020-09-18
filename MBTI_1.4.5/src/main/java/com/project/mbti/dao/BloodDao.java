package com.project.mbti.dao;

import com.project.mbti.vo.Blood;

public interface BloodDao {
	// blood 테이블에 접근하는 DAO
	
	public Blood getBlood(String bId);
	
	public void addBlood(Blood blood);
	
	public void updateBlood(Blood blood);
}
