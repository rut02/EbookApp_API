package com.example.finalproject.service.impl;

import java.util.List;

import com.example.finalproject.model.Rating;

public interface IRating {
	Rating findById(long id);
	List<Rating> findAll();
	List<Rating> fingByBookId(long id);
	Double ratingAVG(long id);
	Rating save(Rating rating);
	void deleteById(long id);
	

}
