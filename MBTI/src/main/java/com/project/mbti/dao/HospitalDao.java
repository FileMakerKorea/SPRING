package com.project.mbti.dao;

import java.util.List;
import java.util.Map;

import com.project.mbti.vo.Hospital;

public interface HospitalDao {
	
	// hospital 테이블에 접근하는 DAO
	public Hospital getHospital(String hospName);
	
	public String getHospitalCode(String hospName);

	public String getHospitalName(String hospCode);
	
	public List<Map<String, Object>> getAllHospitalNameCode();
	
	public abstract List<Hospital> hospitalList(int startRow, int num, String type, String keyword);

	
	public abstract int getHospitalCount(String type, String keyword);

	public String hospitalCodeCheck(String orgCode);

}
