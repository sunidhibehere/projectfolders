package com.example.event.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Attendee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long attendeeId;

	public Long getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(Long attendeeId) {
		this.attendeeId = attendeeId;
	}

	public Set<Registration> getRegistrations(){
		return registrations;
	}
	
	public void setRegistrations(Set<Registration> registrations) {
		this.registrations=registrations;
	}
	
	private String name;
	private String email;


	@ManyToMany(mappedBy="attendees")
	@JsonIgnore
	private Set<Registration> registrations = new HashSet<>();
	public Attendee() {
	
	}
	
	public Attendee(String name,String email) {
		this.setName(name);
		this.setEmail(email);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals (Object o) {
		if(this==o) {
			return true;
		}
		if(!(o instanceof Attendee))
			return false;
		Attendee other = (Attendee) o;
		return attendeeId !=null && attendeeId.equals(other.attendeeId);
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
	
}
