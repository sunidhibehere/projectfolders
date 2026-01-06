package com.example.librarydemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarydemo.model.Author;
import com.example.librarydemo.model.Book;
import com.example.librarydemo.repository.AuthorRepository;
import com.example.librarydemo.repository.BookRepository;


@Service
public class LibraryService {
	 private final AuthorRepository authorRepo;
	 private final BookRepository bookRepo;
	 
	 public LibraryService(AuthorRepository authorRepo, BookRepository bookRepo) {
		 this.authorRepo= authorRepo;
		 this.bookRepo = bookRepo;
	 }
	 
	 public Author createAuthor(String name) {
		 if(authorRepo.existsByName(name)) throw new RuntimeException("Author already exists");
		 return authorRepo.save(new Author(name));
	 }
	 
	 public Book createBook(String title) {
		 if(bookRepo.existsByTitle(title)) throw new RuntimeException("Book already exists");
		 return bookRepo.save(new Book(title));
	 }
	 
	 public Book linkAuthorToBook(Long bookId, Long authorId) {
		 Book book = bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("Book not found"));
		 Author author = authorRepo.findById(authorId).orElseThrow(()-> new RuntimeException("Author not found"));
		 book.getAuthors().add(author);
		 //author.getBooks().add(book);
		 return bookRepo.save(book);
	 }
	 
	 public List<Book> getBooks(){
		 return bookRepo.findAll();
	 }
	 
	 public List<Author> getAuthors(){
		 return authorRepo.findAll();
	 }
	 
}
