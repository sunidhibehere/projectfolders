package com.example.event.model;


import java.util.Set;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class Event {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long eventId;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	public Set<Registration> getRegistrations(){
		return registrations;
	}
	
	public void setRegistrations(Set<Registration> registrations) {
		this.registrations=registrations;
	}
	
	private String title;
	private String location;
	private LocalDate date;
	
	@OneToMany(mappedBy = "event",cascade =CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Registration> registrations = new HashSet<>();
	public Event() {
	
	}
	
	public Event(String title, String location,LocalDate date) {
		this.setTitle(title);
		this.setLocation(location);
		this.setDate(date);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public boolean equals (Object o) {
		if(this==o) {
			return true;
		}
		if(!(o instanceof Event))
			return false;
		Event other = (Event) o;
		return eventId !=null && eventId.equals(other.eventId);
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
}
