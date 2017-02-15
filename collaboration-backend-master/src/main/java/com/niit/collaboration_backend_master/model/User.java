package com.niit.collaboration_backend_master.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CP_USER", schema = "test")
public class User {

	/**
	 * Auto-generated user id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long userId;
	/**
	 * Field to store the <code>USERNAME</code> of a registered user.
	 */
	private String username;
	/**
	 * Field to store the <code>PASSWORD</code> of a registered user.
	 */
	private String password;
	/**
	 * Field to store <code>EMAIL</code> of a registered user.
	 */
	private String email;
	/**
	 * Field to store <code>ROLE</code> of a registered user.
	 * This field can contain either of the following two values:-
	 * <ul>
	 * 	<li><code>ADMIN</code> makes a user administrator.</li>
	 * 	<li><code>USER</code> makes a user standard user.</li>
	 * </ul>
	 */
	private String role;
	/**
	 * This field stores whether a registered user is <code>ACTIVE</code>
	 * or not. If the <code>ADMIN</code> approves a user, this field will
	 * contain <code>TRUE</code>, <code>FALSE</code> otherwise.
	 */
	private boolean active;
	/**
	 * This field stores whether a user is online or not. If the user is
	 * online then <code>ISONLINE</code> will contain <code>TRUE</code>,
	 * <code>FALSE</code> otherwise
	 */
	private boolean isOnline;

	/**
	 * This method returns the auto-generated user id.
	 * 
	 * @return id, the auto-generated user id.
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * This method stores id in the current object.
	 * 
	 * @param userId, the id to be stored.
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * This method returns the <code>USERNAME</code> of a user.
	 * @return username, The user's username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method sets the <code>USERNAME</code> of a user.
	 * 
	 * @param username, The username to be stored.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * This method returns the <code>PASSWORD</code> of a user.
	 * 
	 * @return password, the user's password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method sets the <code>PASSWORD</code> of the user.
	 * 
	 * @param password, the password to be stored.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method returns the <code>EMAIL</code> of a user.
	 * 
	 * @return String, the user's email id.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method sets the <code>EMAIL</code> of a user.
	 * 
	 * @param email, the user's email.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method returns the <code>ROLE</code> of a user.
	 * 
	 * @return String, the user's role.
	 */
	public String getRole() {
		return role;
	}

	/**
	 * This method sets the <code>ROLE</code> of a user.
	 * 
	 * @param role, the user's role.
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * This method returns the whether a user is active or not.
	 * 
	 * @return boolean, true if the user is active, false otherwise.
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * This method sets whether a user active or inactive.
	 * 
	 * @param active the boolean value.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * This method returns the whether a user is online or not.
	 * 
	 * @return boolean, true if the user is online, false otherwise.
	 */
	public boolean isOnline() {
		return isOnline;
	}

	/**
	 * This method sets whether a user is online or offline.
	 * 
	 * @param isOnline the boolean value.
	 */
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

}