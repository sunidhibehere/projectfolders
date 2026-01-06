package com.example.librarydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarydemo.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	boolean existsByName(String name);
}
