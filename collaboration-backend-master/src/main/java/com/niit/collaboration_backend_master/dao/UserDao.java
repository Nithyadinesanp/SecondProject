package com.niit.collaboration_backend_master.dao;

import java.util.List;

import com.niit.collaboration_backend_master.model.User;

public interface UserDao {

	void create(User user);
	
	void udpate(User user);
	
	void remove(User user);
	
	User getUserById(long userId);
	
	User getUserByUsername(String username);
	
	List<User> list();
	
	List<User> listUsersExceptLoggedIn(long loggedInUserId);
	
	boolean isExistingUser(User u);
	
	boolean authenticate(String username, String password);
	
	void setOnline(long userId);
	
	void setOffline(long userId);
	
}