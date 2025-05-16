package com.example.finalproject.json;

import java.util.ArrayList;
import java.util.List;

import com.example.finalproject.model.Genre;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class GenreListJson {
	
	private long genreid;
	private String genre_name;
	
	public static GenreListJson packJson(Genre genre) {
		
		GenreListJson glj = new GenreListJson();
		glj.setGenreid(genre.getId());
		glj.setGenre_name(genre.getGenreName());
		
		return glj;
		
	}
	
	public static List<GenreListJson> packJsons(List<Genre> genres){
		
		List<GenreListJson> genreListJson = new ArrayList<GenreListJson>();
		
		for(Genre genre : genres) {
			genreListJson.add(packJson(genre));
			
		}
		return genreListJson;
	}

}
