package com.project.mbti.vo;

import java.sql.Date;

public class Member {
	
	private String mId, mPassword, mName, mGender, mBType, mRhType, mEmail, mAddr, mCell, mNotes;
	private int mAge, mHeight, mWeight;
	private Date mRegDate;
	
	public Member() {
	
	}
	
	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmGender() {
		return mGender;
	}

	public void setmGender(String mGender) {
		this.mGender = mGender;
	}

	public String getmBType() {
		return mBType;
	}

	public void setmBType(String mBType) {
		this.mBType = mBType;
	}

	public String getmRhType() {
		return mRhType;
	}

	public void setmRhType(String mRhType) {
		this.mRhType = mRhType;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmAddr() {
		return mAddr;
	}

	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}

	public String getmCell() {
		return mCell;
	}

	public void setmCell(String mCell) {
		this.mCell = mCell;
	}

	public String getmNotes() {
		return mNotes;
	}

	public void setmNotes(String mNotes) {
		this.mNotes = mNotes;
	}

	public int getmAge() {
		return mAge;
	}

	public void setmAge(int mAge) {
		this.mAge = mAge;
	}

	public int getmHeight() {
		return mHeight;
	}

	public void setmHeight(int mHeight) {
		this.mHeight = mHeight;
	}

	public int getmWeight() {
		return mWeight;
	}

	public void setmWeight(int mWeight) {
		this.mWeight = mWeight;
	}

	public Date getmRegDate() {
		return mRegDate;
	}

	public void setmRegDate(Date mRegDate) {
		this.mRegDate = mRegDate;
	}

}
