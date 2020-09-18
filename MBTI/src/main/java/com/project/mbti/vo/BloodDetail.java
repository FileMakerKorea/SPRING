package com.project.mbti.vo;

import java.sql.Date;

public class BloodDetail {
	private String bId;
	private String bIndex;
	private int bVolume;
	private String cName;
	private Date bDate;
	private Date bRegDate;
	private String hName;
	private Date buDate;
	private String buName;
	private String bUsed;
	
	public BloodDetail() {
	
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbIndex() {
		return bIndex;
	}

	public void setbIndex(String bIndex) {
		this.bIndex = bIndex;
	}

	public int getbVolume() {
		return bVolume;
	}

	public void setbVolume(int bVolume) {
		this.bVolume = bVolume;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}

	public Date getbRegDate() {
		return bRegDate;
	}

	public void setbRegDate(Date bRegDate) {
		this.bRegDate = bRegDate;
	}

	public String gethName() {
		return hName;
	}

	public void sethName(String hName) {
		this.hName = hName;
	}

	public Date getBuDate() {
		return buDate;
	}

	public void setBuDate(Date buDate) {
		this.buDate = buDate;
	}

	public String getBuName() {
		return buName;
	}

	public void setBuName(String buName) {
		this.buName = buName;
	}

	public String getbUsed() {
		return bUsed;
	}

	public void setbUsed(String bUsed) {
		this.bUsed = bUsed;
	}

	

	
}
