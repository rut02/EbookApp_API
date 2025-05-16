package com.example.finalproject.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalproject.Payload.UserPayload;
import com.example.finalproject.json.UserListJson;
import com.example.finalproject.model.User;
import com.example.finalproject.service.UserService;

@Service
public class UserBusiness {
	

    UserService userservice;
    
    @Autowired
    public UserBusiness(UserService userService) {
        this.userservice = userService;
    }

	public List<UserListJson> getListuser(){
		return UserListJson.packJsons(userservice.getAllUsers());
	}
	
	public UserListJson getUserId(long id) {
		return UserListJson.packJson(userservice.findById(id));
	}
	public UserListJson getUserByEmail(String email) {
		return UserListJson.packJson(userservice.findByEmail(email));
	}
	public UserListJson getUserByEmailAndPassword(String email , String password) {
		return UserListJson.packJson(userservice.findByEmailAndPassword(email, password));
	}
	
	public void saveUser(User us) {
		User user = new User(
				us.getEmail(), 
				us.getPassword(),
				us.getUsername(),
				us.getProfile());
		userservice.save(user);
	}
	
	public void updateUser(long id , UserPayload payload) {
		
		User userdata = userservice.findById(id);
		userdata.setEmail(payload.getEmail());
		userdata.setPassword(payload.getPassword());
		userdata.setUsername(payload.getUsername());
		userdata.setProfile(payload.getProfile());
		userservice.save(userdata);
	}
	public void updateProfile(long id , UserPayload payload) {
		
		User userdata = userservice.findById(id);
		
		userdata.setProfile(payload.getProfile());
		userservice.save(userdata);
	}
	
	public void deleteUser(long id) {
		userservice.deleteById(id);
	}
	
}
