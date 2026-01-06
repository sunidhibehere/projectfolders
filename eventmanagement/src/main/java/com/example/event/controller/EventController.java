package com.example.event.controller;

import com.example.event.model.Event;
import com.example.event.service.EventService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {
	private final EventService service;
	
	public EventController(EventService service) {
		this.service =service;
	}
	
	@PostMapping
	public Event createEvent(@RequestBody Event event) {
		return service.createEvent(event);
	}
	
	@GetMapping("/{id}")
	public Event getEvent(@PathVariable Long id) {
		return service.getEvent(id);
	}
	
	@PutMapping("/{id}")
	public Event updateEvent(@PathVariable Long id,@RequestBody Event event) {
		return service.updateEvent(id,event);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable Long id) {
		service.deleteEvent(id);
	}
	
	@GetMapping
	public List<Event> getAllEvents(){
		return service.getAllEvents();
	}
}
