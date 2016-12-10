package com.example.share.model;

import java.io.Serializable;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Response implements Serializable {

	/**
	 * 回复的作者名字
	 */
	private String mUserName;

	/**
	 * 回复的作者头像
	 */
	private String mUserLogoUrl;

	/**
	 * 回复内容
	 */
	private String mResponse;

	/**
	 * 回复时间
	 */
	private String mDate;

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

	public String getmResponse() {
		return mResponse;
	}

	public void setmResponse(String mResponse) {
		this.mResponse = mResponse;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}



}
