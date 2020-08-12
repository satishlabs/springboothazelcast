package com.springboothazelcast.service;

import org.springframework.stereotype.Service;

import com.springboothazelcast.entity.Book;

@Service
public interface BookService {
	public Book saveBook(Book book);
	
	public Book findById(int bookId);
	
	public Book update(Book book);
	
	public String delete(int bookId);
}
