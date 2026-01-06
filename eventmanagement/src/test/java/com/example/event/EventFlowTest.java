package com.example.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.event.model.*;
import com.example.event.service.*;

@SpringBootTest
class EventFlowTest {
	@Autowired
	private EventService eventService;
	
	@Test
	void testEventCrudFlow() {
		
		//Create
		Event event = new Event("Tech Conference","Pune", LocalDate.of(2025, 1, 15));
		Event saved = eventService.createEvent(event);
		assertNotNull(saved.getEventId());		
		
		//Read
		Event found = eventService.getEvent(saved.getEventId());
		assertEquals("Tech Conference", found.getTitle());
		
		//Update
		found.setLocation("Mumbai");
		Event updated = eventService.updateEvent(found.getEventId(), found);
		assertEquals("Mumbai",updated.getLocation());
		
		//Delete
		eventService.deleteEvent(updated.getEventId());
		assertThrows(RuntimeException.class,()->eventService.getEvent(updated.getEventId()));
	}
	
}
