package com.example.finalproject.service.impl;

import java.util.List;

import com.example.finalproject.model.Favorite;

public interface IFavorite {
	
	List<Favorite> getAllFavorites();
	Favorite findById(long id);
	Favorite findByBookId(long id);
	List<Favorite> findByUserId(long id);
	List<Favorite>findByUserIdANDBookId(long userid,long bookid);
	Favorite save(Favorite favorite);
	void deleteById(long id);
}
