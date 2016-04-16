package com.example.share.model;

/**
 * 
 * @author Xu
 * 每一条分享的数据模型
 * 
 */

import java.io.Serializable;

public class User implements Serializable {

	private String mUserName;
	private int mUserLogo;
	private String mTag;
	private String mTitle;
	private String mContent;
	private String mTime;

	public String getmUserName() {
		return mUserName;
	}

	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public int getmUserLogo() {
		return mUserLogo;
	}

	public void setmUserLogo(int mUserLogo) {
		this.mUserLogo = mUserLogo;
	}

	public String getmTag() {
		return mTag;
	}

	public void setmTag(String mTag) {
		this.mTag = mTag;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public String getmTime() {
		return mTime;
	}

	public void setmTime(String mTime) {
		this.mTime = mTime;
	}

}
