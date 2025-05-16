package com.example.finalproject.service.impl;

import java.util.List;

import com.example.finalproject.model.Genre;

public interface IGenre {
	
	List<Genre> getAllGenre();
	Genre findById(long id);
	Genre findByName(String name);
	Genre save(Genre genre);
	void deleteById(long id);
}
