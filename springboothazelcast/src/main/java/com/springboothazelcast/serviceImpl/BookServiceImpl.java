package com.springboothazelcast.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springboothazelcast.entity.Book;
import com.springboothazelcast.repository.BookRepository;
import com.springboothazelcast.service.BookService;

@Service
@CacheConfig(cacheNames = "book")
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@CachePut(value = "book", key = "#book.bookId")
	public Book saveBook(Book book) {
		Book bk = bookRepository.save(book);
		return bk;
	}

	@Cacheable(value = "book", key = "#bookId")
	public Book findById(int bookId) {
		Optional<Book> bk = bookRepository.findById(bookId);
		return bk.get();
	}
	@CachePut(key = "#book.bookId", value = "book")
	public Book update(Book book) {
		return bookRepository.save(book);
	}
	
	@CacheEvict(value = "book", key = "#bookId")
	public String delete(int bookId) {
		bookRepository.deleteById(bookId);
		return "Book deleted successfully";
	}

}
