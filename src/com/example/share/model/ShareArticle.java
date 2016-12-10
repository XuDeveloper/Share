package com.example.share.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class ShareArticle implements Serializable, Comparable<ShareArticle>{

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
	private String mDate;

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
	private List<Like> mLikes;

	/**
	 * 评论
	 */
	private List<Comment> mComments;
	
	private double mScore;
	public ShareArticle(){
		
	}
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

	public String getDate() {
		return mDate;
	}

	public void setDate(String date) {
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

	public List<Comment> getmComments() {
		return mComments;
	}

	public void setmComments(List<Comment> mComments) {
		this.mComments = mComments;
	}

	public List<Like> getmLikes() {
		return mLikes;
	}

	public void setmLikes(List<Like> mLikes) {
		this.mLikes = mLikes;
	}
	public void setScore(double mScore){
		this.mScore = mScore;
	}
	public double getScore(){
		return mScore;
	}
	@Override
	public int compareTo(ShareArticle another) {
		// TODO Auto-generated method stub
		if((mScore - another.mScore) == 0){
			return 0;
		}else if((mScore - another.mScore) < 0){
			return 1;
		}else{
			return -1;
		}
	}


}
