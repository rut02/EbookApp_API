package com.example.finalproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalproject.model.Genre;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    
	Genre findById(long genreID);
    Genre findGenreByGenreName(String genreName);
    Optional<Genre>findOptionalById(long genreID);
}


