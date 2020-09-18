package com.project.mbti.dao;

import java.util.List;

import com.project.mbti.vo.Center;

public interface CenterDao {

	public abstract List<Center> centerList(int startRow, int num, String type, String keyword);

	public abstract int getCenterCount(String type, String keyword);
}
