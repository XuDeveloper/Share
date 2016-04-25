package com.example.share.model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

	/**
	 * 私信发送方
	 */
	private User from;

	/**
	 * 私信接收方
	 */
	private User to;

	/**
	 * 私信内容
	 */
	private String message;

	/**
	 * 私信发送时间
	 */
	private Date date;

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
