package com.example.share.model;

import java.io.Serializable;
import java.sql.Date;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

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
	private String mDate;
	private User mUser;
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

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public User getmUser() {
		return mUser;
	}

	public void setmUser(User mUser) {
		this.mUser = mUser;
	}


}
