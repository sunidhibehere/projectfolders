package com.example.event.service;

import com.example.event.model.Attendee;
import com.example.event.repository.AttendeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendeeService {
	private final AttendeeRepository repo;
	
	public AttendeeService(AttendeeRepository repo) {
		this.repo=repo;
	}
	
	public Attendee registerAttendee(Attendee attendee) {
		return repo.save(attendee);
	}
	
	public Attendee getAttendee(Long id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException("Attendee not found"));
	}
	
	public Attendee updateAttendee(Long id,Attendee updated) {
		Attendee existing = getAttendee(id);
		existing.setName(updated.getName());
		existing.setEmail(updated.getEmail());
		return repo.save(existing);
	}
	
	public void deleteAttendee(Long id) {
		repo.deleteById(id);
	}
	
	public List<Attendee> getAllAttendees(){
		return repo.findAll();
	}
	
}
