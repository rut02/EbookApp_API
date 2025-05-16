package com.example.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.model.Favorite;
import com.example.finalproject.repository.FavoriteRepository;
import com.example.finalproject.service.impl.IFavorite;


@Service
public class FavoriteService implements IFavorite{
	
	private final FavoriteRepository favoriterepository;
	
	public FavoriteService(FavoriteRepository favoriterepository) {
		this.favoriterepository = favoriterepository;
	}

	@Override
	public List<Favorite> getAllFavorites() {
		return favoriterepository.findAll();
	}

	@Override
	public Favorite findById(long id) {
		return favoriterepository.findById(id);
	}

	@Override
	public Favorite findByBookId(long id) {
		// TODO Auto-generated method stub
		return favoriterepository.findByBookId(id);
	}

	@Override
	public List<Favorite> findByUserId(long id) {
		// TODO Auto-generated method stub
		return favoriterepository.findByUserId(id);
	}

	@Override
	public Favorite save(Favorite favorite) {
		// TODO Auto-generated method stub
		return favoriterepository.save(favorite);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		favoriterepository.deleteById(id);;
	}

	@Override
	public List<Favorite> findByUserIdANDBookId(long userid, long bookid) {
		// TODO Auto-generated method stub
		return favoriterepository.findByUserIdAndBookId(userid, bookid);
	}

	public Optional<Favorite> findOptionalById(long id){
		return favoriterepository.findOptionalById(id);
	}
	
	
//	@Override
//	public List<Favorite> getAllFavorites() {
//		// TODO Auto-generated method stub
//		return favoriterepository.findAll();
//	}
//
//	@Override
//	public Favorite findById(long id) {
//		// TODO Auto-generated method stub
//		return favoriterepository.findById(id);
//	}
//
//	@Override
//	public Favorite findByBookId(long id) {
//		// TODO Auto-generated method stub
//		return favoriterepository.findByBookId(id);
//	}
//
//	@Override
//	public List<Favorite> findByUserId(long id) {
//		// TODO Auto-generated method stub
//		return favoriterepository.findByUserId(id);
//	}
//
//	@Override
//	public Favorite save(Favorite favorite) {
//		// TODO Auto-generated method stub
//		return favoriterepository.save(favorite);
//	}
//
//	@Override
//	public void deleteById(long id) {
//		// TODO Auto-generated method stub
//		favoriterepository.deleteById(id);
//		
//	}


	
	


	
	
}