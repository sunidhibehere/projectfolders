package com.example.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.event.model.*;
import com.example.event.service.*;

@SpringBootTest
public class AttendeeFlowTest {
	@Autowired private AttendeeService attendeeService;
	
	@Test
	void testAttendeeCrudFlow() {
		//Create
		Attendee attendee = new Attendee("Alice","alice@example.com");
		Attendee saved = attendeeService.registerAttendee(attendee);
		assertNotNull(saved.getAttendeeId());		
		
		//Read
		Attendee found = attendeeService.getAttendee(saved.getAttendeeId());
		assertEquals("Alice", found.getName());
		
		//Update
		found.setEmail("alice.new@example.com");
		Attendee updated = attendeeService.updateAttendee(found.getAttendeeId(), found);
		assertEquals("alice.new@example.com",updated.getEmail());
		
		//Delete
		attendeeService.deleteAttendee(updated.getAttendeeId());
		assertThrows(RuntimeException.class,()->attendeeService.getAttendee(updated.getAttendeeId()));
	}
}
