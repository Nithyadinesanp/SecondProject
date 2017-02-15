package com.niit.collaboration_backend_master.model;

import java.util.Date;

public class PrivateMessage extends Message {

	private String friendName;
	private Date time;

	public PrivateMessage() {
		super();
	}

	public PrivateMessage(Message msg, String friendName, Date time) {
		super(msg.getId(), msg.getMessage(), msg.getUsername());
		this.friendName = friendName;
		this.time = time;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
