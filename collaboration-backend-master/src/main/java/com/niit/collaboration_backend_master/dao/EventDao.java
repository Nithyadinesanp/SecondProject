package com.niit.collaboration_backend_master.dao;

import java.util.List;

import com.niit.collaboration_backend_master.model.Event;

public interface EventDao {

	void create(Event event);
	
	void update(Event event);
	
	
	
	Event getEventById(long eventId);
	
	List<Event> listEvents();
	
}
