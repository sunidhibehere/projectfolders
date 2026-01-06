package com.example.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.event.model.*;
import com.example.event.service.*;

@SpringBootTest
class RegistrationFlowTest {
	@Autowired private EventService eventService;
	@Autowired private AttendeeService attendeeService;
	@Autowired private RegistrationService registrationService;
	
	@Test
	void testRegistrationFlow() {
		//Create Event
		Event event = new Event("Java Boot Workshop","Mumbai",LocalDate.of(2025, 2, 20));
		Event savedEvent = eventService.createEvent(event);
		
		//Create Attendee
		Attendee attendee = new Attendee("Bob1","bob1@example.com");
		Attendee savedAttendee = attendeeService.registerAttendee(attendee);
		
		//Create registration for event
		Registration reg = registrationService.createRegistration(savedEvent.getEventId());
		assertNotNull(reg.getRegistrationId());
		
		//Add Attendee to registration
		Registration updated = registrationService.addAttendeeToRegistration(reg.getRegistrationId(),savedAttendee.getAttendeeId());
		assertTrue(updated.getAttendees().contains(savedAttendee));
		
		
		//Read Registration
		Registration found = registrationService.getRegistration(updated.getRegistrationId());
		assertEquals(savedEvent.getEventId(),found.getEvent().getEventId());
		assertEquals(1,found.getAttendees().size());
		
		
		//Delete Registration
		registrationService.deleteRegistration(found.getRegistrationId());
		assertThrows(RuntimeException.class,()->registrationService.getRegistration(found.getRegistrationId()));
	}
	
}
