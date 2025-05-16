package com.example.finalproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalproject.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
	Author findById(long id);
	List<Author> findByAuthorName(String authorName);
	Optional<Author>findOptionalById(long id);
	void deleteById(long id);
}

