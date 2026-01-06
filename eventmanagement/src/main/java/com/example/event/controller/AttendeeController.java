package com.example.event.controller;

import com.example.event.model.Attendee;
import com.example.event.service.AttendeeService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {
private final AttendeeService service;
	
	public AttendeeController(AttendeeService service) {
		this.service =service;
	}
	
	@PostMapping
	public Attendee registerAttendee(@RequestBody Attendee attendee) {
		return service.registerAttendee(attendee);
	}
	
	@GetMapping("/{id}")
	public Attendee getAttendee(@PathVariable Long id) {
		return service.getAttendee(id);
	}
	
	@PutMapping("/{id}")
	public Attendee updateAttendee(@PathVariable Long id,@RequestBody Attendee attendee) {
		return service.updateAttendee(id,attendee);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAttendee(@PathVariable Long id) {
		service.deleteAttendee(id);
	}
	
	@GetMapping
	public List<Attendee> getAllAttendees(){
		return service.getAllAttendees();
	}
}
