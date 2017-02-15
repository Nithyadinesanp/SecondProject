package com.niit.collaboration_backend_master.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration_backend_master.model.Event;

@Repository("eventDao")
@EnableTransactionManagement
@Transactional
public class EventDaoImpl implements EventDao {
	@Autowired
	SessionFactory sessionFactory;

	public void create(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}

	public void update(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);
	}

	public Event getEventById(long eventId) {
		String hql = "from Event where eventId=" + eventId;
		Event event = (Event) sessionFactory.getCurrentSession().createQuery(hql).getSingleResult();
		return event;
	}

	@SuppressWarnings("unchecked")
	public List<Event> listEvents() {
		String hql = "from Event";
		List<Event> events = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
		return events;
	}
	
}
