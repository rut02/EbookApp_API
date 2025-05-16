package com.example.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.finalproject.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	Rating findById(long id);
	List<Rating> findByBookId(long id);
   
   @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.book.id = :id")
   Double ratingAVG(@Param("id") long id);
   
   
   
}







