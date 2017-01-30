package com.niit.restexample_backend.dao;

import java.util.List;

import com.niit.restexample_backend.model.User;

public interface UserDAO {

	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUserByUsername(String username);
	public List<User> listUsers();
	
	
	
}
