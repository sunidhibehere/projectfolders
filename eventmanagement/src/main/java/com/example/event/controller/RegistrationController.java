package com.example.event.controller;

import com.example.event.model.*;
import com.example.event.service.*;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/registrations")
public class RegistrationController {
	private final RegistrationService service;
	
	public RegistrationController(RegistrationService service) {
		this.service =service;
	}
	
	@PostMapping("/{eventId}")
	public Registration createRegistration(@PathVariable Long eventId) {
		return service.createRegistration(eventId);
	}
	
	@GetMapping("/{id}")
	public Registration getRegistration(@PathVariable Long id) {
		return service.getRegistration(id);
	}
	
	@PutMapping("/{id}")
	public Registration addAttendeeToRegistration(@PathVariable Long id,@PathVariable Long attendeeId) {
		return service.addAttendeeToRegistration(id,attendeeId);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRegistration(@PathVariable Long id) {
		service.deleteRegistration(id);
	}
	
	@GetMapping
	public List<Registration> getAllRegistrations() {
		return service.getAllRegistrations();
	}
}
