package com.example.finalproject.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.Payload.RatingPayload;
import com.example.finalproject.json.RatingListJson;
import com.example.finalproject.model.Rating;
import com.example.finalproject.service.RatingService;
@Service
public class RatingBusiness {
	@Autowired
	RatingService ratingService;
	
	public List<RatingListJson>getListRating(){
		return RatingListJson.packJsons(ratingService.findAll());
	}
	public RatingListJson getRatingById(long id){
		return RatingListJson.packJson(ratingService.findById(id));
	}
	public List<RatingListJson>getRatingByBook(long id){
		return RatingListJson.packJsons(ratingService.fingByBookId(id));
	}
	public Double getAverageRatingByBookId(long bookId) {
	    List<Rating> ratings = ratingService.fingByBookId(bookId);
	    if (ratings.isEmpty()) {
	        return 0.0; // หรือค่าเริ่มต้นที่ต้องการให้แสดงถ้าไม่มีคะแนน
	    }
	    double totalRating = 0;
	    for (Rating rating : ratings) {
	        totalRating += rating.getRating();
	    }
	    double avg=totalRating/ratings.size();
	    return Math.round(avg * 100.0) / 100.0;
	}

//	public RatingListJson getRatingAVG(long id){
//		return RatingListJson.packJson(ratingService.ratingAVG(id));
//	}
//	public Double getRatingAVG(long id) {
//	    Double averageRating = ratingService.ratingAVG(id);
//	    return RatingListJson.packJsonavg(averageRating);
//	}

	
	public void saveRating(RatingPayload ratingPayload) {
		Rating rating = new Rating(
				ratingPayload.getBook(),
				ratingPayload.getUser(),
				ratingPayload.getRating());
		ratingService.save(rating);
				
	}
	
	public void updateRating(long id ,RatingPayload payload) {
		Rating ratingData=ratingService.findById(id);
		ratingData.setBook(payload.getBook());
		ratingData.setUser(payload.getUser());
		ratingData.setRating(payload.getRating());
		ratingService.save(ratingData);
	}
	
	public void deleteRating(long id) {
		ratingService.deleteById(id);
	}

	
	
}
