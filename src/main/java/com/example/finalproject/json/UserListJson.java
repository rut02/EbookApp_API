package com.example.finalproject.json;

import java.util.ArrayList;
import java.util.List;

import com.example.finalproject.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserListJson {
	
	private long userid;
	private String email;
	private String password;
	private String username;
	private String profile;
	
	
	public static UserListJson packJson(User user) {
		UserListJson ulj = new UserListJson();
		ulj.setEmail(user.getEmail());
		ulj.setPassword(user.getPassword());
		ulj.setUserid(user.getId());
		ulj.setUsername(user.getUsername());
		ulj.setProfile(user.getProfile());		
		return ulj;
		
	}
	
	public static List<UserListJson> packJsons(List<User> users){
		List<UserListJson> userListJson = new ArrayList<UserListJson>();
		
		for(User user : users) {
			userListJson.add(packJson(user));
		}
		return userListJson;
	}
}
