package com.example.share.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserAndMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User getmUser() {
		return mUser;
	}
	public void setmUser(User mUser) {
		this.mUser = mUser;
	}
	public List<Message> getmMessageList() {
		return mMessageList;
	}
	public void setmMessageList(List<Message> mMessageList) {
		this.mMessageList = mMessageList;
	}
	private User mUser;
	private List<Message> mMessageList;
	public UserAndMessage(User mUser){
		this.mUser = mUser;
		mMessageList = new ArrayList<Message>();
	}
	public UserAndMessage(User mUser, List<Message> mMessageList){
		this.mUser = mUser;
		this.mMessageList = mMessageList;
	}
}
