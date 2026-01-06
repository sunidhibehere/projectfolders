package com.example.librarydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarydemo.model.Book;

public interface BookRepository  extends JpaRepository<Book,Long>{
	boolean existsByTitle(String title);
}
