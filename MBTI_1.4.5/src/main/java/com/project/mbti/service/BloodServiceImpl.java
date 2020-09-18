package com.project.mbti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mbti.dao.BloodDao;
import com.project.mbti.vo.Blood;

@Service
public class BloodServiceImpl implements BloodService {
   
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

}