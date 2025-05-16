package com.example.finalproject.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.Payload.FavoritePayload;
import com.example.finalproject.json.FavoriteListJson;
import com.example.finalproject.model.Favorite;
import com.example.finalproject.service.FavoriteService;
@Service
public class FavoriteBusiness {
	@Autowired
	FavoriteService favoriteService;
	
	public List<FavoriteListJson>getListFavorite(){
		return FavoriteListJson.packJsons(favoriteService.getAllFavorites());
	}
	public FavoriteListJson getFavoriteById(long id){
		return FavoriteListJson.packJson(favoriteService.findById(id));
	}
	
	public List<FavoriteListJson> getFavoriteByUserId(long id){
		return FavoriteListJson.packJsons(favoriteService.findByUserId(id));
	}
	public List<FavoriteListJson> getFavoriteByUserIdAndBookId(long userId, long bookId) {
	    return FavoriteListJson.packJsons(favoriteService.findByUserIdANDBookId(userId, bookId));
	}

	public FavoriteListJson getFavoriteByBookId(long id){
		return FavoriteListJson.packJson(favoriteService.findByBookId(id));
	}
	public void saveFavorite(FavoritePayload favoritePayload) {
		Favorite favorite=new Favorite(
				favoritePayload.getBook(),
				favoritePayload.getUser()
				);
		favoriteService.save(favorite);
				
	}
	public void updateFavorite(long id,FavoritePayload payload) {
		Favorite favoriteData=favoriteService.findById(id);
		favoriteData.setBook(payload.getBook());
		favoriteData.setUser(payload.getUser());
		favoriteService.save(favoriteData);
	}
	public void deleteFavorite(long id) {
		favoriteService.deleteById(id);
	}
}
