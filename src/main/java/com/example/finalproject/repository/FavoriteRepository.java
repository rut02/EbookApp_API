package com.example.finalproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalproject.model.Book;
import com.example.finalproject.model.Favorite;
import com.example.finalproject.model.Genre;
import com.example.finalproject.model.User;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
	
	Favorite findById(long id);
	Favorite findByBookId(long id);
	List<Favorite> findByUserId(long id);
	Optional<Favorite>findOptionalById(long id);
	List<Favorite> findByUserIdAndBookId(long userId, long bookId);
}
