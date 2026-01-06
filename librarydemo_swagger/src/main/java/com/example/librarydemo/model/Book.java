package com.example.librarydemo.model;

import java.util.*;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@ManyToMany
	@JoinTable(
			name ="book_authors",
			joinColumns = @JoinColumn(name="book_id"),
			inverseJoinColumns =@JoinColumn(name="author_id")
	)
	private Set<Author> authors = new HashSet<>();
	
	public Book() {}
	public Book(String title) {this.title=title;}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	};
	
	@Override
	public boolean equals(Object o) {
		if(this==o)return true;
		if(!(o instanceof Book)) return false;
		Book book = (Book) o;
		return Objects.equals(id, book.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
