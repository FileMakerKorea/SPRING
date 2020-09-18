package com.project.mbti.service;

import com.project.mbti.vo.Blood;

public interface BloodService {

    public Blood getBlood(String bId);

    public void addBlood(Blood blood);

    public void updateBlood(Blood blood);
}