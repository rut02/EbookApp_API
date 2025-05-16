package com.example.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.model.Rating;
import com.example.finalproject.repository.RatingRepository;
import com.example.finalproject.service.impl.IRating;



import java.util.List;


@Service
public class RatingService implements IRating{
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> fingByBookId(long id) {
		// TODO Auto-generated method stub
		return ratingRepository.findByBookId(id);
	}

	@Override
	public Double ratingAVG(long id) {
		// TODO Auto-generated method stub
		return ratingRepository.ratingAVG(id);
	}

	@Override
	public Rating save(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepository.save(rating);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rating findById(long id) {
		// TODO Auto-generated method stub
		return ratingRepository.findById(id);
	}

   
}

