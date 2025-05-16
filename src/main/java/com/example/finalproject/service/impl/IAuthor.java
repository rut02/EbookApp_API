package com.example.finalproject.service.impl;

import java.util.List;

import com.example.finalproject.model.Author;

public interface IAuthor {
	List<Author> findAll();
	Author findById(long id);
	List<Author> findByAuthorName(String authorName);
	Author save(Author author);
	void deleteById(long id);
}
