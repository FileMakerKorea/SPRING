package com.project.mbti.vo;

import java.sql.Date;

public class BloodUsed {
	private String buId, buName, hId;
	private Date buDate;
	
	public BloodUsed() {
	
	}

	public String getBuId() {
		return buId;
	}

	public void setBuId(String buId) {
		this.buId = buId;
	}

	public String getBuName() {
		return buName;
	}

	public void setBuName(String buName) {
		this.buName = buName;
	}

	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	public Date getBuDate() {
		return buDate;
	}

	public void setBuDate(Date buDate) {
		this.buDate = buDate;
	}
	
}
