package com.niit.collaboration_backend_master.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration_backend_master.model.User;

@Repository("userDao")
@EnableTransactionManagement
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public void create(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	public void udpate(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void remove(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public User getUserById(long userId) {
		String hql = "from User where userId=" + userId;
		User user = null;
		try {
			user = (User) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (NoResultException e) {
			System.err.println("Inside UserDaoImpl::getUserById() --> " + e.getMessage());
		}
		return user;
	}

	public User getUserByUsername(String username) {
		String hql = "from User where username='" + username + "'";
		User user = null;
		try {
			user = (User) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (NoResultException e) {
			System.err.println("Inside UserDaoImpl::getUserByUsername() --> " + e.getMessage());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> list() {
		String hql = "from User";
		List<User> users = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return users;
	}

	public boolean isExistingUser(User u) {
		User user = getUserByUsername(u.getUsername());
		return (user != null);
	}
	
	public boolean authenticate(String username, String password) {
		User user = getUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsersExceptLoggedIn(long loggedInUserId) {
		String hql = "from User where userId<>" + loggedInUserId;
		List<User> users = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return users;
	}

	public void setOnline(long userId) {
		String hql = "update User set isOnline=true where userId=" + userId;
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public void setOffline(long userId) {
		String hql = "update User set isOnline=false where userId=" + userId;
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

}

