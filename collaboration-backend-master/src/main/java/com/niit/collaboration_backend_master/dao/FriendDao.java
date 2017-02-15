package com.niit.collaboration_backend_master.dao;

import java.util.List;

import com.niit.collaboration_backend_master.model.Friend;

public interface FriendDao {
	
	void add(Friend friend);
	
	void update(Friend friend);
	
	Friend getFriend(long userId, long friendId);
	
	List<Friend> listMyFriends(long userId);
	
	List<Friend> listNewFriendRequests(long userId);
	
	void setOnline(long userId);
	
	void setOffline(long userId);
	
}