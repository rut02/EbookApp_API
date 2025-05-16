package com.example.finalproject.controller;

import com.example.finalproject.Payload.FavoritePayload;
import com.example.finalproject.business.FavoriteBusiness;
import com.example.finalproject.exception.BaseException;
import com.example.finalproject.json.FavoriteListJson;
import com.example.finalproject.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {
    @Autowired
    FavoriteService favoriteService;

    @Autowired
    FavoriteBusiness favoriteBusiness;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }
    
    @PostMapping
    public ResponseEntity<Void> saveFavorite(@RequestBody FavoritePayload payload) throws BaseException {
        favoriteBusiness.saveFavorite(payload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FavoriteListJson>> getAllFavorites() throws BaseException {
        return ResponseEntity.ok(favoriteBusiness.getListFavorite());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FavoriteListJson> getFavoriteById(@PathVariable("id") long id) throws BaseException {
        return ResponseEntity.ok(favoriteBusiness.getFavoriteById(id));
    }
    @GetMapping("user/{id}")
    public ResponseEntity<List<FavoriteListJson>> getFavoriteByUserId(@PathVariable("id") long id) throws BaseException {
        return ResponseEntity.ok(favoriteBusiness.getFavoriteByUserId(id));
    }
    @GetMapping("user/{userId}/book/{bookId}")
    public ResponseEntity<List<FavoriteListJson>> getFavoriteByUserIdAndBookId(
            @PathVariable("userId") long userId, @PathVariable("bookId") long bookId) throws BaseException {
        return ResponseEntity.ok(favoriteBusiness.getFavoriteByUserIdAndBookId(userId, bookId));
    }

    @PutMapping("/{id}")
    public void updateFavorite(@PathVariable Long id, @RequestBody FavoritePayload payload) {
    	favoriteBusiness.updateFavorite(id, payload);
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
    public ResponseEntity<FavoriteListJson> deleteFavoriteById(@PathVariable("id") long id) {
        try {
            favoriteBusiness.deleteFavorite(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
