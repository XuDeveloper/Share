package com.example.share.model;

/**
 * 
 * @author Xu
 * 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

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
	private Bitmap mLogo;

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
	private List<ShareArticle> mArticles;

	/**
	 * 用户发表过的评论
	 */
	private List<Comment> mComments;
	
	private List<ShareArticle> mLikeArticles;

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

	public Bitmap getmLogo() {
		return mLogo;
	}

	public void setmLogo(Bitmap mLogo) {
		this.mLogo = mLogo;
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

	public List<ShareArticle> getmArticles() {
		return mArticles;
	}

	public void setmArticles(List<ShareArticle> mArticles) {
		this.mArticles = mArticles;
	}

	public List<Comment> getmComments() {
		return mComments;
	}

	public void setmComments(List<Comment> mComments) {
		this.mComments = mComments;
	}

	public List<ShareArticle> getmLikeArticles() {
		return mLikeArticles;
	}

	public void setmLikeArticles(List<ShareArticle> mLikeArticles) {
		this.mLikeArticles = mLikeArticles;
	}

}
