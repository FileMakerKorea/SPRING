package com.project.mbti.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mbti.dao.BloodDao;
import com.project.mbti.vo.Blood;
import com.project.mbti.vo.BloodDetail;
import com.project.mbti.vo.HospitalCount;

@Service
public class BloodServiceImpl implements BloodService {

	/* 겹치는 부분이 있어 주석처리 후 메소드 안에서 선언
	private static final int PAGE_SIZE = 10;
	private static final int PAGE_GROUP = 10;
	*/
	
	@Autowired
	private BloodDao bloodDao;

	@Override
	public Blood getBlood(String bId) {
		return bloodDao.getBlood(bId);
	}

	@Override
	public void addBlood(Blood blood) {
		bloodDao.addBlood(blood);

	}

	@Override
	public void updateBlood(Blood blood) {
		bloodDao.updateBlood(blood);
	}

	@Override
	public Map<String, Object> getMembersBloodList(String mId, int page) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		final int PAGE_SIZE = 10;
		final int PAGE_GROUP = 10;

		int currentPage = page;
		int startRow = PAGE_SIZE * (currentPage - 1);
		int count = PAGE_SIZE;
		int listCount = 0;

		List<Blood> bloodList;

		bloodList = bloodDao.getMembersBloodList(mId, startRow, count);
		listCount = bloodDao.getMembersBloodCount(mId);

		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1 - (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		int endPage = startPage + PAGE_GROUP - 1;
		if (endPage > pageCount) {
			endPage = pageCount;
		}

		modelMap.put("page", page);
		modelMap.put("currentPage", currentPage);
		modelMap.put("pageGroup", PAGE_GROUP);
		modelMap.put("pageCount", pageCount);
		modelMap.put("startPage", startPage);
		modelMap.put("endPage", endPage);
		modelMap.put("bloodList", bloodList);

		return modelMap;
	}

	@Override
	public List<Blood> getMembersBloodList(String mId) {
		return bloodDao.getMembersBloodList(mId);
	}

	@Override
	public BloodDetail getBloodDetail(Blood blood) {
		return bloodDao.getStepwiseBloodDetail(blood);
	}

	@Override
	public List<Map<String, Object>> getMembersBloodStatus(String mId, String target) {
		return bloodDao.getMembersBloodStatus(mId, target);
	}

	@Override
	public List<Map<String, Object>> getCentersBloodCountByHosp(String cId) {
		return bloodDao.getCentersBloodCountByHosp(cId);
	}

	@Override
	public List<Map<String, Object>> getCentersBloodByHosp(String cId, String hId) {
		return bloodDao.getCentersBloodByHosp(cId, hId);
	}

	@Override
	public List<String> getCentersUnUsedBloodId(String cId) {
		return bloodDao.getCentersUnUsedBloodId(cId);
	}

	@Override
	public void deliverToHosp(String bId, String hId, Date bRegDate) {
		bloodDao.deliverToHosp(bId, hId, bRegDate);		
	}

	@Override
	public Map<String, Object> hospitalCount(String h_Id, int page) {
		final int PAGE_SIZE = 10;
		final int PAGE_GROUP = 10;
		
		int currentPage = page;
		int startRow = PAGE_SIZE * (currentPage - 1);
		int listCount = 0;
		listCount = bloodDao.getCenterListCount(h_Id);

		List<HospitalCount> regCenterList = bloodDao.getCenterBloodList(h_Id, startRow, PAGE_SIZE);

		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1 - (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		int endPage = startPage + PAGE_GROUP - 1;

		if (endPage > pageCount) {
			endPage = pageCount;
		}

		int total;
		int used;
		
		for (int i = 0; i < regCenterList.size(); i++) {

			String centerId = regCenterList.get(i).getCenterId();
			total = bloodDao.getBloodTotalCount(h_Id, centerId);
			used = bloodDao.getBloodTotalCount_No(h_Id, centerId);
			regCenterList.get(i).setBloodTotal(total);
			regCenterList.get(i).setBloodNotUsed(used);
			regCenterList.get(i).setBloodUsed(total - used);
			regCenterList.get(i).setMaleRhpA(bloodDao.getBloodCount(h_Id, centerId, "남", "RH+", "A", "Y"));
			regCenterList.get(i).setMaleRhpB(bloodDao.getBloodCount(h_Id, centerId, "남", "RH+", "B", "Y"));
			regCenterList.get(i).setMaleRhpO(bloodDao.getBloodCount(h_Id, centerId, "남", "RH+", "O", "Y"));
			regCenterList.get(i).setMaleRhpAB(bloodDao.getBloodCount(h_Id, centerId, "남", "RH+", "AB", "Y"));
			regCenterList.get(i).setMaleRhmA(bloodDao.getBloodCount(h_Id, centerId, "남", "RH-", "A", "Y"));
			regCenterList.get(i).setMaleRhmB(bloodDao.getBloodCount(h_Id, centerId, "남", "RH-", "B", "Y"));
			regCenterList.get(i).setMaleRhmO(bloodDao.getBloodCount(h_Id, centerId, "남", "RH-", "O", "Y"));
			regCenterList.get(i).setMaleRhmAB(bloodDao.getBloodCount(h_Id, centerId, "남", "RH-", "AB", "Y"));
			regCenterList.get(i).setFemaleRhpA(bloodDao.getBloodCount(h_Id, centerId, "여", "RH+", "A", "Y"));
			regCenterList.get(i).setFemaleRhpB(bloodDao.getBloodCount(h_Id, centerId, "여", "RH+", "B", "Y"));
			regCenterList.get(i).setFemaleRhpO(bloodDao.getBloodCount(h_Id, centerId, "여", "RH+", "O", "Y"));
			regCenterList.get(i).setFemaleRhpAB(bloodDao.getBloodCount(h_Id, centerId, "여", "RH+", "AB", "Y"));
			regCenterList.get(i).setFemaleRhmA(bloodDao.getBloodCount(h_Id, centerId, "여", "RH-", "A", "Y"));
			regCenterList.get(i).setFemaleRhmB(bloodDao.getBloodCount(h_Id, centerId, "여", "RH-", "B", "Y"));
			regCenterList.get(i).setFemaleRhmO(bloodDao.getBloodCount(h_Id, centerId, "여", "RH-", "O", "Y"));
			regCenterList.get(i).setFemaleRhmAB(bloodDao.getBloodCount(h_Id, centerId, "여", "RH-", "AB", "Y"));
		}

		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("page", page);
		modelMap.put("currentPage", currentPage);
		modelMap.put("pageGroup", PAGE_GROUP);
		modelMap.put("pageCount", pageCount);
		modelMap.put("startPage", startPage);
		modelMap.put("endPage", endPage);
		modelMap.put("regCenterList", regCenterList);

		return modelMap;
	}
	
	
	
}