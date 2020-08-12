package com.springboothazelcast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboothazelcast.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
