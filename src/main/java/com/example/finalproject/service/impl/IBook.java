package com.example.finalproject.service.impl;

import java.util.List;

import com.example.finalproject.model.Book;

public interface IBook {
	
	List<Book> findAll();
	Book findById(long id);
	List<Book> findByAuthor(String authorName);
	List<Book> findByGenre(String genre);
	List<Book> findByTitle(String title);
	List<Book> findByOther(String other);
	Book save(Book book);
	void deleteById(long id);
	
}
