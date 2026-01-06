package com.example.event.service;

import com.example.event.model.Event;
import com.example.event.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {
	private final EventRepository repo;
	
	public EventService(EventRepository repo) {
		this.repo=repo;
	}
	
	public Event createEvent(Event event) {
		return repo.save(event);
	}
	
	public Event getEvent(Long id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException("Event not found"));
	}
	
	public Event updateEvent(Long id,Event updated) {
		Event existing = getEvent(id);
		existing.setTitle(updated.getTitle());
		existing.setLocation(updated.getLocation());
		existing.setDate(updated.getDate());
		return repo.save(existing);
	}
	
	public void deleteEvent(Long id) {
		repo.deleteById(id);
	}
	
	public List<Event> getAllEvents(){
		return repo.findAll();
	}
}
