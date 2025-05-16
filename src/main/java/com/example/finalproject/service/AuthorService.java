package com.example.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.model.Author;
import com.example.finalproject.model.Genre;
import com.example.finalproject.repository.AuthorRepository;
import com.example.finalproject.service.impl.IAuthor;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthor{
	@Autowired
    private AuthorRepository authorRepository;
    
	@Override
	public List<Author> findAll() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}

	@Override
	public Author findById(long id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id);
	}

	@Override
	public List<Author> findByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		return authorRepository.findByAuthorName(authorName);
	}

	@Override
	public Author save(Author author) {
		// TODO Auto-generated method stub
		return authorRepository.save(author);
	}

	@Override
	public void deleteById(long id) {
		authorRepository.deleteById(id);
		
	}
	public Optional<Author> findOptionalById(long id){
		return authorRepository.findOptionalById(id);
	}

    
}

