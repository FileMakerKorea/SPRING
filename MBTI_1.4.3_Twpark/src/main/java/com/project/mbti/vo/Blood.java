package com.project.mbti.vo;


import java.sql.Date;

public class Blood {
	private String bId, mId, cId, hId, buId, bType, rhType, bIndex, bUsed;
	private int bVolume;
	private Date bDate, bRegDate;
	
	public Blood() {
	}
	
	public String getbIndex() {
		return bIndex;
	}

	public void setbIndex(String bIndex) {
		this.bIndex = bIndex;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	public String getBuId() {
		return buId;
	}

	public void setBuId(String buId) {
		this.buId = buId;
	}

	public String getbType() {
		return bType;
	}

	public void setbType(String bType) {
		this.bType = bType;
	}

	public String getRhType() {
		return rhType;
	}

	public void setRhType(String rhType) {
		this.rhType = rhType;
	}

	public String getbUsed() {
		return bUsed;
	}

	public void setbUsed(String bUsed) {
		this.bUsed = bUsed;
	}

	public int getbVolume() {
		return bVolume;
	}

	public void setbVolume(int bVolume) {
		this.bVolume = bVolume;
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
	
}
