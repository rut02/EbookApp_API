package com.example.finalproject.controller;


import com.example.finalproject.Payload.RatingPayload;
import com.example.finalproject.business.RatingBusiness;
import com.example.finalproject.exception.BaseException;
import com.example.finalproject.json.RatingListJson;
import com.example.finalproject.service.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @Autowired
    RatingBusiness ratingBusiness;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    
//    @PostMapping
//    public void createFavorite(@RequestBody FavoritePayload favoritePayload) {
//    	favoriteBusiness.saveFavorite(favoritePayload);
//    }
    
    @PostMapping
    public ResponseEntity<Void> saveRating(@RequestBody RatingPayload payload) throws BaseException {
    	ratingBusiness.saveRating(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RatingListJson>> getAllRating() throws BaseException {
        return ResponseEntity.ok(ratingBusiness.getListRating());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RatingListJson> getRatingById(@PathVariable("id") long id) throws BaseException {
        return ResponseEntity.ok(ratingBusiness.getRatingById(id));
    }
    @GetMapping("book/{id}")
    public ResponseEntity<List<RatingListJson>> getRatingByBook(@PathVariable("id") long id) throws BaseException {
        return ResponseEntity.ok(ratingBusiness.getRatingByBook(id));
    }
    @GetMapping("/avg/{id}")
    public ResponseEntity<Double> getAverageRatingByBookId(@PathVariable("id") long id) {
        Double averageRating = ratingBusiness.getAverageRatingByBookId(id);
        return ResponseEntity.ok(averageRating);
    }

//    @GetMapping("avg/{id}")
//    public ResponseEntity<RatingListJson> getRatingAVG(@PathVariable("id") long id) throws BaseException {
//        return ResponseEntity.ok(ratingBusiness.getRatingAVG(id));
//    }

    @PutMapping("/{id}")
    public void updateRating(@PathVariable Long id, @RequestBody RatingPayload payload) {
    	ratingBusiness.updateRating(id, payload);
    }
    
//    @PutMapping("/favorites/{id}")
//    public ResponseEntity<FavoriteListJson> updateFavorite(@PathVariable("id") long id, @RequestBody FavoritePayload payload) {
//        Optional<Favorite> favoriteData = favoriteService.findbyId(id);
//        if (favoriteData.isPresent()) {
//            favoriteBusiness.updateFavorite(favoriteData.get().getId(), payload);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RatingListJson> deleteRatingById(@PathVariable("id") long id) {
        try {
        	ratingBusiness.deleteRating(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
