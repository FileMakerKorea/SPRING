package com.project.mbti.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.project.mbti.vo.Blood;
import com.project.mbti.vo.BloodDetail;
import com.project.mbti.vo.HospitalCount;

public interface BloodDao {
	// blood 테이블에 접근하는 DAO
	
	public Blood getBlood(String bId);
	
	public void addBlood(Blood blood);
	
	public void updateBlood(Blood blood);
	
	public List<Blood> getMembersBloodList(String mId, int startRow, int count);

	public List<Blood> getMembersBloodList(String mId);
	
	public int getMembersBloodCount(String mId);
	
	public BloodDetail getStepwiseBloodDetail(Blood blood);
	
	public List<Map<String, Object>> getMembersBloodStatus(String mId, String target);
	
	public List<Map<String, Object>> getCentersBloodCountByHosp(String cId);
	
	public List<Map<String, Object>> getCentersBloodByHosp(String cId, String hId);
	
	public List<String> getCentersUnUsedBloodId(String cId);
	
	public void deliverToHosp(String bId, String hId, Date bRegDate);

	public List<HospitalCount> getCenterBloodList(String h_Id, int startRow, int num);
	
	public int getCenterListCount(String h_Id);
	
	public int getBloodCount(String h_id, String c_id,  String m_gender, String rh_Type, String b_Type, String b_used );
	
	public int getBloodTotalCount(String h_id, String c_id);
	
	public int getBloodTotalCount_No(String h_id, String c_id);	
}
