package com.example.share.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ShareArticle implements Serializable {

	/**
	 * 文章标题
	 */
	private String mTitle;

	/**
	 * 文章标签
	 */
	private String mTag;

	/**
	 * 文章内容
	 */
	private String mContent;

	/**
	 * 发布文章时间
	 */
	private Date mDate;

	/**
	 * 发布文章的作者名字
	 */
	private String mUserName;

	/**
	 * 发布文章的作者头像
	 */
	private String mUserLogoUrl;

	/**
	 * 点赞数目
	 */
	private ArrayList<Like> mLikes;

	/**
	 * 评论
	 */
	private ArrayList<Comment> mComments;

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getmTag() {
		return mTag;
	}

	public void setmTag(String mTag) {
		this.mTag = mTag;
	}

	public String getContent() {
		return mContent;
	}

	public void setContent(String content) {
		this.mContent = content;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		this.mDate = date;
	}

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

	public ArrayList<Comment> getmComments() {
		return mComments;
	}

	public void setmComments(ArrayList<Comment> mComments) {
		this.mComments = mComments;
	}

	public ArrayList<Like> getmLikes() {
		return mLikes;
	}

	public void setmLikes(ArrayList<Like> mLikes) {
		this.mLikes = mLikes;
	}

}
