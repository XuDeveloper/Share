package com.example.share.model;

import java.io.Serializable;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Comment implements Serializable {

	/**
	 * 发布评论的作者名字
	 */
	private String mUserName;

	/**
	 * 发布评论的作者头像
	 */
	private String mUserLogoUrl;

	/**
	 * 评论内容
	 */
	private String mComment;

	/**
	 * 评论时间
	 */
	private String mDate;
	
	/**
	 * 回复
	 */
	private Response mResponse;

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

	public String getmComment() {
		return mComment;
	}

	public void setmComment(String mComment) {
		this.mComment = mComment;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public Response getmResponse() {
		return mResponse;
	}

	public void setmResponse(Response mResponse) {
		this.mResponse = mResponse;
	}



	
	

}
