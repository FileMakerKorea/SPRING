package com.project.mbti.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.project.mbti.vo.Blood;
import com.project.mbti.vo.BloodDetail;

public interface BloodService {

    public Blood getBlood(String bId);

    public void addBlood(Blood blood);

    public void updateBlood(Blood blood);
    
    public Map<String, Object> getMembersBloodList(String mId, int page);
    
    public List<Blood> getMembersBloodList(String mId);
    
    public BloodDetail getBloodDetail(Blood blood);
    
    public List<Map<String, Object>> getMembersBloodStatus(String mId, String target);

	public List<Map<String, Object>> getCentersBloodCountByHosp(String cId);
    
	public List<Map<String, Object>> getCentersBloodByHosp(String cId, String hId);
    
    public List<String> getCentersUnUsedBloodId(String cId);
    
    public void deliverToHosp(String bId, String hId, Date bRegDate);

    public Map<String, Object> hospitalCount(String h_Id, int page);
     
}