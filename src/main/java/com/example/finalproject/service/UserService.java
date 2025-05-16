package com.example.finalproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.model.User;
import com.example.finalproject.repository.UserRepositiry;
import com.example.finalproject.service.impl.IUser;

@Service
public class UserService implements IUser{

	
	private UserRepositiry userrepository;
	
	public UserService(UserRepositiry userrepository) {
		this.userrepository = userrepository;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}



	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userrepository.findById(id);
	}



	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userrepository.findByEmail(email);
	}



	@Override
	public User findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userrepository.findByEmailAndPassword(email, password);
	}



	@Override
	public User save(User us) {
		// TODO Auto-generated method stub
		return userrepository.save(us);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		userrepository.deleteById(id);
	}
	
	public Optional<User> findOptionalById(long id){
		return userrepository.findOptionalById(id);
	}
	
	
	public User loginUser(String email, String password) {

	    User user = userrepository.findByEmailAndPassword(email, password);
	    
	    if (user != null) {
	    	
	        return user;
	        
	    } else {
	    	
	        return null;
	    }
	}




	

	
	

	


	
}
