package com.niit.collaboration_backend_master.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration_backend_master.model.Friend;

@Repository("friendDao")
@EnableTransactionManagement
@Transactional
public class FriendDaoImpl implements FriendDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	UserDao userDao;
	
	public void add(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		
		Friend friend2 = new Friend();
		friend2.setUser(friend.getFriend());
		friend2.setFriend(friend.getUser());
		friend2.setStatus("NEW");
		friend2.setOnline(false);
		
		session.saveOrUpdate(friend);
		session.saveOrUpdate(friend2);
	}

	public void update(Friend friend) {
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
	}

	public Friend getFriend(long userId, long friendId) {
		String hql = "from Friend where userId=" + userId + " and friendId=" + friendId;
		Friend friend = null;
		try {
			friend = (Friend) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace(System.err);
		}
		return friend;
	}

	@SuppressWarnings("unchecked")
	public List<Friend> listMyFriends(long userId) {
		String hql = "from Friend where friendId=" + userId + " and status='ACCEPTED'";
		List<Friend> friends = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return friends;
	}

	@SuppressWarnings("unchecked")
	public List<Friend> listNewFriendRequests(long userId) {
		String hql = "from Friend where friendId=" + userId + " and status='NEW'";
		List<Friend> friends = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return friends;
	}

	public void setOnline(long userId) {
		String hql = "update Friend set isOnline=true where friendId=" + userId;
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

	public void setOffline(long userId) {
		String hql = "update Friend set isOnline=false where friendId=" + userId;
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}

}
