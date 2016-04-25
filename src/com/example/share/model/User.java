package com.example.share.model;

/**
 * 
 * @author Xu
 * 
 */

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

	/**
	 * 用户名
	 */
	private String mName;

	/**
	 * 用户账号
	 */
	private String mAccount;

	/**
	 * 用户密码
	 */
	private String mPassWord;

	/**
	 * 用户头像
	 */
	private String mLogoUrl;

	/**
	 * 用户性别
	 */
	private String mSex;

	/**
	 * 用户个人简介
	 */
	private String mDescription;

	/**
	 * 用户邮箱
	 */
	private String mMail;

	/**
	 * 用户发表过的文章
	 */
	private ArrayList<ShareArticle> mArticles;

	/**
	 * 用户发表过的评论
	 */
	private ArrayList<Comment> mComments;

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmAccount() {
		return mAccount;
	}

	public void setmAccount(String mAccount) {
		this.mAccount = mAccount;
	}

	public String getmPassWord() {
		return mPassWord;
	}

	public void setmPassWord(String mPassWord) {
		this.mPassWord = mPassWord;
	}

	public String getmLogoUrl() {
		return mLogoUrl;
	}

	public void setmLogoUrl(String mLogoUrl) {
		this.mLogoUrl = mLogoUrl;
	}

	public String getmSex() {
		return mSex;
	}

	public void setmSex(String mSex) {
		this.mSex = mSex;
	}

	public String getmDescription() {
		return mDescription;
	}

	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}

	public String getmMail() {
		return mMail;
	}

	public void setmMail(String mMail) {
		this.mMail = mMail;
	}

	public ArrayList<ShareArticle> getmArticles() {
		return mArticles;
	}

	public void setmArticles(ArrayList<ShareArticle> mArticles) {
		this.mArticles = mArticles;
	}

	public ArrayList<Comment> getmComments() {
		return mComments;
	}

	public void setmComments(ArrayList<Comment> mComments) {
		this.mComments = mComments;
	}

}
