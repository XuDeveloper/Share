package com.example.share.model;

import java.io.Serializable;
import java.sql.Date;

public class Like implements Serializable {

	/**
	 * 点赞人的姓名
	 */
	private String mUserName;

	/**
	 * 点赞人的头像
	 */
	private String mUserLogoUrl;

	/**
	 * 点赞的时间
	 */
	private Date mDate;

	public String getmUserName() {
		return mUserName;
	}

	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public String getmUserLogoUrl() {
		return mUserLogoUrl;
	}

	public void setmUserLogoUrl(String mUserLogoUrl) {
		this.mUserLogoUrl = mUserLogoUrl;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

}
