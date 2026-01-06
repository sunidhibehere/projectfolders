package com.example.event.model;

import java.util.Set;
import java.util.*;
import jakarta.persistence.*;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long registrationId;

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event=event;
	}
	
	public Set<Attendee> getAttendees(){
		return attendees;
	}
	
	public void setAttendees(Set<Attendee> attendees) {
		this.attendees=attendees;
	}
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="registration_attendees", joinColumns = @JoinColumn(name="registration_id"),inverseJoinColumns=@JoinColumn(name="attendee_id"))
	private Set<Attendee> attendees= new HashSet<>();
	
	public Registration() {	
		
	}
	public Registration(Event event) {	
		this.event=event;
	}
	
	@Override
	public boolean equals (Object o) {
		if(this==o) {
			return true;
		}
		if(!(o instanceof Registration))
			return false;
		Registration other = (Registration) o;
		return registrationId !=null && registrationId .equals(other.registrationId );
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
}
