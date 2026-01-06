package com.example.librarydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique=true)
	private String name;
	
	@ManyToMany(mappedBy="authors")
	@JsonIgnore
	private Set<Book> books = new HashSet<>();
	
	public Author() {}
	public Author(String name) {
		this.name=name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}
		if(!(o instanceof Author))return false;
		Author author = (Author) o;
		return Objects.equals(id, author.id);
	}
	
}
