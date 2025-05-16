package com.example.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.model.Genre;
import com.example.finalproject.repository.GenreRepository;
import com.example.finalproject.service.impl.IGenre;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements IGenre{

	private final GenreRepository genrerepository;
	
	@Autowired
	public GenreService(GenreRepository genrerepository) {
		this.genrerepository = genrerepository;
	}
	
	@Override
	public List<Genre> getAllGenre() {
		// TODO Auto-generated method stub
		return genrerepository.findAll();
	}

	@Override
	public Genre findById(long id) {
		// TODO Auto-generated method stub
		return genrerepository.findById(id);
	}

	@Override
	public Genre findByName(String name) {
		// TODO Auto-generated method stub
		return genrerepository.findGenreByGenreName(name);
	}

	@Override
	public Genre save(Genre genre) {
		// TODO Auto-generated method stub
		return genrerepository.save(genre);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		genrerepository.deleteById(id);
	}
	
	public Optional<Genre> findOptionalById(long id){
		return genrerepository.findOptionalById(id);
	}
  

}
