package com.example.librarydemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.example.librarydemo.model.Author;
import com.example.librarydemo.model.Book;
import com.example.librarydemo.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	 private final LibraryService service;
	 
	 public LibraryController(LibraryService service) {
		 this.service=service;
	 }
	 
	 @PostMapping("/cauthors")
	 public Author createAuthor(@RequestParam String name) {
		 return service.createAuthor(name);
	 }
	 
	 @PostMapping("/cbooks")
	 public Book createBook(@RequestParam String title) {
		 return service.createBook(title);
	 }
	 
	 @PostMapping("/books/{bookId}/authors/{authorId}")
	 public Book linkAuthor(@PathVariable Long bookId, @PathVariable Long authorId) {
		 return service.linkAuthorToBook(bookId, authorId);
	 }
	 
	 @GetMapping("/books")
	 public List<Book> getBooks(){
		 return service.getBooks();
	 }
	 
	 @GetMapping("/authors")
	 public List<Author> getAuthors(){
		 return service.getAuthors();
	 }
	 
}
