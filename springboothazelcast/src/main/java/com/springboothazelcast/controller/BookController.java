package com.springboothazelcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboothazelcast.entity.Book;
import com.springboothazelcast.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping(value = "/savebook")
	public Book saveBook(@RequestBody Book book) {
		Book bookResponse = bookService.saveBook(book);
		return bookResponse;
	}
	
	@GetMapping(value = "/{bookId}")
	public Book getBookDetails(@PathVariable int bookId) {
		Book bookResponse = bookService.findById(bookId);
		return bookResponse;
	}
	
	@PutMapping(value = "/update")
	public Book update(@RequestBody Book book) {
		Book bookResponse = bookService.update(book);
		return bookResponse;
	}

	@DeleteMapping(value = "/{bookId}")
	public String delete(@PathVariable int bookId) {
		String response = bookService.delete(bookId);
		return response;
	}
}
