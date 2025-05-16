package com.example.finalproject.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.Payload.GenrePayload;
import com.example.finalproject.json.GenreListJson;
import com.example.finalproject.model.Genre;
import com.example.finalproject.service.GenreService;

@Service
public class GenreBusiness {
	
	
	@Autowired
	GenreService genreservice;
	
	
	public List<GenreListJson> getListGenre(){
		return GenreListJson.packJsons(genreservice.getAllGenre());
	}
	public GenreListJson getGenreId(long id) {
		return GenreListJson.packJson(genreservice.findById(id));
	}
	
	public GenreListJson getGenreByEmail(String name) {
		return GenreListJson.packJson(genreservice.findByName(name));
	}
	
	public void saveGenre(GenrePayload payload) {
		
		Genre genre = new Genre(
				payload.getGenre_name());
		
		genreservice.save(genre);
	}
	
	public void updateGenre(long id , GenrePayload payload) {
		
		Genre genredata = genreservice.findById(id);
		genredata.setGenreName(payload.getGenre_name());
		genreservice.save(genredata);
	}
	
	public void deleteGenre(long id) {
		genreservice.deleteById(id);
	}
}
