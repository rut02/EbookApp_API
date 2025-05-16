package com.example.finalproject.json;

import java.util.ArrayList;
import java.util.List;

import com.example.finalproject.model.Book;

import com.example.finalproject.model.Favorite;
import com.example.finalproject.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FavoriteListJson {
	
	private long id;
	private User user;
	private Book book;
	
	public static FavoriteListJson packJson(Favorite favorite) {
		FavoriteListJson flj = new FavoriteListJson();
		flj.setId(favorite.getId());
		flj.setBook(favorite.getBook());
	    flj.setUser(favorite.getUser());
		return flj;
		
		
	}
	public static List<FavoriteListJson> packJsons(List<Favorite> favorites){
		List<FavoriteListJson> flj = new ArrayList<FavoriteListJson>();
		for(Favorite favorite:favorites) {
			flj.add(packJson(favorite));
			
		}
		return flj;
	}

}
