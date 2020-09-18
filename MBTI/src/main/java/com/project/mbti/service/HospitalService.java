package com.project.mbti.service;

import java.util.List;
import java.util.Map;

import com.project.mbti.vo.Hospital;

public interface HospitalService {
	
	public Hospital getHospital(String hospCode);
	
	public String getHospitalName(String hospCode);
	
	public List<Map<String, Object>> getHospitalNameAll();
	
	public int hospitalCodeCheck(String hospName, String hospCode);
	
	public abstract Map<String, Object> hospitalList(int pageNum, String type, String keyword);

	public int hospitalCodeCheck(String orgCode);
	
}
