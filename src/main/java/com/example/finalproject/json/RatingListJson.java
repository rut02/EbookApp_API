package com.example.finalproject.json;

import java.util.ArrayList;
import java.util.List;

import com.example.finalproject.model.Book;
import com.example.finalproject.model.Rating;
import com.example.finalproject.model.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RatingListJson {
	private long id;
	private User user;
	private Book book;
	private int rating;
	
	public static RatingListJson packJson(Rating rating) {
		RatingListJson rlj = new RatingListJson();
		rlj.setId(rating.getId());
		rlj.setBook(rating.getBook());
		rlj.setUser(rating.getUser());
		rlj.setRating(rating.getRating());
		return rlj;
		
	}
	public static List<RatingListJson> packJsons(List<Rating> ratings) {
		List<RatingListJson> rlj = new ArrayList<RatingListJson>();
		for(Rating rating:ratings) {
			rlj.add(packJson(rating));
		}
		return rlj;
		
	}
//	public static Double packJsonavg(Double averageRating) {
//	    RatingListJson rlj = new RatingListJson();
//	    // Set appropriate values in rlj based on the averageRating
//	    rlj.setRating(averageRating.intValue());
//	    return rlj;
//	}

	
}
