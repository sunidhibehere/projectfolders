package com.example.event.service;

import com.example.event.model.Event;
import com.example.event.model.Attendee;
import com.example.event.model.Registration;
import com.example.event.repository.EventRepository;
import com.example.event.repository.AttendeeRepository;
import com.example.event.repository.RegistrationRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistrationService {
	private final EventRepository eventRepo;
	private final AttendeeRepository attendeeRepo;
	private final RegistrationRepository regRepo;
	
	public RegistrationService(RegistrationRepository regRepo, EventRepository eventRepo,AttendeeRepository attendeeRepo) {
		this.regRepo=regRepo;
		this.eventRepo=eventRepo;
		this.attendeeRepo=attendeeRepo;
	}
	
	//Create
	@Transactional
	public Registration createRegistration(Long eventId) {
		Event event = eventRepo.findById(eventId).orElseThrow(()->new RuntimeException("Event not found"));
		Registration reg = new Registration(event);
		return regRepo.save(reg);
	}
	
	//Read
	@Transactional
	public Registration getRegistration(Long id) {
		return regRepo.findById(id).orElseThrow(()->new RuntimeException("Registration not found"));
	}
	
	//Update
	@Transactional
	public Registration addAttendeeToRegistration(Long regId,Long attendeeId) {
		Registration reg = getRegistration(regId);
		Attendee attendee = attendeeRepo.findById(attendeeId).orElseThrow(()->new RuntimeException("Attendee not found"));
		reg.getAttendees().add(attendee);
		return regRepo.save(reg);
	}
	
	//Delete
	@Transactional
	public void deleteRegistration(Long id) {
		regRepo.deleteById(id);
	}
	
	//ListAll
	@Transactional(readOnly=true)
	public List<Registration> getAllRegistrations(){
		return regRepo.findAll();
	}	
}
